package com.service.catalog.data.response;

import lombok.Data;

import java.util.List;
import java.util.Objects;

@Data
public class ResponseData {

    private List<Object> AllCallers;
    private List<Object> AllBackends;
    private List<Object> Backends;
    private List<Object> Callers;
    private List<Object> Users;
    private List<Object> ServiceNames;
    private List<Object> ServiceNamesByDynamicSearch;
    private List<Object> getPerformanceReport;
}
