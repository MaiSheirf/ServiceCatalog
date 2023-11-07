package com.service.catalog.repository;

import com.service.catalog.entity.EsbService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.relational.core.sql.In;
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

    @Query(value = "SELECT * FROM (\n" +
            "\n" +
            "SELECT\n" +
            "  s.id AS service_id,\n" +
            "  s.name AS service_name ,\n" +
            "  s.unique_id, s.ENVIRONMENT , s.SERVER ,\n" +
            "  LISTAGG(DISTINCT c.name, ',') WITHIN GROUP (ORDER BY c.name) AS channels,\n" +
            "  LISTAGG(DISTINCT cs.USERS, ',') WITHIN GROUP (ORDER BY cs.USERS) AS USERS,\n" +
            "  LISTAGG(DISTINCT cs.protocol, ',')  AS MW_PROTOCOL,\n" +
            "  LISTAGG(DISTINCT b.name, ',') WITHIN GROUP (ORDER BY b.name) AS backends,\n" +
            "  LISTAGG(DISTINCT OPERATION_NAME, ',') WITHIN GROUP (ORDER BY OPERATION_NAME ) AS BE_OPERATIONS ,\n" +
            "  LISTAGG(DISTINCT sb.be_protocol, ',') AS BE_PROTOCOL\n" +
            "\n" +
            "FROM\n" +
            "  esb_services s , channel_service cs , channel c ,service_backend sb , backend b\n" +
            "where s.id = cs.service_id\n" +
            "  and  cs.channel_id = c.id\n" +
            "  and s.id = sb.service_id\n" +
            "  and sb.backend_id = b.id\n" +
            "GROUP BY\n" +
            "  s.id,\n" +
            "  s.name,\n" +
            "  s.unique_id ,\n" +
            "  s.ENVIRONMENT ,\n" +
            "  s.SERVER\n" +
            ") a \n" +
            "  WHERE ( upper(a.service_name) like upper(?1) OR ?1 IS NULL ) \n" +
            "    AND ( upper(a.unique_id) like  upper(?2) OR ?2 IS NULL )  \n" +
            "    AND ( upper(a.environment) like upper(?3) OR ?3 IS NULL ) \n" +
            "    AND ( upper(a.server) like upper(?4) OR ?4 IS NULL ) \n" +
            "    AND ( upper(a.backends) like upper(?5) OR ?5 IS NULL ) \n" +
            "    AND ( upper(a.be_operations) like  upper(?6) OR ?6 IS NULL ) \n" +
            "    AND ( upper(a.be_protocol) like  upper(?7) OR ?7 IS NULL ) \n" +
            "    AND ( upper(a.users) like  upper(?8) OR ?8 IS NULL )\n" +
            "    AND ( upper(a.channels) like  upper(?9) OR ?9 IS NULL )\n" +
            "    AND ( upper(a.mw_protocol)  like  upper(?10) OR ?10 IS NULL ) " , nativeQuery = true)
    List<Object> getServiceNamesByDynamicSearch(String serviceName , String uniqueId , String environment,
                                                String server , String backends , String beOperations ,
                                                String beProtocol , String users , String channels ,
                                                String mwProtocol);
}
