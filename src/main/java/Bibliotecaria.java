
public class Bibliotecaria {
	UsuarioDB userDB;
	LivroDB livroDB;
	
	public Bibliotecaria(UsuarioDB userDB, LivroDB livroDB){
		this.userDB = userDB;
		this.livroDB = livroDB;
	}
	
	public boolean inserirUsuario(Usuario user){
		return userDB.createUser(user);
	}
	
	public boolean deleteUsuario(Usuario user){
		return userDB.deleteUser(user.getId());
	}
	
	public boolean inserirLivro(Livro livro){
		return livroDB.InserirLivro(livro);
	}
	
	public boolean deleteLivro(Livro livro){
		return livroDB.deleteLivro(livro.getId());
	}
	
	public void blockUser(Usuario user, int prazo){
		user.block(prazo);
		userDB.updateUser(user.getId());
	}
	
	public boolean emprestarLivro(Usuario user, Livro livro){
		if(user.isBlocked() || livro.isEmprestado())
			return false;
		livro.emprestar(user);
		return true;
	}
}
