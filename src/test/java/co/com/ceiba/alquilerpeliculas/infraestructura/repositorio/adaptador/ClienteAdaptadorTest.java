package co.com.ceiba.alquilerpeliculas.infraestructura.repositorio.adaptador;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import co.com.ceiba.alquilerpeliculas.dominio.model.dto.ClienteDto;
import co.com.ceiba.alquilerpeliculas.dominio.model.entidad.Cliente;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class ClienteAdaptadorTest {
	
	@Autowired
	ClienteAdaptador clienteAdaptador;
	
	@Test
	public void findByIdentificacionTest() {
		String identificacion = "31274274";
		
		ClienteDto clienteDto = clienteAdaptador.findByIdentificacion(identificacion);
		
		assertEquals("Gomez Grajales", clienteDto.getApellidos());
		
	}
	
	@Test
	public void findIdByIdentificacionTest() {
		String identificacion = "94444555";
		
		Long id = clienteAdaptador.findIdByIdentificacion(identificacion);
		
		assertEquals(2, id);
		
	}
	
	@Test
	public void findByIdTest() {
		Long id = (long) 2;
		
		Cliente cliente = clienteAdaptador.findById(id);
		
		assertEquals("94444555", cliente.getIdentificacion());		
		
	}

}
