package com.hamster.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@TestExecutionListeners({ ServiceTestExecutionListener.class })
@ActiveProfiles("test")
public abstract class AServiceTest extends
        AbstractTransactionalJUnit4SpringContextTests {

    @PersistenceContext
    protected EntityManager emf;

}
