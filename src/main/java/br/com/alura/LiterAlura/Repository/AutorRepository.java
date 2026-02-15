package br.com.alura.LiterAlura.Repository;

import br.com.alura.LiterAlura.Model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AutorRepository extends JpaRepository<Autor, Long> {

   // Optional<Autor> findByTituloIgnoreCase(String nome);

    @Query("SELECT DISTINCT a FROM Livro l JOIN l.autor a ORDER BY a.nome")
    List<Autor> listarAutorResgistrado();

    @Query("SELECT  DISTINCT a FROM Livro l JOIN l.autor a WHERE  a.anoNascimento <= :ano AND (a.anoFalecimento IS NULL OR a.anoFalecimento >= :ano)")
    List<Autor> listarAutoresVivosNoAno(int ano);
}
