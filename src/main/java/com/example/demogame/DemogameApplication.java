package com.example.demogame;

import com.example.demogame.user.User;
import com.example.demogame.user.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class DemogameApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemogameApplication.class, args);
    }


    @Bean
    CommandLineRunner run(UserService userService){
        return args -> {
            User user = userService.getUserByEmail("myemail");
            if(user == null){
                userService.addUser(new User("alon", "tester","myemail","12345"));
            }
        };
    }

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
