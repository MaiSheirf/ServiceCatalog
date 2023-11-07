package com.service.catalog.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@Configuration
@ComponentScan
public class ServiceRouting implements ServiceList{

    @Autowired
    private ServiceRoutingStore serviceRoutingStore;
    @Override
    public List<Object> getAllCallers(String serviceName, String databaseName) {
        List<Object> getAllCallers = new ArrayList<>();
        switch (databaseName.toUpperCase()) {
            case "DEV11":
                getAllCallers = serviceRoutingStore.getAllCallers(serviceName);
                break;
            default:
                throw new IllegalArgumentException("Invalid database name: " + databaseName);
        }
        return getAllCallers;
    }

    @Override
    public List<Object> getAllBackends(String serviceName, String databaseName) {
        List<Object> getAllBackends = new ArrayList<>();
        switch (databaseName.toUpperCase()) {
            case "DEV11":
                getAllBackends = serviceRoutingStore.getAllBackends(serviceName);
                break;
            default:
                throw new IllegalArgumentException("Invalid database name: " + databaseName);
        }
        return getAllBackends;
    }

    @Override
    public List<Object> getServiceNames(String serviceName ,String databaseName) {
        List<Object> getServiceNames = new ArrayList<>();
        switch (databaseName.toUpperCase()) {
            case "DEV11":
                getServiceNames = serviceRoutingStore.getServiceNames(serviceName);
                break;
            default:
                throw new IllegalArgumentException("Invalid database name: " + databaseName);
        }
        return getServiceNames;
    }

    @Override
    public List<Object> getCallers(String caller ,String databaseName) {
        List<Object> getCallers = new ArrayList<>();
        switch (databaseName.toUpperCase()) {
            case "DEV11":
                getCallers = serviceRoutingStore.getCallers(caller);
                break;
            default:
                throw new IllegalArgumentException("Invalid database name: " + databaseName);
        }
        return getCallers;
    }

    @Override
    public List<Object> getBackends(String backend ,String databaseName) {
        List<Object> getBackends = new ArrayList<>();
        switch (databaseName.toUpperCase()) {
            case "DEV11":
                getBackends = serviceRoutingStore.getBackends(backend);
                break;
            default:
                throw new IllegalArgumentException("Invalid database name: " + databaseName);
        }
        return getBackends;
    }

    @Override
    public List<Object> getUsers(String user ,String databaseName) {
        List<Object> getUsers = new ArrayList<>();
        switch (databaseName.toUpperCase()) {
            case "DEV11":
                getUsers = serviceRoutingStore.getUsers(user);
                break;
            default:
                throw new IllegalArgumentException("Invalid database name: " + databaseName);
        }
        return getUsers;
    }

    @Override
    public List<Object> getServiceNamesByDynamicSearch(String serviceName, String uniqueId, String environment, String server, String backends, String beOperations, String beProtocol, String users, String channels, String mwProtocol, String databaseName) {
        List<Object> getServiceNamesByDynamicSearch = new ArrayList<>();
        switch (databaseName.toUpperCase()) {
            case "DEV11":
                getServiceNamesByDynamicSearch = serviceRoutingStore.getServiceNamesByDynamicSearch(serviceName,uniqueId,environment,server,
                        backends,beOperations,beProtocol,users,channels,mwProtocol);
                break;
            default:
                throw new IllegalArgumentException("Invalid database name: " + databaseName);
        }
        return getServiceNamesByDynamicSearch;
    }
}
