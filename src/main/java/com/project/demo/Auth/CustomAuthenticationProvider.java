package com.project.demo.Auth;

import com.project.demo.entities.User;
import com.project.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

    private
    @Autowired
    UserService service;

    @Override
    public Authentication authenticate(Authentication authentication)
            throws AuthenticationException {

        String name = authentication.getName();
        String password = authentication.getCredentials().toString();
        List<User> users = service.getAll().stream()
                .filter(user -> user.getUsername().equals(name) &&  user.getPassword().equals(password))
                .collect(Collectors.toList());
        List<GrantedAuthority> grantedAuths = new ArrayList<>();

        if(users.isEmpty())
        {
            return null;
        }

        if (users.get(0).getType().equalsIgnoreCase("admin"))
        {
            grantedAuths.add(new SimpleGrantedAuthority("admin"));
        }
        else{
            grantedAuths.add(new SimpleGrantedAuthority("user"));
        }
        return new UsernamePasswordAuthenticationToken(name, password, grantedAuths);
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}