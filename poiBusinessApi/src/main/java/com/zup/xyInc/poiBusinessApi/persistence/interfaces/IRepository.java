package com.zup.xyInc.poiBusinessApi.persistence.interfaces;

import com.zup.xyInc.poiBusinessApi.exception.PoiException;

/**
 * Classe que representa a interface base a ser implementada por um repositório
 * 
 * @author rafael
 *
 * @param <T>
 * @param <ID>
 */
public interface IRepository<T, ID> {

	/**
	 * Método responsável por salvar objeto
	 * 
	 * @param object
	 * @return
	 * @throws PoiException
	 */
	T save(T object) throws PoiException;
	
	/**
	 * Método responsável por remover objeto
	 * 
	 * @param object
	 * @throws PoiException
	 */
	void delete(T object) throws PoiException;
	
	/**
	 * Método responsável por alterar objeto
	 * 
	 * @param object
	 * @return
	 * @throws PoiException
	 */
	T update(T object) throws PoiException;
	
}