package io.react.realworldapp;

import com.github.javafaker.Faker;

public class UserData {
    public static User defaultUser() {
        return new User("realapp512", "realapp512@email.com", "qwerty123");
    }

    public static User randomUser() {
        Faker faker = new Faker();
        User user = new User();
        user.setUserName(faker.name().username());
        user.setEmail(faker.name().lastName() + "@email.com");
        user.setPassword("qwerty123");
        return user;
    }
}
