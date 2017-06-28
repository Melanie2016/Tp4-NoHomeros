package ar.edu.unlam.basica2.tp4.noHomeros;

import java.util.Comparator;

public class OrdenadorPorEdad implements Comparator<Cliente>{

	@Override
	public int compare(Cliente cliente1, Cliente cliente2) {
		// TODO Auto-generated method stub
		return cliente1.getEdad().compareTo(cliente2.getEdad());
	}

}
