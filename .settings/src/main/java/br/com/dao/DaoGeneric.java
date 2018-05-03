package br.com.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.com.jpautil.JpaUtil;

public class DaoGeneric<E> {

	
	public void salvar (E entidade) {
	EntityManager entitymanager = JpaUtil.getEntityManager();
	EntityTransaction entityTransaction = entitymanager.getTransaction();
	entityTransaction.begin();
	entitymanager.persist(entidade);
	entityTransaction.commit();
	entitymanager.close();
	
	}

	public E merge (E entidade) {
		EntityManager entitymanager = JpaUtil.getEntityManager();
		EntityTransaction entityTransaction = entitymanager.getTransaction();
		entityTransaction.begin();
		
		E retorno = entitymanager.merge(entidade);
		
		entityTransaction.commit();
		entitymanager.close();
		
		return retorno;
		
		}
	
	public void delete(E entidade) {
		EntityManager entitymanager = JpaUtil.getEntityManager();
		EntityTransaction entityTransaction = entitymanager.getTransaction();
		entityTransaction.begin();
		
	    entitymanager.remove(entidade);
		
		entityTransaction.commit();
		entitymanager.close();
		
		
		}
	
	public void deletePorId (E entidade) {
		EntityManager entitymanager = JpaUtil.getEntityManager();
		EntityTransaction entityTransaction = entitymanager.getTransaction();
		entityTransaction.begin();
		
		Object c  = entitymanager.merge(entidade);
	    entitymanager.remove(c);
	    
		/*entitymanager.createQuery("delete from " + entidade.getClass().getCanonicalName() + " where id = "+ id ).executeUpdate();
	    entitymanager.remove(entidade); */
		
		entityTransaction.commit();
		entitymanager.close();
		
		
		}
	
	public List<E> getListEntity(Class<E> entidade ){
		EntityManager entitymanager = JpaUtil.getEntityManager();
		EntityTransaction entityTransaction = entitymanager.getTransaction();
		entityTransaction.begin();
		
		List<E> retorno = entitymanager.createQuery("from " + entidade.getName()).getResultList();		
		entityTransaction.commit();
		entitymanager.close();
		
	return retorno;
	
	}
	

}
