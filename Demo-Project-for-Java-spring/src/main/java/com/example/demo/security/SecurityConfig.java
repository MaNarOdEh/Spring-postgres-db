package com.example.demo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final String[] PUPLIC_END_POINTS = { "/api/v1/auth/**", "/api/public" };

    @Bean
    AuthFilter authFilter() {
        return new AuthFilter();
    };

    @Bean
    @Override
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

    /**
     * configure method
     * 
     * From this method we will determine all the public url that can be accessed
     * from any one , and all the url that need 'authentication' also it will
     * configure any coming respone to filter before passing it
     * 
     * @param HttpSecurity the http to configure the securtiy
     * @return nothing
     */

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and().authorizeRequests().antMatchers(PUPLIC_END_POINTS).permitAll().anyRequest().authenticated().and()
                .addFilterBefore(authFilter(), UsernamePasswordAuthenticationFilter.class);

    }

}