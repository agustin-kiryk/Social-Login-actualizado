package com.example.google.mapper;

import com.example.google.dto.UserDTO;
import com.example.google.dto.UserDTOAux;
import com.example.google.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class UserMapper {

    public OAuth2AuthenticationToken oauth2;
    public UserEntity userDTO2Entity(UserDTO userDTO) {

        Map<String, Object> attrs = oauth2.getPrincipal().getAttributes();
        String email = (String) attrs.get("email");
        String name = (String) attrs.get("name");
        String picture = (String) attrs.get("picture");
        String date = (String) attrs.get("exp");
        UserDTO dto = UserDTO.of(email, name, picture, date);
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(dto.getUserName());
        userEntity.setPicture(dto.getPicture());
        userEntity.setEmail(dto.getEmail());
        userEntity.setExp(dto.getExp());

        return userEntity;
    }

    public UserDTOAux userEntity2DTO(UserEntity entity) {
        UserDTOAux dto = new UserDTOAux();
        dto.setId(entity.getId());
        dto.setName(entity.getUsername());
        dto.setPicture(entity.getPicture());

        return dto;
    }
}
