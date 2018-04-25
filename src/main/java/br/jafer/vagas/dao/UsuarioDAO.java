package br.jafer.vagas.dao;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import br.jafer.vagas.entity.Usuario;
import br.jafer.vagas.util.HibernateUtil;

public class UsuarioDAO extends GenericDAO<Usuario> {
	
	public Usuario autenticar(String userName, String senha) {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		try {
			Criteria consulta = session.createCriteria(Usuario.class);
			
			consulta.add(Restrictions.eq("userName", userName));
			SimpleHash hash = new SimpleHash("md5", senha);
			consulta.add(Restrictions.eq("senha", hash.toHex()));
			
			Usuario resultado = (Usuario) consulta.uniqueResult();
			
			return resultado;
			
		}catch (Exception e) {
			throw e;
		}finally {
			session.close();
		}
	}

}
