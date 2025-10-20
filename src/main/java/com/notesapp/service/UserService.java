package com.notesapp.service;

import com.notesapp.DTO.UserDTO;
import com.notesapp.model.User;

import java.util.List;

public interface UserService {

    void updateUserRole(Long userId, String roleName);

    List<User> getAllUsers();

    UserDTO getUserById(Long id);
}
