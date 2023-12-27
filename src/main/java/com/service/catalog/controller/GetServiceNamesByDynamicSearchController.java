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
@RequestMapping("/dynamicsearch")
public class GetServiceNamesByDynamicSearchController {

    private final Logger logger = LoggerFactory.getLogger(getClass());
    private final ServiceRouting serviceRouter;

    public GetServiceNamesByDynamicSearchController(ServiceRouting serviceRouter) {
        this.serviceRouter = serviceRouter;
    }

    @GetMapping("/{databaseName}/{serviceName}/{uniqueId}/{environment}/{server}/{backends}/{beOperations}/{beProtocol}/{users}/{channels}/{mwProtocol}")
    public Response getServiceNamesByDynamicSearch
            (@PathVariable("databaseName") String databaseName ,
                                    @PathVariable("serviceName") String serviceName ,
                                    @PathVariable("uniqueId") String uniqueId ,
                                    @PathVariable("environment") String environment,
                                    @PathVariable("server")String server ,
                                    @PathVariable("backends") String backends ,
                                    @PathVariable("beOperations") String beOperations ,
                                    @PathVariable("beProtocol")  String beProtocol ,
                                    @PathVariable("users") String users ,
                                    @PathVariable("channels") String channels ,
                                    @PathVariable("mwProtocol") String mwProtocol

    ) {
        logger.trace("Controller will serve func [{}] through DB [{}] with variables sent [{}],[{}],[{}],[{}],[{}],[{}],[{}],[{}],[{}],[{}]",
                "ServiceNamesByDynamicSearch",databaseName,serviceName ,uniqueId,environment,server,
                backends,beOperations,beProtocol,users,channels,mwProtocol);
       /*serviceName ="%" + serviceName + "%" ;
        uniqueId = "%" + uniqueId +"%";
        environment = "%" + environment + "%";
        server = "%" + server + "%";
        backends = "%" + backends + "%";
        beOperations = "%" + beOperations + "%";
        beProtocol = "%" + beProtocol + "%";
        users = "%" + users + "%";
        channels = "%" + channels + "%";
        mwProtocol = "%" + mwProtocol + "%"; */



        if (serviceName.equals("NA")){
            serviceName = null;
        }
        if (uniqueId.equals("NA")){
            uniqueId = null;
        }
        if (environment.equals("NA")){
            environment = null;
        }
        if (server.equals("NA")){
            server = null;
        }
        if (backends.equals("NA")){
            backends = null;
        }
        if (beOperations.equals("NA")){
            beOperations = null;
        }
        if (beProtocol.equals("NA")){
            beProtocol = null;
        }
        if (users.equals("NA")){
            users = null;
        }
        if (channels.equals("NA")){
            channels = null;
        }
        if (mwProtocol.equals("NA")){
            mwProtocol = null;
        }

        List<Object> getServiceNamesByDynamicSearch = serviceRouter.getServiceNamesByDynamicSearch(serviceName ,uniqueId,environment,server,
                backends,beOperations,beProtocol,users,channels,mwProtocol ,databaseName);
        return ResponseHandler.handleResponse(getServiceNamesByDynamicSearch, "getServiceNamesByDynamicSearch");
    }

}
