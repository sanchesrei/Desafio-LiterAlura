package br.com.alura.LiterAlura.Model;

import com.fasterxml.jackson.annotation.JsonAlias;

import java.util.List;

public record DadosRepostaApi(
        @JsonAlias("results") List<DadosLivro> resultado)
        {
}
