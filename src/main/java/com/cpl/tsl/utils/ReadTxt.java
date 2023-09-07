package com.cpl.tsl.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.UUID;

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
                int i=50;
                while((lineTxt = bufferedReader.readLine()) != null){
                    String[] linArr=lineTxt.split("\\|");
                    String bmdm="BM8"+String.format("%08d", i);
                    i++;
                    String id= UUID.randomUUID().toString().replace("-","");
                    //市直
                    /*String sql="INSERT INTO `cestc_dportal_yanshi`.`MH_SS_BM` (`ID`, `BMDM`, `BMMC`, `BMJC`, `BMBZ`, `SJBMDM`, `BMCJDM`, `YZBM`, `BMDZ`, `BMDIANHUA`, `CZ`, `DZXX`, `XZQHDM`, `FZR`, `YXBZ`, `ZYZZKJMC`, " +
                            "`ZYZZKJDM`, `ZYZZKJLXDM`, `ZYZZKJLXMC`, `BMLX`, `YXQKSRQ`, `YXQJSRQ`, `BMMS`, `SFSC`, `BBH`, `CJR_ID`, `CJSJ`, `XGR_ID`, `XGSJ`, `SJBMID`, `XH`, `SJLY`, `TYSHXYDM`, `XZQHCODE`, `XZQHNAME`, " +
                            "`SJGWYBMDM`, `SJQX`, `ZZCJ`, `XNZZ`, `ZYYWZDBMDM`, `SJYWBMDM`, `SJZZCJ`) VALUES " +
                            "('"+id+"', '"+bmdm+"', '"+linArr[1]+"', '"+linArr[1]+"', NULL, '01800000000', '02', '', '"+linArr[8]+"', '', NULL, NULL, NULL, '', 'Y', NULL, NULL, NULL, NULL, '01', '1690684269930', '4102329600000'," +
                            " NULL, 'N', '0', NULL, NULL, '02023080215114578900000101687555', '1691396724625', '02022112317160202100000101348439', NULL, NULL, '"+linArr[7]+"', '51', '四川省', '"+linArr[9]+"', NULL, '2', 'N', '"+linArr[5]+"', '', NULL);";*/
                    //三级
                    String sql="INSERT INTO `cestc_dportal_yanshi`.`MH_SS_BM` (`ID`, `BMDM`, `BMMC`, `BMJC`, `BMBZ`, `SJBMDM`, `BMCJDM`, `YZBM`, `BMDZ`, `BMDIANHUA`, `CZ`, `DZXX`, `XZQHDM`, `FZR`, `YXBZ`, `ZYZZKJMC`, " +
                            "`ZYZZKJDM`, `ZYZZKJLXDM`, `ZYZZKJLXMC`, `BMLX`, `YXQKSRQ`, `YXQJSRQ`, `BMMS`, `SFSC`, `BBH`, `CJR_ID`, `CJSJ`, `XGR_ID`, `XGSJ`, `SJBMID`, `XH`, `SJLY`, `TYSHXYDM`, `XZQHCODE`, `XZQHNAME`, " +
                            "`SJGWYBMDM`, `SJQX`, `ZZCJ`, `XNZZ`, `ZYYWZDBMDM`, `SJYWBMDM`, `SJZZCJ`) VALUES " +
                            "('"+id+"', '"+bmdm+"', '"+linArr[1]+"', '"+linArr[1]+"', NULL, 'BM800000049', '03', '', '"+linArr[8]+"', '', NULL, NULL, NULL, '', 'Y', NULL, NULL, NULL, NULL, '01', '1690684269930', '4102329600000'," +
                            " NULL, 'N', '0', NULL, NULL, '02023080215114578900000101687555', '1691396724625', '02022112317160202100000101348439', NULL, NULL, '"+linArr[7]+"', '51', '四川省', '"+linArr[9]+"', NULL, '2', 'N', '"+linArr[5]+"', '', NULL);";
                    System.out.println(sql);
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
        String filePath = "D:\\LLL\\1.txt";
//      "res/";
        readTxtFile(filePath);
    }



}