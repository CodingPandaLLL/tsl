package com.cpl.tsl.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;

/**
 * 将内容写入文件的工具类
 *
 * @author: lll
 * @date: 2022年02月11日 14:02:26
 */
public class WriteToFile {

    private static final Logger logger = LoggerFactory.getLogger(WriteToFile.class);

    /**
     * FileWritter写入文件
     * @param data
     * @param file
     * @return void
     * @author: lll
     * @date: 2022年02月11日 18:02:46
     */
    private static void writeToFileiv(String data, File file) {
        try {
            //if file doesnt exists, then create it
            if (!file.exists()) {
                file.createNewFile();
            }
            //true = append file
            FileWriter fileWritter = new FileWriter(file.getName(), true);
            fileWritter.write(data);
            fileWritter.close();

            logger.info("Done");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 缓冲字符（BufferedWriter ）是一个字符流类来处理字符数据。不同于字节流（数据转换成字节），你可以直接写字符串，数组或字符数据保存到文件
     * @param content 内容
     * @param file 文件
     * @return void
     * @author: lll
     * @date: 2022年02月11日 18:02:15
     */
    private static void writeToFileiii(String content, File file) {
        try {
                        // if file doesnt exists, then create it
            if (!file.exists()) {
                file.createNewFile();
            }

            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(content);
            bw.close();

            logger.info("Done");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 文件输出流是一种用于处理原始二进制数据的字节流类。为了将数据写入到文件中，必须将数据转换为字节，并保存到文件
     * @param fop 文件输入流
     * @param content 内容
     * @return void
     * @author: lll
     * @date: 2022年02月11日 18:02:27
     */
    private static void writeToFileii(FileOutputStream fop, String content,File file) {
        try {


            fop = new FileOutputStream(file);

            // if file doesnt exists, then create it
            if (!file.exists()) {
                file.createNewFile();
            }

            // get the content in bytes
            byte[] contentInBytes = content.getBytes();

            fop.write(contentInBytes);
            fop.flush();
            fop.close();

            logger.info("Done");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fop != null) {
                    fop.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 使用新的“尝试资源关闭”的方法来轻松处理文件
     *
     * @param file 文件
     * @param content 写入内容
     * @return void
     * @author: lll
     * @date: 2022年02月11日 18:02:07
     */
    private static void writeTofilei(File file, String content) {
        try (FileOutputStream fop1 = new FileOutputStream(file)) {

            // if file doesn't exists, then create it
            if (!file.exists()) {
                file.createNewFile();
            }

            // get the content in bytes
            byte[] contentInBytes = content.getBytes();

            fop1.write(contentInBytes);
            fop1.flush();
            fop1.close();

            logger.info("Done");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        File fileI = new File("d:/newfile.txt");
        String contentI = "会当凌绝顶,一览众山小";
        writeTofilei(fileI, contentI);

        String contentII = "春蚕到死丝方尽,蜡炬成灰泪始干。";
        FileOutputStream fop = null;
        File fileII = new File("d:/newfileII.txt");
        writeToFileii(fop, contentII,fileII);

        String contentIII = "黑发不知勤学早,白首方悔读书迟。";
        File fileIII = new File("d:/newfileIII.txt");
        writeToFileiii(contentIII, fileIII);

        //不能指定路径
        String contentIV = "被酒莫惊春睡重,赌书消得泼茶香,当时只道是寻常。";
        File fileIV = new File("newfileIV.txt");
        writeToFileiv(contentIV, fileIV);
    }
}
