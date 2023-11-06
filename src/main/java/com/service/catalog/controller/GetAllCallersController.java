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
@RequestMapping("/allcallers")
public class GetAllCallersController {

    private final ServiceRouting serviceRouter;

    public GetAllCallersController(ServiceRouting serviceRouter) {
        this.serviceRouter = serviceRouter;
    }

    @GetMapping("/{databaseName}/{serviceName}")
    public Response getAllCallers(@PathVariable("databaseName") String databaseName,
                                   @PathVariable("serviceName") String serviceName
    ) {
        serviceName = "%" + serviceName + "%";
        List<Object> getAllCallers = serviceRouter.getAllCallers(serviceName,databaseName);
        return ResponseHandler.handleResponse(getAllCallers, "getAllCallers");
    }

}
