package com.hamster.service;

import java.util.Collection;

import org.springframework.context.annotation.Configuration;

import com.google.common.collect.ImmutableSet;

@Configuration
public class TestConfig extends AServiceTestConfig {

    @Override
    protected Collection<String> getScripts() {
        return ImmutableSet.of("classpath:db/common-schema.sql");
    }
}
