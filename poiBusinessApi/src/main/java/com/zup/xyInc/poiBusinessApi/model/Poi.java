/**
 * 
 */
package com.zup.xyInc.poiBusinessApi.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.context.annotation.Configuration;

/**
 * Classe que representa um objeto POI
 * 
 * @author rafael
 *
 */
@Entity
@Configuration
public class Poi {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer codigo;

	private String nome;

	private Integer coordenadaX;

	private Integer coordenadaY;
	
	/**
	 *	Construtor 
	 */
	public Poi(){}
	
	/**
	 * Construtor
	 * 
	 * @param nome
	 * @param coordenadaX
	 * @param coordenadaY
	 */
	public Poi(String nome, Integer coordenadaX, Integer coordenadaY) {
		this.nome = nome;
		this.coordenadaX = coordenadaX;
		this.coordenadaY = coordenadaY;
	}
	
	/**
	 * Retorna código do POI
	 * 
	 * @return
	 */
	public Integer getCodigo() {
		return codigo;
	}
	
	/**
	 * Atribui código do POI
	 * 
	 * @param codigo
	 */
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
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
	
	/**
	 * Método responsável por verificar se a distância deste POI a 
	 * um ponto específico é menor que a máxima exigida
	 * 
	 * @param ponto
	 * @return
	 */
	public Boolean varificaDistanciaAtePonto(PontoReferencia ponto) {
		Double distancia = Math.sqrt(Math.pow((this.coordenadaX - ponto.getCoordenadaX()), 2) + Math.pow((this.coordenadaY - ponto.getCoordenadaY()), 2));
		return distancia.intValue() <= ponto.getDistanciaMaxima();
	}
	
}
