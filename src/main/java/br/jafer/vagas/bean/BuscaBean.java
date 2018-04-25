package br.jafer.vagas.bean;

import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.omnifaces.util.Faces;
import org.omnifaces.util.Messages;

import br.jafer.vagas.dao.PessoaDAO;
import br.jafer.vagas.entity.Pessoa;

@ManagedBean
@ViewScoped
public class BuscaBean{
	
	private Pessoa pessoa;
	
	public Pessoa getPessoa() {
		return pessoa;
	}
	
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	
	@PostConstruct
	public void init() {
		pessoa = new Pessoa();
	}
	
	public void buscar() throws IOException {
		try {
			PessoaDAO dao = new PessoaDAO();
			Pessoa result = dao.search(pessoa.getCpf());
//			Messages.addFlashGlobalInfo("usuário encontrado"+ result.getNome());
			if(result == null) {
				Messages.addFlashGlobalWarn("Usuário não cadastrado");
			}else {
				Faces.redirect("./pages/cadastro.xhtml");
				pessoa = result;
			}
			
		}catch (RuntimeException e) {
			Messages.addGlobalError("ocorreu um erro");
			e.printStackTrace();
			
		}
	}

}
