package ar.edu.unlam.basica2.tp4.noHomeros;

public class Cliente implements Comparable<Cliente>{

	private String nombre;
	private Integer edad;
	
	
	
	
	
	@Override // para ordenar por nombre 
	public int compareTo(Cliente otroCliente) {
		
		return this.getNombre().compareTo(otroCliente.getNombre());
	}

	@Override //para mostrar en consola
	public String toString(){
		return "Cliente: Nombre: "+nombre+ " Edad: "+edad+ "]";
		
	}

	
	
	
	
	
	
///////////////////////////////////////////////////////////////////////////
//Get & Set
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;}

	public Integer getEdad() {
		return edad;	}
	public void setEdad(Integer edad) {
		this.edad = edad;
	}

//HashCode & Equals
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((edad == null) ? 0 : edad.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		if (edad == null) {
			if (other.edad != null)
				return false;
		} else if (!edad.equals(other.edad))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}
	
	
	
	
}
