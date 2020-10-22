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
		this.fechaEntrega = (Date) fechaEntrega.clone();
		this.valor = valor;
		this.fechaRegistro = (Date) fechaRegistro.clone();
		this.cliente = cliente;
		this.pelicula = pelicula;
	}

	public Long getId() {
		return id;
	}

	public Date getFechaAlquiler() {
		return (Date) fechaAlquiler.clone();
	}

	public void setFechaAlquiler(Date fechaAlquiler) {
		this.fechaAlquiler = (Date) fechaAlquiler.clone();
	}

	public Date getFechaEntrega() {
		return (Date) fechaEntrega.clone();
	}

	public void setFechaEntrega(Date fechaEntrega) {
		this.fechaEntrega = (Date) fechaEntrega.clone();
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Date getFechaRegistro() {
		return (Date) fechaRegistro.clone();
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = (Date) fechaRegistro.clone();
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
