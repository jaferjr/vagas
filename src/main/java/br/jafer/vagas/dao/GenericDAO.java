package br.jafer.vagas.dao;


import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import br.jafer.vagas.util.HibernateUtil;

public class GenericDAO<E> {
	
	private Class<E> c;
	public GenericDAO() {
		this.c = (Class<E>)((ParameterizedType) getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
	}
	
	public void save(E entity){

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		
		try {
			tx = session.beginTransaction();
			session.save(entity);
			tx.commit();				
			
		} catch (RuntimeException e) {
			if(tx != null){
				tx.rollback();
				throw e;
			}
				
		}finally {
			session.close();
			
		}
	}
	
	public List<E> list(){
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			Criteria criteria = session.createCriteria(c);
			return criteria.list(); 
			
		} catch (RuntimeException e) {
			throw e;
		}finally {
			session.close();
		}
	}
	
	
	@SuppressWarnings("unchecked")
	public E search(Long codigo){
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			Criteria criteria = session.createCriteria(c);
			criteria.add(Restrictions.idEq(codigo));
			return (E)criteria.uniqueResult(); 
			
		} catch (RuntimeException e) {
			throw e;
		}finally {
			session.close();
		}
	}
	
	@SuppressWarnings("unchecked")
	public E search(String str){
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			Criteria criteria = session.createCriteria(c);
			criteria.add(Restrictions.eq("cpf",str));
			return (E)criteria.uniqueResult(); 
			
		} catch (RuntimeException e) {
			throw e;
		}finally {
			session.close();
		}
	}
	
	public void exclude(E entity){

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		
		try {
			tx = session.beginTransaction();
			session.delete(entity);
			tx.commit();				
			
		} catch (RuntimeException e) {
			if(tx != null){
				tx.rollback();
				throw e;
			}
				
		}finally {
			session.close();
			
		}
	}
	
	public void edit(E entity){

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		
		try {
			tx = session.beginTransaction();
			session.update(entity);
			tx.commit();				
			
		} catch (RuntimeException e) {
			if(tx != null){
				tx.rollback();
				throw e;
			}
				
		}finally {
			session.close();
			
		}
	}
	
	public void merge(E entity){

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		
		try {
			tx = session.beginTransaction();
			session.merge(entity     );
			tx.commit();				
			
		} catch (RuntimeException e) {
			if(tx != null){
				tx.rollback();
				throw e;
			}
				
		}finally {
			session.close();
			
		}
	}
	

}
