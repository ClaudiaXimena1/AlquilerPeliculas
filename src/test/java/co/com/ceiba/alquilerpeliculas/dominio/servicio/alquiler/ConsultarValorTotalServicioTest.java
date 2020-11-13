package co.com.ceiba.alquilerpeliculas.dominio.servicio.alquiler;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class ConsultarValorTotalServicioTest {
	
	@Autowired
	ConsultarValorTotalServicio consultarValorTotalServicio;
	
	@Test
	public void ejecutarCalculaConAlquilerTest() {
		String identificacion = "22888999";
		String fecha = "2020-11-13";
		Double valor;
		
		valor = consultarValorTotalServicio.ejecutar(identificacion, fecha);
		
		assertEquals(new Double(14000.00), valor);
		
	}
	
	@Test
	public void ejecutarCalculaSinAlquilerTest() {
		String identificacion = "22888999";
		String fecha = "2020-11-16";
		Double valor;
		
		valor = consultarValorTotalServicio.ejecutar(identificacion, fecha);
		
		assertEquals(new Double(0.00), valor);
		
	}


}
