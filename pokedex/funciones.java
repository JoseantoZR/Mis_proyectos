package pokedex;
import java.util.Scanner;

public class funciones {
	
	static void pokedex(pokemon mipokemon) {
		Scanner escan = new Scanner(System.in);
		System.out.println("El pokemon delante tuya es un "+ mipokemon.getNombre()+"\nSe ha registrado el pokemon con el id "+ mipokemon.getNumero());
		
		if(mipokemon.getTamaño() == 0) {									//si es la primera vez se pide el tamaño
			System.out.println("¿Cuantos cm mide? ");
			int resint = escan.nextInt();									//introducir tmañano
			
			while(resint>350 || resint==0) {
				System.out.println("Eso es imposible!");					//un tamaño demasiado grande o 0 repite la pregunta
				System.out.println("¿Cuantos cm mide? ");
				resint = escan.nextInt();	
			}
			if(resint <10) {
				System.out.println("¿solo "+resint+"cm? Es muy pequeño");
			}
			else if(resint >= 10 && resint <= 200){
				System.out.println("¿Mide "+resint+"cm? No esta nada mal");
			}
			else {
				System.out.println("¿Mide "+resint+"cm? Es grandisimo");
			}
			mipokemon.setTamaño(resint);									//registra el tamaño
			}
		else{																//si ya tiene tamaño establecido
			System.out.println("Tiene un tamaño de "+mipokemon.getTamaño()+"cm");
		}
	};
	
	static boolean huir() {
		int numaux = (int) Math.floor(Math.random()*10);	  //un 10% de posibilidades de no poder huir
		boolean bolaux;
		if(numaux==9) {
			bolaux= false;
		}
		else{
			bolaux= true;
		}
		return bolaux;
	};
	
	static void luchar(pokemon mipokemon) {
		Scanner escan = new Scanner(System.in);
		System.out.println("Adelante pikachu");
		while(mipokemon.getVida()>0) {							//mientras la vida del objeto pokemon sea positivo se mantiene el combate
			System.out.println("ahora mismo "+mipokemon.getNombre()+" tiene "+ mipokemon.getVida()+" de vida");
			System.out.println("¿que ataque usar? \n 1.placaje \n 2.rayo \n 3.hipnosis \n 4.rayo de la muerte mortal");
			int numaux=(int) Math.floor(Math.random()*30);			//daño del movimiento
			int intscn = escan.nextInt();							//movimiento a usar
			if(intscn==1) {
				System.out.println("pikachu usó placaje. Ataque eficaz");
				mipokemon.setVida(mipokemon.getVida()-numaux);		//daño del movimiento (0-30)
			}
			else if(intscn==2) {
				System.out.println("pikachu usó rayo. Ataque muy eficaz");
				mipokemon.setVida(mipokemon.getVida()-(numaux+30));	//daño del movimiento (30-60)
			}
			else if(intscn==3) {
				System.out.println("Pikachu uso hipnosis pero falló");
			}
			else if(intscn==4) {
				System.out.println("pikachu usó rayo de la muerte mortal. Ataque supereficaz");
				mipokemon.setVida(mipokemon.getVida()-(numaux+70));	//daño del movimiento (70-100)
			}
		}
		System.out.println("el "+mipokemon.getNombre()+ " salvaje se debilito");
	}
	
	static boolean capturar(pokemon mipokemon) throws InterruptedException {		//si captura delvuelve true si vuelve da false
		boolean bolaux=true;
		Scanner escan = new Scanner(System.in);
		String estado= "capturado";

		while(estado.equals("capturado")) {											//mientras no se capture y cambie la variable se mantienel bucle
			System.out.println("¿Que pokeball usar? \n 1.pokeball \n 2.ultrabal \n 3.Volver");
			int numaux=(int) Math.floor(Math.random()*10);							//numero para saber si se captura
			int intscn = escan.nextInt();
			if(intscn==1) {
				System.out.println("usaste pokeball");
				if(numaux<=4) {	
					Thread.sleep(1000);
					System.out.println("TIC...");
					Thread.sleep(1000);
					System.out.println("El pokemon escapó");
				}
				else if(numaux<=7 && numaux>=5) {
					Thread.sleep(1000);
					System.out.println("TIC...");
					Thread.sleep(1000);
					System.out.println("TIC...");
					Thread.sleep(1000);
					System.out.println("El pokemon escapó");
				}
				else if(numaux==8 || numaux==9) {
					Thread.sleep(1000);
					System.out.println("TIC...");
					Thread.sleep(1000);
					System.out.println("TIC...");
					Thread.sleep(1000);
					System.out.println("TIC...");
					Thread.sleep(1000);
					System.out.println("El pokemon escapó");
				}else {
					Thread.sleep(1000);
					System.out.println("TIC...");
					Thread.sleep(1000);
					System.out.println("TIC...");
					Thread.sleep(1000);
					System.out.println("TIC...");
					Thread.sleep(1000);
					System.out.println("¡Ya está! "+mipokemon.getNombre() +" capturado");
					break;
				}
			}
			else if(intscn==2) {
				System.out.println("usaste superball");
				if(numaux<=2) {
					Thread.sleep(1000);
					System.out.println("TIC...");
					Thread.sleep(1000);
					System.out.println("El pokemon escapó");
				}
				else if(numaux<=4 && numaux>=3) {
					Thread.sleep(1000);
					System.out.println("TIC...");
					Thread.sleep(1000);
					System.out.println("TIC...");
					Thread.sleep(1000);
					System.out.println("El pokemon escapó");
				}
				else if(numaux<=7 && numaux>=5) {
					Thread.sleep(1000);
					System.out.println("TIC...");
					Thread.sleep(1000);
					System.out.println("TIC...");
					Thread.sleep(1000);
					System.out.println("TIC...");
					Thread.sleep(1000);
					System.out.println("El pokemon escapó");
				}else {
					Thread.sleep(1000);
					System.out.println("TIC...");
					Thread.sleep(1000);
					System.out.println("TIC...");
					Thread.sleep(1000);
					System.out.println("TIC...");
					Thread.sleep(1000);
					System.out.println("¡Ya está! "+mipokemon.getNombre() +" capturado");
					break;
				}
			}else {
				bolaux=false;
				break;
			}
		}
		return bolaux;
	}
}
