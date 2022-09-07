package com.cpl.tsl.demo;

import sun.net.www.protocol.http.HttpURLConnection;

import java.io.*;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @author 码农小江
 * H20121012.java
 * 2012-10-12下午11:40:21
 */
public class Demo {
    /**
     * 功能：Java读取txt文件的内容
     * 步骤：1：先获得文件句柄
     * 2：获得文件句柄当做是输入一个字节码流，需要对这个输入流进行读取
     * 3：读取到输入流后，需要读取生成字节流
     * 4：一行一行的输出。readline()。
     * 备注：需要考虑的是异常情况
     *
     * @param filePath
     */
    public static void readTxtFile(String filePath) {
        try {
            String encoding = "UTF-8";
            File file = new File(filePath);
            if (file.isFile() && file.exists()) { //判断文件是否存在
                InputStreamReader read = new InputStreamReader(
                        new FileInputStream(file), encoding);//考虑到编码格式
                BufferedReader bufferedReader = new BufferedReader(read);
                String lineTxt = null;
                while ((lineTxt = bufferedReader.readLine()) != null) {
                    System.out.println("开始读取：");
                    System.out.println(lineTxt);
                    System.out.println("等待2秒，开始下一个");
                    Thread.currentThread().sleep(2000);
                }
                read.close();
            } else {
                System.out.println("找不到指定的文件");
            }
        } catch (Exception e) {
            System.out.println("读取文件内容出错");
            e.printStackTrace();
        }

    }

    /**
     * 判断当前是否为节假日： 0 上班 1周末 2节假日
     *
     * @param httpArg :参数
     * @return 返回结果
     */

    public static String request(String httpArg) {
        String httpUrl = "http://tool.bitefu.net/jiari/";
        BufferedReader reader = null;
        String result = null;
        StringBuffer sbf = new StringBuffer();
        httpUrl = httpUrl + "?d=" + httpArg;
        try {
            URL url = new URL(httpUrl);
            HttpURLConnection connection = (HttpURLConnection) url
                    .openConnection();
            connection.setRequestMethod("GET");
            connection.connect();
            InputStream is = connection.getInputStream();
            reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            String strRead = null;
            while ((strRead = reader.readLine()) != null) {
                sbf.append(strRead);

            }
            reader.close();
            result = sbf.toString();
        } catch (Exception e) {
            e.printStackTrace();

        }

        return result;

    }

    public static void main(String argv[]) {
//        String filePath = "D:\\LLL\\20220404.log";
//        readTxtFile(filePath);
        DateTimeFormatter date = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter date1 = DateTimeFormatter.ofPattern("yyyyMMdd");
        // 处理节假日
        SimpleDateFormat f = new SimpleDateFormat("yyyyMMdd");
        LocalDate startTime = LocalDate.parse("2099-08-22", date);
        LocalDate endTime = LocalDate.parse("2099-08-23", date);

        //如果开始时间在结束时间之前就循环（需要包含结束时间）
        while (startTime.isBefore(endTime) || startTime.equals(endTime)) {
            //每循环一次就加一天
            startTime = startTime.plusDays(1);
            String lll= startTime.format(date1);
            String httpArg = f.format(new Date());
            String jsonResult = request(httpArg);
            //String jsonResult = HolidayUtil.request("20220715");
            // 0 上班 1周末 2节假日

            if ("0".equals(jsonResult)) {
                System.out.println("0上班日");
            }

            if ("1".equals(jsonResult)) {
                System.out.println("1周末");
            }

            if ("2".equals(jsonResult)) {
                System.out.println("2节假日");
            }
        }


    }


}