package com.service.catalog.service;

import java.util.List;

public interface ServiceList {
    List<Object> getAllCallers(String serviceName , String databaseName);

    List<Object> getAllBackends(String serviceName , String databaseName);

    List<Object> getServiceNames(String serviceName ,String databaseName);

    List<Object> getCallers(String caller , String databaseName);

    List<Object> getBackends(String backend ,String databaseName);

    List<Object> getUsers(String user ,String databaseName);

    List<Object> getServiceNamesByDynamicSearch(String serviceName , String uniqueId , String environment,
                                                String server , String backends , String beOperations ,
                                                String beProtocol , String users , String channels ,
                                                String mwProtocol , String databaseName);
}
