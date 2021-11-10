package junit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import org.junit.After;
import org.junit.Before;
import usuarios.Tecnico;

class TesteoTecnico {
	
	Tecnico p1;
	Tecnico p2;
	
	/**
	 * Se lanza antes de los test
	 * @throws Exception excepcion
	 */
	@Before
	public void setUp() throws Exception {
		
		p1 = new Tecnico(
				   "String nombre", "String apellido1", "String apellido2", 45, "String dni",
	               "String user", "String password", "String email", "String tipopersona", "String titulacion",
	                "String categoria", 10
		    		);
			
		p2 = new Tecnico();
	}
	
	/**
	 * Se lanza despues de los test
	 * @throws Exception excepcion
	 */
	@After
	public void tearDown() throws Exception {
	}
	
	/**
	 * test de los tecnicos
	 */

	@Test
	public void test() {
	
		assertEquals(p2.getTitulacion(), null);
		
		p2.setTitulacion("String titulacion");
		
		assertEquals(p1.getTitulacion(), p2.getTitulacion());
		
		assertEquals(p1.getTitulacion(), "String titulacion");
		
	}


}
