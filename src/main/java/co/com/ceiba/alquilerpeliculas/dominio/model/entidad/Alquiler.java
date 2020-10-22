package co.com.ceiba.alquilerpeliculas.dominio.model.entidad;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

public class Alquiler {

	private Long id;
	private Date fechaAlquiler;
	private Date fechaEntrega;
	private Double valor;
	private Date fechaRegistro;

	@Autowired
	private Cliente cliente;

	@Autowired
	private Pelicula pelicula;

	public Alquiler() {

	}

	public Alquiler(Long id, Date fechaAlquiler, Date fechaEntrega, Double valor, Date fechaRegistro, Cliente cliente,
			Pelicula pelicula) {
		super();
		this.id = id;
		this.fechaAlquiler = (Date) fechaAlquiler.clone();
		this.fechaEntrega = fechaEntrega;
		this.valor = valor;
		this.fechaRegistro = fechaRegistro;
		this.cliente = cliente;
		this.pelicula = pelicula;
	}

	public Long getId() {
		return id;
	}

	public Date getFechaAlquiler() {
		return fechaAlquiler;
	}

	public void setFechaAlquiler(Date fechaAlquiler) {
		this.fechaAlquiler = fechaAlquiler;
	}

	public Date getFechaEntrega() {
		return fechaEntrega;
	}

	public void setFechaEntrega(Date fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Pelicula getPelicula() {
		return pelicula;
	}

	public void setPelicula(Pelicula pelicula) {
		this.pelicula = pelicula;
	}

}
