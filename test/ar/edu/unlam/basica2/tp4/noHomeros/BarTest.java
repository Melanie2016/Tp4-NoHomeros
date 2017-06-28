package ar.edu.unlam.basica2.tp4.noHomeros;


import java.util.TreeSet;

import org.junit.Assert;
import org.junit.Test;


public class BarTest {

	@Test
	public void testQueUnBarSeCreeVacio(){
	
		Bar miBar = new Bar();
		
		Integer esperado = 0;
		Integer obtenido = miBar.getMiSetDeClientes().size();
		
		Assert.assertEquals(esperado, obtenido);
	}
	
	@Test
	public void testQueSeAbraElBar(){ 
		
		Bar miBar = new Bar();
		
		miBar.abrirBar();
		
		Assert.assertTrue(miBar.getEstadoBar());
	}
	
	@Test
	public void testQueSeCierreElBar(){ 
		
		Bar miBar = new Bar();
		
		miBar.cerrarBar();
		
		Assert.assertFalse(miBar.getEstadoBar());
	}
	
	@Test
	public void testQueNoSeCierreElBarSiPoseeClientesDentro(){
		
		Bar miBar = new Bar();
		Cliente cliente1 = new Cliente();
		
		cliente1.setNombre("Gonzalo");
		cliente1.setEdad(18);
		
		miBar.agregarCliente(cliente1);
		miBar.cerrarBar();
		
		Assert.assertTrue(miBar.getEstadoBar());
		
	}
	
	@Test
	public void testQueSeAgreguenClientesAlBar(){
		
		Bar miBar = new Bar();
		Cliente cliente1 = new Cliente();
		Cliente cliente2 = new Cliente();
		Cliente cliente3 = new Cliente();
		
		cliente1.setNombre("Gonzalo");
		cliente1.setEdad(18);
		
		cliente2.setNombre("Anabella");
		cliente2.setEdad(20);
		
		cliente3.setNombre("Paola");
		cliente3.setEdad(39);
		
		miBar.agregarCliente(cliente1);
		miBar.agregarCliente(cliente2);
		miBar.agregarCliente(cliente3);
		
		Integer esperado = 3;
		Integer obtenido = miBar.getMiSetDeClientes().size();
		Assert.assertEquals(esperado, obtenido);
	}
	
	@Test
	public void testQueNoAdmitaElIngresoDeClientesConMismoNombre(){
		
		Bar miBar = new Bar();
		Cliente cliente1 = new Cliente();
		Cliente cliente2 = new Cliente();
		Cliente cliente3 = new Cliente();
		Cliente cliente4 = new Cliente();
		Cliente cliente5 = new Cliente();
		
		cliente1.setNombre("Maria");
		cliente1.setEdad(50);
		
		cliente2.setNombre("Christian");
		cliente2.setEdad(43);
		
		cliente3.setNombre("Clara");
		cliente3.setEdad(73);
		
		cliente4.setNombre("Maria");
		cliente4.setEdad(45);
		
		cliente5.setNombre("Clara");
		cliente5.setEdad(45);
		
		miBar.agregarCliente(cliente1);
		miBar.agregarCliente(cliente2);
		miBar.agregarCliente(cliente3);
		miBar.agregarCliente(cliente4);
		miBar.agregarCliente(cliente5);

		
		Integer esperado = 3;
		Integer obtenido = miBar.getMiSetDeClientes().size();
		Assert.assertEquals(esperado, obtenido);
	}
	
	@Test
	public void testMostrarLosClientesOrdenadosAlfabeticamente(){
		Bar miBar = new Bar();
		
		Cliente cliente1 = new Cliente();
		Cliente cliente2 = new Cliente();
		Cliente cliente3 = new Cliente();
		
		cliente1.setNombre("Brenda");
		cliente1.setEdad(23);
		
		cliente2.setNombre("Ayelen");
		cliente2.setEdad(10);
		
		cliente3.setNombre("Florencia");
		cliente3.setEdad(18);
		
		miBar.agregarCliente(cliente1);
		miBar.agregarCliente(cliente2);
		miBar.agregarCliente(cliente3);
		
		miBar.mostrarCliente();
		
		Assert.assertTrue(miBar.getMiSetDeClientes().first().getNombre().equals("Ayelen"));
		Assert.assertTrue(miBar.getMiSetDeClientes().last().getNombre().equals("Florencia"));
	}
	
	@Test
	public void testQueNoAdmitaDuplicadosYOrdeneAlfabeticamente() {
		
		Bar miBar = new Bar();
		
		Cliente cliente1 = new Cliente();
		Cliente cliente2 = new Cliente();
		Cliente cliente3 = new Cliente();
		Cliente cliente4 = new Cliente();
		
		cliente1.setNombre("Florencia");
		cliente1.setEdad(23);
		
		cliente2.setNombre("Florencia");
		cliente2.setEdad(28);
				
		cliente3.setNombre("Melanie");
		cliente3.setEdad(23);
			
		cliente4.setNombre("Walter");
		cliente4.setEdad(34);
		
		
		miBar.agregarCliente(cliente1);
		miBar.agregarCliente(cliente2);
		miBar.agregarCliente(cliente3);
		miBar.agregarCliente(cliente4);
		
		miBar.mostrarCliente();
		
		Integer esperado = 3;
		Integer obtenido = miBar.getMiSetDeClientes().size();
		Assert.assertEquals(esperado,obtenido);
		
		Assert.assertTrue(miBar.getMiSetDeClientes().first().getNombre().equals("Florencia"));
		Assert.assertTrue(miBar.getMiSetDeClientes().last().getNombre().equals("Walter"));
	
	
		
	}

	@Test
	public void testQueLosClientesPuedanCompararseUnoDentroYOtroFueraDelBar(){
		
		Bar miBar = new Bar();
		
		Cliente cliente1 = new Cliente();
		Cliente cliente2 = new Cliente();
		Cliente cliente3 = new Cliente();
		Cliente cliente4 = new Cliente();
		
		cliente1.setNombre("Florencia");
		cliente2.setNombre("Florencia");
		cliente3.setNombre("Melanie");
		cliente4.setNombre("Melanie");
		
		miBar.agregarCliente(cliente1);
		miBar.agregarCliente(cliente3);
		
		Assert.assertTrue(cliente1.equals(cliente2));
		Assert.assertEquals(2,miBar.getMiSetDeClientes().size());
	
	}
	
	@Test
	public void testQueLosClientesSePuedanOrdenarPorEdad(){
		
		Bar miBar = new Bar();
		OrdenadorPorEdad miOrdenador = new OrdenadorPorEdad();
		miBar.setMiSetDeClientes(new TreeSet<Cliente>(miOrdenador));;
		
		Cliente cliente1 = new Cliente();
		Cliente cliente2 = new Cliente();
		Cliente cliente3 = new Cliente();
		
		cliente1.setEdad(23);
		cliente2.setEdad(20);
		cliente3.setEdad(40);
		
		miBar.agregarCliente(cliente1);
		miBar.agregarCliente(cliente2);
		miBar.agregarCliente(cliente3);
		
		miBar.mostrarCliente();
		
		Assert.assertTrue(miBar.getMiSetDeClientes().first().getEdad().equals(20));
		Assert.assertTrue(miBar.getMiSetDeClientes().last().getEdad().equals(40));

	}
	
	
	
	
	
	
	
}
