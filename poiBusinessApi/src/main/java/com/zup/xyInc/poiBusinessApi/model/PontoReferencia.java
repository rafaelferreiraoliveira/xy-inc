package com.zup.xyInc.poiBusinessApi.model;

/**
 * Classe que representa um ponto de referência a ser consultado
 * 
 * @author rafael
 *
 */
public class PontoReferencia {

	private Integer coordenadaX;
	private Integer coordenadaY;
	private Integer distanciaMaxima;
	
	/**
	 * Construtor 
	 */
	public PontoReferencia() {
		super();
	}
	
	/**
	 * Construtor
	 * 
	 * @param coordenadaX
	 * @param coordenadaY
	 * @param distanciaMaxima
	 */
	public PontoReferencia(Integer coordenadaX, Integer coordenadaY, Integer distanciaMaxima) {
		super();
		this.coordenadaX = coordenadaX;
		this.coordenadaY = coordenadaY;
		this.distanciaMaxima = distanciaMaxima;
	}

	/**
	 * Retorna coordenada X do ponto de referência
	 * 
	 * @return
	 */
	public Integer getCoordenadaX() {
		return coordenadaX;
	}
	
	/**
	 * Atribui coordenada X do ponto de referência
	 * 
	 * @param coordenadaX
	 */
	public void setCoordenadaX(Integer coordenadaX) {
		this.coordenadaX = coordenadaX;
	}
	
	/**
	 * Retorna coordenada Y do ponto de referência
	 * 
	 * @return
	 */
	public Integer getCoordenadaY() {
		return coordenadaY;
	}
	
	/**
	 * Atribui coordenada Y do ponto de referência
	 * 
	 * @param coordenadaY
	 */
	public void setCoordenadaY(Integer coordenadaY) {
		this.coordenadaY = coordenadaY;
	}
	
	/**
	 * Retorna distancia máxima do ponto de referência
	 * 
	 * @return
	 */
	public Integer getDistanciaMaxima() {
		return distanciaMaxima;
	}
	
	/**
	 * Atribui distancia máxima do ponto de referência
	 * 
	 * @param distanciaMaxima
	 */
	public void setDistanciaMaxima(Integer distanciaMaxima) {
		this.distanciaMaxima = distanciaMaxima;
	}
	
}
