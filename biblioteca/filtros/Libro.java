package filtros;

public class Libro {
	int ID;
	String titulo;
	
	
	public Libro(int ID, String titulo) {
		this.ID = ID;
		this.titulo = titulo;
	}


	
	public int getID() {
		return ID;
	}
	public String getTitulo() {
		return titulo;
	}
	
    @Override
    public String toString() {
        return "id= " + ID + ", " + titulo + "";
    }
}
