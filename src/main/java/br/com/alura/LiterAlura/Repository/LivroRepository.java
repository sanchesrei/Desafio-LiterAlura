package br.com.alura.LiterAlura.Repository;

import br.com.alura.LiterAlura.Model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LivroRepository extends JpaRepository<Livro, Long> {
    Optional<Livro> findByTituloIgnoreCase(String titulo);

   // List<Livro> findByIdiomaIgnoreCase(String idioma);
    List<Livro> findByIdiomasContainingIgnoreCase(String idiomas);
}
