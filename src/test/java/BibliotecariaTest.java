import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;

public class BibliotecariaTest {
	UsuarioDB userDB;
	LivroDB livroDB;
	Bibliotecaria bib;
	Usuario user, user2;
	Livro livro;

	@Before
	public void setup(){
		userDB = mock(UsuarioDB.class);
		livroDB = mock(LivroDB.class);
		bib = new Bibliotecaria(userDB, livroDB);
		user = new Usuario();
		user2 = new Usuario();
		livro = new Livro("Naruto", "Masashi Kishimoto");
	}
	@Test
	public void testAddUser() {
		when(bib.inserirUsuario(user)).thenReturn(true);
		assertTrue(bib.inserirUsuario(user));
	}
	
	@Test
	public void testAddBook(){
		when(bib.inserirLivro(livro)).thenReturn(true);
		assertTrue(bib.inserirLivro(livro));
	}
	
	@Test
	public void deleteValidUser(){
		bib.inserirUsuario(user);
		when(bib.deleteUsuario(user)).thenReturn(true);
		assertTrue(bib.deleteUsuario(user));
	}
	
	@Test
	public void whenUserNotInDBthenReturnFalse(){
		when(bib.deleteUsuario(user2)).thenReturn(false);
		assertFalse(bib.deleteUsuario(user));
	}
	
	@Test
	public void whenBookIsAvailableAndBorrowThenReturnTrue(){
		bib.inserirLivro(livro);
		assertTrue(bib.emprestarLivro(user, livro));
	}
	
	@Test
	public void whenBookIsNotAvailableAndBorrowThenReturnFalse(){
		bib.inserirLivro(livro);
		bib.emprestarLivro(user, livro);
		assertFalse(bib.emprestarLivro(user2, livro));
	}
	
	@Test
	public void whenUserIsBlockedAndBorrowThenReturnFalse(){
		bib.blockUser(user, 7);
		assertFalse(bib.emprestarLivro(user, livro));
	}
}
