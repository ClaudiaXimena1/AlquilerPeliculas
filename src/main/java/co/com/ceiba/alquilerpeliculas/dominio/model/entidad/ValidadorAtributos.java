package co.com.ceiba.alquilerpeliculas.dominio.model.entidad;

import co.com.ceiba.alquilerpeliculas.dominio.excepcion.ValidaAtributosObligatorios;

public class ValidadorAtributos {
    
	private ValidadorAtributos() {}
	
	public static void validarAtributos(Object atributo, String mensaje) {

		if (atributo == null) {
			
			throw new ValidaAtributosObligatorios(mensaje);
			
		}

	}

}
