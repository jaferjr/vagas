package br.jafer.vagas.bean;


import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.omnifaces.util.Faces;
import org.omnifaces.util.Messages;

import br.jafer.vagas.dao.UsuarioDAO;
import br.jafer.vagas.entity.Usuario;

@ManagedBean
@SessionScoped
public class UserLoginBean {

	private Usuario usuario;

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@PostConstruct
	public void novo() {
		usuario = new Usuario();
	}
	
	public void autenticar() {
		try {
			UsuarioDAO dao = new UsuarioDAO();
			Usuario user = dao.autenticar(usuario.getUserName(), usuario.getSenha());
			if(user == null) {
				Messages.addGlobalError("Credenciais Inválidas");
				return;
				
			}
			
			Faces.redirect("./pages/principal.xhtml");
		} catch (IOException e) {
			Messages.addGlobalError(e.getMessage());
			e.printStackTrace();
		}
	}

}
