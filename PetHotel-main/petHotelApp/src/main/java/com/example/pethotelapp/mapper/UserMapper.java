package com.example.pethotelapp.mapper;

import com.example.pethotelapp.dto.UserDto;
import com.example.pethotelapp.model.UserModel;

public class UserMapper {
    public static UserDto toUserDto(UserModel userModel){
        UserDto userDto = new UserDto();
        userDto.setFirstName(userModel.getFirstName());
        userDto.setLastName(userModel.getLastName());
        userDto.setPhone(userModel.getPhone());
        userDto.setEmail(userModel.getEmail());
        userDto.setLogin(userModel.getLogin());
        userDto.setPassword(userModel.getPassword());
        //userDto.setAnimals(userModel.getAnimals());
        return userDto;}

    public static UserModel toUserModel(UserDto userDto){
        UserModel userModel = new UserModel();
        userModel.setFirstName(userDto.getFirstName());
        userModel.setLastName(userDto.getLastName());
        userModel.setPhone(userDto.getPhone());
        userModel.setEmail(userDto.getEmail());
        userModel.setLogin(userDto.getLogin());
        userModel.setPassword(userDto.getPassword());
        //userModel.setAnimals(userDto.getAnimals());
    return userModel;}
}
