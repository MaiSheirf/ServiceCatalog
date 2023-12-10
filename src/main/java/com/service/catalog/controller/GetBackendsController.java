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
@RequestMapping("/backends")
public class GetBackendsController {

    private final ServiceRouting serviceRouter;

    public GetBackendsController(ServiceRouting serviceRouter) {
        this.serviceRouter = serviceRouter;
    }

    @GetMapping("/{databaseName}/{backend}")
    public Response getBackends(@PathVariable("databaseName") String databaseName
            ,@PathVariable("backend") String backend
    ) {
        backend ="%" + backend + "%" ;

//        if (backend.equals("NA")){
//            backend = null;
//        }

        List<Object> getBackends = serviceRouter.getBackends(backend ,databaseName);
        return ResponseHandler.handleResponse(getBackends, "getBackends");
    }
}
