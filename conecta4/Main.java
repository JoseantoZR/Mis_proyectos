package conecta4;

import java.util.Scanner;

public class Main {
	
	public static void main(String[]args) {

		int filas=5;														//Variables que vamos a usar
		int columnas= 6;
		boolean victoria=false;
		int turno=1;
		int estado=2;
		Scanner escan = new Scanner(System.in);	
		
		
		
		Casilla[][] tablero = new Casilla[filas][columnas];					//inicializa el tablero
		for (int i=0;i<filas;i++) {
			for (int j=0;j<columnas;j++) {
				tablero[i][j]=new Casilla(i,j);
			}
		}
		
		Funciones.CrearTablero(filas, columnas,tablero);					//genera el tablero
		
		System.out.println("Introduzca una columna(1-"+columnas+")");


		while(victoria==false) {											//inicia el bucle del juego
			
			int resint = (escan.nextInt());
			
			while(resint>columnas || resint<0) {							//solicita una columna dentro del los limites
					System.out.println("Columna no valida. introduzca otra columna");
					resint = (escan.nextInt());
			}
			while(tablero[0][resint-1].getEstado()!=0) {					//solicita una columna que no este llena
				System.out.println("Columna llena. introduzca otra columna");
				resint = (escan.nextInt());
		}
			resint--;
			

			if(turno % 2 == 0) {											//determina el jugador segun el turno actual
				System.out.println("Turno del jugador "+estado);
				estado=2;
			}else {
				System.out.println("Turno del jugador "+estado);
				estado=1;
			}
			
			
			for(int i=(filas-1);i>=0;i--) {									//comprueba si hay condicion de victoria desde la
				if(tablero[i][resint].getEstado()==0) {						//ultima casilla marcada
					tablero[i][resint].setEstado(estado);
					Funciones.CrearTablero(filas, columnas,tablero);
					turno++;
					victoria=Funciones.ComprobarVictoria(tablero, i, resint, estado);
					i=0;
				}
				else {
				}
			}
		}
		escan.close();
		
		if (estado==1) {													//felicita al ganador
			System.out.print("Ganador Jugador 1(X)");
		}else {
			System.out.print("Ganador Jugador 2(O)");
		}
	}	
}
