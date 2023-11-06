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
    List<Object> getServiceNames(){
        return entityRepo.getServiceNames();
    }

    @SwitchDataSource("DEV11")
    List<Object> getCallers(){
        return entityRepo.getCallers();
    }

    @SwitchDataSource("DEV11")
    List<Object> getBackends(){
        return entityRepo.getBackends();
    }

    @SwitchDataSource("DEV11")
    List<Object> getUsers(){
        return entityRepo.getUsers();
    }
}
