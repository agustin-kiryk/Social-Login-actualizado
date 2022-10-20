package com.example.google.dto;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;


public class UserDTO {
    private Long id;
    private final String username;
    private final String picture;
    private final String email;
    private final String exp; //TODO: exp = Fecha y hora de logeo en la app

    private UserDTO(String email, String username, String picture, String date) {
        this.email= email;
        this.username= username;
        this.picture = picture;
        this.exp = date;

    }

    public static UserDTO of(String email, String username, String picture, String date) {
        return new UserDTO(email,username,picture,date);
    }
    public String getEmail(){return email;}
    public String getUserName(){return username;}
    public  String getPicture(){
        return picture;
    }
    public String getExp(){
        return exp;
    }
}
