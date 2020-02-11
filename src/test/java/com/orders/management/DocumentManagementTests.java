package com.orders.management;

import org.junit.ClassRule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class DocumentManagementTests {

	@ClassRule
	public static SpringBootAppIntegrationTest testAppMysqlContainer = SpringBootAppIntegrationTest.getInstance();

	private static final Logger logger = LoggerFactory.getLogger(DocumentManagementTests.class);
	public void contextLoads() {
		//assertEquals(1, 1);
		logger.info("               !!!!!!!!!!!!!!!!!!!!!!!!! contextLoaded OK !!!!!!!!!!!!!!!!!!!!!!!!!!");
    }
    @Test
	public void test()
	{
		System.out.println("test");
	}

}
