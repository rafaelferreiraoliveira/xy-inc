/**
 * 
 */
package com.zup.xyInc.poiBusinessApi.model.DTO;

/**
 * Classe que representa um DTO do objeto POI
 * 
 * @author rafael
 *
 */
public class PoiDTO {

	private String nome;

	private Integer coordenadaX;

	private Integer coordenadaY;
	
	/**
	 *	Construtor 
	 */
	public PoiDTO(){}
	
	/**
	 * Construtor
	 * 
	 * @param nome
	 * @param coordenadaX
	 * @param coordenadaY
	 */
	public PoiDTO(String nome, Integer coordenadaX, Integer coordenadaY) {
		this.nome = nome;
		this.coordenadaX = coordenadaX;
		this.coordenadaY = coordenadaY;
	}
	
	/**
	 * Retorna nome do POI
	 * 
	 * @return
	 */
	public String getNome() {
		return nome;
	}
	
	/**
	 * Atribui nome do POI
	 * 
	 * @param nome
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	/**
	 * Retorna coordenada X do POI
	 * 
	 * @return
	 */
	public Integer getCoordenadaX() {
		return coordenadaX;
	}
	
	/**
	 * Atribui coordenada X do POI
	 * 
	 * @param coordenadaX
	 */
	public void setCoordenadaX(Integer coordenadaX) {
		this.coordenadaX = coordenadaX;
	}
	
	/**
	 * Retorna coordenada Y do POI
	 * 
	 * @return
	 */
	public Integer getCoordenadaY() {
		return coordenadaY;
	}
	
	/**
	 * Atribui coordenada Y do POI
	 * 
	 * @param coordenadaY
	 */
	public void setCoordenadaY(Integer coordenadaY) {
		this.coordenadaY = coordenadaY;
	}
	
}
