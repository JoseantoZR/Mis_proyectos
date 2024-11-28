package pokedex;
import java.util.Scanner;

public class Main {
	static String[] pokemons = { "pidgey", "bulbasaur","caterpie","magicarp","scizor"};
	
	public static void main(String[]args) throws InterruptedException {
		int intaux = (int) Math.floor(Math.random()*5);   //numero random para sacar un pokemon
		boolean bucle =true;							  //mantiene el programa mientras no se huya, capture o debilite al pokemon
		pokemon mipokemon = new pokemon(pokemons[intaux]);
		mipokemon.setNumero(intaux);					  //guarda el numero en la pokedex
		System.out.println("un " + mipokemon.getNombre() + " salvaje apareció");
		
		
		
		while(bucle==true){
			System.out.println("¿Que quieres hacer? ¿Pokedex, capturar, luchar o huir?");
			Scanner escan = new Scanner(System.in);
			String restrg = escan.nextLine();					 //la respuesta del jugador
		
			if(restrg.equals("Pokedex")||restrg.equals("pokedex")) {
					funciones.pokedex(mipokemon);
			}
			else if(restrg.equals("huir")) {
				boolean bolaux = funciones.huir();				//determina si se huye o no con un booleano
				if (bolaux==true) {
					System.out.println("Huiste sin problemas");
					break;
				}else {
					System.out.println("No has podido escapar");
				}
			}
			else if(restrg.equals("luchar")) {
				funciones.luchar(mipokemon);
				break;
			}
			else if(restrg.equals("capturar")){
				if(funciones.capturar(mipokemon)==true) {		//si captura se cierra el bucle si vuelve se mantiene
					break;
				}
				else {
				}
			}
		}
	}
}
