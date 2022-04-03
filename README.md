# 7DaysOfCode
Alura 7 Day Java Code Challenge ☕



## 1 - Desafio

- Fazer o seu código Java rodar e consumir a API do IMDB! Seu objetivo será imprimir os resultados de uma busca na linha de comando.
  

## Solução

Inicialmente criar uma conta no IMDB para ter a chave de acesso ao serviço (apiKey).

Criar o código Java que executará uma requisição HTTP do tipo GET e usar o pacote java.net.http e as classes HttpRequest, HttpClient, HttpResponse e URI para executar a requisição e pegar a resposta (o JSON) e imprimir o corpo da resposta no console.

Acessar o webservice ou API da plataforma em IMDB:

https://imdb-api.com/

URL para requisição: 

https://imdb-api.com/en/API/Top250Movies/<apiKey>

Retorno esperado da requisição:

{"items":[{"id":"tt5491994","rank":"1","title":"Planet Earth II","fullTitle":"Planet Earth II (2016)"…

