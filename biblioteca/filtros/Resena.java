package filtros;

public class Resena {
	int ID;
	String resena;
	int nota;
	
	
	public Resena(int ID, String resena, int nota) {
		this.ID = ID;
		this.resena = resena;
		this.nota = nota;
	}


	public int getID() {
		return ID;
	}


	public void setID(int ID) {
		this.ID = ID;
	}


	public String getResena() {
		return resena;
	}


	public void setResena(String resena) {
		this.resena = resena;
	}


	public int getNota() {
		return nota;
	}


	public void setNota(int nota) {
		this.nota = nota;
	}
	
	
	
}
