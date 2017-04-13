package com.sprint.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class AppConfig {

	@Bean
	public ATest test() {
		return new ATestImpl();
	}

}
