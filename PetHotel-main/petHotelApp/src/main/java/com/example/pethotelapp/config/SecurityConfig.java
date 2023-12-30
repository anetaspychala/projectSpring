package com.example.pethotelapp.config;

import com.example.pethotelapp.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.servlet.util.matcher.MvcRequestMatcher;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import org.springframework.web.servlet.handler.HandlerMappingIntrospector;

import java.util.Arrays;


@Configuration
@RequiredArgsConstructor
@Slf4j
public class SecurityConfig  {

    @Bean
    public static PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Bean
    MvcRequestMatcher.Builder matcher(HandlerMappingIntrospector handlerMappingIntrospector) {
        return new MvcRequestMatcher.Builder(handlerMappingIntrospector);
    }
    @Bean
    public InMemoryUserDetailsManager get() {
        UserDetails user = User.withUsername("test")
                .password(passwordEncoder().encode("test"))
                .roles("USER")
                .build();
        UserDetails admin = User.withUsername("admin")
                .password(passwordEncoder().encode("admin"))
                .roles("ADMIN")
                .build();
        return new InMemoryUserDetailsManager(Arrays.asList(user, admin));
    }
    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring().requestMatchers(new AntPathRequestMatcher("/**"));

    }


    @Bean
    public SecurityFilterChain filterSecurity(HttpSecurity http, MvcRequestMatcher.Builder mvcMatcher) throws Exception {
        http
                // .exceptionHandling().accessDeniedPage("/accessDenied")
                .cors(c->c.disable())
                .csrf(c->c.disable())
                .authorizeHttpRequests((authorize) ->
                        authorize
                                .requestMatchers("/adminpanel/**").hasRole("ADMIN")
                                .requestMatchers("/userpanel/**").hasRole("USER")
                                .requestMatchers("/","/login").permitAll()
                                .anyRequest().authenticated()

                )
                // .exceptionHandling().accessDeniedPage("/accessDenied.html").and()
                .formLogin(
                        form -> form
                                .loginPage("/login")
                                .loginProcessingUrl("/login")
                                .defaultSuccessUrl("/")
                                .permitAll()
                ).logout(
                        logout -> logout
                                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                                .permitAll()
                                .logoutSuccessUrl("/")//po wylogowaniu wracamy na home,
                        // nie na stronę logowania
                )
        ;
        return http.build();
    }
}