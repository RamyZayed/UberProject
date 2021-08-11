package com.example.actualproject.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {

    private final PasswordEncoder PASSWORD_ENCONDER;

    @Autowired
    public ApplicationSecurityConfig(PasswordEncoder password_enconder) {
        this.PASSWORD_ENCONDER = password_enconder;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests().
                antMatchers("/","index","/css/*","/js/*").permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();
    }

    @Override
    @Bean
    protected UserDetailsService userDetailsService() {
         UserDetails AnwarUser = User.builder()
                .username("Anwar")
                .password(PASSWORD_ENCONDER.encode("password"))
                .roles("PERSON") //ROLE_PERSON
                 .build();


         UserDetails HarithUser = User.builder()
                .username("Harith")
                .password(PASSWORD_ENCONDER.encode("password123"))
                .roles("ADMIN") //ROLE_PERSON
                 .build();



         return new InMemoryUserDetailsManager(
                 AnwarUser,
                 HarithUser
         );


    }
}
