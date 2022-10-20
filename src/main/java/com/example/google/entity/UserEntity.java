package com.example.google.entity;

import com.example.google.dto.UserDTO;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.Collection;
@Entity
@Getter
@Setter
@Table(name = "visitantes")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String username;
    private String picture;
    private String email;
    private String exp;

    public UserEntity() {
    }

    private UserEntity(String email, String username, String picture, String exp) {
        this.email = email;
        this.username = username;
        this.picture = picture;
        this.exp = exp;
    }


    public static UserEntity fromDTO(UserDTO userDTO) {
        return UserEntity.of(userDTO.getEmail(), userDTO.getName(), userDTO.getPicture(),userDTO.getExp());
    }

    private static UserEntity of(String email, String name, String picture, String exp) {
        return new UserEntity(email,name,picture,exp);
    }

    public UserDTO toDTO() {
        return UserDTO.of(email,username, picture,exp);
    }


}
