package com.in28minutes.learning.jpa.jpain10steps;


import com.in28minutes.learning.jpa.jpain10steps.DAO.UserDAOService;
import com.in28minutes.learning.jpa.jpain10steps.DAO.UserRepository;
import com.in28minutes.learning.jpa.jpain10steps.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class UserRepositoryCommandLineRunner implements CommandLineRunner {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserDAOServiceCommandLineRunner.class);

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        User user = new User("Jack", "Admin");
        userRepository.save(user);
        LOGGER.info("New User Created :{}", user);

        Optional<User> userOptional = userRepository.findById(1L);
        LOGGER.info("User Finded :{}", userOptional);

        List<User> users = userRepository.findAll();
        LOGGER.info("All Users :{}", users);
    }
}