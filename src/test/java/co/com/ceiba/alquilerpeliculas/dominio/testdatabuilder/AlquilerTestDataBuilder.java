package co.com.ceiba.alquilerpeliculas.dominio.testdatabuilder;

import java.util.Date;

import co.com.ceiba.alquilerpeliculas.dominio.model.entidad.Alquiler;
import co.com.ceiba.alquilerpeliculas.dominio.model.entidad.Cliente;
import co.com.ceiba.alquilerpeliculas.dominio.model.entidad.Pelicula;

public class AlquilerTestDataBuilder {

	private Date fechaAlquiler;
	private Date fechaEntrega;
	private Double valor;
	private Cliente cliente;
	private Pelicula pelicula;

	public AlquilerTestDataBuilder(){
		this.fechaAlquiler = null;
		this.fechaEntrega = null;
		this.valor = (double) 5000;
		this.cliente = new Cliente(null, "94444555","Alexander","Lozada Avila", "Calle 2B con 81A", "4445566","3166998877");
		this.pelicula = new Pelicula(null, "Batman","Accion","2 horas 15 minutos");
	}

	public AlquilerTestDataBuilder setFechaAlquiler(Date fechaAlquiler) {
		this.fechaAlquiler = fechaAlquiler;
		return this;
	}

	public AlquilerTestDataBuilder setFechaEntrega(Date fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
		return this;
	}

	public AlquilerTestDataBuilder setValor(Double valor) {
		this.valor = valor;
		return this;
	}

	public AlquilerTestDataBuilder setCliente(Cliente cliente) {
		this.cliente = cliente;
		return this;
	}

	public AlquilerTestDataBuilder setPelicula(Pelicula pelicula) {
		this.pelicula = pelicula;
		return this;
	}

	public Alquiler build() {
		return new Alquiler(fechaAlquiler, fechaEntrega, valor, cliente, pelicula);
	}

}
