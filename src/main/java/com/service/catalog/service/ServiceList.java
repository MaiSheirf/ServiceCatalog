package com.service.catalog.service;

import java.util.List;

public interface ServiceList {
    List<Object> getAllCallers(String serviceName , String databaseName);

    List<Object> getAllBackends(String serviceName , String databaseName);

    List<Object> getServiceNames(String databaseName);

    List<Object> getCallers(String databaseName);

    List<Object> getBackends(String databaseName);

    List<Object> getUsers(String databaseName);
}
