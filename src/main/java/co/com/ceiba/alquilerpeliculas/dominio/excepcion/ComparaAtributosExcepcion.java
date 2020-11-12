package co.com.ceiba.alquilerpeliculas.dominio.excepcion;

public class ComparaAtributosExcepcion extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public ComparaAtributosExcepcion(String mensaje) {
		super(mensaje);
	}


}
