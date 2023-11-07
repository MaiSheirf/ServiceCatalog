package com.service.catalog.controller;

import com.service.catalog.data.helper.ResponseHandler;
import com.service.catalog.data.response.Response;
import com.service.catalog.service.ServiceRouting;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/servicenames")
public class GetServiceNamesController {

    private final ServiceRouting serviceRouter;

    public GetServiceNamesController(ServiceRouting serviceRouter) {
        this.serviceRouter = serviceRouter;
    }

    @GetMapping("/{databaseName}/{serviceName}")
    public Response getServiceNames(@PathVariable("databaseName") String databaseName ,
                                    @PathVariable("serviceName") String serviceName

    ) {
        serviceName ="%" + serviceName + "%" ;

        if (serviceName.equals("NA")){
            serviceName = null;
        }

        List<Object> getServiceNames = serviceRouter.getServiceNames(serviceName , databaseName);
        return ResponseHandler.handleResponse(getServiceNames, "getServiceNames");
    }
}
