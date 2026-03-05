package br.com.challenge.literalura.principal;

import java.util.Scanner;

public class Principal {

    Scanner teclado = new Scanner(System.in);

    public void exibiMenu(){
        System.out.println("""
                -------------------
                Escolha o número da sua opção:
                
                1 - Buscar livro pelo título
                2 - Listar livros registrados
                3 - Listar autores registrados
                4 - LIstar autores vivos em um determinado ano
                5 - listar livros em um determinado idioma
                
                0 - Sair""");
        try{
            var escolha = teclado.nextInt();
            teclado.nextLine();
            switch (escolha){
                case 1 -> buscarLivro();

            }
        }
    }
}
