package com.example.restservice.integration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.restservice.RestServiceApplication;
import com.example.restservice.model.Greeting;

@SpringBootTest(classes = RestServiceApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class GreetingAppIntegrationTest {

	@Autowired
	private TestRestTemplate restTemplate;
	
	private String getRootUrl() {
		return "http://localhost:8083/api/v1";
	}

	@Test
	void testGetAllGreetings() {
		HttpHeaders headers = new HttpHeaders();
		HttpEntity<String> entity = new HttpEntity<String>(null, headers);
		
		ResponseEntity<String> response = restTemplate
				.exchange(getRootUrl() + "/greetings",
				HttpMethod.GET, entity, String.class);
		
		assertNotNull(response.getBody());
		assertEquals(HttpStatus.OK, response.getStatusCode());
	}
	
	@Test
	void test_KO() {
		HttpHeaders headers = new HttpHeaders();
		HttpEntity<String> entity = new HttpEntity<String>(null, headers);
		
		ResponseEntity<String> response = restTemplate
				.exchange(getRootUrl() + "/greetingsSSS",
				HttpMethod.GET, entity, String.class);
		
		assertNotNull(response.getBody());
		assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
	}
	
	@Test
	void testCreateGreeting() {
		Greeting newGreeting = new Greeting("Saludos, test de integracion", "ES");

		ResponseEntity<Greeting> postResponse = restTemplate.postForEntity(getRootUrl() + "/greeting", newGreeting, Greeting.class);
		assertNotNull(postResponse);
		assertNotNull(postResponse.getBody());
		assertEquals(HttpStatus.OK, postResponse.getStatusCode());
	}
}
