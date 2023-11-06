package com.service.catalog.data.response;

import lombok.Data;

@Data
public class Response {


    private com.service.catalog.data.response.ResponseStatus ResponseStatus;
    private com.service.catalog.data.response.ResponseData ResponseData;

}
