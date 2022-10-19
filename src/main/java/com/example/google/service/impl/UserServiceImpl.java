package com.example.google.service.impl;

import com.example.google.dto.UserDTO;
import com.example.google.dto.UserDTOAux;
import com.example.google.entity.UserEntity;
import com.example.google.mapper.UserMapper;
import com.example.google.repository.UserRepository;
import com.example.google.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    @Autowired
    UserRepository userRepository;



    @Override
    public UserDTOAux save(UserDTO dto) {
        UserEntity entity = userMapper.userDTO2Entity(dto);
        UserEntity entitysaved = userRepository.save(entity);
        UserDTOAux result = userMapper.userEntity2DTO(entitysaved);
        return result;
    }
}
