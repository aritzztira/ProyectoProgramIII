package junit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import usuarios.Jugador;

import static org.junit.Assert.*;


import org.junit.After;
import org.junit.Before;

class TesteoJugador {

	Jugador p1;
	Jugador p2;
	
	/**
	 * Se lanza antes de los test
	 * @throws Exception excepcion
	 */
	@Before
	public void setUp() throws Exception {
		
		p1 = new Jugador(
				"String nombre", "String apellido1", "String apellido2", 20, "String dni", "String user", "String password", 
	    		"String email", "String tipopersona", "String piernaHabil", 70, 180, "String posicion", 1
	    		);
		
		p2= new Jugador();
	}
	
	/**
	 * Se lanza después de los test
	 * @throws Exception excepcion
	 */
	
	@After
	public void tearDown() throws Exception {
	}
	
	/**
	 * Test de los constructores
	 */
	@Test
	public void testConstructor() 
	{
		
		p2.setNombre("String nombre");
		assertEquals(p1.getNombre(), p2.getNombre(), 0.0);
		
		assertEquals(p1.getNombre(), "String nombre", 0.0);
		
		
	}

}
