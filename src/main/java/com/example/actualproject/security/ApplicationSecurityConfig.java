package com.example.actualproject.security;

import com.example.actualproject.auth.ApplicationUserService;
import com.example.actualproject.jwt.JwtConfig;
import com.example.actualproject.jwt.JwtTokenVerifier;
import com.example.actualproject.jwt.jwtUsernameAndPasswordAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.crypto.SecretKey;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {

    private final PasswordEncoder PASSWORD_ENCONDER;
    private final ApplicationUserService applicationUserService;
    private final SecretKey secretKey;
    private final JwtConfig jwtConfig;

    @Autowired
    public ApplicationSecurityConfig(PasswordEncoder password_enconder,
                                     ApplicationUserService applicationUserService,
                                     SecretKey secretKey,
                                     JwtConfig jwtConfig) {
        this.PASSWORD_ENCONDER = password_enconder;
        this.applicationUserService = applicationUserService;
        this.secretKey = secretKey;
        this.jwtConfig = jwtConfig;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                .csrf().disable()
                .sessionManagement()
                    .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                    .addFilter(new jwtUsernameAndPasswordAuthenticationFilter(authenticationManager(), jwtConfig, secretKey))
                    .addFilterAfter(new JwtTokenVerifier(secretKey, jwtConfig),jwtUsernameAndPasswordAuthenticationFilter.class)
                .authorizeRequests()
                .antMatchers("/emp/**","/","index","/css/*","/js/*").permitAll()
                .anyRequest()
                .authenticated();


    }


/*
**
     *
     * this was for form authnetication


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
               // .csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
                //.and()
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/","index","/css/*","/js/*").permitAll()
              //  .antMatchers("/person/*").hasRole(ApplicationUserRole.PERSON.name())


                .antMatchers(HttpMethod.POST,"/person").hasAnyAuthority(ApplicationUserPermession.PERSON_WRITE.getPermession()) // anyone that has the person_write permession can access this
                .antMatchers(HttpMethod.DELETE,"/person/*").hasAnyAuthority(ApplicationUserPermession.PERSON_WRITE.getPermession()) // anyone that has the person_write permession can access this
                .antMatchers(HttpMethod.PUT,"/person/*").hasAnyAuthority(ApplicationUserPermession.PERSON_WRITE.getPermession()) // anyone that has the person_write permession can access this
                .antMatchers(HttpMethod.GET,"/person/*","/person").hasAnyRole(ApplicationUserRole.ADMIN.name(),ApplicationUserRole.ADMINTRAINEE.name())// anyone that has the person_write permession can access this

                .anyRequest()
                .authenticated()
                .and()
              //  .httpBasic();
                .formLogin()
                    .loginPage("/login").permitAll()
                    .defaultSuccessUrl("/second",true)
                    .passwordParameter("password") // same as html
                    .usernameParameter("username")
                .and()
                .rememberMe()
                    .tokenValiditySeconds((int)TimeUnit.DAYS.toSeconds(2)) //default to 2 weeks
                    .key("something very secured")
                    .rememberMeParameter("remember-me")
                .and()
                .logout()
                    .logoutUrl("/logout")
                    .logoutRequestMatcher(new AntPathRequestMatcher("/logout","GET"))
                    .clearAuthentication(true)
                    .deleteCookies("JSESSIONID","remember-me")
                    .logoutSuccessUrl("/login");
    }


*/

    @Bean
    public DaoAuthenticationProvider daoauthenticationProvider() {
         DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
         provider.setPasswordEncoder(PASSWORD_ENCONDER);
         provider.setUserDetailsService(applicationUserService);
         return provider;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(daoauthenticationProvider());
    }
/*
    @Override
    @Bean
    protected UserDetailsService userDetailsService() {
         UserDetails AnwarUser = User.builder()
                .username("Anwar")
                .password(PASSWORD_ENCONDER.encode("pass"))
              //  .roles(ApplicationUserRole.STUDENT.name()) //ROLE_PERSON
                 .authorities(ApplicationUserRole.PERSON.getGrantedAuthorities())
                 .build();


         UserDetails HarithUser = User.builder()
                .username("Harith")
                .password(PASSWORD_ENCONDER.encode("pass"))
             //   .roles(ApplicationUserRole.ADMIN.name()) //ROLE_PERSON
                 .authorities(ApplicationUserRole.ADMIN.getGrantedAuthorities())
                 .build();

         UserDetails TomUser = User.builder()
                 .username("Tom")
                 .password(PASSWORD_ENCONDER.encode("pass"))
               //  .roles(ApplicationUserRole.ADMINTRAINEE.name()) //ROLE_ADMINTRAINEE
                 .authorities(ApplicationUserRole.ADMINTRAINEE.getGrantedAuthorities())
                 .build();

         return new InMemoryUserDetailsManager(
                 AnwarUser,
                 HarithUser,
                 TomUser
         );


    }*/

}
