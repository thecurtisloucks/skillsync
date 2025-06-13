package com.skillsync.backend;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import com.skillsync.backend.config.TestSecurityConfig;

@SpringBootTest
@Import(TestSecurityConfig.class)
class SkillsyncBackendApplicationTests {

	@Test
	void contextLoads() {
	}

}
