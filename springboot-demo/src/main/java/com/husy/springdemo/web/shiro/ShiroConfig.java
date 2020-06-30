package com.husy.springdemo.web.shiro;

import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.mgt.eis.JavaUuidSessionIdGenerator;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.crazycake.shiro.RedisCacheManager;
import org.crazycake.shiro.RedisManager;
import org.crazycake.shiro.RedisSessionDAO;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import java.util.LinkedHashMap;

/**
 * @author: husy
 * @date: 2020/6/20 17:18
 */
@Configuration
public class ShiroConfig {
    // redis 缓存失效时间
    private final int CACHE_TIMEOUT = 30 * 60 * 1000;

    @Value("${spring.redis.host}")
    public String redis_host;
    @Value("${spring.redis.port}")
    private String redis_port;
    @Value("${spring.redis.password}")
    private String password;
    @Value("${spring.redis.timeout}")
    private int timeout;

    /**
     * ShiroFilterFactoryBean 处理拦截资源文件问题。
     * 注意：初始化ShiroFilterFactoryBean的时候需要注入：SecurityManager
     * Web应用中,Shiro可控制的Web请求必须经过Shiro主过滤器的拦截
     *
     * @return
     */
    @Bean(name = "shirFilter")
    public ShiroFilterFactoryBean shiroFilter() {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager());

        /* shiro [urls] 模块过滤；配置访问权限 必须是LinkedHashMap，因为它必须保证有序
         * 过滤链定义，从上向下顺序执行，一般将 /**放在最为下边
         * anon:所有url都都可以匿名访问，
         * authc:所有url都必须认证通过才可以访问;
         * 过滤链定义，从上向下顺序执行，authc 应放在 anon 下面
         */
        LinkedHashMap<String, String> filterChainDefinitionMap = new LinkedHashMap<>();
        filterChainDefinitionMap.put("/login", "anon");
        // 配置不会被拦截的链接 顺序判断，因为前端模板采用了thymeleaf，这里不能直接使用 ("/static/**", "anon")来配置匿名访问，必须配置到每个静态目录
        filterChainDefinitionMap.put("/css/**", "anon");
        filterChainDefinitionMap.put("/fonts/**", "anon");
        filterChainDefinitionMap.put("/img/**", "anon");
        filterChainDefinitionMap.put("/js/**", "anon");
        filterChainDefinitionMap.put("/html/**", "anon");
        // 所有url都必须认证通过才可以访问
        filterChainDefinitionMap.put("/**", "authc");
        // 退出配置过滤器,其中的具体的退出代码Shiro已经替我们实现了, 位置放在 anon、authc下面
        filterChainDefinitionMap.put("/logout", "logout");

        // shiro [main] 模块过滤
        // 没有登陆的用户只能访问登陆页面； 如果不设置默认会自动寻找Web工程根目录下的"/login.jsp"页面
        // 配器shirot认登录累面地址，前后端分离中登录累面跳转应由前端路由控制，后台仅返回json数据, 对应LoginController中unauth请求
        shiroFilterFactoryBean.setLoginUrl("/un_auth");
        // 登录成功后要跳转的链接；此项目是前后端分离，故此行注释掉，登录成功之后返回用户基本信息及token给前端
        //shiroFilterFactoryBean.setSuccessUrl("/index");

        // 未授权界面;对应LoginController中 unauthorized 请求
        shiroFilterFactoryBean.setUnauthorizedUrl("/unauthorized");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return shiroFilterFactoryBean;
    }

    /**
     * 配置核心安全事务管理器
     *
     * @return
     */
    @Bean
    public SecurityManager securityManager() {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        //设置自定义realm
        securityManager.setRealm(myShiroRealm());
        //配置session管理器
        securityManager.setSessionManager(sessionManager());
        // 配置 ehcache缓存管理器
        securityManager.setCacheManager(cacheManager());
        // 配置记住我
        securityManager.setRememberMeManager(rememberMeManager());

        return securityManager;
    }


    /**
     * realm实现身份认证Realm，，继承自AuthorizingRealm，此处的注入不可以缺少。否则会在UserRealm中注入对象会报空指针.
     *
     * @return
     */
    @Bean
    public ShiroRealm myShiroRealm() {
        ShiroRealm shiroRealm = new ShiroRealm();
        shiroRealm.setCachingEnabled(true);
        //启用身份验证缓存，即缓存AuthenticationInfo信息，默认false
        shiroRealm.setAuthenticationCachingEnabled(true);
        //缓存AuthenticationInfo信息的缓存名称 在ehcache-shiro.xml中有对应缓存的配置
        shiroRealm.setAuthenticationCacheName("authenticationCache");
        //启用授权缓存，即缓存AuthorizationInfo信息，默认false
        shiroRealm.setAuthorizationCachingEnabled(true);
        //缓存AuthorizationInfo信息的缓存名称  在ehcache-shiro.xml中有对应缓存的配置
        shiroRealm.setAuthorizationCacheName("authorizationCache");
        // 加密处理
        shiroRealm.setCredentialsMatcher(hashedCredentialsMatcher());
        return shiroRealm;
    }

    /**
     * Shiro session管理
     */
    @Bean
    public DefaultWebSessionManager sessionManager() {
        //自定义sessionManager
        ShiroSessionManager sessionManager = new ShiroSessionManager();
        //设置sessionDao
        sessionManager.setSessionDAO(sessionDAO());
        return sessionManager;
    }

    /**
     * shiro 缓存管理
     * 使用的是 shiro-redis 开源插件，提供redis 进行缓存管理
     * 作用：，比如用户登录后，其用户信息、拥有的角色/权限不必每次去查，这样可以提高效率；
     *
     * @return
     */
    @Bean
    public RedisCacheManager cacheManager() {
        RedisCacheManager redisCacheManager = new RedisCacheManager();
        redisCacheManager.setRedisManager(redisManager());
        // redis中针对不同用户缓存
        // 必须要设置主键名称，shiro-redis 插件用过这个缓存用户信息
        redisCacheManager.setPrincipalIdFieldName("userId");
        //用户权限信息缓存时间
        redisCacheManager.setExpire(CACHE_TIMEOUT);
        return redisCacheManager;
    }

    /**
     * 凭证匹配器（由于我们的密码校验交给Shiro的SimpleAuthenticationInfo进行处理了）
     */
    @Bean
    public HashedCredentialsMatcher hashedCredentialsMatcher() {
        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
        // 散列算法:这里使用MD5算法;
        hashedCredentialsMatcher.setHashAlgorithmName("md5");
        // 散列的次数，比如散列两次，相当于 md5(md5(""));
        hashedCredentialsMatcher.setHashIterations(1);
        return hashedCredentialsMatcher;
    }

    /**
     * sessionDAO，持久化session ;使用的是shiro-redis开源插件,来提供redisSessionDAO操作
     */
    @Bean
    public RedisSessionDAO sessionDAO() {
        RedisSessionDAO redisSessionDAO = new RedisSessionDAO();
        redisSessionDAO.setRedisManager(redisManager());
        //  Session ID 生成器
        redisSessionDAO.setSessionIdGenerator(new JavaUuidSessionIdGenerator());
        redisSessionDAO.setExpire(1800);
        return redisSessionDAO;
    }

    /**
     * 配置shiro redisManager 使用的是shiro-redis开源插件
     *
     * @return
     */
    public RedisManager redisManager() {
        RedisManager redisManager = new RedisManager();
        redisManager.setHost(redis_host + ":" + redis_port);
        //redisManager.setPassword(password);
        // 配置缓存过期时间
        redisManager.setTimeout(timeout);
        return redisManager;
    }


    /**
     * 会话Cookie模板
     */
    private SimpleCookie sessionIdCookie() {
        SimpleCookie simpleCookie = new SimpleCookie();
        /*
         * setcookie的httponly属性如果设为true的话，会增加对xss防护的安全系数。它有以下特点：
         * 不会暴露给客户端 防止xss读取cookie
         */
        simpleCookie.setHttpOnly(true);
        //  path为 / 用于多个系统共享 JSESSIONID
        simpleCookie.setPath("/");
        // 设置Cookie的过期时间，秒为单位，默认-1表示关闭浏览器时过期Cookie
        simpleCookie.setMaxAge(-1);
        // Cookie名称
        simpleCookie.setName("client-session-id");
        return simpleCookie;
    }

    /**
     * rememberMe管理器
     *
     * @return
     */
    private CookieRememberMeManager rememberMeManager() {
        CookieRememberMeManager cookieRememberMeManager = new CookieRememberMeManager();
        //rememberMe cookie加密的密钥 建议每个项目都不一样 默认AES算法 密钥长度(128 256 512 位)
        //cookieRememberMeManager.setCipherKey(Base64.decode("4AvVhmFLUs0KTA3Kprsdag=="));

        SimpleCookie simpleCookie = new SimpleCookie();
        // 不会暴露给客户端
        simpleCookie.setHttpOnly(true);
        // 设置Cookie的过期时间，秒为单位，默认-1表示关闭浏览器时过期Cookie
        simpleCookie.setMaxAge(-1);
        // Cookie名称
        simpleCookie.setName("rememberMe");
        cookieRememberMeManager.setCookie(simpleCookie);

        return cookieRememberMeManager;
    }

    /**
     * Shiro生命周期处理器，这里需要 static 修饰，不然，@Value 和@Autowired 会失效
     *
     * @return
     */
    @Bean(name = "lifecycleBeanPostProcessor")
    public static LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
        return new LifecycleBeanPostProcessor();
    }

    /**
     * 开启shiro 注解模式
     * 可以在controller中的方法前加上注解，如 @RequiresPermissions("userInfo:add")
     *
     * @return
     */
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor() {
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager());
        return authorizationAttributeSourceAdvisor;
    }

    /**
     * @描述：开启Shiro的注解(如@RequiresRoles,@RequiresPermissions),需借助SpringAOP扫描使用Shiro注解的类,并在必要时进行安全逻辑验证 配置以下两个bean(DefaultAdvisorAutoProxyCreator和AuthorizationAttributeSourceAdvisor)即可实现此功能
     * (保证实现了Shiro内部lifecycle函数的bean执行) has run
     * 不使用注解的话，可以注释掉这两个配置
     * 必须在lifecycleBeanPostProcessor创建之后创建
     */
    @Bean
    @DependsOn("lifecycleBeanPostProcessor")
    public DefaultAdvisorAutoProxyCreator advisorAutoProxyCreator() {
        DefaultAdvisorAutoProxyCreator advisorAutoProxyCreator = new DefaultAdvisorAutoProxyCreator();
        advisorAutoProxyCreator.setProxyTargetClass(true);
        return advisorAutoProxyCreator;
    }

    /**
     * 解决： 无权限页面不跳转 shiroFilterFactoryBean.setUnauthorizedUrl("/unauthorized") 无效
     * shiro的源代码ShiroFilterFactoryBean.Java定义的filter必须满足filter instanceof AuthorizationFilter，
     * 只有perms，roles，ssl，rest，port才是属于AuthorizationFilter，而anon，authcBasic，auchc，user是AuthenticationFilter，
     * 所以unauthorizedUrl设置后页面不跳转 Shiro注解模式下，登录失败与没有权限都是通过抛出异常。
     * 并且默认并没有去处理或者捕获这些异常。在SpringMVC下需要配置捕获相应异常来通知用户信息
     *
     * 此项目使用 shiro 场景为前后端分离项目，这里先注释掉，统一异常处理已在 GlobalExceptionHand.java 中实现
     * @return
     */
    //@Bean
    //public SimpleMappingExceptionResolver simpleMappingExceptionResolver() {
    //    SimpleMappingExceptionResolver exceptionResolver=new SimpleMappingExceptionResolver();
    //    Properties properties=new Properties();
    //    //这里是异常页面的路径
    //    properties.setProperty("DatabaseException", "databaseError");
    //    properties.setProperty("UnauthorizedException", "/user/403");
    //
    //    exceptionResolver.setExceptionMappings(properties);
    //    return exceptionResolver;
    //}


    /**
     * 并发登录控制
     * @return
     */
    //@Bean
    //public KickoutSessionControlFilter kickoutSessionControlFilter(){
    //    KickoutSessionControlFilter kickoutSessionControlFilter = new KickoutSessionControlFilter();
    //    //用于根据会话ID，获取会话进行踢出操作的；
    //    kickoutSessionControlFilter.setSessionManager(sessionManager());
    //    //使用cacheManager获取相应的cache来缓存用户登录的会话；用于保存用户—会话之间的关系的；
    //    kickoutSessionControlFilter.setCacheManager(redisCacheManager());
    //    //是否踢出后来登录的，默认是false；即后者登录的用户踢出前者登录的用户；
    //    kickoutSessionControlFilter.setKickoutAfter(false);
    //    //同一个用户最大的会话数，默认1；比如2的意思是同一个用户允许最多同时两个人登录；
    //    kickoutSessionControlFilter.setMaxSession(1);
    //    //被踢出后重定向到的地址；
    //    kickoutSessionControlFilter.setKickoutUrl("/login?kickout=1");
    //    return kickoutSessionControlFilter;

    //}


    ///**
    // * session工厂
    // *
    // * @return
    // */
    //private SessionFactory sessionFactory() {
    //    return new ShiroSessionFactory();
    //}

    /**
     * 配置session监听
     * @return
     */
    //@Bean("sessionListener")
    //public ShiroSessionListener sessionListener(){
    //    ShiroSessionListener sessionListener = new ShiroSessionListener();
    //    return sessionListener;
    //}
}
