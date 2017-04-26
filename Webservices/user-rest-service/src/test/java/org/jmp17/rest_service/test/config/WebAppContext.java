package org.jmp17.rest_service.test.config;

import org.jmp17.rest_service.UserRestController;
import org.jmp17.rest_service.data.UserRepository;
import org.jmp17.rest_service.handlers.RestErrorHandler;
import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Created by asavitsky on 25.4.17.
 */
@Configuration
@EnableWebMvc
public class WebAppContext {
    @Bean
    public UserRestController userRestController(UserRepository userRepository){
        return new UserRestController( userRepository );
    }

    @Bean
    public UserRepository userRepository() {
        return Mockito.mock(UserRepository.class);
    }

    @Bean
    public RestErrorHandler restErrorHandler(){
        return new RestErrorHandler();
    }
}
