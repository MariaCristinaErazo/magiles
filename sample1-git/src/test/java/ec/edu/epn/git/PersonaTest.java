package ec.edu.epn.git;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.After;

public class PersonaTest {
	
  private Persona per;
	
    @BeforeClass
	public static void beforeClass() {
        System.out.println("beforeClass");
       
       
    }
	
	@Before
    public void before() {
      System.out.println("before");
      per = new Persona();
    }
	
	@Test
	public void testVerificarUsuario() {
    per.setUsuario("Edwin");
	boolean actual=per.VerificarUsuario(per.getUsuario());
	boolean esperado=true;
	assertEquals(esperado, actual);
	}
	
	@Test
	public void testVerificarContrasenia() {
	per.setContrasenia("asdf1234");
	boolean actual=per.VerificarContrasenia(per.getContrasenia());
	boolean esperado=true;
	assertEquals(esperado, actual);
		
	}
	@After
	  public void after () {
	      per=null;
	      System.out.println("after");
	    }

}
