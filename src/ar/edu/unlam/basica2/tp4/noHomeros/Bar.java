package ar.edu.unlam.basica2.tp4.noHomeros;

import java.util.TreeSet;

public class Bar {

	private TreeSet<Cliente> miSetDeClientes ;
	private Boolean estadoBar;
	
	

	public Bar(){
		this.miSetDeClientes = new TreeSet<Cliente>();
		this.estadoBar = false;
		
	}
	
	
	public void abrirBar(){
		this.estadoBar = true;
	}
	
	
	public void cerrarBar(){
		if( miSetDeClientes.size()>=1){
			try{
				throw new Exception("No se puede cerrar el Bar con clientes en su interior");
			}catch (Exception e){
				e.printStackTrace();
				this.estadoBar = true;
				System.out.println(e.getMessage());
				
			}
		}else{
			this.estadoBar = false;
		}
	}
	
	
	public void agregarCliente (Cliente clientes){ 
		if(miSetDeClientes.contains(clientes)){
			try {
				throw new Exception("No se permite el ingreso de : "+clientes+",pues ya existe un cliente con dicho nombre dentro del bar.");
			}catch (Exception e){
				e.printStackTrace();
				

				this.miSetDeClientes.remove(clientes);
				this.miSetDeClientes.add(clientes);
				System.out.println(e.getMessage());
			}
		}else{
			this.miSetDeClientes.add(clientes);
		}
	}
	
	
	public void mostrarCliente (){
		System.out.println(miSetDeClientes);
	}


	
	
	
	
////////////////////////////////////////////////////////////////////////
// Get & Set
	
	public TreeSet<Cliente> getMiSetDeClientes() {
		return miSetDeClientes;
	}
	public void setMiSetDeClientes(TreeSet<Cliente> miSetDeClientes) {
		this.miSetDeClientes = miSetDeClientes;
	}

	
	
	public Boolean getEstadoBar() {
		return estadoBar;
	}
	public void setEstadoBar(Boolean estadoBar) {
		this.estadoBar = estadoBar;
	}


}
