package co.com.ceiba.alquilerpeliculas.dominio.model.entidad;

import org.junit.Assert;
import org.junit.Test;

public class ValidadorAtributosTest {

	@Test
	public void validarAtributosTest() {
		final String mensageObligatorio = "El nombre es un dato obligatorio.";

		try {
			ValidadorAtributos.validarAtributos(null, mensageObligatorio);
		} catch (Exception e) {
			Assert.assertTrue(e.getMessage().contains(mensageObligatorio));
		}

	}

}
