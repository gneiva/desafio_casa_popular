# Seleção de famílias aptas a ganharem uma casa popular
Projeto para o desafio de seleção de famílias aptas a ganharem uma casa popular da Digix

## Objetivo

Temos um produto e recebemos o desafio de gerar uma lista de pessoas aptas a ganhar uma casa popular do governo, tendo como única exigência que essa lista esteja ordenada de forma mais justa possível com um somatório de pontos, analisando aspectos das famílias que estão participando. São considerados os seguintes critérios para a construção das pontuações:

- Renda total da família até 900 reais - valendo 5 pontos;
- Renda total da família de 901 à 1500 reais - valendo 3 pontos;
- Famílias com 3 ou mais dependentes  (lembrando que dependentes maiores de 18 anos não contam) - valendo 3 pontos;
- Famílias com 1 ou 2 dependentes  (lembrando que dependentes maiores de 18 anos não contam) - valendo 2 pontos.

O código que faz essa análise hoje é totalmente procedural, repleto de blocos if/else pra analisar e montar as classificações e nos dá muito custo de manutenção, nos motivando a procurar uma nova solução para este problema. Seu desafio é justamente isso, codificar uma forma melhor de chegar no mesmo resultado usando e abusando da orientação à objetos, criando classes e métodos de uma forma que fique tudo mais legível e fácil de manter e estender.

Falando sobre estender, o cliente já deixou um alerta ligado de que irão incluir novos critérios na avaliação das famílias em breve, assim que forem aprovados pelo governador, então temos que ter uma solução preparada para adicioná-los sem muito custo de implementação.

## pré-requisito
Java versão 8 ou posterior <br>
Maven 3.3+<br>
GIT<br>

## Instalação
1º Utilizando o GIT realize o clone do projeto<br>
<code> git clone https://github.com/gneiva/desafio_casa_popular.git </code>

2º Acesse a pasta do projeto<br>
<code> cd desafio_casa_popular/  </code>

3º Com o maven realize o build<br>
<code> mvn clean package  </code>

4º Rode a aplicação<br>
<code> java -jar target/casa-0.0.1-SNAPSHOT.jar  </code>

5º Testando a aplicação<br>
acesse http://localhost:8080/familia/rank utilizando o método GET para obter o objeto json com as famílias ordenada por pontuação
