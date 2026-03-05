package br.com.challenge.literalura.repository;

import br.com.challenge.literalura.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorRepository extends JpaRepository<Autor, Long> {
}
