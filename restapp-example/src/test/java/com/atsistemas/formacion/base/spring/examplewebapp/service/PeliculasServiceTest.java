package com.atsistemas.formacion.base.spring.examplewebapp.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.atsistemas.formacion.base.spring.examplewebapp.model.Pelicula;
import com.atsistemas.formacion.base.spring.examplewebapp.repository.impl.PeliculasRepositoryImpl;
import com.atsistemas.formacion.base.spring.examplewebapp.service.impl.PeliculasServiceImpl;

// @RunWith(SpringJUnit4ClassRunner.class) -> JUNIT 4
// @RunWith(MockitoJUnitRunner.class) -> JUNIT 4
// @ExtendWith(SpringExtension.class) -> JUNIT 5
@ExtendWith(MockitoExtension.class) // -> JUNIT 5
public class PeliculasServiceTest {
	
	@InjectMocks
	PeliculasServiceImpl peliculasService;
	
	@Mock
	PeliculasRepositoryImpl repository;
	
	private Map<Integer, Pelicula> peliculas;
	private Integer id;
	private Pelicula expectedFilm;
	
	
	@BeforeEach
	void setup_test() {
		
		peliculas = new HashMap<>();
		peliculas.put(1,
				new Pelicula(1, "2001", "Stanley Kubrik", "Ci-Fi", "1968"));
		peliculas.put(2,
				new Pelicula(2, "Alien", "Ridley Scott", "Ci-Fi", "1979"));
		
		// INIT TEST VARIABLES	
		
		id = Integer.valueOf(1);
		expectedFilm = peliculas.get(1);
		
	}
	
	@Test
	//@DisplayName("Test para buscar una pelicula")
	void test_buscarPelicula() throws Exception {
		
		// DEFINICIÓN DE VARIABLES DE ENTRADA Y RESULTADOS
		Integer peliculaIdParam = Integer.valueOf("1");
		Pelicula valorEsperado = new Pelicula(1, "2001", "Stanley Kubrik", "Ci-Fi", "1968");
		Integer valorIncorrecto = Integer.valueOf("9");
		
		// COMPORTAMIENTO ESPERADO DEL CUERPO DEL MÉTODO
		// BDDMockito.given(repository.buscarPelicula(id)).willReturn(valorEsperado);
		// Mockito.when(repository.buscarPelicula(anyInt())).thenReturn((any(Pelicula.class)));
		// Mockito.when(repository.buscarPelicula(any(Integer.class))).thenReturn(any());
		
		when(repository.buscarPelicula(peliculaIdParam)).thenReturn(valorEsperado);
		
		
		// LLAMADA A MÉTODO A TESTEAR
		Pelicula peliculaActual = peliculasService.buscarPelicula(peliculaIdParam);
		
		
		// COMPROBACIONES DEL RESULTADO ESPERADO
		assertNotNull(peliculaActual);
		assertEquals(peliculaIdParam, peliculaActual.getId());
		// assertEquals(valorIncorrecto, peliculaActual.getId());
	}
	
	@Test
	@DisplayName("Test para cubrir el caso de lanzar una excepción")
	void test_buscarPelicula_error() throws Exception {
		
		// DEFINICIÓN DE VARIABLES DE ENTRADA Y RESULTADOS
		Integer peliculaIdParam = null;
		
		when(repository.buscarPelicula(peliculaIdParam)).thenThrow(new Exception("test"));
		
		// LLAMADA A MÉTODO A TESTEAR
		Pelicula peliculaActual = peliculasService.buscarPelicula(peliculaIdParam);
		
		
		// COMPROBACIONES DEL RESULTADO ESPERADO
		assertNotNull(peliculaActual);
		assertEquals("ERROR", peliculaActual.getTitulo());
	}
	
	
	@Test()
	//@DisplayName("Test para obtener una lista de peliculas")
	void test_listarPeliculas() throws Exception {
		
		// DEFINICIÓN DE VARIABLES DE ENTRADA
		List<Pelicula> resultadoEsperado = List.of(peliculas.get(1));
		// List<Pelicula> resultadoEsperado = new ArrayList<>();
		
		// COMPORTAMIENTO ESPERADO DEL CUERPO DEL MÉTODO
		// when(repository.listarPeliculas()).thenReturn(anyList());
		when(repository.listarPeliculas()).thenReturn(resultadoEsperado);
		
		// LLAMADA A MÉTODO A TESTEAR
		List<Pelicula> peliculasActual = peliculasService.listarPeliculas();
		
		// COMPROBACIONES DEL RESULTADO ESPERADO
		assertNotNull(peliculasActual);
		// assertEquals(peliculas.size(), Integer.valueOf(1));
		assertTrue(peliculasActual.size() > 0);
	}
	
	
	@Test
	void test_guardarPeliculaId() {
		
		
		// DEFINICIÓN DE VARIABLES DE ENTRADA
		Pelicula peliculaParam = new Pelicula();
		Integer peliculaIdEsperado = 1;
		
		// COMPORTAMIENTO ESPERADO DEL CUERPO DEL MÉTODO
		when(repository.guardarPeliculaId(peliculaParam)).thenReturn(peliculaIdEsperado);
		
		
		// LLAMADA A MÉTODO A TESTEAR
		Integer idActual = peliculasService.guardarPeliculaId(peliculaParam);
		
		
		// COMPROBACIONES DEL RESULTADO ESPERADO
		assertNotNull(idActual);
		assertTrue(idActual.intValue() > -1);
		assertEquals(peliculaIdEsperado, idActual);
		
		
	}
	
}
