package com.kartik.configuration;

import com.kartik.services.UserService;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.persistence.Column;

@Configurable
@ComponentScan({"com.kartik"})
public class ApplicationContextBean {

    public ApplicationContextBean() {
    }


//    @Bean
//    UserService userService() {
//        return new UserService ();
//    }
}
