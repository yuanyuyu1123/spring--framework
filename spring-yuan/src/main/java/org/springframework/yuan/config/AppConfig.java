package org.springframework.yuan.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = "org.springframework.yuan")
@PropertySource("classpath:application.yml")
public class AppConfig {}
