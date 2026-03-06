package br.com.challenge.literalura.repository;

import br.com.challenge.literalura.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AutorRepository extends JpaRepository<Autor, Long> {

    @Query("SELECT a FROM Autor a WHERE a.nascimento <= :ano AND a.falecimento >= :ano")
    List<Autor> autoresVivosAno(int ano);
}
