package com.example.restservice;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.example.restservice.service.GreetingService;

@ExtendWith(MockitoExtension.class)
class TestMockitoExtensionCase {
	
	@MockBean
	GreetingService service;

    @Test
    void test() {
        assertThat(service).isNotNull(); // Test will fail
    }
}
