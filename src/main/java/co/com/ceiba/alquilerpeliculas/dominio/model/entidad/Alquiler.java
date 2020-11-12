package co.com.ceiba.alquilerpeliculas.dominio.model.entidad;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

public class Alquiler {

	private static final String FECHA_ALQUILER_ES_UN_DATO_OBLIGATORIO = "La Fecha de Alquiler es un dato obligatorio.";
	private static final String FECHA_ENTREGA_ES_UN_DATO_OBLIGATORIO = "La Fecha de Entrega es un dato obligatorio.";
	private static final String FECHA_ENTREGA_MENOR_FECHA_ALQUILER = "La Fecha de Entrega debe ser mayor a la Fecha de Alquiler.";
	
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

	public Alquiler(Date fechaAlquiler, Date fechaEntrega, Double valor, Cliente cliente, Pelicula pelicula) {
		ValidadorAtributos.validarAtributos(fechaAlquiler, FECHA_ALQUILER_ES_UN_DATO_OBLIGATORIO);
		ValidadorAtributos.validarAtributos(fechaEntrega, FECHA_ENTREGA_ES_UN_DATO_OBLIGATORIO);
		ValidadorAtributos.validarFechas(fechaAlquiler, fechaEntrega, FECHA_ENTREGA_MENOR_FECHA_ALQUILER);

		this.fechaAlquiler = (Date) fechaAlquiler.clone();
		this.fechaEntrega = (Date) fechaEntrega.clone();
		this.valor = valor;
		this.fechaRegistro = new Date();
		this.cliente = cliente;
		this.pelicula = pelicula;
	}

	public void setId(Long id) {
		this.id = id;
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
