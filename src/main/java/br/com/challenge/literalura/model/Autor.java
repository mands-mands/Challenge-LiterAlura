package br.com.challenge.literalura.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private int nascimento;
    private int falecimento;
    @OneToMany(mappedBy = "autor", cascade = CascadeType.ALL)
    private List<Livro> listaLivros = new ArrayList<>();

    public Autor(String nome, int nascimento, int falecimento, List<Livro> listaLivros) {
        this.nome = nome;
        this.nascimento = nascimento;
        this.falecimento = falecimento;
        this.listaLivros = listaLivros;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNascimento() {
        return nascimento;
    }

    public void setNascimento(int nascimento) {
        this.nascimento = nascimento;
    }

    public int getFalecimento() {
        return falecimento;
    }

    public void setFalecimento(int falecimento) {
        this.falecimento = falecimento;
    }

    public List<Livro> getListaLivros() {
        return listaLivros;
    }

    public void setListaLivros(List<Livro> listaLivros) {
        this.listaLivros = listaLivros;
    }

    @Override
    public String toString() {
        return  " Nome ='" + nome + '\'' +
                ", Nascimento =" + nascimento +
                ", Falecimento =" + falecimento +
                ", Livros =" + listaLivros ;
    }
}
