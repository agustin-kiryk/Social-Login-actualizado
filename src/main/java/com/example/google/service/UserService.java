package com.example.google.service;

import com.example.google.dto.UserDTO;
import com.example.google.dto.UserDTOAux;

import java.util.List;


public interface UserService {




     void addAccount(UserDTO userDTO);

    List<UserDTOAux> getAllUsers();
}
