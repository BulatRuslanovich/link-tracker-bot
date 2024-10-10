package com.bipbup.scrapper;


import liquibase.command.CommandScope;
import liquibase.database.Database;
import liquibase.database.DatabaseFactory;
import liquibase.database.jvm.JdbcConnection;
import lombok.SneakyThrows;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Testcontainers;

import static liquibase.command.core.InternalSnapshotCommandStep.DATABASE_ARG;
import static liquibase.command.core.UpdateCommandStep.COMMAND_NAME;

@Testcontainers
public abstract class IntegrationEnvironment {
    public static final PostgreSQLContainer<?> POSTGRES;

    static {
        POSTGRES = new PostgreSQLContainer<>("postgres:15")
                .withDatabaseName("scrapper")
                .withUsername("getname")
                .withPassword("1234");
        POSTGRES.start();

        runMigrations();
    }

    @SneakyThrows
    private static void runMigrations() {
        Database database = DatabaseFactory.getInstance()
                .findCorrectDatabaseImplementation(new JdbcConnection(IntegrationEnvironment.POSTGRES.createConnection("")));

        new CommandScope(COMMAND_NAME)
                .addArgumentValue("changelogFile", "db/changelog/db.changelog-master.xml")
                .addArgumentValue(DATABASE_ARG, database)
                .execute();
    }

    @DynamicPropertySource
    static void jdbcProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", POSTGRES::getJdbcUrl);
        registry.add("spring.datasource.username", POSTGRES::getUsername);
        registry.add("spring.datasource.password", POSTGRES::getPassword);
    }
}