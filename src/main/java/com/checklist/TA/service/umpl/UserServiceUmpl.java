package com.checklist.TA.service.umpl;

import com.checklist.TA.bo.User;
import com.checklist.TA.repository.UserRepository;
import com.checklist.TA.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;


@Service
public class UserServiceUmpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder bcryptEncoder;


    @Override
    public Optional<User> userSave(User user) {
        Date currentDate = new Date();
        user.setCreatedDate(currentDate);
        return Optional.ofNullable(userRepository.save(user));
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> Delete(User user) {
        userRepository.deleteById(user.getId());
        return Optional.ofNullable(user);
    }

    @Override
    public Optional<User> UpdateUser(User user) {
        Date currentDate = new Date();
        user.setUpdateDate(currentDate);
        return Optional.ofNullable(userRepository.save(user));
    }

    @Override
    public long countUsers() {
        return userRepository.count();
    }

    @Override
    public Optional<User> changePassword(User user) {
        user.setPassword(bcryptEncoder.encode(user.getPassword()));
        return Optional.ofNullable(userRepository.save(user));
    }

    @Override
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }
}
