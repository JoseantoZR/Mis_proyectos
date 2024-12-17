package filtros;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
    	
    	String LibrosCSV = "resources/libros.csv";
    	String ResenasCSV = "resources/resenas.csv";
    	List<Libro> biblio = new ArrayList<>();	 
    	List<Resena> resenas = new ArrayList<>();	
        Scanner escan = new Scanner(System.in);

        System.out.println("Bienvenido");
        
        while(true) {
        	
        	biblio.clear();
        	resenas.clear();
            System.out.println("\n¿Que desea hacer? \n \n1.Ver la lista de libros \n2.Añadir un libro a la lista"
            	+ "\n3.Comprobar que un libro esta en la lista\n4.Ver reseñas de un libro especifico\n"
            	+ "5.Añadir reseñas a un libro\n6.Salir");
            int resint = (escan.nextInt());
            
            if(resint==1){		//ver biblio
            	
            	biblio = Funciones.LeerBiblio();
          		System.out.println("\nLibros cargados desde el archivo CSV:");
          		
          		for (Libro libro : biblio) {
              		System.out.println(libro);
          		}
            }
            
            if(resint==2) {		//añadir a biblio
            	
            	escan.nextLine();
            	biblio = Funciones.LeerBiblio();
            	System.out.println("\n Introduce el libro que quieras añadir");
            	String restrg=escan.nextLine();
            	String linea=(Integer.toString(biblio.size()+1)+","+restrg);
            	
				try (BufferedWriter bw = new BufferedWriter(new FileWriter(LibrosCSV, true))){
					bw.newLine(); 											// Añadir un salto de línea 
					bw.write(linea); 										// Añadimos lanueva línea al archivo 
					System.out.println("Línea añadida con exito.");
				  
				} catch (IOException e) { 
					e.printStackTrace(); 
				}	 
            }
            
            
            if(resint==3) {		//buscar en biblio
            	escan.nextLine();
            	biblio = Funciones.LeerBiblio();
            	System.out.println("\n Introduce el libro que quieras buscar");
            	String restrg=escan.nextLine();
            	
            	int n=Funciones.EncontrarLibro(restrg);					//devuelve el id o -1 si no esta
            	if(n!=-1) {
            		System.out.println("\nLibro encontrado con id= "+n);
            	}
            }
            
            		
            if(resint==4) {		//Ver reseñas
            	escan.nextLine();
            	resenas= Funciones.Leerresenas();
            	biblio = Funciones.LeerBiblio();
            	int punt=0;
            	int contador=0;
            	
            	System.out.println("\n Introduce el libro que quieras buscar");
            	String restrg=escan.nextLine();
            	
            	int n= Funciones.EncontrarLibro(restrg);				//devuelve el id o -1 si no esta
            	
            	if(n!=-1) {												//Si encuentra el id
            		
            		for(int i=0; i<resenas.size();i++) {				
            	
            		if(resenas.get(i).getID()==(n)) {					//Busca todas las reseñas que coincidan con el id
            				punt = punt+resenas.get(i).getNota();
            				contador++;
            				System.out.println(resenas.get(i).getNota()+"  "+resenas.get(i).getResena());
            			}
            		}

            		System.out.println("\nNota media total= "+ (double)punt/contador); //hace la media de las reseñas
            	}
            }
       
            if(resint==5) {		//Añadir reseña
            	escan.nextLine();
            	boolean bucle=true;											//para poder cerrar el bucle sin break;
            	resenas= Funciones.Leerresenas();
            	System.out.println("¿Sobre que libro quieres hacer una reseña?");
            	String restrg=escan.nextLine();
            	int n=Funciones.EncontrarLibro(restrg);						//guardar id del libro
            	int nota=0;
            	System.out.println("Describe tu opinión sobre el:");
            	restrg=escan.nextLine();									//guardar la opinión
            	
            	while(bucle==true) {
            		System.out.println("¿Qué nota le das del 1 al 5?");		
            		nota= escan.nextInt();								//guardar la nota del 1 al 5
            		if(nota>0 && 5>nota) {
            			bucle=false;	
            		}
            	}
            	
            	String linea=(n+",\""+restrg+"\","+nota);					//escribir la linea nueva
				try (BufferedWriter bw = new BufferedWriter(new FileWriter(ResenasCSV, true))){
					bw.newLine(); 											// Añadir un salto de línea 
					bw.write(linea); 										// Añadimos lanueva línea al archivo 
					System.out.println("Reseña añadida con exito.");
				  
				} catch (IOException e) { 
					e.printStackTrace(); 
				}
            }
            

            if(resint==6) {
                escan.close();
            	break;
            }
            
        } 

    }

}