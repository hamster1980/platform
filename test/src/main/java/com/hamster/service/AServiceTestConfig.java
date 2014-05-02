package com.hamster.service;

import java.util.Collection;

import javax.sql.DataSource;

import org.dbunit.DataSourceDatabaseTester;
import org.dbunit.util.fileloader.XlsDataFileLoader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

@ImportResource({ "classpath:spring/tx-jpa.xml" })
@Import({ SecurityTestConfig.class })
@ComponentScan(basePackages = { "com.hamster" })
@Profile("test")
public abstract class AServiceTestConfig {

    public static final String DATABASE_TESTER_BEAN = "databaseTester";
    public static final String XLS_DATA_FILE_LOADER_BEAN = "xlsDataFileLoader";

    @Bean
    public DataSource dataSource() {
        EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2);
        for (String script : getScripts()) {
            builder.addScript(script);
        }
        return builder.build();
    }

    @Bean(name = DATABASE_TESTER_BEAN)
    public DataSourceDatabaseTester dataSourceDatabaseTester() {
        return new DataSourceDatabaseTester(dataSource());
    }

    @Bean(name = XLS_DATA_FILE_LOADER_BEAN)
    public XlsDataFileLoader xlsDataFileLoader() {
        return new XlsDataFileLoader();
    }

    protected abstract Collection<String> getScripts();

}
