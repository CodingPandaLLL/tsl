package com.cpl.tsl.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializeUtils {

    //private static final Logger logger = LoggerFactory.getLogger(SerializeUtils.class);

    private static void close(ObjectOutputStream objectOutputStream, ByteArrayOutputStream byteArrayOutputStream) {
        try {
            if (byteArrayOutputStream != null) {
                byteArrayOutputStream.close();
            }
            if (objectOutputStream != null) {
                objectOutputStream.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
            //logger.error("关闭IO资源异常[" + e.getMessage() + "]", e);
        }
    }

    private static void close(ObjectInputStream objectInputStream, ByteArrayInputStream byteArrayInputStream) {
        try {
            if (objectInputStream != null) {
                objectInputStream.close();
            }
            if (byteArrayInputStream != null) {
                byteArrayInputStream.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
            //logger.error("关闭IO资源异常[" + e.getMessage() + "]", e);
        }
    }

    public static byte[] serialize(Object object) {
        ObjectOutputStream objectOutputStream = null;
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(object);
            byte[] bytes = byteArrayOutputStream.toByteArray();
            return bytes;
        } catch (Exception e) {
            e.printStackTrace();
            //logger.error("序列化对象异常[" + e.getMessage() + "]", e);
        } finally {
            close(objectOutputStream, byteArrayOutputStream);
        }
        return null;
    }

    @SuppressWarnings("unchecked")
    public static <T> T unserialize(byte[] bytes) {
        if (bytes == null)
            return null;
        ByteArrayInputStream byteArrayInputStream = null;
        ObjectInputStream objectInputStream = null;
        try {
            byteArrayInputStream = new ByteArrayInputStream(bytes);
            objectInputStream = new ObjectInputStream(byteArrayInputStream);
            return (T) objectInputStream.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(objectInputStream, byteArrayInputStream);
        }
        return null;
    }

}