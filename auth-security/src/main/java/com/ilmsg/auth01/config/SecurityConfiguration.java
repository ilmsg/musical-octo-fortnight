package com.ilmsg.auth01.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.ilmsg.auth01.service.MyUserDetailService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
    @Autowired
    private MyUserDetailService myUserDetailService;

    @Bean
    SecurityFilterChain secruityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(req -> req
                        .requestMatchers("/home", "/register/**").permitAll()
                        .requestMatchers("/admin/**").hasRole("ADMIN")
                        .requestMatchers("/user/**").hasRole("USER")
                        .anyRequest().authenticated())
                .formLogin(formLogin -> formLogin
                        .loginPage("/login")
                        .usernameParameter("username")
                        .passwordParameter("password")
                        .successHandler(new AuthenticationSuccessHandler())
                        .permitAll());

        return http.build();
    }

    // @Bean
    // public UserDetailsService userDetailsService() {
    // UserDetails normalUser = User.builder()
    // .username("gc")
    // .password(passwordEncoder().encode("1234"))
    // .roles("USER")
    // .build();
    // UserDetails adminUser = User.builder()
    // .username("admin")
    // .password(passwordEncoder().encode("1234"))
    // .roles("USER", "ADMIN")
    // .build();
    // return new InMemoryUserDetailsManager(normalUser, adminUser);
    // }

    @Bean
    UserDetailsService userDetailsService() {
        return myUserDetailService;
    }

    @Bean
    AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(myUserDetailService);
        provider.setPasswordEncoder(passwordEncoder());
        log.info("authenticationProvider:");
        return provider;
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}