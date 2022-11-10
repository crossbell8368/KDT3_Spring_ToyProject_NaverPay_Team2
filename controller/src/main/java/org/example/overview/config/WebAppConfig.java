package org.example.overview.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Configuration
@ComponentScan(
        basePackages = "org.example.overview",
        useDefaultFilters = false,
        includeFilters = {@ComponentScan.Filter(
                type = FilterType.ANNOTATION,
                value = {Component.class, Repository.class, Service.class})})
public class WebAppConfig {

}

