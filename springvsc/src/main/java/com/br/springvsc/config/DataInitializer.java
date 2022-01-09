package com.br.springvsc.config;

import java.util.List;

import com.br.springvsc.entity.User;
import com.br.springvsc.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

public class DataInitializer implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    UserRepository userRepository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

        List<User> users = userRepository.findAll();

        if (users.isEmpty()) {
            createUser("Pedro", "bre@gmail.com");
            createUser("João", "joao@gmail.com");
            createUser("Maria", "maria@gmail.com");
        }

    }

    public void createUser(String name, String email) {
        User user = new User(name, email);
        userRepository.save(user);

    }

}
