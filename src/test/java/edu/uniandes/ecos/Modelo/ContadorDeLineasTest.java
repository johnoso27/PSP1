package edu.uniandes.ecos.Modelo;

import static junit.framework.Assert.assertEquals;
import junit.framework.TestCase;

/**
 * Pruebas unitarias para la clase ContadorDeLineas
 *
 * @author JohnDany
 */
public class ContadorDeLineasTest extends TestCase {

    public ContadorDeLineasTest(String testName) {
        super(testName);
    }

    /**
     * Test of ContarLineasCodigoFuente method, of class ContadorDeLineas.
     */
    public void testContarLineasCodigoFuente() {
        ContadorDeLineas contador = new ContadorDeLineas();
        RespuestaContador respuesta = contador.ContarLineasCodigoFuente("src/main/java/ArchivosFuente/psp0", ".java");
        assertNotNull(respuesta);
        assertEquals(72, respuesta.getCantidadLineas());
    }

}
