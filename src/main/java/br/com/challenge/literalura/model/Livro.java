package br.com.challenge.literalura.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    @ManyToOne
    private Autor autor;
    private List<String> idioma;


    public Livro(String titulo, Autor autor, List<String> idioma) {
        this.titulo = titulo;
        this.autor = autor;
        this.idioma = idioma;
    }

    public Livro(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public List<String> getIdioma() {
        return idioma;
    }

    public void setIdioma(List<String> idioma) {
        this.idioma = idioma;
    }

    @Override
    public String toString() {
        return " Titulo='" + titulo + '\'' +
                ", Autor=" + autor.getNome() +
                ", Idioma='" + idioma + '\'' +
                '}';
    }
}
