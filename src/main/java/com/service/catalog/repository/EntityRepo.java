package com.service.catalog.repository;

import com.service.catalog.entity.EsbService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EntityRepo extends JpaRepository<EsbService,Integer> {

    @Query(value = "SELECT CHANNEL.NAME AS CALLERS FROM CHANNEL , ESB_SERVICES , CHANNEL_SERVICE\n" +
            "where   ESB_SERVICES.ID = CHANNEL_SERVICE.SERVICE_ID \n" +
            "AND   CHANNEL_SERVICE.CHANNEL_ID = CHANNEL.ID \n" +
            "AND   UPPER(ESB_SERVICES.NAME) LIKE UPPER(?1)" , nativeQuery = true)
    List<Object> getAllCallers(String serviceName);

    @Query(value = "SELECT DISTINCT (BACKEND.NAME) AS BACKENDS FROM BACKEND , ESB_SERVICES , SERVICE_BACKEND\n" +
            "where SERVICE_BACKEND.BACKEND_ID = BACKEND.ID \n" +
            "AND   ESB_SERVICES.ID = SERVICE_BACKEND.SERVICE_ID \n" +
            "AND   UPPER(ESB_SERVICES.NAME) LIKE UPPER(?1)" , nativeQuery = true)
    List<Object> getAllBackends(String serviceName);

    @Query(value = "SELECT NAME AS SERVICE_NAME FROM ESB_SERVICES where upper(NAME) like upper(?1)" , nativeQuery = true)
    List<Object> getServiceNames(String serviceName);

    @Query(value = "SELECT NAME AS CALLERS FROM CHANNEL where upper(NAME) like upper(?1) " , nativeQuery = true)
    List<Object> getCallers(String caller);

    @Query(value = "SELECT NAME AS BACKENDS FROM BACKEND where upper(NAME) like upper(?1)" , nativeQuery = true)
    List<Object> getBackends(String backend);

    @Query(value = "SELECT DISTINCT(USERS) FROM CHANNEL_SERVICE where upper(USERS) like UPPER(?1)" , nativeQuery = true)
    List<Object> getUsers(String user);
}
