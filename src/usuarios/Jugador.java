package usuarios;

import java.util.ArrayList;

public class Jugador extends Persona
{
	
	ArrayList<String> listaJugadores= new ArrayList <String>();
	
	private String piernaHabil;
	private double peso;
	private double altura;
	private String posicion;
	private int dorsal;
	
	public Jugador(String nombre, String apellido1, String apellido2, int edad, String dni, String user,
			String password, String email, String tipopersona, String piernaHabil, double peso, double altura,
			String posicion, int dorsal) {
		super(nombre, apellido1, apellido2, edad, dni, user, password, email, tipopersona);
		this.piernaHabil = piernaHabil;
		this.peso = peso;
		this.altura = altura;
		this.posicion = posicion;
		this.dorsal = dorsal;
	}
	
	public Jugador ()
	{
		
	}

	public ArrayList<String> getListaJugadores() {
		return listaJugadores;
	}

	public void setListaJugadores(ArrayList<String> listaJugadores) {
		this.listaJugadores = listaJugadores;
	}

	public String getPiernaHabil() {
		return piernaHabil;
	}

	public void setPiernaHabil(String piernaHabil) {
		this.piernaHabil = piernaHabil;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}

	public String getPosicion() {
		return posicion;
	}

	public void setPosicion(String posicion) {
		this.posicion = posicion;
	}

	public int getDorsal() {
		return dorsal;
	}

	public void setDorsal(int dorsal) {
		this.dorsal = dorsal;
	}
	
	

}
