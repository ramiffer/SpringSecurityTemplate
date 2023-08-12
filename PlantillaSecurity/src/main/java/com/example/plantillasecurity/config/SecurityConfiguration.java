package com.example.plantillasecurity.config;

import com.example.plantillasecurity.services.UserServiceDetailsImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    private final UserServiceDetailsImpl userServiceDetailsImpl;

    public SecurityConfiguration(UserServiceDetailsImpl userServiceDetailsImpl){
        this.userServiceDetailsImpl = userServiceDetailsImpl;
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
                .authorizeHttpRequests(auth -> {
                    auth.requestMatchers("/index**", "/login**", "/registration**", "/css/**").permitAll(); //requestMatchers
                    auth.anyRequest().authenticated();
                })

                .formLogin(login -> login
                    .loginPage("/login")
                    .successHandler(successHandler())   //redirect /home
                    .permitAll()
                    .failureHandler(new CustomUrlAuth())
                )

                .logout(logout ->
                     logout
                        .logoutSuccessUrl("/index")
                        .permitAll()
                )

                .exceptionHandling(exceptionHandling ->
                        exceptionHandling
                                .authenticationEntryPoint((request, response, authException) -> {
                                    if ("XMLHttpRequest".equals(request.getHeader("X-Requested-With"))) { // /index start page
                                        response.sendError(401, "Unauthorized");
                                    } else {
                                        response.sendRedirect("/index");
                                    }
                                })
                );

        return http.build();

    }

    public AuthenticationSuccessHandler successHandler() {
        return ((request, response, authentication) -> response.sendRedirect("/home"));
    }

}
