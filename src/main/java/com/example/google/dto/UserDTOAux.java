package com.example.google.dto;

import lombok.Data;

@Data
public class UserDTOAux {

    private Long id;
    private String picture;
    private String name;
    private String email;
    private String exp; //TODO: exp = Fecha y hora de logeo en la app
}
