package mapa_tesoro;

import java.util.Scanner;

public class Main {
	
	public static void main(String[]args) {

		String fila="";
		boolean boltes = false;
		
		casilla[] filas1=new casilla[4];			//Array de objetos(casillas) en filas
		filas1[0]= new casilla("A1");
		filas1[1]= new casilla("A2");
		filas1[2]= new casilla("A3");
		filas1[3]= new casilla("A4");
		
		casilla[] filas2=new casilla[4];			//Array de objetos(casillas) en filas
		filas2[0]= new casilla("B1");
		filas2[1]= new casilla("B2");
		filas2[2]= new casilla("B3");
		filas2[3]= new casilla("B4");
		
		casilla[] filas3=new casilla[4];			//Array de objetos(casillas) en filas
		filas3[0]= new casilla("C1");
		filas3[1]= new casilla("C2");
		filas3[2]= new casilla("C3");
		filas3[3]= new casilla("C4");
		
		casilla[] filas4=new casilla[4];			//Array de objetos(casillas) en filas
		filas4[0]= new casilla("D1");
		filas4[1]= new casilla("D2");
		filas4[2]= new casilla("D3");
		filas4[3]= new casilla("D4");
		
		casilla[][] tablero= {filas1, filas2, filas3, filas4};				//Array(tablero) de array(filas) de objetos(casillas)
		String letras[]= { "A","B","C","D"};
		tablero[(int) Math.floor(Math.random()*4)][(int) Math.floor(Math.random()*4)].setTesoro(1);		//marca un tesoro al azar
		
		do {																			
			System.out.println(" 1  2  3  4");											//genera el tablero
			for(int i=0; i<4;i++) {
				for(int j=0; j<4;j++) {
					if(tablero[i][j].getEstado()==0) {									//si no se ha buscado esta en O
						fila=fila+" O ";	
					}else if(tablero[i][j].getEstado()==1) {							//si ya se ha buscado esta en X
						fila=fila+" X ";
					}
				}
				System.out.println(letras[i]+fila+" \n");
				
				fila="";	
			}
			
			System.out.println("¿En que casilla buscar?");
			Scanner escan = new Scanner(System.in);
			String restrg = escan.nextLine();



			for(int i=0; i<4;i++) {															//busca casilla por casilla
				for(int j=0; j<4;j++) {
					if(tablero[i][j].getNombre().equals(restrg)&&tablero[i][j].getEstado()==0) {	//si coincide con la introducida
						if(tablero[i][j].getTesoro()==1){											//si tiene el tesoro se acaba
							System.out.println("¡Enhorabuena has encontrado el tesoro!");
							boltes=true;
							break;
						}else {
							tablero[i][j].setEstado(1);													//si no, la marca como buscada
						}
					}else if(tablero[i][j].getNombre().equals(restrg)&&tablero[i][j].getEstado()==1) {	//si ya esta marcada, te aclara que
						System.out.println("Ahí ya has buscado");										//ahi ya has buscado
					}
				}
			}
		}
		
		while (boltes==false);
	}
}