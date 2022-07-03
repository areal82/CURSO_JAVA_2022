package com.example.restservice.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.StringUtils;

import com.example.restservice.dto.GreetingDTO;

class GreetingTest {
	
	@Test
	void bean_null_test() {
		final GreetingDTO checkNull = new GreetingDTO("test", "test");
		
		if(StringUtils.isBlank(checkNull.toString())) {
			Assertions.fail();
		}
		
	}
}
