package co.com.ceiba.alquilerpeliculas.dominio.excepcion;

public class ValidaAtributosObligatorios extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ValidaAtributosObligatorios(String mensaje) {
		super(mensaje);
	}

}
