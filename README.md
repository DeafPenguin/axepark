<h1 align="center">
📄<br>Axe Parking
</h1>

## Projeto de gerenciamento de estacionamento

Projeto criado a partir do desafio de projeto do [Bootcamp Québec Java Digital](https://web.dio.me/track/quebec-java-digital), da Digital Innovation One.

## Linguagens e tecnologias utilizadas

- <img src="https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white"/>
- <img src="https://img.shields.io/badge/Spring-6DB33F?style=for-the-badge&logo=spring&logoColor=white"/> [¹]
- <img src="https://img.shields.io/badge/Docker-2496ED?style=for-the-badge&logo=docker&logoColor=white"/>  
- <a href="https://axepark.herokuapp.com/"><img src="https://img.shields.io/badge/Heroku-430098?style=for-the-badge&logo=heroku&logoColor=white"/></a>
- <a href="https://github.com/DeafPenguin/axepark"><img src="https://img.shields.io/badge/Git-E34F26?style=for-the-badge&logo=git&logoColor=white"/></a>

[¹] Apesar que foi utilizado SpringFox/Swagger2 no projeto do DIO, tomei a liberdade para utilizar o SpringDoc/Swagger3 por questão de compatibilidade.

## Run database

Para criar e rodar o bd, utilizar docker e executar o comando abaixo:
```
docker run --name parking-db -p 5432:5432 -e POSTGRES_DB=axeparking -e POSTGRES_USER=admin -e POSTGRES_PASSWORD=123 -d postgres:10-alpine
```

## 🍜 Licença

Esse projeto está sob licença. Veja o arquivo [LICENÇA](LICENSE.md) para mais detalhes.<br>