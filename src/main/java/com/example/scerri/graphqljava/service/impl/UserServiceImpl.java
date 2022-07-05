package com.example.scerri.graphqljava.service.impl;

import com.example.scerri.graphqljava.generated.types.User;
import com.example.scerri.graphqljava.service.UserService;
import net.datafaker.Faker;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private List<User> fakeUsers;

    @PostConstruct
    private void createUsers() {
        Faker faker = new Faker();
        fakeUsers = Arrays.asList(
                User.newBuilder().id(1).firstName(faker.name().firstName()).lastName(faker.name().lastName()).build(),
                User.newBuilder().id(2).firstName(faker.name().firstName()).lastName(faker.name().lastName()).build(),
                User.newBuilder().id(3).firstName(faker.name().firstName()).lastName(faker.name().lastName()).build(),
                User.newBuilder().id(4).firstName(faker.name().firstName()).lastName(faker.name().lastName()).build(),
                User.newBuilder().id(5).firstName(faker.name().firstName()).lastName(faker.name().lastName()).build(),
                User.newBuilder().id(6).firstName(faker.name().firstName()).lastName(faker.name().lastName()).build(),
                User.newBuilder().id(7).firstName(faker.name().firstName()).lastName(faker.name().lastName()).build()
        );
    }

    @Override
    public List<User> users() {
        return fakeUsers;
    }
}
