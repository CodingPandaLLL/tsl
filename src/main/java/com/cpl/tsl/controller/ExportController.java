package com.cpl.tsl.controller;


import com.cpl.tsl.service.EmployeeService;
import com.cpl.tsl.utils.ExcelExport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
@Api(tags = "导出员工模块")
public class ExportController {

    @Autowired(required = false)
    EmployeeService employeeService;

    private static final Logger logger = LoggerFactory.getLogger(ExportController.class);


    //导出学生
    @GetMapping("/export")
    @ApiOperation(value="导出员工信息",notes = "导出员工信息")
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
        logger.info("运行时间:" + (endTime - startTime) + "ms");
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
