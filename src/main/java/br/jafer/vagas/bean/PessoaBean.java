package br.jafer.vagas.bean;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;
import org.primefaces.context.RequestContext;

import br.jafer.vagas.dao.PessoaDAO;
import br.jafer.vagas.entity.Pessoa;





@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class PessoaBean implements Serializable{
	
	private Pessoa pessoa = new Pessoa();
	private List<Pessoa> pessoas;
	
	
	
	public List<Pessoa> getPessoas() {
		return pessoas;
	}

	public void setPessoas(List<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}
	
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	
	public void abrirDialogo() {
		Map<String, Object> opcoes = new HashMap<>();
		opcoes.put("Modal", true);
		opcoes.put("resizable", false);
		opcoes.put("contentHeight",470);
		
		RequestContext.getCurrentInstance().openDialog("selecaoPessoa", opcoes,null);
		
	}
	
	@PostConstruct
	public void listPessoas(){
		try {
			PessoaDAO dao = new PessoaDAO();
			pessoas = dao.list();
			
		} catch (RuntimeException e) {
			Messages.addFlashGlobalError("Ocorreu um erro");
			e.printStackTrace();
		}
	}
	
	public void novo() {
		pessoa = new Pessoa();
	}
	
	public void exiracao() {
		
	}
	
	public void detail(ActionEvent event) {
		 pessoa= (Pessoa)event.getComponent().getAttributes().get("selectedPerson");
	}
	
	
	
	
	
	public void salvar(){
		try {
			PessoaDAO dao = new PessoaDAO();
			
			
			pessoa.setCidade("Caucaia");
			pessoa.setEstado("Ceará");
			Calendar calendar = Calendar.getInstance();			
			calendar.setTime(new Date());						
			pessoa.setDataPrimeiraCredencial(calendar.getTime());
			calendar.add(Calendar.YEAR, 5);			
			pessoa.setVencimento(calendar.getTime());
			
			dao.merge(pessoa);
			novo();
			pessoas = dao.list();
			
			Messages.addGlobalInfo("Salvo com sucesso!!");	
		} catch (Exception e) {
			Messages.addFlashGlobalError("Ocorreu um erro");
			e.printStackTrace();
		}
		
	
	}

}
