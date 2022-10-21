package com.example.google.service.impl;

import com.example.google.dto.UserDTO;
import com.example.google.dto.UserDTOAux;
import com.example.google.entity.UserEntity;
import com.example.google.mapper.UserMapper;
import com.example.google.repository.UserRepository;
import com.example.google.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    @Autowired
    UserRepository userRepository;

    @Transactional
    @Override
    public void addAccount(UserDTO userDTO) {
        UserEntity entity = UserEntity.fromDTO(userDTO);
        userRepository.save(entity);
    }

    @Override
    public List<UserDTOAux> getAllUsers() {
        List<UserEntity> entities = userRepository.findAll();
        List<UserDTOAux> result = userMapper.generoEntityList2DTOList(entities);
        return result;
    }
}
