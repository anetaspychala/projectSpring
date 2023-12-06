/*
package com.example.pethotelapp.controller;

import com.example.pethotelapp.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation*/
/**//*
.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class HelloControler {
    private final UserService userService;

    @GetMapping("/login") public String login() { return "login"; }


    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("userRoles", SecurityContextHolder.getContext().getAuthentication().getAuthorities().toString());
        return "home";
    }//musi zwrocic name dirstname albo nazwiko
}
*/
