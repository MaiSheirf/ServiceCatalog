package com.service.catalog.service;

import com.service.catalog.config.SwitchDataSource;
import com.service.catalog.repository.EntityRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Slf4j
@Service
public class ServiceRoutingStore {

    @Autowired
    private EntityRepo entityRepo;

    @SwitchDataSource("DEV11")
    List<Object> getAllCallers(String serviceName){
        return entityRepo.getAllCallers(serviceName);
    }

    @SwitchDataSource("DEV11")
    List<Object> getAllBackends(String serviceName){
        return entityRepo.getAllBackends(serviceName);
    }

    @SwitchDataSource("DEV11")
    List<Object> getServiceNames(String serviceName){
        return entityRepo.getServiceNames(serviceName);
    }

    @SwitchDataSource("DEV11")
    List<Object> getCallers(String caller){
        return entityRepo.getCallers(caller);
    }

    @SwitchDataSource("DEV11")
    List<Object> getBackends(String backend){
        return entityRepo.getBackends(backend);
    }

    @SwitchDataSource("DEV11")
    List<Object> getUsers(String user){
        return entityRepo.getUsers(user);
    }

    @SwitchDataSource("DEV11")
    List<Object> getServiceNamesByDynamicSearch(String serviceName , String uniqueId , String environment,
                                                String server , String backends , String beOperations ,
                                                String beProtocol , String users , String channels ,
                                                String mwProtocol){
        return entityRepo.getServiceNamesByDynamicSearch(serviceName,uniqueId,environment,server,
                backends,beOperations,beProtocol,users,channels,mwProtocol);
    }
}
