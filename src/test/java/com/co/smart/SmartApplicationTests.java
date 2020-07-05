package com.co.smart;

import org.junit.Ignore;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
@Ignore("fix issue with liquibase migration - use another profile for h2 only")
class SmartApplicationTests {

	@Test
	void contextLoads() {
	}

}
