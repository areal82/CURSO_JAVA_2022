package com.example.restservice.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.restservice.dto.GreetingDTO;
import com.example.restservice.exception.ResourceNotFoundException;
import com.example.restservice.model.Greeting;
import com.example.restservice.service.GreetingService;

@ExtendWith(MockitoExtension.class)
class GreetingControllerTest {
	
	@InjectMocks
	GreetingController controller;
	
	@Mock
	GreetingService service;
	
	// @Before -> JUNIT 4
	@BeforeEach // JUNIT 5
	void setup_test() {
		
		// INIT TEST VARIABLES		
	}
	
	@Test
	void test_findAll() throws Exception {
		
		// DEFINICIÓN DE VARIABLES DE ENTRADA Y RESULTADOS
		List<Greeting> expectedResult = new ArrayList<>();
		expectedResult.add(new Greeting("Hola", "ES"));
		expectedResult.add(new Greeting("Hello", "EN"));
		// Mockito.anyString(), Mockito.anyString(), Mockito.anyString()
		expectedResult.add(Mockito.mock(Greeting.class));
		expectedResult.add(Mockito.mock(Greeting.class));
		
		// COMPORTAMIENTO ESPERADO DEL CUERPO DEL MÉTODO
		when(service.findAllGreetings()).thenReturn(expectedResult);		
		
		// LLAMADA A MÉTODO A TESTEAR
		List<GreetingDTO> currentResult = controller.greetings();
		
		// assertEquals -> JUNIT 4
		// assertThat -> JUNIT 5
		// COMPROBACIONES DEL RESULTADO ESPERADO;
		assertThat(currentResult).isNotNull();
		assertThat(currentResult).isNotEmpty();
		// assertThat(currentResult.size()).isGreaterThan(2);
		assertThat(currentResult).hasSizeGreaterThan(2);
		assertThat(currentResult).hasSize(4);
	}
	
	@Test
	void test_findAll_KO() throws Exception {
		
		// DEFINICIÓN DE VARIABLES DE ENTRADA Y RESULTADOS
		
		// COMPORTAMIENTO ESPERADO DEL CUERPO DEL MÉTODO
		when(service.findAllGreetings()).thenThrow(new ResourceNotFoundException("No existen saludos en la base de datos!"));		
		
		// LLAMADA A MÉTODO A TESTEAR
		try {
			List<GreetingDTO> currentResult = controller.greetings();
			assertThat(Boolean.FALSE);
		} catch (ResourceNotFoundException e) {
			assertThat(Boolean.TRUE);
		}
	}
}
