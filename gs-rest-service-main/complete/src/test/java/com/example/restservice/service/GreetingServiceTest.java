package com.example.restservice.service;

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

import com.example.restservice.model.Greeting;
import com.example.restservice.repository.GreetingRepository;
import com.example.restservice.service.impl.GreetingServiceImpl;


//@RunWith(SpringJUnit4ClassRunner.class) -> JUNIT 4
//@RunWith(MockitoJUnitRunner.class) -> JUNIT 4
//@ExtendWith(SpringExtension.class) // -> JUNIT 5
@ExtendWith(MockitoExtension.class) // -> JUNIT 5
class GreetingServiceTest {
	
	@InjectMocks
	GreetingServiceImpl service;
	
	@Mock
	GreetingRepository repository;
	
	private Integer greetingId;
	
	// @Before -> JUNIT 4
	@BeforeEach // JUNIT 5
	void setup_test() {
		
		// INIT TEST VARIABLES	
		
		greetingId = Integer.valueOf(1);
		
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
		expectedResult.add(Mockito.mock(Greeting.class));
		expectedResult.add(Mockito.mock(Greeting.class));
		
		// COMPORTAMIENTO ESPERADO DEL CUERPO DEL MÉTODO
		when(repository.findAll()).thenReturn(expectedResult);		
		
		// LLAMADA A MÉTODO A TESTEAR
		List<Greeting> currentResult = service.findAllGreetings();
		
		// assertEquals -> JUNIT 4
		// assertThat -> JUNIT 4
		// COMPROBACIONES DEL RESULTADO ESPERADO;
		assertThat(currentResult).isNotNull();
		assertThat(currentResult).isNotEmpty();
		// assertThat(currentResult.size()).isGreaterThan(2);
		assertThat(currentResult).hasSizeGreaterThan(2);
		assertThat(currentResult).hasSize(6);
	}
}
