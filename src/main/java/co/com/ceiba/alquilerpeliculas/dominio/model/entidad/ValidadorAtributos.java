package co.com.ceiba.alquilerpeliculas.dominio.model.entidad;

import java.util.Date;

import co.com.ceiba.alquilerpeliculas.dominio.excepcion.ComparaAtributosExcepcion;
import co.com.ceiba.alquilerpeliculas.dominio.excepcion.ValidaAtributosObligatorios;

public final class ValidadorAtributos {

	private ValidadorAtributos() {

	}

	public static void validarAtributos(Object atributo, String mensaje) {

		if (atributo == null || atributo == "") {
			throw new ValidaAtributosObligatorios(mensaje);
		}

	}

	public static void validarFechas(Date fechaIni, Date fechaFin, String mensaje) {

		if (fechaFin.before(fechaIni)) {
			throw new ComparaAtributosExcepcion(mensaje);
		}
	}

}
