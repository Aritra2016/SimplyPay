package com.aritra.SimplyPay.Security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class securityConfig {

    public SecurityFilterChain  securityFilterChain(HttpSecurity http) throws Exception{
        /**
            * This method configures the security filter chain for the application.
         * It disables CSRF protection and sets up authorization rules for HTTP requests.
         * * @param http The HttpSecurity object used to configure security settings.
         * * @return The configured SecurityFilterChain object.
         * * The method allows all requests to the "/api/v3/users/**" endpoint,
         *
         */
        http
                .csrf(csrf-> csrf.disable())
                .authorizeHttpRequests(auth-> auth
                        .requestMatchers("/api/v3/users/**").permitAll()
                                .anyRequest().authenticated()
                );
         return http.build();
    }
}


