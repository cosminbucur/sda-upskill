package com.sda.oauth2;

import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

public class JWTSecurityConfig extends WebSecurityConfigurerAdapter {

//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests(auth -> auth
//                // anyone with access token and scope read, can ge items
//                .antMatchers(HttpMethod.GET, "/items/**").hasAuthority("SCOPE_read")
//                .antMatchers(HttpMethod.POST, "/items/**").hasAuthority("SCOPE_write")
//                .anyRequest().authenticated())
//                // indicate the type of tokens supported by the server
//                .oauth2ResourceServer(oauth2 -> oauth2.jwt());
//    }
}
