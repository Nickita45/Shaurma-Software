package com.orders.management;

import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Test;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testcontainers.containers.DockerComposeContainer;
import org.testcontainers.containers.MySQLContainer;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class SpringBootAppIntegrationTest extends MySQLContainer<SpringBootAppIntegrationTest> {
    private static final Logger logger = LoggerFactory.getLogger(SpringBootAppIntegrationTest.class);
    private static final String IMAGE_VERSION ;
    private static final String DRIVER;
    private static final String MYSQL_JDBC_URL_EXT = "?createDatabaseIfNotExist=true&autoReconnect=true&useUnicode=true&characterEncoding=utf-8&useSSL=false&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private static final long STARTUP_TIMEOUT_SECONDS = 300;
    private static final String TEST_APPLICATION_PROPERTIES = "src/test/resources/application.properties";
    private static final String APPLICATION_PROPERTIES = "src/main/resources/application.properties";
    private static final String SYSTEM_PROPERTY__DB_URL = "DB_URL";
    private static final String SYSTEM_PROPERTY__DB_USERNAME = "user";
    private static final String SYSTEM_PROPERTY__DB_PASSWORD = "password";
    private static final String APPLICATION_PROPERTY_NAME__DRIVER_CLASS_NAME = "spring.datasource.driver-class-name";
    private static final String TEST_APPLICATION_PROPERTY_NAME__MYSQL_CONTAINER_IMAGE_VERSION = "mysqlContainerImageVersion";

    static {
        String driver;
        String mysqlContainerImageVersion;
        Properties applicationProperties = new Properties();
        Properties testApplicationProperties = new Properties();
        try {
            applicationProperties.load(new FileReader(APPLICATION_PROPERTIES));
            driver = applicationProperties.getProperty(APPLICATION_PROPERTY_NAME__DRIVER_CLASS_NAME);

            testApplicationProperties.load(new FileReader(TEST_APPLICATION_PROPERTIES));
            mysqlContainerImageVersion = testApplicationProperties.getProperty(TEST_APPLICATION_PROPERTY_NAME__MYSQL_CONTAINER_IMAGE_VERSION);
        }
        catch (IOException e) {
            driver = "com.mysql.cj.jdbc.Driver";    // ""com.mysql.jdbc.Driver";
            mysqlContainerImageVersion = "5.7";
        }

        DRIVER = driver;
        logger.info("  !!!!!!!! TEST CONTAINER - spring.datasource.driver-class-name : " + DRIVER);

        IMAGE_VERSION = "mysql:" + mysqlContainerImageVersion;
        logger.info("  !!!!!!!! TEST CONTAINER - DB image version : " + IMAGE_VERSION);
    }


    private static SpringBootAppIntegrationTest container;

    private SpringBootAppIntegrationTest() {
        super(IMAGE_VERSION);
    }

    public static SpringBootAppIntegrationTest getInstance() {
        if (container == null) {
            container = new SpringBootAppIntegrationTest()
                    .withStartupTimeout(Duration.ofSeconds(STARTUP_TIMEOUT_SECONDS))
            ;
        }
        return container;
    }

    @Override
    public String getDriverClassName() {
        return DRIVER;
    }

    @Override
    public String getJdbcUrl() {
        return super.getJdbcUrl() + MYSQL_JDBC_URL_EXT;
    }

    @Override
    public String getTestQueryString() {
        return "SELECT 1";
    }

    @Override
    public void start() {
        logger.info("               !!!!!!!!!!!!!!!!!!!!!!!!! Trying to start container !!!!!!!!!!!!!!!!!!!!!!!!!!");

        super.start();
        System.setProperty(SYSTEM_PROPERTY__DB_URL, container.getJdbcUrl());
        System.setProperty(SYSTEM_PROPERTY__DB_USERNAME, container.getUsername());
        System.setProperty(SYSTEM_PROPERTY__DB_PASSWORD, container.getPassword());

        logger.info("               !!!!!!!!!!!!!!!!!!!!!!!!! TestAppMysqlContainer STARTED !!!!!!!!!!!!!!!!!!!!!!!!!!");
        logger.info("               !!!!!!!!!!!!!!!!!!!!!!!!! MySql STARTED !!!!!!!!!!!!!!!!!!!!!!!!!!");
        logger.info("               !!!!!!!!!!!!!!!!!!!!!!!!! JdbcUrl: " + container.getJdbcUrl() + " !!!!!!!!!!!!!!!!!!!!!!!!!!");
        logger.info("               !!!!!!!!!!!!!!!!!!!!!!!!! USERNAME: " + container.getUsername() + " !!!!!!!!!!!!!!!!!!!!!!!!!!");
        logger.info("               !!!!!!!!!!!!!!!!!!!!!!!!! PASSWORD: " + container.getPassword() + " !!!!!!!!!!!!!!!!!!!!!!!!!!");
    }

    @Override
    public void stop() {
        //do nothing, JVM handles shut down
        logger.info("               !!!!!!!!!!!!!!!!!!!!!!!!! TestAppMysqlContainer STOPPED !!!!!!!!!!!!!!!!!!!!!!!!!!");
    }
}
