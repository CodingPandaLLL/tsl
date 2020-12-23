package com.llltony.springboot.controller;


import com.llltony.springboot.service.EmployeeService;
import com.llltony.springboot.utils.ExcelExport;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/excel")
public class ExportController {

    @Autowired(required = false)
    EmployeeService employeeService;


    //查询学生
    @GetMapping("/export")
    public void getEmp() {


        long startTime = System.currentTimeMillis();
        ServletRequestAttributes servletRequestAttributes =
                (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = servletRequestAttributes.getRequest();
        HttpServletResponse response = servletRequestAttributes.getResponse();
        SXSSFWorkbook workbook = getCameraListExcel();
        //以流输出到浏览器
        String kkk = "123";
        ExcelExport.writeToResponse(workbook, request, response, kkk);
        long endTime = System.currentTimeMillis();
        System.out.println("运行时间:" + (endTime - startTime) + "ms");
    }

    public SXSSFWorkbook getCameraListExcel() {
        // 字段名Key
        List<String> fieldNames = new ArrayList<>();
        fieldNames.add("1");
        fieldNames.add("2");
        fieldNames.add("3");

//        List<String> cameraList= mapper.getCameraListExcel(camera);
        SXSSFWorkbook workbook = ExcelExport.export("sheet1",
                fieldNames, fieldNames);
        return workbook;
    }

}
