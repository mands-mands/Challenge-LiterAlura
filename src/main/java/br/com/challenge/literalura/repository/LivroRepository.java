package br.com.challenge.literalura.repository;

import br.com.challenge.literalura.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LivroRepository extends JpaRepository<Livro, Long> {

    List<Livro> findByIdioma(String idioma);

    Optional<Livro> findByTitulo(String titulo);

}
