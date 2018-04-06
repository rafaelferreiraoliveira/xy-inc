package com.zup.xyInc.poiBusinessApi;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.google.gson.Gson;
import com.zup.xyInc.poiBusinessApi.model.DTO.PoiDTO;

/**
 * Classe responsável por testar as funcionalidades da API
 * 
 * @author rafael
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = PoiBusinessApiApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PoiBusinessApiApplicationTests {
	
	@Autowired 
	private WebApplicationContext webApplicationContext;
	
	@Autowired 
	private Gson gson;
	
	private MockMvc mockMvc;
	
	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}
	
	/**
	 * Teste responsável por validar o serviço de consulta de POIs cadastrados
	 * 
	 * Retorno esperado: lista de POIs cadastrados
	 * 
	 * @throws Exception
	 */
	@Test
	public void listar() throws Exception {	
		mockMvc.perform(MockMvcRequestBuilders
				.get("/poiBusinessApi/listar")
				.accept(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk())
				.andDo(print());
	}
	
	/**
	 * Teste responsável por salvar um novo POI
	 * 
	 * Retorno esperado: objeto POI cadastrado
	 * 
	 * @throws Exception
	 */
	@Test
	public void salvar() throws Exception {
		
		String json = gson.toJson(new PoiDTO("Casa", 18, 5));
		
		mockMvc.perform(MockMvcRequestBuilders
				.post("/poiBusinessApi/inserir")
				.contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
				.content(json)
				.accept(MediaType.APPLICATION_JSON_UTF8_VALUE))
				.andExpect(status().isAccepted())
				.andDo(print());
	}
	
	/**
	 * Teste responsável por salvar um novo POI e listar os POIs cadastrados
	 * 
	 * Retorno esperado: objeto POI cadastrado e lista com todos os POIs cadastrados, com pelo menos o POI cadastrado neste teste
	 * 
	 * @throws Exception
	 */
	@Test
	public void salvarListar() throws Exception {
		
		String json = gson.toJson(new PoiDTO("Casa", 18, 5));
		
		mockMvc.perform(MockMvcRequestBuilders
				.post("/poiBusinessApi/inserir")
				.contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
				.content(json)
				.accept(MediaType.APPLICATION_JSON_UTF8_VALUE))
				.andExpect(status().isAccepted())
				.andDo(print());
		
		mockMvc.perform(MockMvcRequestBuilders
				.get("/poiBusinessApi/listar")
				.accept(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk())
				.andDo(print());
	}
	
	/**
	 * Teste responsável por tentar cadastrar um novo POI sem informar o nome
	 * 
	 * Retorno esperado: mensagem "Atenção! Nome do POI não informado!".
	 * 
	 * @throws Exception
	 */
	@Test
	public void salvarNomeNull() throws Exception {
		
		String json = gson.toJson(new PoiDTO(null, 18, 5));
		
		mockMvc.perform(MockMvcRequestBuilders
				.post("/poiBusinessApi/inserir")
				.contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
				.content(json)
				.accept(MediaType.APPLICATION_JSON_UTF8_VALUE))
				.andExpect(status().isBadRequest())
				.andDo(print());
	}
	
	/**
	 * Teste responsável por tentar cadastrar um novo POI com o valor do nome inválido
	 * 
	 * Retorno esperado: mensagem "Atenção! Nome do POI informado é inválido! O valor deve ter no máximo 50 caractéres."
	 * 
	 * @throws Exception
	 */
	@Test
	public void salvarNomeInvalido() throws Exception {
		
		String json = gson.toJson(new PoiDTO("AaAaAaAaAaAaAaAaAaAaAaAaAaAaAaAaAaAaAaAaAaAaAaAaAaAa", 18, 5));
		
		mockMvc.perform(MockMvcRequestBuilders
				.post("/poiBusinessApi/inserir")
				.contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
				.content(json)
				.accept(MediaType.APPLICATION_JSON_UTF8_VALUE))
				.andExpect(status().isBadRequest())
				.andDo(print());
	}
	
	/**
	 * Teste responsável por tentar cadastrar um novo POI com coordenada X nula
	 * 
	 * Retorno esperado: mensagem "Atenção! Coordenada X do POI não informada!"
	 * 
	 * @throws Exception
	 */
	@Test
	public void salvarCoordenadaXNull() throws Exception {
		
		String json = gson.toJson(new PoiDTO("Casa", null, 5));
		
		mockMvc.perform(MockMvcRequestBuilders
				.post("/poiBusinessApi/inserir")
				.contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
				.content(json)
				.accept(MediaType.APPLICATION_JSON_UTF8_VALUE))
				.andExpect(status().isBadRequest())
				.andDo(print());
	}
	
	/**
	 * Teste responsável por tentar cadastrar um novo POI com coordenada X inválida
	 * 
	 * Retorno esperado: mensagem "Atenção! Coordenada X do POI informada é inválida! O valor deve ser um inteiro não negativo."
	 * 
	 * @throws Exception
	 */
	@Test
	public void salvarCoordenadaXInvalida() throws Exception {
		
		String json = gson.toJson(new PoiDTO("Casa", -18, 5));
		
		mockMvc.perform(MockMvcRequestBuilders
				.post("/poiBusinessApi/inserir")
				.contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
				.content(json)
				.accept(MediaType.APPLICATION_JSON_UTF8_VALUE))
				.andExpect(status().isBadRequest())
				.andDo(print());
	}
	
	/**
	 * Teste responsável por tentar cadastrar um novo POI com coordenada Y nula
	 * 
	 * Retorno esperado: mensagem "Atenção! Coordenada Y do POI não informada!"
	 * 
	 * @throws Exception
	 */
	@Test
	public void salvarCoordenadaYNull() throws Exception {
		
		String json = gson.toJson(new PoiDTO("Casa", 18, null));
		
		mockMvc.perform(MockMvcRequestBuilders
				.post("/poiBusinessApi/inserir")
				.contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
				.content(json)
				.accept(MediaType.APPLICATION_JSON_UTF8_VALUE))
				.andExpect(status().isBadRequest())
				.andDo(print());
	}
	
	/**
	 * Teste responsável por tentar cadastrar um novo POI com coordenada Y inválida
	 * 
	 * Retorno esperado: mensagem "Atenção! Coordenada Y do POI informada é inválida! O valor deve ser um inteiro não negativo."
	 * 
	 * @throws Exception
	 */
	@Test
	public void salvarCoordenadaYInvalida() throws Exception {
		
		String json = gson.toJson(new PoiDTO("Casa", 18, -5));
		
		mockMvc.perform(MockMvcRequestBuilders
				.post("/poiBusinessApi/inserir")
				.contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
				.content(json)
				.accept(MediaType.APPLICATION_JSON_UTF8_VALUE))
				.andExpect(status().isBadRequest())
				.andDo(print());
	}
	
	/**
	 * Teste responsável por buscar POIs próximos ao ponto X=20, Y=10 e com distância máxima de 10 unidades de medida
	 * 
	 * Retorno esperado: lista de POIs cadastrados próximos a este ponto
	 * 
	 * @throws Exception
	 */
	@Test
	public void buscarProximo() throws Exception {
		
		mockMvc.perform(MockMvcRequestBuilders
				.get("/poiBusinessApi/listarProximos?coordenadaX=20&coordenadaY=10&distanciaMaxima=10")
				.accept(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk())
				.andDo(print());
	}
	
	/**
	 * Teste responsável por cadastrar um novo POI e buscar todos os POIs próximos ao ponto X=20, Y=10 e com distância máxima de 10 unidades de medida
	 * 
	 * Retorno esperado: objeto POI cadastrado e lista de POIs cadastrados próximos a este ponto, trazendo pelo menos o POI cadastrado neste teste
	 * 
	 * @throws Exception
	 */
	@Test
	public void salvarBuscarProximo() throws Exception {
		
		String json = gson.toJson(new PoiDTO("Casa", 18, 5));
		
		mockMvc.perform(MockMvcRequestBuilders
				.post("/poiBusinessApi/inserir")
				.contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
				.content(json)
				.accept(MediaType.APPLICATION_JSON_UTF8_VALUE))
				.andExpect(status().isAccepted())
				.andDo(print());
		
		mockMvc.perform(MockMvcRequestBuilders
				.get("/poiBusinessApi/listarProximos?coordenadaX=20&coordenadaY=10&distanciaMaxima=10")
				.accept(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk())
				.andDo(print());
	}
	
}
