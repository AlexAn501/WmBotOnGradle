package ru.worldmac.wmbot.testConfig;

import org.testcontainers.containers.PostgreSQLContainer;

public final class TestPostgresContainer extends PostgreSQLContainer<TestPostgresContainer> {

    private static final String IMAGE_VERSION = "postgres:latest";
    private static final String SCHEMA_NAME = "wm_bot";

    private static TestPostgresContainer postgreSQLContainer;

    private TestPostgresContainer() {
        super(IMAGE_VERSION);
    }

    public static TestPostgresContainer getInstance() {
        if (postgreSQLContainer == null) {
            postgreSQLContainer = new TestPostgresContainer()
                    .withDatabaseName("postgres")
                    .withUrlParam("currentSchema", SCHEMA_NAME)
                    .withUsername("postgres")
                    .withPassword("postgres");
        }
        return postgreSQLContainer;
    }

    @Override
    public void start() {
        super.start();
        //Setting access to the container for tests
        String jdbcUrl = postgreSQLContainer.getJdbcUrl();
        System.setProperty("DB_URL", jdbcUrl);
        System.setProperty("DB_USERNAME", postgreSQLContainer.getUsername());
        System.setProperty("DB_PASSWORD", postgreSQLContainer.getPassword());
    }

    @Override
    public void stop() {
        //do nothing, JVM handles shut down
    }
}

