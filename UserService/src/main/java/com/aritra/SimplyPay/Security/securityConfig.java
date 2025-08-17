package com.aritra.SimplyPay.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class securityConfig {

    @Bean
    public SecurityFilterChain  securityFilterChain(HttpSecurity http) throws Exception{

        http
                .csrf(csrf-> csrf.disable())
                .authorizeHttpRequests(auth-> auth
                        .requestMatchers("/api/v3/users/**").permitAll()
                                .anyRequest().authenticated()
                );
         return http.build();
    }
}

    /**
     * This configuration class sets up the security filter chain for the application.
     * It disables CSRF protection and allows all requests to the "/api/v3/users/**" endpoint,
     * while requiring authentication for any other requests.
     *
     * @param http HttpSecurity object to configure security settings
     * @return SecurityFilterChain object that defines the security rules
     * @throws Exception if there is an error during configuration
     */

