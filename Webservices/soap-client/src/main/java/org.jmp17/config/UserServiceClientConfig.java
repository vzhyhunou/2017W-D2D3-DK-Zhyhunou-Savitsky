package org.jmp17.config;

import org.jmp17.client.UserService;
import org.jmp17.client.UserServicePortType;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import javax.xml.ws.BindingProvider;

/**
 * Created by antonsavitsky on 3/18/17.
 */
@Configuration
@ComponentScan("org.jmp17")
@PropertySource("classpath:conf/env/${ENV}/app.properties")
public class UserServiceClientConfig {

    @Value("${service.url}")
    private String serviceUrl;

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer(){
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean
    public UserServicePortType userServicePortType(){
        UserService userService = new UserService();
        UserServicePortType userServicePort = userService.getUserServicePort();
        BindingProvider bp = (BindingProvider) userServicePort;
        bp.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, serviceUrl);
        return userServicePort;
    }
}
