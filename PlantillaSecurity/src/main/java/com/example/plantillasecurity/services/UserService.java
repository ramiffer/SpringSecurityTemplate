package com.example.plantillasecurity.services;

import com.example.plantillasecurity.models.User;
import com.example.plantillasecurity.repositories.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder){
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User createUser(User u){
        u.setPassword(passwordEncoder.encode(u.getPassword())); //Hash
        return userRepository.save(u);
    }

}
