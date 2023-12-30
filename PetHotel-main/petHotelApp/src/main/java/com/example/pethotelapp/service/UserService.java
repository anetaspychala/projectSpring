package com.example.pethotelapp.service;

import com.example.pethotelapp.dto.UserDto;
import com.example.pethotelapp.mapper.RoomMapper;
import com.example.pethotelapp.mapper.UserMapper;
import com.example.pethotelapp.model.RoleModel;
import com.example.pethotelapp.model.RoomModel;
import com.example.pethotelapp.model.UserModel;
import com.example.pethotelapp.repository.RoleRepository;
import com.example.pethotelapp.repository.UserRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService  {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public UserDto addUser(UserDto userDto) {
        UserModel userModel = UserMapper.toUserModel(userDto);
     //   userModel.setRoles(convertRoleNamesToModels(userDto.getRoles()));
        UserModel addUser = userRepository.save(userModel);
        return UserMapper.toUserDto(addUser);
    }

    public List<UserModel> getUsersList() {
        return userRepository.findAll();
    }

    public UserModel findByLogin(String login) {
        return userRepository.findByLogin(login).orElseThrow(() -> new RuntimeException("Could not find user by login"));
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public UserDto editUser(Long id, UserDto updatedUserDto) {
        Optional<UserModel> userOptional = userRepository.findById(id);

        if (userOptional.isPresent()) {
            UserModel existingUser = userOptional.get();
            existingUser.setFirstName(updatedUserDto.getFirstName());
            existingUser.setLastName(updatedUserDto.getLastName());
            existingUser.setPhone(updatedUserDto.getPhone());
            existingUser.setEmail(updatedUserDto.getEmail());
            existingUser.setLogin(updatedUserDto.getLogin());
            existingUser.setPassword(updatedUserDto.getPassword());
            UserModel updatedUser = userRepository.save(existingUser);
            return UserMapper.toUserDto(updatedUser);
        } else {
            throw new NoSuchElementException("User with id " + id + " not found");
        }
    }

/*    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserModel user = findByLogin(username);

        if (user == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }

        Set<GrantedAuthority> authorities = user.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toSet());

        return new org.springframework.security.core.userdetails.User(
                username,
                user.getPassword(),
                authorities
        );
    }

    private Set<RoleModel> convertRoleNamesToModels(Set<String> roleNames) {
        return roleNames.stream()
                .map(roleRepository::findByName)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toSet());
    }*/
}

