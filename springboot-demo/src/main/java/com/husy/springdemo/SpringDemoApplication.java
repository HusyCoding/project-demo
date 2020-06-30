package com.husy.springdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableAsync
@EnableWebMvc
@EnableTransactionManagement
@SpringBootApplication(scanBasePackages = "com.husy.springdemo")
public class SpringDemoApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(SpringDemoApplication.class, args);
    }

    /**
     * 加载YML格式自定义配置文件
     */
//    @Bean
//    public static PropertySourcesPlaceholderConfigurer properties() throws IOException {
//        PropertySourcesPlaceholderConfigurer configurer = new PropertySourcesPlaceholderConfigurer();
//        YamlPropertiesFactoryBean yaml = new YamlPropertiesFactoryBean();
//        //File引入
//        yaml.setResources(new PathMatchingResourcePatternResolver().getResources("classpath:config/**/*.yml"));
//        configurer.setProperties(yaml.getObject());
//        return configurer;
//    }
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(SpringDemoApplication.class);
    }
}
