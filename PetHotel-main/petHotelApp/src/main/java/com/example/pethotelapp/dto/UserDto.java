package com.example.pethotelapp.dto;

import lombok.Data;

import java.util.Set;


@Data
public class UserDto {

    private Long id;

    private String firstName;

    private String lastName;

    private String email;

    private Long phone;

    private String login;

    private String password;

 /*   private Set<String> roles;*/

  // private List<AnimalModel> animals;  do odblokowania przekazanie id

    //private List<Long> reservationsIds;
}
