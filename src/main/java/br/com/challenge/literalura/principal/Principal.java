package br.com.challenge.literalura.principal;

import br.com.challenge.literalura.dto.DadosAutor;
import br.com.challenge.literalura.dto.DadosLivro;
import br.com.challenge.literalura.dto.DadosResposta;
import br.com.challenge.literalura.model.Autor;
import br.com.challenge.literalura.model.Livro;
import br.com.challenge.literalura.repository.AutorRepository;
import br.com.challenge.literalura.repository.LivroRepository;
import br.com.challenge.literalura.service.ConectaApi;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {

    Scanner teclado = new Scanner(System.in);
    private String endereco = "https://gutendex.com/books/?search=";
    private LivroRepository livroRepository;
    private AutorRepository autorRepository;

    public Principal(LivroRepository livroRepository, AutorRepository autorRepository) {
        this.livroRepository = livroRepository;
        this.autorRepository = autorRepository;
    }

    boolean continuar = true;

    public void exibiMenu(){

        while(continuar) {
            System.out.println("""
                    -------------------
                    Escolha o número da sua opção:
                    
                    1 - Buscar livro pelo título
                    2 - Listar livros registrados
                    3 - Listar autores registrados
                    4 - Listar autores vivos em um determinado ano
                    5 - Listar livros em um determinado idioma
                    
                    0 - Sair""");
            try {
                var escolha = teclado.nextInt();
                teclado.nextLine();
                switch (escolha) {
                    case 1 -> buscarLivro();
                    case 2 -> listarLivros();
                    case 3 -> listarAutores();
                    case 4 -> listarAutoresVivos();
                    case 5 -> livroPorIdioma();
                    default -> System.out.println("Opção inválida!!!");
                }
            } catch (InputMismatchException | JsonProcessingException e) {
                System.out.println("Escolha inválida! Tente novamente");
                teclado.nextLine();
            }
        }
    }

    public void buscarLivro() throws JsonProcessingException {
        System.out.println("Digite o nome do livro:");
        var nomeLivro = teclado.nextLine().toLowerCase();
        ConectaApi conexao = new ConectaApi();
        var json = conexao.conectApi(endereco + nomeLivro.trim().replace(" ", "+"));
        ObjectMapper mapper = new ObjectMapper();
        DadosResposta resposta = mapper.readValue(json, DadosResposta.class);

        if (!resposta.results().isEmpty()) {

            DadosLivro dadosLivro = resposta.results().get(0);
            DadosAutor dadosAutor = dadosLivro.autor().get(0);

            Autor autor = new Autor();
            autor.setNome(dadosAutor.nome());
            autor.setNascimento(dadosAutor.nascimento());
            autor.setFalecimento(dadosAutor.falecimento());
            autorRepository.save(autor);

            Livro livro = new Livro();
            livro.setTitulo(dadosLivro.titulo());
            livro.setIdioma(dadosLivro.idioma().get(0));
            livro.setAutor(autor);
            livroRepository.save(livro);

            System.out.println("Título: " + dadosLivro.titulo());
            System.out.println("Autor: " + dadosLivro.autor().get(0).nome());
            System.out.println("Idioma: " + dadosLivro.idioma().get(0));

        } else {
            System.out.println("Livro não encontrado.");
        }
    }


    private void listarLivros() {
    }

    private void listarAutores() {
    }

    private void listarAutoresVivos() {
    }

    private void livroPorIdioma() {
    }

}
