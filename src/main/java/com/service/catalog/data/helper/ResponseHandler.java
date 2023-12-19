package com.service.catalog.data.helper;

import com.service.catalog.data.response.Response;
import com.service.catalog.data.response.ResponseData;
import com.service.catalog.data.response.ResponseStatus;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j

public class ResponseHandler {

    public static Response handleResponse(List<Object> data, String serviceName) {
        Response response = new Response();
        ResponseData responseData = generateServiceResponseData(data, serviceName);
        ResponseStatus status = new ResponseStatus("100", "Success");

        System.out.println(" data is  >>>>>>>>>>>>>>>>>>>>>>>>>>> " + data.size() );
        System.out.println(" data is  >>>>>>>>>>>>>>>>>>>>>>>>>>> " +data.isEmpty());
        if (data.isEmpty() || data.size() == 0) {
            // set empty error code Status
            status.setCode("101");
            status.setMsg("NO Data Found");
        }
        response.setResponseStatus(status);
        response.setResponseData(responseData);
        return response;
    }

    private static ResponseData generateServiceResponseData(List<Object> data, String serviceName) {
        ResponseData responseData = new ResponseData();
        if (serviceName.equals("getAllCallers")) {
            responseData.setAllCallers(data);
        }
        if (serviceName.equals("getAllBackends")) {
            responseData.setAllBackends(data);
        }
        if (serviceName.equals("getBackends")) {
            responseData.setBackends(data);
        }
        if (serviceName.equals("getCallers")) {
            responseData.setCallers(data);
        }
        if (serviceName.equals("getUsers")) {
            responseData.setUsers(data);
        }
        if (serviceName.equals("getServiceNames")) {
            responseData.setServiceNames(data);
        }
        if (serviceName.equals("getServiceNamesByDynamicSearch")) {
            responseData.setServiceNamesByDynamicSearch(data);
            System.out.println("maiii");
        }
        if (serviceName.equals("getPerformanceReport")) {
            responseData.setServiceNamesByDynamicSearch(data);
            System.out.println("maiii");
        }

        return responseData;
    }
}

