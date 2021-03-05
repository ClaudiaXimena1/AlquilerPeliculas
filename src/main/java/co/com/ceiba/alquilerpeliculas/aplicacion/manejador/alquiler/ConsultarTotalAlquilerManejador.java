package co.com.ceiba.alquilerpeliculas.aplicacion.manejador.alquiler;

import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import co.com.ceiba.alquilerpeliculas.dominio.servicio.alquiler.ConsultarValorTotalServicio;

@Component
public class ConsultarTotalAlquilerManejador {

	private ConsultarValorTotalServicio consultarValorTotalServicio;

	public ConsultarTotalAlquilerManejador(ConsultarValorTotalServicio consultarValorTotalServicio) {
		this.consultarValorTotalServicio = consultarValorTotalServicio;
	}
	
	@Transactional
	public Double ejecutar(String identificacion, String fechaAlquiler) {
		return consultarValorTotalServicio.ejecutar(identificacion, fechaAlquiler);
	}

}
