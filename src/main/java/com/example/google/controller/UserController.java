package com.example.google.controller;

import com.example.google.dto.UserDTO;
import com.example.google.dto.UserDTOAux;
import com.example.google.repository.UserRepository;
import com.example.google.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;
@RestController
@RequestMapping("/")

public class UserController {
   private UserService userService;
   @Autowired
    UserController(UserService userService){
    this.userService = userService;
   }
   @Autowired
    UserRepository userRepository;

    @GetMapping
    public Map<String, Object> currentuser(OAuth2AuthenticationToken oauth2, UserDTO dto) {

        return oauth2.getPrincipal().getAttributes();
    }
    @GetMapping("/userVisit")
    public UserDTO currentUser(OAuth2AuthenticationToken oauth2) {
        Map<String, Object> attrs = oauth2.getPrincipal().getAttributes();
        String email = (String) attrs.get("email");
        String name = (String) attrs.get("name");
        String picture = (String) attrs.get("picture");
        UserDTO.of(email, name, picture);
        return UserDTO.of(email, name, picture);
    }
    @GetMapping("userList")
    public ResponseEntity<List<UserDTOAux>> getAll() {
        List<UserDTOAux> users = userService.getAllUsers();
        return ResponseEntity.ok().body(users);
    }
}




