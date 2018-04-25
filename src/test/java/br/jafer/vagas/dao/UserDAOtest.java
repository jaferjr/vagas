package br.jafer.vagas.dao;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.junit.Ignore;
import org.junit.Test;

import br.jafer.vagas.entity.Usuario;

public class UserDAOtest {
	@Ignore
	@Test
	public void save() {
		
		UsuarioDAO dao = new UsuarioDAO();
		
		
		
		Usuario usuario = new Usuario();
		usuario.setAtivo(true);	
		usuario.setTipo('a');		
		usuario.setUserName("tiburcio");
		usuario.setSenhaNCript("12345");
		SimpleHash hash = new SimpleHash("md5", usuario.getSenhaNCript());
		usuario.setSenha(hash.toHex());
		
		dao.save(usuario);
		
	}
	
	@Test
	public void autenticar() {
		String user = "tiburcio";
		String senha = "12345";
		
		UsuarioDAO dao = new UsuarioDAO();
		Usuario usuario = dao.autenticar(user, senha);
		
		System.out.println("usuario: "+usuario.getUserName());
		
		
	}

}
