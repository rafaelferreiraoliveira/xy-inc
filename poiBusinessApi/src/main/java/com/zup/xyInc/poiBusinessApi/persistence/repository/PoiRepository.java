package com.zup.xyInc.poiBusinessApi.persistence.repository;

import java.io.Serializable;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Service;

import com.zup.xyInc.poiBusinessApi.exception.PoiException;
import com.zup.xyInc.poiBusinessApi.model.Poi;
import com.zup.xyInc.poiBusinessApi.model.PontoReferencia;
import com.zup.xyInc.poiBusinessApi.persistence.base.Repository;

/**
 * Classe responsável por realizar operações relacionadas aos POIs na base de dados
 * 
 * @author rafael
 *
 */
@Service
public class PoiRepository extends Repository<Poi, Long> implements Serializable {

	private static final long serialVersionUID = 2428084748948403879L;

	/**
	 * Método responsável por listar todos os POIs cadastrados
	 * 
	 * @return
	 * @throws PoiException
	 */
	public List<Poi> findAll() throws PoiException{
		CriteriaQuery<Poi> criteria = getSession().getCriteriaBuilder().createQuery(Poi.class);
		criteria.from(Poi.class);
		return getSession().createQuery(criteria).getResultList();
	}
	
	/**
	 * Método responsável por buscar todos os possíveis POIs com distância menor ou igual à máxima informada
	 * 
	 * @param ponto
	 * @return
	 * @throws PoiException
	 */
	public List<Poi> buscarPoisProximo(PontoReferencia ponto) throws PoiException{
		
		Integer coordenadaXMaxima = ponto.getCoordenadaX() + ponto.getDistanciaMaxima();
		Integer coordenadaXMinima = ponto.getCoordenadaX() - ponto.getDistanciaMaxima();
		Integer coordenadaYMaxima = ponto.getCoordenadaY() + ponto.getDistanciaMaxima();
		Integer coordenadaYMinima = ponto.getCoordenadaY() - ponto.getDistanciaMaxima();
		
		CriteriaBuilder builder = getSession().getCriteriaBuilder();
		CriteriaQuery<Poi> criteria = builder.createQuery(Poi.class);
		Root<Poi> root = criteria.from(Poi.class);
		criteria.select(root)
			.where(builder.le(root.get("coordenadaX"), coordenadaXMaxima),
					builder.ge(root.get("coordenadaX"), coordenadaXMinima),
					builder.le(root.get("coordenadaY"), coordenadaYMaxima),
					builder.ge(root.get("coordenadaY"), coordenadaYMinima));
		
		return getSession().createQuery(criteria).getResultList();
	}
	
}
