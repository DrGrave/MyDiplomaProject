package com.genezis.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Created by Vadim on 11.04.2017.
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.genezis")
public class ServerConfiguration {
}
