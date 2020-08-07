package ec.edu.epn.git;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestEditorTexto {

private editor ed;
	
    @BeforeClass
	public static void beforeClass() {
        System.out.println("beforeClass");
       
        }
	
	@Before
    public void before() {
      System.out.println("before");
      ed = new editor();
    }
	
	@Test
	public void testGuardar() {
		String ruta = "C:/Users/User/Desktop/testGuardar.txt";
		String texto = "Hola mundo!";
		int actual=ed.Guardar(ruta,texto);
		int esperado=1;
		assertEquals(esperado, actual);
	
	}
	
	@Test
	public void testAbrir() {
		String ruta = "C:/Users/User/Desktop/testGuardar.txt";
		int actual=ed.Abrir(ruta);
		int esperado=1;
		assertEquals(esperado, actual);
	
	}
	
	@Test
	public void testNuevo() {
		int actual=ed.Nuevo();
		int esperado=1;
		assertEquals(esperado, actual);
	
	}
	
	
	
	

}
