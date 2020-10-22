package co.com.ceiba.alquilerpeliculas.dominio.model.entidad;

import static org.junit.Assert.fail;

import org.junit.Assert;
import org.junit.Test;

public class ValidadorAtributosTest {

	@Test
	public void validarAtributosNullTest() {
		final String mensageObligatorio = "El nombre es un dato obligatorio.";

		try {
			ValidadorAtributos.validarAtributos(null, mensageObligatorio);
		} catch (Exception e) {
			Assert.assertTrue(e.getMessage().contains(mensageObligatorio));
		}

	}
	
	@Test
	public void validarAtributosNotNullTest() {
		final String mensageObligatorio = "El nombre es un dato obligatorio.";

		try {
			ValidadorAtributos.validarAtributos("Titanic", mensageObligatorio);
		} catch (Exception e) {
			fail("Should not have thrown any exception");
		}

	}

}
