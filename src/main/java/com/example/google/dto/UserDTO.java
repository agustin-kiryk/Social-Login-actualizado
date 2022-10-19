package com.example.google.dto;


import lombok.Data;

@Data
public class UserDTO {
    private Long id;
    private String picture;
    private String name;
    private String email;
    private String exp; //TODO: exp = Fecha y hora de logeo en la app

    public UserDTO(String email, String name, String picture, String date) {
        this.email= email;
        this.name= name;
        this.picture = picture;
        this.exp = date;

    }



    public static UserDTO of(String email, String name, String picture, String date) {
        return new UserDTO(email,name,picture,date);
    }
}
