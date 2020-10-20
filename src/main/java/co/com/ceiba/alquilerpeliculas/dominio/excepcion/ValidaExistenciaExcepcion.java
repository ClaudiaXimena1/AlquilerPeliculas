package co.com.ceiba.alquilerpeliculas.dominio.excepcion;

public class ValidaExistenciaExcepcion extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ValidaExistenciaExcepcion(String mensaje) {
		super(mensaje);
	}

}
