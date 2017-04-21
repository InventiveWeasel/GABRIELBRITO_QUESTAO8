
public class Usuario {
	private int id;
	private static int IdCounter=1;
	private boolean Blocked;
	private int prazo;
	
	public Usuario(){
		id = IdCounter;
		IdCounter++;
		Blocked = false;
		prazo = 0;
	}
	
	public int getId(){
		return id;
	}
	
	
	public void block(int prazo){
		Blocked = true;
		this.prazo = prazo;
	}
	
	public void unblock(){
		Blocked = false;
	}
	
	public boolean isBlocked(){
		return Blocked;
	}
	
}
