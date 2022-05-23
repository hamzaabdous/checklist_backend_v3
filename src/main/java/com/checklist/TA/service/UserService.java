package com.checklist.TA.service;

import com.checklist.TA.bo.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    public Optional<User> userSave (User user);
    public List<User> findAll();
    public Optional<User> Delete(User user);
    public Optional<User> UpdateUser(User user);
    public long countUsers();
    public Optional<User> changePassword(User user);
    public Optional<User> findById(Long id);
}
