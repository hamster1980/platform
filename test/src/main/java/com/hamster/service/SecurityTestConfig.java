package com.hamster.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;
import org.springframework.security.core.Authentication;

@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityTestConfig extends GlobalMethodSecurityConfiguration {

    @Override
    @Bean
    protected AuthenticationManager authenticationManager() throws Exception {
        return new AuthenticationManager() {

            @Override
            public Authentication authenticate(Authentication authentication) {
                return authentication;
            }
            
        };
    }

}
