package co.com.ceiba.alquilerpeliculas.dominio.servicio.alquiler;

import java.util.Calendar;
import java.util.Date;

import co.com.ceiba.alquilerpeliculas.dominio.excepcion.ValidaExistenciaExcepcion;
import co.com.ceiba.alquilerpeliculas.dominio.model.dto.AlquilerDto;
import co.com.ceiba.alquilerpeliculas.dominio.model.entidad.Alquiler;
import co.com.ceiba.alquilerpeliculas.dominio.model.entidad.Cliente;
import co.com.ceiba.alquilerpeliculas.dominio.model.entidad.Pelicula;
import co.com.ceiba.alquilerpeliculas.dominio.puerto.repositorio.AlquilerRepositorio;
import co.com.ceiba.alquilerpeliculas.dominio.puerto.repositorio.ClienteRepositorio;
import co.com.ceiba.alquilerpeliculas.dominio.puerto.repositorio.PeliculaRepositorio;

public class RegistrarAlquilerServicio {

	private AlquilerRepositorio alquilerRepositorio;
	private ClienteRepositorio clienteRepositorio;
	private PeliculaRepositorio peliculaRepositorio;

	private static final String EL_CLIENTE_NO_EXISTE_EN_EL_SISTEMA = "El Cliente no existe en el sistema.";
	private static final String LA_PELICULA_NO_EXISTE_EN_EL_SISTEMA = "La Pelicula no existe en el sistema.";
	private static final Double VALOR_ALQUILER = (double) 5000;
	private static final Double VALOR_RECARGO = (double) 2000;
	private static final int DIAS_ALQUILER = 2;

	public RegistrarAlquilerServicio(AlquilerRepositorio alquilerRepositorio, ClienteRepositorio clienteRepositorio,
			PeliculaRepositorio peliculaRepositorio) {
		this.alquilerRepositorio = alquilerRepositorio;
		this.clienteRepositorio = clienteRepositorio;
		this.peliculaRepositorio = peliculaRepositorio;
	}

	public AlquilerDto ejecutar(Alquiler alquiler) {
		Long idPelicula = validaExistePeli(alquiler.getPelicula().getNombre());
		Long idCliente = validaExisteCliente(alquiler.getCliente().getIdentificacion());

		if (idCliente != null) {
			Cliente cliente = clienteRepositorio.findById(idCliente);
			alquiler.setCliente(cliente);
		} else {
			throw new ValidaExistenciaExcepcion(EL_CLIENTE_NO_EXISTE_EN_EL_SISTEMA);
		}

		if (idPelicula != null) {
			Pelicula pelicula = peliculaRepositorio.findById(idPelicula);
			alquiler.setPelicula(pelicula);
		} else {
			throw new ValidaExistenciaExcepcion(LA_PELICULA_NO_EXISTE_EN_EL_SISTEMA);
		}

		alquiler.setFechaAlquiler(calcularFecha(alquiler.getFechaAlquiler(), 0));

		if (alquiler.getFechaEntrega().compareTo(alquiler.getFechaAlquiler()) < 0 || alquiler.getFechaEntrega().compareTo(alquiler.getFechaAlquiler()) == 0) {
			alquiler.setFechaEntrega(calcularFecha(alquiler.getFechaEntrega(), DIAS_ALQUILER));
		} else {
			alquiler.setFechaEntrega(calcularFecha(alquiler.getFechaEntrega(), 0));
		}

		alquiler.setValor(calcularValorAlquiler(alquiler.getFechaEntrega(), alquiler.getFechaAlquiler()));

		return this.alquilerRepositorio.registrarAlquiler(alquiler);
	}

	private Long validaExistePeli(String nombre) {
		Long idPelicula = peliculaRepositorio.findIdByNombre(nombre);

		if (idPelicula == null) {
			return null;
		}
		return idPelicula;
	}

	private Long validaExisteCliente(String identificacion) {
		Long idCliente = clienteRepositorio.findIdByIdentificacion(identificacion);

		if (idCliente == null) {
			return null;
		}
		return idCliente;
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

		Double valor = VALOR_ALQUILER;
		int dias = daysDifference(fechaAlquiler, fechaEntrega);

		if (dias > 2) {
			valor = VALOR_ALQUILER + VALOR_RECARGO;
		}

		return valor;

	}

	private int daysDifference(Date fechaIni, Date fechaFin) {

		fechaIni = setMidnight(fechaIni);
		fechaFin = setMidnight(fechaFin);
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

	public Date setMidnight(Date date) {

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);

		return calendar.getTime();

	}

}
