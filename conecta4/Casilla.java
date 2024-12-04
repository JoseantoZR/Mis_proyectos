package conecta4;

public class Casilla {
	int fila;
	int columna;
	int estado;

	
	public Casilla(int fila, int columna) {						//casillas licalizadas por fila y columna. Con estado 0(vacia),
		this.fila=fila;											//1(jugador 1) o 2 (jugador 2)
		this.columna=columna;
		this.estado=0;
	}

	
	
	public int getEstado() {									//solo hace falta cambiar si es de un jugador u otro la ultima ficha.
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

}
