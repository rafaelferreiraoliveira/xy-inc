package com.zup.xyInc.poiBusinessApi.bizz.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zup.xyInc.poiBusinessApi.constants.MensagensRetorno;
import com.zup.xyInc.poiBusinessApi.exception.PoiException;
import com.zup.xyInc.poiBusinessApi.model.Poi;
import com.zup.xyInc.poiBusinessApi.model.PontoReferencia;
import com.zup.xyInc.poiBusinessApi.model.DTO.PoiDTO;
import com.zup.xyInc.poiBusinessApi.persistence.repository.PoiRepository;

/**
 * Classe responsável por realizar a interface com o repositório e implementar regras de validação
 * 
 * @author rafael
 *
 */
@Service
public class PoiBizzController implements Serializable {
	
	private static final long serialVersionUID = -7703768626593891716L;
	
	@Autowired
	private PoiRepository poiRepository;

	/**
	 * Método reponsável por salvar um novo objeto POI
	 * 
	 * @param poi
	 * @return
	 * @throws PoiException
	 */
	public Poi save(PoiDTO poiDTO) throws PoiException {
		validaPoiAntesSalvar(poiDTO);
		Poi poi = new Poi(poiDTO.getNome(),poiDTO.getCoordenadaX(),poiDTO.getCoordenadaY());
		return poiRepository.save(poi);
	}

	/**
	 * Método responsável por consultar todos os objetos POIs na base de dados
	 * 
	 * @return
	 * @throws PoiException
	 */
	public List<Poi> findAll() throws PoiException {
		return poiRepository.findAll();
	}
	
	/**
	 * Méotodo responsável por validar o objeto POI antes de salva-lo na base de dados
	 * 
	 * @param poi
	 * @throws PoiException
	 */
	private void validaPoiAntesSalvar(PoiDTO poi) throws PoiException {
		if (StringUtils.isEmpty(poi.getNome())) {
			throw new PoiException(MensagensRetorno.NOME_NAO_INFORMADO);
		} else if (poi.getNome().length() > 50) {
			throw new PoiException(MensagensRetorno.NOME_INVALIDO);
		} else if (poi.getCoordenadaX() == null) { 
			throw new PoiException(MensagensRetorno.COORDENADA_X_NAO_INFORMADA);
		} else if (poi.getCoordenadaX().compareTo(0) < 0) {
			throw new PoiException(MensagensRetorno.COORDENADA_X_INVALIDA);
		} else if (poi.getCoordenadaY() == null) { 
			throw new PoiException(MensagensRetorno.COORDENADA_Y_NAO_INFORMADA);
		} else if (poi.getCoordenadaY().compareTo(0) < 0) {
			throw new PoiException(MensagensRetorno.COORDENADA_Y_INVALIDA);
		}
	}
	
	/**
	 * Método responsável por buscar todos os POIs com distância menor ou igual à máxima informada
	 * 
	 * @param ponto
	 * @return
	 * @throws PoiException
	 */
	public List<String> buscarPoisProximo(PontoReferencia ponto) throws PoiException{
		List<Poi> listaPoi = poiRepository.buscarPoisProximo(ponto);
		List<String> listaRetorno = new ArrayList<>();
		listaPoi.stream().forEach(p -> {
			if (p.varificaDistanciaAtePonto(ponto)) listaRetorno.add(p.getNome());
		});
		return listaRetorno;
	}
	
}
