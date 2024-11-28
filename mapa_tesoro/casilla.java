package mapa_tesoro;

public class casilla {
	String nombre;
	int estado;
	int tesoro;
	
	public casilla(String nombre) {
		this.nombre=nombre;
		this.estado=0;
		this.tesoro=0;
	}

	public String getNombre() {
		return nombre;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public int getTesoro() {
		return tesoro;
	}

	public void setTesoro(int tesoro) {
		this.tesoro = tesoro;
	}
}
