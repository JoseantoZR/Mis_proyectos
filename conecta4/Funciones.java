package conecta4;


public class Funciones {
	
	static void CrearTablero(int filas,int columnas, Casilla[][] tablero) {
		

        System.out.println();											//pinta el tablero 
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
            	int valor = tablero[i][j].getEstado();
            	
            	switch(valor) {
            	case 0:
                    System.out.print(" [ ] ");            		
            		break;
            	case 1:
                    System.out.print(" [X] ");
            		break;
            	case 2:
                    System.out.print(" [O] ");
            		break;
            	}
            }
            System.out.println();
            System.out.println();
        }
	}
	
	
	
	
	static boolean ComprobarVictoria(Casilla[][] tablero, int fila, int col, int estado) { //comprueba que al menos una linea suma 4
        return (comprobarVertical(tablero, fila, col, estado) ||
                comprobarHorizontal(tablero, fila, col, estado) ||
                comprobarDiagonal(tablero, fila, col, estado));
    }
	
	
    public static boolean comprobarVertical(Casilla[][] tablero, int fila, int col, int estado) {
        int contador = 1;										// Contamos la casilla en la posición inicial
        
        int i = fila + 1;
        while (i < tablero.length) {  							//Vamos sumando(hacia abajo en el tablero)
            if (tablero[i][col].getEstado() == estado) {
                contador++;
            } else {
                break;
            }
            i++;
        }
        return contador == 4;
    }
    
    
    public static boolean comprobarHorizontal(Casilla[][] tablero, int fila, int col, int estado) {
        int contador = 1;  										// Contamos la casilla en la posición inicial

        														// Revisar hacia la derecha (col++)
        int j = col+1;
        while (j < tablero[fila].length) {  
            if (tablero[fila][j].getEstado() == estado) {
                contador++;
            } else {
                break;
            }
            j++;
        }

        														// Revisar hacia la izquierda (col--)
        j = col-1;
        while (j >= 0) {  						
            if (tablero[fila][j].getEstado() == estado) {
                contador++;
            } else {
                break;
            }
            j--;
        }
															// Verificar si se encontraron 4 casillas consecutivas
        return contador >= 4;								//no reiniciamos el contador porque la ultima casilla
    }														//puede estar en medio de las 4 en linea
    	
    
    public static boolean comprobarDiagonal(Casilla[][] tablero, int fila, int col, int estado) {
    	 int contadormas = 1;  									// Contamos la casilla en la posición inicial
    	 int contadormenos = 1;
    	 int contador=0;
    	    													// Revisar hacia abajo a la derecha (j++ i++) y arriba a la izq(i-- j--)
    	    int i = fila +1;
    	    int j = col +1;
    	    while (i > tablero.length && j > tablero[0].length) {
    	        if (tablero[i][j].getEstado() == estado) {
    	            contadormas++;
    	        } else {
    	            break;
    	        }
    	        i++;
    	        j++;
    	    }    	    
    	     i = fila -1;
    	     j = col -1;
    	    while (i < tablero.length && j < tablero[0].length && j>=0) {
    	        if (tablero[i][j].getEstado() == estado) {
    	            contadormas++;
    	        } else {
    	            break;
    	        }
    	        i--;
    	        j--;
    	    }


    	    													// Revisar hacia abajo a la izquierda (j-- i++) y arriba a la derecha(i-- j++)
    	    
    	    
    	    i = fila +1;
    	    j = col -1;
    	    while (i < tablero.length && j >= 0) {
    	        if (tablero[i][j].getEstado() == estado) {
    	            contadormenos++;
    	        } else {
    	            break;
    	        }
    	        i++;
    	        j--;
    	    }    	
    	    i = fila -1;
    	    j = col +1;
    	    while (j < tablero.length && i >= 0) {
    	        if (tablero[i][j].getEstado() == estado) {
    	            contadormenos++;
    	        } else {
    	            break;
    	        }
    	        i--;
    	        j++;
    	    }
    	    
    	    
    	    
    	    
    	    if (contadormas==4||contadormenos==4) {				// Verificar si se encontraron 4 casillas consecutivas
    	    	contador=4;
    	    }
    	    
    	    return contador == 4;
    	}	
}

