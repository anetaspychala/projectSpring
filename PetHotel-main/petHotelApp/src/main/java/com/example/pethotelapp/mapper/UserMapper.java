package com.example.pethotelapp.mapper;

import com.example.pethotelapp.dto.UserDto;
import com.example.pethotelapp.model.RoleModel;
import com.example.pethotelapp.model.UserModel;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class UserMapper {

        public static UserDto toUserDto(UserModel userModel) {
            UserDto userDto = new UserDto();
            userDto.setFirstName(userModel.getFirstName());
            userDto.setLastName(userModel.getLastName());
            userDto.setPhone(userModel.getPhone());
            userDto.setEmail(userModel.getEmail());
            userDto.setLogin(userModel.getLogin());
            userDto.setPassword(userModel.getPassword());
        /*    userDto.setRoles(userModel.getRoles().stream().map(RoleModel::getName).collect(Collectors.toSet()));*/
            return userDto;
        }

        public static UserModel toUserModel(UserDto userDto) {
            UserModel userModel = new UserModel();
            userModel.setFirstName(userDto.getFirstName());
            userModel.setLastName(userDto.getLastName());
            userModel.setPhone(userDto.getPhone());
            userModel.setEmail(userDto.getEmail());
            userModel.setLogin(userDto.getLogin());
            userModel.setPassword(userDto.getPassword());
         /*   userModel.setRoles(roles);*/
            return userModel;
        }
    }

