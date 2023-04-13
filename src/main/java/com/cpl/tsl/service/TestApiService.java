package com.cpl.tsl.service;


import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import com.cpl.tsl.bean.Person;
@WebService(targetNamespace = "http://service.tsl.cpl.com")
public interface TestApiService {
    /**
     * 请求参数样例：
     *<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:ser="http://service.tsl.cpl.com">
     *    <soapenv:Header/>
     *    <soapenv:Body>
     *       <ser:insertPersonInfo>
     *       <ser:PERSON>[{"id": 111,"name": "popu_895","idCard": "89328923788925"}]
     *       </ser:PERSON></ser:insertPersonInfo>
     *    </soapenv:Body>
     * </soapenv:Envelope>
     */
    @WebMethod
    Person insertPersonInfo(@WebParam(name = "PERSON", targetNamespace = "http://service.tsl.cpl.com") String person);
}