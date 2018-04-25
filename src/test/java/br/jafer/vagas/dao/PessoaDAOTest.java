package br.jafer.vagas.dao;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.junit.Ignore;
import org.junit.Test;

import br.jafer.vagas.entity.Pessoa;

public class PessoaDAOTest {

	@Test
	@Ignore
	public void save(){		
		
		
		Pessoa pessoa = new Pessoa();
		pessoa.setTipo(1);
		pessoa.setCpf("74656738978");
		pessoa.setRg("897776454");
		
		
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		try {
		pessoa.setNascimento(format.parse("21/03/1976"));
		}catch (ParseException e) {
			e.printStackTrace();
		}
		pessoa.setDataPrimeiraCredencial(calendar.getTime());
		calendar.add(Calendar.YEAR, 5);
		pessoa.setVencimento(calendar.getTime());
		
		
//		try {
//			dataNascimento = dateFormat.parse("21/03/1976");
////			dataVencimento = dateFormat.parse(")
//			
//			pessoa.setNascimento(dataNascimento);
//			pessoa.setDataPrimeiraCredencial(dataNascimento);
//			pessoa.setVencimento(dataNascimento);
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		pessoa.setBairro("Varjta");
		pessoa.setCep("608226676");
		pessoa.setLogradouro("Rua dos Edonistas, 24");
		pessoa.setNome("Tiburcio Almeida");
		pessoa.setCidade("Fortaleza");
		pessoa.setEstado("Ceará");
		
		PessoaDAO dao = new PessoaDAO();
		dao.save(pessoa);
		
		
	}
	
	@Test
	@Ignore
	public void listPessoa(){
		PessoaDAO dao = new PessoaDAO();
		dao.list();
	}
	@Test
	
	public void search(){
		PessoaDAO dao = new PessoaDAO();
		dao.search("74656738978");		
	}
	
	@Test
	@Ignore
	public void excluir(){		
		PessoaDAO dao = new PessoaDAO();
		Pessoa p = dao.search(40L); 			
		dao.exclude(p);
	}


}
