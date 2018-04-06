package com.zup.xyInc.poiBusinessApi.bizz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zup.xyInc.poiBusinessApi.bizz.controller.PoiBizzController;
import com.zup.xyInc.poiBusinessApi.exception.PoiException;
import com.zup.xyInc.poiBusinessApi.model.Poi;
import com.zup.xyInc.poiBusinessApi.model.PontoReferencia;
import com.zup.xyInc.poiBusinessApi.model.DTO.PoiDTO;

/**
 * Esta classe apresenta os serviços que serão expostos pela API
 * 
 * @author rafael
 *
 */
@RestController
@RequestMapping(value="/poiBusinessApi")
public class PoiBizzService {
	
	@Autowired
	private PoiBizzController poiBizzController; 
	
	/**
	 * Serviço responsável por inserir um novo POI na base de dados
	 * 
	 * @param poi
	 * @return
	 * @throws PoiException
	 */
	@PostMapping(value="/inserir",consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<?> inserir(@RequestBody PoiDTO poi) {
		Poi retorno;
		try {
			retorno = poiBizzController.save(poi);
			return new ResponseEntity<Poi>(retorno, HttpStatus.ACCEPTED);
		} catch (PoiException e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	/**
	 * Serviço responsável por listar todos os POIs cadastrados na base de dados
	 * 
	 * @return
	 * @throws PoiException
	 */
	@GetMapping("/listar")
	public ResponseEntity<List<Poi>> listar() throws PoiException{
		List<Poi> lista = poiBizzController.findAll();
		return new ResponseEntity<List<Poi>>(lista, HttpStatus.OK);
	}
	
	/**
	 * Serviço responsável por listar todos os POIs pŕoximos ao ponto indicado
	 * 
	 * @param coordenadax
	 * @param coordenadaY
	 * @param distancia
	 * @return
	 * @throws PoiException 
	 */
	@GetMapping("/listarProximos")
	public ResponseEntity<List<String>> listarProximos(
			@RequestParam(name="coordenadaX",required=true) Integer coordenadaX,
			@RequestParam(name="coordenadaY",required=true) Integer coordenadaY,
			@RequestParam(name="distanciaMaxima",required=true) Integer distanciaMaxima
			) throws PoiException {
		PontoReferencia ponto = new PontoReferencia(coordenadaX, coordenadaY, distanciaMaxima);
		List<String> listaRetorno = poiBizzController.buscarPoisProximo(ponto);
		return new ResponseEntity<List<String>>(listaRetorno, HttpStatus.OK);
	}
	
}
