# 📚 LiterAlura - Catálogo de Livros

## 🎯 Sobre o Projeto

O **LiterAlura** é um catálogo de livros desenvolvido em Java com Spring Boot, que consome a API pública [Gutendex](https://gutendex.com/) para buscar informações sobre livros e armazená-las em um banco de dados local PostgreSQL.

Este projeto foi desenvolvido como parte do desafio da formação Oracle Next Education (ONE) em parceria com a Alura.

## 🛠️ Tecnologias Utilizadas

- **Java 17** - Linguagem de programação
- **Spring Boot 3.2.3** - Framework principal
- **Spring Data JPA / Hibernate** - Persistência de dados
- **PostgreSQL 16** - Banco de dados relacional
- **Maven** - Gerenciamento de dependências
- **Gutendex API** - Fonte de dados dos livros

## ✨ Funcionalidades

O sistema oferece um menu interativo no terminal com as seguintes opções:

1. Buscar livros pelo título
2. Listar livros registrados
3. Listar autores registrados
4. Listar autores vivos em determinado ano
5. Listar livros em determinado idioma


### 📖 Detalhamento das funcionalidades

| Opção | Descrição | Exemplo |
|-------|-----------|---------|
| **1. Buscar livro pelo título** | Consulta a API Gutendex e salva o livro no banco de dados | "Dom Casmurro", "Emma" |
| **2. Listar livros registrados** | Exibe todos os livros já salvos no banco | Título, autor, idioma, downloads |
| **3. Listar autores registrados** | Mostra todos os autores com seus livros e anos de nascimento/falecimento | Machado de Assis (1839-1908) |
| **4. Autores vivos em um ano** | Filtra autores que estavam vivos em um ano específico | Ano 1800 → Jane Austen |
| **5. Livros por idioma** | Busca livros pelos idiomas disponíveis (pt, en, es, fr) | "pt" → Dom Casmurro |

## Como rodar o projeto

### Pré-requisitos
- Java 17 instalado
- Banco de dados rodando (ex: PostgreSQL)
- Maven instalado

### 📥 Clonando o repositório

Clone o repósitorio em sua pasta desejada:

```bash
git clone https://github.com/mands-mands/Challenge-LiterAlura.git
```
### Configuração do banco
1. Crie um banco de dados no PostgreSQL:
```sql
CREATE DATABASE literalura;
```
2. Edite o arquivo:

`src/main/resources/application.properties`

Exemplo (PostgreSQL):
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/literalura
spring.datasource.username=SEU_USUARIO
spring.datasource.password=SUA_SENHA

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
```
### ▶️ Executando o programa

1. Abra o projeto na sua IDE de preferência (IntelliJ, Eclipse, VS Code)

2. Localize a classe principal:  
   `src/main/java/br/com/challenge/literalura/LiteraluraApplication.java`

3. Execute a aplicação clicando no botão "Run" (▶️) da sua IDE

4. O menu interativo será exibido no terminal da IDE:


![Demostração do LiterAlura em execução](assets/LiterAlura.gif)

**Pronto!** Agora é só testar as funcionalidades do catálogo. 😊

## 🎓 Agradecimentos

Gostaria de agradecer:
- **Oracle** e **Alura** pela oportunidade de participar do programa **Oracle Next Education (ONE)**
- A toda equipe de instrutores e suporte que tornaram este aprendizado possível
- À comunidade da Alura, sempre disposta a ajudar

**⭐ Se este projeto te ajudou, considere dar uma estrela! ⭐**
