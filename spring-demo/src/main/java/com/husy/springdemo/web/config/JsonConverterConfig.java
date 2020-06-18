package com.husy.springdemo.web.config;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import java.text.SimpleDateFormat;
import java.util.TimeZone;

/**
 * JSON解析器配置
 *
 * @author husy
 * @date 2020/6/18
 */
@Configuration
public class JsonConverterConfig {
    /**
     * Jackson 解析
     *
     * @return
     */
    @Bean
    public MappingJackson2HttpMessageConverter getMappingJackson2HttpMessageConverter() {
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        ObjectMapper objectMapper = new ObjectMapper();

        // 对象的所有字段全部列入
        objectMapper.setSerializationInclusion(JsonInclude.Include.ALWAYS);
        //忽略值为默认值的属性
        objectMapper.setDefaultPropertyInclusion(JsonInclude.Include.NON_DEFAULT);
        // 设置时区为东八区
        objectMapper.setTimeZone(TimeZone.getTimeZone("GMT+8"));
        // 所有的日期格式统一为：yyyy-MM-dd HH:mm:ss.SSS ,该配置有时区效果，等同GMT+8
        objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS"));
        // 美化输出
        objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);

        // 允许序列化空的POJO类（否则会抛出异常）
        objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, true);
        // 把java.util.Date, Calendar输出为数字（时间戳）
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        //序列化枚举是否以toString()来输出，默认false，即默认以name()来输出
        objectMapper.configure(SerializationFeature.WRITE_ENUMS_USING_TO_STRING, false);
        //序列化枚举是否以ordinal()来输出，默认false
        objectMapper.configure(SerializationFeature.WRITE_ENUMS_USING_INDEX, false);
        //序列化单元素数组时不以数组来输出，默认false
        objectMapper.configure(SerializationFeature.WRITE_ENUMS_USING_TO_STRING, true);
        //序列化POJO领域对象按字母顺序排序属性，默认false,不能适用于java.util.Map系列化
        objectMapper.configure(MapperFeature.SORT_PROPERTIES_ALPHABETICALLY, true);
        //序列化Map时对key进行排序操作，默认false
        objectMapper.configure(SerializationFeature.ORDER_MAP_ENTRIES_BY_KEYS, true);
        //序列化char[]时以json数组输出，默认false,即包含数组所有字符的单个JSON字符串
        objectMapper.configure(SerializationFeature.WRITE_CHAR_ARRAYS_AS_JSON_ARRAYS, true);

        // 在反序列化时忽略在 json 中存在但 Java 对象不存在的属性
        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        //在反序列化时该特性决定对于json浮点数，是否使用BigDecimal来序列化。如果不允许，则使用Double序列化。 默认为false
        objectMapper.configure(DeserializationFeature.USE_BIG_DECIMAL_FOR_FLOATS, false);
        //在反序列化时该特性决定对于json整形（非浮点），是否使用BigInteger来序列化。如果不允许，则根据数值大小来确定 是使用Integer或者Long
        objectMapper.configure(DeserializationFeature.USE_BIG_INTEGER_FOR_INTS, false);
        //在反序列化时该特性决定JSON ARRAY是映射为Object[]还是List<Object>。如果开启，都为Object[]，false时，则使用List  默认为false
        objectMapper.configure(DeserializationFeature.USE_JAVA_ARRAY_FOR_JSON_ARRAY, false);
        //在反序列化时是否使用Enum.toString()的值对json string进行反序列化。这个的设置和WRITE_ENUMS_USING_TO_STRING需要一致。
        objectMapper.configure(DeserializationFeature.READ_ENUMS_USING_TO_STRING, true);
        converter.setObjectMapper(objectMapper);

        return converter;
    }

}
