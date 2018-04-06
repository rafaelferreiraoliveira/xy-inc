package com.zup.xyInc.poiBusinessApi.persistence.base;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;

import com.zup.xyInc.poiBusinessApi.exception.PoiException;
import com.zup.xyInc.poiBusinessApi.persistence.interfaces.IRepository;

/**
 * Classe que representa o repositório base do projeto
 * 
 * @author rafael
 *
 * @param <T>
 * @param <ID>
 */
public class Repository<T, ID extends Serializable> implements IRepository<T, ID> {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public T save(T object) throws PoiException{
		this.getSession().saveOrUpdate(object);
		return object;
	}
	
	@Override
	public void delete(T object) throws PoiException{
		getSession().delete(object);
	}

	@Override
	public T update(T object) throws PoiException{
		getSession().update(object);
		return object;
	}
	
	protected Session getSession() {
		return entityManager.unwrap(Session.class);
	}
	
	protected EntityManager getEntityManager() {
		return entityManager;
	}
}
