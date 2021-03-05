package co.com.ceiba.alquilerpeliculas.dominio.model.entidad;

import java.util.Calendar;
import java.util.Date;

public class Alquiler {

	private static final String FECHA_ALQUILER_ES_UN_DATO_OBLIGATORIO = "La Fecha de Alquiler es un dato obligatorio.";
	private static final String FECHA_ENTREGA_ES_UN_DATO_OBLIGATORIO = "La Fecha de Entrega es un dato obligatorio.";
	private static final String FECHA_ENTREGA_MENOR_FECHA_ALQUILER = "La Fecha de Entrega debe ser mayor a la Fecha de Alquiler.";
	private static final Double VALOR_ALQUILER = (double) 5000;
	private static final Double VALOR_RECARGO = (double) 2000;
	private static final int DIAS_ALQUILER = 2;

	private Long id;
	private Date fechaAlquiler;
	private Date fechaEntrega;
	private Double valor;
	private Date fechaRegistro;

	private Cliente cliente;

	private Pelicula pelicula;

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

		calcularFechaAlquiler();
		setValor(calcularValorAlquiler(getFechaEntrega(), getFechaAlquiler()));
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

	private void calcularFechaAlquiler() {
		setFechaAlquiler(calcularFecha(getFechaAlquiler(), 0));

		if (getFechaEntrega().compareTo(getFechaAlquiler()) < 0
				|| getFechaEntrega().compareTo(getFechaAlquiler()) == 0) {
			setFechaEntrega(calcularFecha(getFechaEntrega(), DIAS_ALQUILER));
		} else {
			setFechaEntrega(calcularFecha(getFechaEntrega(), 0));
		}

	}

	private Date calcularFecha(Date fechaInicial, int dias) {
		int diaSemana = 0;

		Calendar calendario = Calendar.getInstance();
		calendario.setTime(fechaInicial);
		calendario.add(Calendar.DAY_OF_YEAR, dias);
		diaSemana = calendario.get(Calendar.DAY_OF_WEEK);

		if (diaSemana == 1) {
			calendario.add(Calendar.DAY_OF_YEAR, 1);
		}

		if (diaSemana == 7) {
			calendario.add(Calendar.DAY_OF_YEAR, 2);
		}

		return calendario.getTime();

	}

	private Double calcularValorAlquiler(Date fechaAlquiler, Date fechaEntrega) {

		Double valorAlquiler = VALOR_ALQUILER;
		int dias = diasDiferencia(fechaAlquiler, fechaEntrega);

		if (dias > DIAS_ALQUILER) {
			valorAlquiler = VALOR_ALQUILER + VALOR_RECARGO;
		}

		return valorAlquiler;

	}

	private int diasDiferencia(Date fechaIni, Date fechaFin) {

		fechaIni = setMediaNoche(fechaIni);
		fechaFin = setMediaNoche(fechaFin);
		int days = 0;

		Calendar calendar1 = Calendar.getInstance();
		Calendar calendar2 = Calendar.getInstance();

		if (fechaFin.compareTo(fechaIni) > 0) {
			calendar1.setTime(fechaIni);
			calendar2.setTime(fechaFin);

		} else {
			calendar1.setTime(fechaFin);
			calendar2.setTime(fechaIni);

		}

		while (calendar1.compareTo(calendar2) < 0) {
			calendar1.add(Calendar.DAY_OF_MONTH, 1);
			days++;
		}

		return days;

	}

	public Date setMediaNoche(Date date) {

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);

		return calendar.getTime();

	}

}
