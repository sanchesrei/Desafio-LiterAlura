# 📚 LiterAlura - Catálogo de Livros

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-6DB33F?style=for-the-badge&logo=spring-boot&logoColor=white)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-316192?style=for-the-badge&logo=postgresql&logoColor=white)

O **LiterAlura** é uma aplicação Java desenvolvida como parte do desafio do programa **Oracle Next Education (ONE)** em parceria com a **Alura**. O objetivo é construir um catálogo de livros que consome dados da API [Gutendex](https://gutendex.com/), realiza a persistência num banco de dados relacional e permite consultas através de um menu interativo no terminal.

## 🔨 Funcionalidades

O sistema oferece as seguintes opções:

1.  **Buscar livro pelo título:** Consulta a API Gutendex e guarda o livro e o autor no banco de dados.
2.  **Listar livros registados:** Exibe todos os livros guardados no banco local.
3.  **Listar autores registados:** Exibe todos os autores guardados no sistema.
4.  **Listar autores vivos num determinado ano:** Filtra autores que estavam vivos no ano informado.
5.  **Listar livros num determinado idioma:** Filtra livros por siglas (ex: `pt`, `en`, `es`, `fr`).

## 🚀 Tecnologias Utilizadas

* **Java 17**
* **Spring Boot 3**
* **Spring Data JPA**
* **PostgreSQL**
* **Jackson** (para manipulação de JSON)
* **Maven** (gestor de dependências)

## 📋 Pré-requisitos

Antes de começar, certifique-se de que tem instalado:
* JDK 17 ou superior
* Maven
* PostgreSQL

## 🔧 Configuração e Execução

1. **Clone o repositório:**
   ```bash
   git clone [https://github.com/sanchesrei/Desafio-LiterAlura.git](https://github.com/sanchesrei/Desafio-LiterAlura.git)
   cd Desafio-LiterAlura
