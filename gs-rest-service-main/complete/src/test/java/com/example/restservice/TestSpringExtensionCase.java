package com.example.restservice;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.restservice.service.GreetingService;

@ExtendWith(SpringExtension.class)
class TestSpringExtensionCase {
	
	@MockBean
	GreetingService service;

    @Test
    void test() {
        assertThat(service).isNotNull(); // Test succeeds
    }
}
