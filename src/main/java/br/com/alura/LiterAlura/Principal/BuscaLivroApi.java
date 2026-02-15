package br.com.alura.LiterAlura.Principal;

import br.com.alura.LiterAlura.Model.DadosLivro;
import br.com.alura.LiterAlura.Model.DadosRepostaApi;
import br.com.alura.LiterAlura.Model.Livro;
import br.com.alura.LiterAlura.Repository.LivroRepository;
import br.com.alura.LiterAlura.Service.ConsumoApi;
import br.com.alura.LiterAlura.Service.ConvertDados;

import java.util.Optional;
import java.util.Scanner;

public class BuscaLivroApi {
    // Scanner é apenas uma referência
    private Scanner leitor;
    private ConsumoApi consumo = new ConsumoApi();
    private ConvertDados conversor = new ConvertDados();
    private LivroRepository repositorio;
    private final String ENDERECO = "https://gutendex.com/books/?search=";

    // Construtor que recebe o scanner da classe e Repositório da classe Principal
    public BuscaLivroApi(Scanner leitor, LivroRepository repositorio) {
        this.leitor = leitor;
        this.repositorio = repositorio;
    }

    public void buscarLivro() {
        System.out.println("Digite nome de um Livro para fazer busca");
        var nomeLivro = leitor.nextLine();

        if (nomeLivro.isBlank()) {
            System.out.println("Busca vazia");
        }

        String json = consumo.obterDados(ENDERECO + nomeLivro
                .trim().replace(" ", "+"));

        DadosRepostaApi dados = conversor.obterDados(json, DadosRepostaApi.class);

        if (dados != null && !dados.resultado().isEmpty()) {
            DadosLivro dadosLivro = dados.resultado().get(0);
            // Verifica se o livro já existe no banco
            Optional<Livro> livroExistente = repositorio.findByTituloIgnoreCase(dadosLivro.titulo());

            if (livroExistente.isPresent()) {
                System.out.println("\n Livro já registrado no banco!");
                exibirResumo(dadosLivro);
            } else {
                Livro novoLivro = new Livro(dadosLivro);
                repositorio.save(novoLivro);

                System.out.println("\n Livro  salvo com sucesso!");
                exibirResumo(dadosLivro);
            }

        } else {
            System.out.println("Livro não encontrado na API.");
        }
    }

    public void exibirResumo(DadosLivro dadosLivro) {
        System.out.println("==================");
        System.out.println("Titulo:" + dadosLivro.titulo());
        System.out.println("Autor:" + dadosLivro.autores());
        System.out.println("Idioma:" + dadosLivro.idiomas());
        System.out.println("==================");
    }
}
