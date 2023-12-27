package com.service.catalog.controller;

import com.service.catalog.data.helper.ResponseHandler;
import com.service.catalog.data.response.Response;
import com.service.catalog.service.ServiceRouting;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/performancereport")
public class GetPerformanceReportController {

    private final Logger logger = LoggerFactory.getLogger(getClass());
    private final ServiceRouting serviceRouter;

    public GetPerformanceReportController(ServiceRouting serviceRouter) {
        this.serviceRouter = serviceRouter;
    }

    @GetMapping("/{databaseName}/{fromData}/{toDate}/{server}/{serviceName}" +
            "/{backend}/{channel}")
    public Response getPerformanceReport(@PathVariable("databaseName") String databaseName ,
             @PathVariable("fromData") String fromData ,
             @PathVariable("toDate") String toDate ,
             @PathVariable("server") String server,
             @PathVariable("serviceName")String serviceName ,
             @PathVariable("backend") String backend ,
             @PathVariable("channel") String channel
            ) {

        logger.trace("Controller will serve func [{}] through DB [{}] with variables sent [{}],[{}],[{}],[{}],[{}],[{}]",
                "PerformanceReport",databaseName,fromData,toDate,server,
                serviceName , backend, channel);

        if (fromData.equals("NA")){
            fromData = null;
        }
        if (toDate.equals("NA")){
            toDate = null;
        }
        if (server.equals("NA")){
            server = null;
        }
        if (serviceName.equals("NA")){
            serviceName = null;
        }
        if (backend.equals("NA")){
            backend = null;
        }
        if (channel.equals("NA")){
            channel = null;
        }


        List<Object> getPerformanceReport = serviceRouter.getPerformanceReport(fromData,toDate,server,
                serviceName , backend, channel,databaseName);
        return ResponseHandler.handleResponse(getPerformanceReport, "getPerformanceReport");
    }

}
