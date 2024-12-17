package filtros;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Funciones {
	
    
	static String LibrosCSV = "resources/libros.csv";					// Ruta de los archivos CSV dentro de la carpeta resources
    static String ResenasCSV = "resources/resenas.csv";
    static List<Libro> biblio = new ArrayList<>();	 			        // Lista para almacenar todos los libros
	static List<Resena> resenas = new ArrayList<>();							// Lista para almacenar todas las reseñas
		
    
    
	static List<Libro> LeerBiblio() {
    	try (BufferedReader br = new BufferedReader(new FileReader(LibrosCSV))) {	// Leer el archivo CSV y crear objetos Libro
        	
            String linea;
            br.readLine();												// Al leer que salte la primera linea(id,titulo)
            
            while ((linea = br.readLine()) != null) {
                
                String[] partes = linea.split(",");						// Separar la linea por cada ","
                
                if (partes.length == 2) { 								// Verificar que hay dos elementos: ID y Titulo
                    try {
                    	
                        int id = Integer.parseInt(partes[0].trim());	// Convertir el ID a int
                        String titulo = partes[1].trim();  				// El titulo a String
                        Libro libro = new Libro(id, titulo);			// Crear un Libro
                        biblio.add(libro);								// Añadirlo a la lista
                        
                    } catch (NumberFormatException e) {
                        System.out.println("Error al convertir el ID a aaaanúmero: " + partes[0]);
                    }
                }
            }



        } catch (IOException e) {
            e.printStackTrace();
        }
    	
    	return biblio;
	}
	
	
	
	
	static List<Resena> Leerresenas() {
    	try (BufferedReader br = new BufferedReader(new FileReader(ResenasCSV))) {	// Leer el archivo CSV y crear objetos reseña
        	
            String linea;
            br.readLine();															// Al leer que salte la primera linea(id,reseña,nota)
            
            while ((linea = br.readLine()) != null) {
                
                String[] partes = linea.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");		// Separar la linea por cada "," si hay comillas no divide
                
                if (partes.length == 3) { 											// Verificar que hay tres elementos
                    try {
                    	
                        int id = Integer.parseInt(partes[0].trim());				// Convertir el ID a int
                        String coment = partes[1].trim();  							// El titulo a String
                        int nota = Integer.parseInt(partes[2].trim());              // La nota a int
                        Resena resena = new Resena(id, coment, nota);				// Crear una reseña
                        resenas.add(resena);										// Añadirlo a la lista
                        
                    } catch (NumberFormatException e) {
                        System.out.println("Error al convertir el ID a número: " + partes[0]);
                    }
                }
            }



        } catch (IOException e) {
            e.printStackTrace();
        }
    	
    	return resenas;
	}
	
	
	static int EncontrarLibro(String libro) {
    	int n=0;		
    	biblio= Funciones.LeerBiblio();
    	
    	for(int i=0; i<biblio.size();i++) {											//Busca por cada linea
    		if(biblio.get(i).getTitulo().equals(libro)) {							// si encuentra una coincidencia se detiene
    			n=biblio.get(i).getID();
    			break;
    		}else if(i==(biblio.size()-1)&&!biblio.get(i).getTitulo().equals(libro)){//si llega al final sin coincidencias da fallo
    			System.out.println("libro no encontrado");
    			n=-1;
    		}
    	}
    	
		return n;
		
	}
	
}