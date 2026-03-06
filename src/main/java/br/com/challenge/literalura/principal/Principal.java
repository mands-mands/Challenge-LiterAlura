package br.com.challenge.literalura.principal;

import br.com.challenge.literalura.dto.DadosLivro;
import br.com.challenge.literalura.dto.DadosResposta;
import br.com.challenge.literalura.model.Livro;
import br.com.challenge.literalura.service.ConectaApi;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {

    Scanner teclado = new Scanner(System.in);
    private String endereco = "https://gutendex.com/books/?search=";

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

            DadosLivro livro = resposta.results().get(0);

            System.out.println("Título: " + livro.titulo());
            System.out.println("Autor: " + livro.autor().get(0).nome());
            System.out.println("Idioma: " + livro.idioma().get(0));

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
