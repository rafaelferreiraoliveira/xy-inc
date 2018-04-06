#	Desafio ZUP - Teste Desenvolvedor Back-End 2
#	Rafael Ferreira Oliveira

#	Requisitos propostos

	R1 ->	Construa um serviço para cadastrar pontos de interesse (POI), com 3 atributos: Nome do POI, coordenada X (inteiro não negativo) e coordenada Y (inteiro não negativo). Os POIs devem ser armazenados em uma base de dados.

	R2 ->	Construa um serviço para listar todos os POIs cadastrados.

	R3 ->	Construa um serviço para listar POIs por proximidade. Este serviço receberá uma coordenada X e uma coordenada Y, especificando um ponto de referência, bem como uma distância máxima (d-max) em metros. O serviço deverá retornar todos os POIs da base de dados que estejam a uma distância menor ou igual a d-max a partir do ponto de referência.

#	Iniciando Aplicação

->	Para iniciar a aplicação deve-se executar a classe PoiBusinessApiApplication como uma Aplicação Java, ou "Java Application".
	Esta classe está disponível em: src/main/java -> com.zup.xyInc.poiBusinessApi

#	Execução das operações

R1	->	Inserir um novo POI.
	
	->	Chamada do serviço:

	*	URL:	http://localhost:8080/poiBusinessApi/inserir
	*	Method:	POST
	*	Header: application/json
	*	Body:	{
					"nome":"Casa",
					"coordenadaX":18,
					"coordenadaY":5
				}

	->	Retorno esperado:

	{
		"codigo": 1,
   		"nome": "Casa",
   		"coordenadaX": 18,
   		"coordenadaY": 5
	}

	*	Observação: o objeto informado no body é do tipo PoiDTO;
					o valor do código é um número "auto increment", assim o número um representado acima é apenas um exemplo;

R2	->	Listar todos os POIs cadastrados.

	->	Chamada do serviço:

	*	URL:	http://localhost:8080/poiBusinessApi/listar
	*	Method:	GET
	*	Header: application/json
	*	Body:	N/A

	->	Retorno esperado:

	[
   		{
			"codigo": 1,
			"nome": "Lanchonete",
			"coordenadaX": 27,
			"coordenadaY": 12
		},
		{
			"codigo": 2,
			"nome": "Posto",
			"coordenadaX": 31,
			"coordenadaY": 18
		},
		{
			"codigo": 3,
			"nome": "Joalheria",
			"coordenadaX": 15,
			"coordenadaY": 12
		},
		...
	]

R3	->	Listar todos os POIs a uma distância máxima de um ponto informado.	

	->	Chamada do serviço:

	*	URL:	http://localhost:8080/poiBusinessApi/listarProximos?coordenadaX=20&coordenadaY=10&distanciaMaxima=10
	*	Method:	GET
	*	Header:	application/json
	*	Body:	N/A

	->	Retorno esperado:

	[	
   		"Lanchonete",
   		"Joalheria",
   		...
	]

	*	Observação:	o exemplo acima considera a consulta de todos os POIs próximos ao ponto de coordenada X igual a 20,	coordenada Y igual a 10 e a uma distância máxima de 10 unidades de medida.

#	Observações

	->	Caso deseje iniciar a aplicação inserindo os dados passados como exemplo no teste, deve-se remover as linhas 1 e 9 do arquivo V02__Popula_Tabela_POI.sql disponível em: src/main/resource -> /db -> /migration
