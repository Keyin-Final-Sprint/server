package com.keyin.server.service;

import com.keyin.server.entity.User;
import com.keyin.server.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface UserService {

    Optional<User> findByEmail(String email);

    void save(User user);
}
