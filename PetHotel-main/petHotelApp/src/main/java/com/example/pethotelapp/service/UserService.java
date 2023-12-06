package com.example.pethotelapp.service;

import com.example.pethotelapp.dto.UserDto;
import com.example.pethotelapp.mapper.UserMapper;
import com.example.pethotelapp.model.UserModel;
import com.example.pethotelapp.repository.UserRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public UserDto addUser(UserDto userDto){
        UserModel userModel = UserMapper.toUserModel(userDto);
        UserModel addUser = userRepository.save(userModel);
        return UserMapper.toUserDto(addUser);
    }
    public List<UserModel> getUsersList() {
        return userRepository.findAll();
    }
    public UserModel findByEmail(String email){
        return userRepository.findByEmail(email).orElseThrow(()->new RuntimeException("Could not find user by email"));
    }

    public void deleteUser(Long id) {userRepository.deleteById(id);}

   // @Override
/*    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserModel user = findByEmail(username);
        Set<GrantedAuthority> authorities = user.getRoles().stream().map((role) -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toSet());
      return new org.springframework.security.core.userdetails.User(username, user.getPassword(), authorities);}*/
}
