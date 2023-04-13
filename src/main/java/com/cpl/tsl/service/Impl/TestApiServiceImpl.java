package com.cpl.tsl.service.Impl;

import com.alibaba.fastjson.JSONArray;
import org.springframework.stereotype.Component;
import com.cpl.tsl.bean.Person;
import javax.jws.WebService;
import com.cpl.tsl.service.TestApiService;
import java.util.List;

@Component
@WebService(name = "testApiService",
        targetNamespace = "http://service.tsl.cpl.com",
        endpointInterface = "com.cpl.tsl.service.TestApiService",
        portName = "10000")
public class TestApiServiceImpl implements TestApiService {
    @Override
    public Person insertPersonInfo(String person) {
        List<Person> list = JSONArray.parseArray(person, Person.class);
        //TODO 逻辑处理
        return list.get(0);
    }
}