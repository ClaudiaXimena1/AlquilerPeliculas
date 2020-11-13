package co.com.ceiba.alquilerpeliculas.dominio.servicio.alquiler;

import co.com.ceiba.alquilerpeliculas.dominio.puerto.repositorio.AlquilerRepositorio;

public class ConsultarValorTotalServicio {
	
	private AlquilerRepositorio alquilerRepositorio;
	
	public ConsultarValorTotalServicio(AlquilerRepositorio alquilerRepositorio) {
		this.alquilerRepositorio = alquilerRepositorio;
	}
	
	public Double ejecutar(String identificacion, String fechaAlquiler) {
		return alquilerRepositorio.calcularTotalAlquiler(identificacion, fechaAlquiler);
	}

}
