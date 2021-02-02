package usuarios;

import java.util.ArrayList;

public class Tecnico extends Persona
{
	ArrayList<String> listaTecnicos= new ArrayList <String>();
	
	private String titulacion;
	private String categoria;
	private int anyosExperiencia;
	
	
	public Tecnico(String nombre, String apellido1, String apellido2, int edad, String dni, String user,
			String password, String email, String tipopersona, String titulacion, String categoria, int anyosExperiencia) {
		super(nombre, apellido1, apellido2, edad, dni, user, password, email, tipopersona);
		this.titulacion = titulacion;
		this.categoria = categoria;
		this.anyosExperiencia = anyosExperiencia;
	}
	
	public Tecnico()
	{
		
	}

	public ArrayList<String> getListaTecnicos() {
		return listaTecnicos;
	}

	public void setListaTecnicos(ArrayList<String> listaTecnicos) {
		this.listaTecnicos = listaTecnicos;
	}

	public String getTitulacion() {
		return titulacion;
	}

	public void setTitulacion(String titulacion) {
		this.titulacion = titulacion;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public int getAnyosExperiencia() {
		return anyosExperiencia;
	}

	public void setAnyosExperiencia(int anyosExperiencia) {
		this.anyosExperiencia = anyosExperiencia;
	}
	
	

}
