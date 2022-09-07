package com.cpl.tsl.controller;


import com.alibaba.fastjson.JSONObject;
import com.cpl.tsl.bean.Jjr;
import com.cpl.tsl.bean.ResultMap;
import com.cpl.tsl.service.JjrService;
import com.cpl.tsl.utils.Lunar;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sun.net.www.protocol.http.HttpURLConnection;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 节假日 前端控制器
 * </p>
 *
 * @author lll
 * @since 2022-08-22
 */
@RestController
@RequestMapping("/jjr")
@Api(tags = "节假日模块")
public class JjrController {

    @Autowired
    private JjrService jjrService;

    private long strToCalendar(String passTime) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");
        Date date = null;
        try {
            date = sdf.parse(passTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.getTimeInMillis();
    }

    @GetMapping("/requestThirdApi")
    @ApiOperation(value = "调用第三方接口Demo", httpMethod = "GET", notes = "调用第三方接口Demo", nickname = "测试")
    public ResultMap<JSONObject> requestThirdApi() throws InterruptedException, ParseException {
        long startTimeMillis = System.currentTimeMillis(); // 记录方法开始执行的时间
        DateTimeFormatter date = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter date1 = DateTimeFormatter.ofPattern("yyyyMMdd");
        // 处理节假日
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat date4 = new SimpleDateFormat("MMdd");
        LocalDate startTime = LocalDate.parse("2022-01-01", date);
        LocalDate endTime = LocalDate.parse("2032-12-30", date);
//        LocalDate endTime = LocalDate.parse("2099-08-23", date);
        /**
         * （一）元旦节，放假1天（1月1日）；
         * （二）春节，放假3天（农历除夕、正月初一、初二）；
         * （三）清明节，放假1天（农历清明当日）；
         * （四）劳动节，放假1天（5月1日）；
         * （五）端午节，放假1天（农历端午当日）；
         * （六）中秋节，放假1天（农历中秋当日）；
         * （七）国庆节，放假3天（10月1日、2日、3日）
         *
         * -- `JJRLX` char(2) DEFAULT NULL COMMENT '01元旦，02春节，03清明节，04劳动节，05端午节，06中秋节，07国庆节，08补班',
         * UPDATE `ss_jjr` SET JJRLX='01' WHERE JJRMC="元旦";
         * UPDATE `ss_jjr` SET JJRLX='02' WHERE JJRMC="春节";
         * UPDATE `ss_jjr` SET JJRLX='03' WHERE JJRMC="清明节";
         * UPDATE `ss_jjr` SET JJRLX='04' WHERE JJRMC="劳动节";
         * UPDATE `ss_jjr` SET JJRLX='05' WHERE JJRMC="端午节";
         * UPDATE `ss_jjr` SET JJRLX='06' WHERE JJRMC="中秋节";
         * UPDATE `ss_jjr` SET JJRLX='07' WHERE JJRMC="国庆节";
         */
        Map yingljjrs = new HashMap<>();
        yingljjrs.put("一月初一", "春节");
        yingljjrs.put("一月初二", "春节");
        yingljjrs.put("一月初三", "春节");
        yingljjrs.put("五月初五", "端午节");
        yingljjrs.put("八月十五", "中秋节");
        Map yangjjrs = new HashMap();
        yangjjrs.put("0101", "元旦");
        yangjjrs.put("0405", "清明节");
        yangjjrs.put("0501", "劳动节");
        yangjjrs.put("1001", "国庆节");
        yangjjrs.put("1002", "国庆节");
        yangjjrs.put("1003", "国庆节");
        int i = 50;
        //如果开始时间在结束时间之前就循环（需要包含结束时间）
        while (startTime.isBefore(endTime) || startTime.equals(endTime)) {
            //每循环一次就加一天
            startTime = startTime.plusDays(1);
            System.out.println(startTime + "");
            Date date2 = f.parse(startTime + "");
            String riqi=date4.format(date2);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date date3 = sdf.parse(startTime + "");
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date3);
            Integer wek = calendar.get(Calendar.DAY_OF_WEEK);

            Lunar lunar = new Lunar(calendar);
            System.out.println(lunar + " " + wek + " " + riqi);
            if(yingljjrs.containsKey(lunar+"")){
                Jjr jjr = new Jjr();
                jjr.setId(i+"");
                jjr.setJjrlx("09");
                jjr.setJjrmc(yingljjrs.get(lunar+"").toString());
                jjr.setJjrq(startTime);
                jjrService.save(jjr);
                i++;
                System.out.println("2节假日");
                continue;
            }

            if(yangjjrs.containsKey(riqi)){
                Jjr jjr = new Jjr();
                jjr.setId(i+"");
                jjr.setJjrlx("09");
                jjr.setJjrmc(yangjjrs.get(riqi).toString());
                jjr.setJjrq(startTime);
                jjrService.save(jjr);
                i++;
                System.out.println("2节假日");
                continue;
            }
//            String lll= startTime.format(date1);
//            String httpArg = f.format(startTime);
//            System.out.printf("请求日期"+httpArg);
//            Integer jsonResult= APIHelper.holidayType(date2);
//            String jsonResult = request(httpArg);
            //String jsonResult = HolidayUtil.request("20220715");
            // 0 上班 1周末 2节假日
            //0 工作日, 1 休息日, 2 节假日, -1 为判断出错
//            if (0==(jsonResult)) {
//                System.out.println("0上班日");
//                Thread.sleep(1000);
//            }


            if (1==(wek) || 7==wek) {
                Jjr jjr = new Jjr();
                jjr.setId(i+"");
                jjr.setJjrlx("09");
                jjr.setJjrmc("周末");
                jjr.setJjrq(startTime);
                jjrService.save(jjr);
                i++;
                System.out.println("1周末");
//                Thread.sleep(1000);
            }

//            if (2==(jsonResult)) {
//                Jjr jjr = new Jjr();
//                jjr.setId(i+"");
//                jjr.setJjrlx("09");
//                jjr.setJjrmc("节假日");
//                jjr.setJjrq(startTime);
//                jjrService.save(jjr);
//                i++;
//                System.out.println("2节假日");
//                Thread.sleep(1000);
//            }
        }


        long endTimeMillis = System.currentTimeMillis(); // 记录方法执行完成的时间
        return ResultMap.resultSuccess("wait " + (endTimeMillis - startTimeMillis) + "ms");
    }

    public String request(String httpArg) {
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

}
