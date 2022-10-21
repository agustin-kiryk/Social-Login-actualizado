package com.example.google.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


public class UserDTO {
    private Long id;
    private final String username;
    private final String picture;
    private final String email;


    public UserDTO(String email, String username, String picture) {
        this.email= email;
        this.username= username;
        this.picture = picture;


    }

    public static UserDTO of(String email, String username, String picture) {
        return new UserDTO(email,username,picture);
    }
    public String getEmail(){return email;}
    public String getUserName(){return username;}
    public  String getPicture(){
        return picture;
    }



}
