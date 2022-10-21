package com.example.google.entity;

import com.example.google.dto.UserDTO;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.Collection;
@Entity

@Table(name = "visitantes")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String username;
    private String picture;
    private String email;


    public UserEntity() {
    }

    private UserEntity(String email, String username, String picture) {
        this.email = email;
        this.username = username;
        this.picture = picture;

    }


    public static UserEntity fromDTO(UserDTO userDTO) {
        return UserEntity.of(userDTO.getEmail(), userDTO.getUserName(), userDTO.getPicture());
    }

    private static UserEntity of(String email, String username, String picture) {
        return new UserEntity(email,username,picture);
    }

    public UserDTO toDTO() {
        return UserDTO.of(email,username, picture);
    }




    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}
