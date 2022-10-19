package com.example.google.service;

import com.example.google.dto.UserDTO;
import com.example.google.dto.UserDTOAux;
import org.springframework.stereotype.Service;


public interface UserService {
     UserDTO save(UserDTOAux dto);


     UserDTOAux save(UserDTO dto);
}
