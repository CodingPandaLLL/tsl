package com.cpl.tsl.utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;

/**
 * 将对象转化为Json字符串工具类
 * @author lll
 * @date 2021/4/4 16:03
 */
public class JacksonUtil {

    private static final Logger logger = LoggerFactory.getLogger(com.cpl.tsl.utils.JacksonUtil.class);

    private JacksonUtil() {
    }

    private static final ObjectMapper mapper = getNoNullValuesMapper(new ObjectMapper());

    public static ObjectMapper getNoNullValuesMapper(ObjectMapper mapper) {
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        return mapper;
    }

    /**
     * JSON to Bean.
     */
    public static <T> T toBean(final String jsonString, Class clazz) throws IOException {
        return (T) mapper.readValue(jsonString, clazz);
    }

    /**
     * JSON to Bean.
     */
    public static <T> T toBeanQuietly(final String jsonString, Class clazz) {
        try {
            return (T) mapper.readValue(jsonString, clazz);
        } catch (IOException e) {
            logger.error("", e);
            return null;
        }
    }

    /**
     * to JSON.
     */
    public static String toJsonString(final Object data) {
        Writer strWriter = new StringWriter();
        String jsonString = toJsonString(strWriter, data);
        try {
            strWriter.flush();
            strWriter.close();
        } catch (IOException e) {
            logger.error("", e);
        }
        return jsonString;
    }

    /**
     * to JSON.
     */
    public static String toJsonString(Writer strWriter, final Object data) {
        return toJsonString(mapper, strWriter, data);
    }

    /**
     * to JSON.
     */
    public static String toJsonString(ObjectMapper mapper, Writer strWriter, final Object data) {
        try {
            mapper.writeValue(strWriter, data);
        } catch (JsonGenerationException e) {
            logger.error("", e);
        } catch (JsonMappingException e) {
            logger.error("", e);
        } catch (IOException e) {
            logger.error("", e);
        }
        return strWriter.toString();
    }

}
