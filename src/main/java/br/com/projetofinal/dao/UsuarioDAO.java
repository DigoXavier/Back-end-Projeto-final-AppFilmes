package br.com.projetofinal.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import br.com.projetofinal.beans.Usuario;

public interface UsuarioDAO extends CrudRepository<Usuario, Integer> {
	
	public Usuario findByEmailAndSenha(String email, String senha);
	
	@Query(value="select * from tb_usuario where nome like %%", nativeQuery = true)
	public List<Usuario> listByNomeLike(String nome);
	
}
