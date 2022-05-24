package com.cpl.tsl.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/**
 * 读取文件
 *
 * @author: lll
 * @date: 2022年05月24日 17:05:58
 */
public class ReadTxt {
    /**
     * 功能：Java读取txt文件的内容
     * 步骤：1：先获得文件句柄
     * 2：获得文件句柄当做是输入一个字节码流，需要对这个输入流进行读取
     * 3：读取到输入流后，需要读取生成字节流
     * 4：一行一行的输出。readline()。
     * 备注：需要考虑的是异常情况
     * @param filePath
     */
    public static void readTxtFile(String filePath){
        try {
            String encoding="UTF-8";
            File file=new File(filePath);
            if(file.isFile() && file.exists()){ //判断文件是否存在
                InputStreamReader read = new InputStreamReader(
                        new FileInputStream(file),encoding);//考虑到编码格式
                BufferedReader bufferedReader = new BufferedReader(read);
                String lineTxt = null;
                while((lineTxt = bufferedReader.readLine()) != null){
                    System.out.println("开始读取：");
                    System.out.println(lineTxt);
                    System.out.println("等待2秒，开始下一个");
                    Thread.currentThread().sleep(2000);
                }
                read.close();
            }else{
                System.out.println("找不到指定的文件");
            }
        } catch (Exception e) {
            System.out.println("读取文件内容出错");
            e.printStackTrace();
        }

    }

    public static void main(String argv[]){
        String filePath = "D:\\LLL\\20220404.log";
//      "res/";
        readTxtFile(filePath);
    }



}