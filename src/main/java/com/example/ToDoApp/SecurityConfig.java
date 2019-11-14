package com.example.ToDoApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers( "/", "/home", "/init", "/h2", "/h2/**" ).permitAll()
                .antMatchers( "/admin" ).hasRole( "ADMIN" )
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage( "/login" )
                .permitAll();
        http.csrf().disable();
        http.headers().frameOptions().disable();
        http.logout().logoutRequestMatcher( new AntPathRequestMatcher( "/logout" )).logoutSuccessUrl( "/login" );
    }

    // todo db connection to user table
    @Bean
    public UserDetailsService userDetailsService() {
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser( User.withDefaultPasswordEncoder().username( "user" ).password( "123" ).roles( "USER" ).build() );
        manager.createUser( User.withDefaultPasswordEncoder().username( "admin" ).password( "123" ).roles( "USER", "ADMIN" ).build() );
        return manager;
    }

    @Autowired
    private SecurityUserDetailsService userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider( authenticationProvider() );
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider
                = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService( userDetailsService );
        authProvider.setPasswordEncoder( encoder() );
        return authProvider;
    }

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder( 11 );
    }



}
