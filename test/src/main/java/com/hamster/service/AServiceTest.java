package com.hamster.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.After;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.google.common.collect.ImmutableList;

@RunWith(SpringJUnit4ClassRunner.class)
@TestExecutionListeners({ ServiceTestExecutionListener.class })
@ActiveProfiles("test")
public abstract class AServiceTest extends AbstractTransactionalJUnit4SpringContextTests {

    @PersistenceContext
    protected EntityManager emf;
    @Autowired
    private AuthenticationManager am;
    
    @After
    public void clear() {
        SecurityContextHolder.clearContext();
    }

    protected void defaultLogin() {
        defaultLogin("ROLE_EMPTY");
    }
    
    protected void defaultLogin(String role) {
        Authentication auth = new UsernamePasswordAuthenticationToken("", "", ImmutableList.of(new SimpleGrantedAuthority(role)));
        SecurityContextHolder.getContext().setAuthentication(auth);//am.authenticate(auth));
    }
    
}
