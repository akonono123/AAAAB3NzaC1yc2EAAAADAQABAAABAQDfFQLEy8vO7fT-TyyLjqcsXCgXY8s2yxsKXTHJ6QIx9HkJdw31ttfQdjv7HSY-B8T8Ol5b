package com.bootcamp.springboot.config;

import com.bootcamp.springboot.service.TodoService;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class beanconfig {
    @Bean
    public TodoService getitemService() {
        return new TodoService();
    }

}
