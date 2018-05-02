package br.com.dao;

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

}
