package com.example.google.config;

import com.example.google.dto.UserDTO;
import com.example.google.service.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@Component
public class AuthHandler implements AuthenticationSuccessHandler {

    private UserService userService;
    public AuthHandler(UserService userService){
        this.userService = userService;
    }
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response,
                                        Authentication authentication) throws IOException {
        OAuth2AuthenticationToken token = (OAuth2AuthenticationToken)authentication;
        OAuth2User user = token.getPrincipal();

        Map<String, Object> attributes = user.getAttributes();

        UserDTO userDTO = UserDTO.of(
                (String) attributes.get("email"),
                (String) attributes.get("name"),
                (String) attributes.get("picture"),
                (String) attributes.get("exp")
        );
        userService.addAccount(userDTO);


        response.sendRedirect("/");



    }
}
