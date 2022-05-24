package com.example.demo.springin10days.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SomeExternalService {
    // from property file -> external.service.url
    @Value("${external.service.url}")
    private String url;

    public String returnServiceURL(){
        return url;
    }
}
