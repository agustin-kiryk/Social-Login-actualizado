package com.example.google.controller;

import com.example.google.entity.UserEntity;
import com.sun.xml.bind.v2.util.QNameMap;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.sql.SQLOutput;
import java.util.Map;

@RestController
@RequestMapping("/")
public class UserController {

    @GetMapping
    public Map<String, Object> currentUser(OAuth2AuthenticationToken oAuth2AuthenticationToken){
       

        return oAuth2AuthenticationToken.getPrincipal().getAttributes();
    }
}
