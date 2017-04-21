
public class Livro {
	private String autor;
	private String titulo;
	private int id;
	private static int idCounter = 1;
	private boolean isEmprestado;
	private Usuario emprestador;
	
	public Livro(String titulo, String autor){
		this.autor = autor;
		this.titulo = titulo;
		this.id = idCounter;
		idCounter++;
		isEmprestado = false;
		emprestador = null;
	}
	
	public int getId(){
		return this.id;
	}
	
	public boolean isEmprestado(){
		return isEmprestado;
	}
	
	public void emprestar(Usuario user){
		isEmprestado = true;
		emprestador = user;
	}
}
