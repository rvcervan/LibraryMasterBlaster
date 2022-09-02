package com.project.demo.Auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig {



    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        // We don't need CSRF for this example
        httpSecurity.csrf().disable().httpBasic()
                .and()
                // don't authenticate this particular request
                .authorizeHttpRequests()
                .antMatchers("/user/createUser").permitAll()
                .antMatchers("/user/*").hasAuthority("user")
                .antMatchers("/user/*/*").hasAuthority("user")
                .anyRequest()
                .authenticated()
                .and().formLogin();


        // Add a filter to validate the tokens with every request
        return httpSecurity.build();
    }
}