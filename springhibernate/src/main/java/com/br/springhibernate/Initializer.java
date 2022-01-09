package com.br.springhibernate;

import java.util.Arrays;

import com.br.springhibernate.entity.Functionality;
import com.br.springhibernate.entity.Role;
import com.br.springhibernate.entity.User;
import com.br.springhibernate.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class Initializer implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent arg0) {

        Functionality functionality = new Functionality();
        functionality.setName("Add");

        Functionality functionality2 = new Functionality();
        functionality2.setName("Delete");

        Role role = new Role("Admin", StatusRole.ATIVO, Arrays.asList(functionality));
        Role role3 = new Role("Aluno", StatusRole.ATIVO, Arrays.asList(functionality2));

        User user = new User();

        user.setName("José");
        user.setEmail("jose@gmail.com");
        user.setRoles(Arrays.asList(role, role3));
        this.userRepository.save(user);

        User user2 = new User();

        user2.setName("Maria");
        user2.setEmail("maria@gmail.com");

        this.userRepository.save(user2);

        User userR = this.userRepository.findByName("Jo");

        System.out.println(userR.getName());

    }

}
