package com.example.google.controller;

import com.example.google.dto.UserDTO;
import com.example.google.entity.UserEntity;
import com.google.api.client.auth.openidconnect.IdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.json.webtoken.JsonWebToken;
import com.nimbusds.jose.Payload;
import com.sun.xml.bind.v2.util.QNameMap;
import org.apache.catalina.User;
import org.hibernate.mapping.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.web.bind.annotation.*;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;



import java.net.URI;
import java.sql.SQLOutput;
import java.util.Collections;
import java.util.Map;

@RestController
@RequestMapping("/")
public class UserController {

    @GetMapping
    public UserDTO currentUser(OAuth2AuthenticationToken oauth2) {
        Map<String, Object> attrs = oauth2.getPrincipal().getAttributes();
        String email = (String) attrs.get("email");
        String name = (String) attrs.get("name");
        String picture = (String) attrs.get("picture");
        String date = (String) attrs.get("exp");


        return UserDTO.of(email, name, picture, date);
    }
}

   /* public UserEntity UserDTO2Entity(GoogleIdToken.Payload payload){
        UserEntity entity = new UserEntity();
        entity.setUsername(pay);
        return entity;
    }
    GoogleIdToken idToken
    GoogleIdToken.Payload payload =
   

}
    GoogleIdToken idToken = verifier.verify(idTokenString);
        if (idToken != null) {
        Payload payload = idToken.getPayload();*/




