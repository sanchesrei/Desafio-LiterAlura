package br.com.alura.LiterAlura.Principal;

import br.com.alura.LiterAlura.Model.Autor;
import br.com.alura.LiterAlura.Model.Livro;
import br.com.alura.LiterAlura.Repository.AutorRepository;
import br.com.alura.LiterAlura.Repository.LivroRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {

    private Scanner leitura = new Scanner(System.in);
    private LivroRepository repositorioLivro;
    private AutorRepository repositorioAutor;
    private BuscaLivroApi buscaLivroApi;
    private List<Livro> livros = new ArrayList<>();
    List<Autor> autores = new ArrayList<>();

    public Principal(LivroRepository repositorioLivro, AutorRepository repositorioAutor) {
        this.repositorioLivro = repositorioLivro;
        this.repositorioAutor = repositorioAutor;
        this.buscaLivroApi = new BuscaLivroApi(leitura, repositorioLivro);
    }

    public void exibeMenu() {

        int opcao = -1;

        while (opcao != 0) {
            var menu = """
                    -------------------
                    Escolha uma opção:
                    1 - Buscar livro pelo título
                    2 - Listar Livros registrados
                    3 - Listar autores registrados
                    4 - Listar autores vivos em um determinado ano
                    5 - Listar Livros em determinado idioma
                    0 - Sair
                    -------------------
                    Digite uma opção:
                    """;

            System.out.println(menu);

            try {
                var entrada = leitura.nextLine();
                opcao = Integer.parseInt(entrada);

                switch (opcao) {
                    case 1:
                        buscaLivroApi.buscarLivro();
                        break;
                    case 2:
                        listarLivrosDoBanco();
                        break;
                    case 3:
                        listarAutorResgistrado();
                        break;
                    case 4:
                        listarAutoresVivosNoAno();
                        break;
                    case 5:
                        listarLivrosPorIdioma();
                        break;
                    case 0:
                        System.out.println("Saindo...");
                        break;
                    default:
                        System.out.println("Opção inválida");
                        break;
                }

                if (opcao != 0) aguardarEnter();

            } catch (NumberFormatException e) {
                System.out.println("Erro: Por favor, digite a penas números inteiros!");
                aguardarEnter();
            }
        }
    }

    private void aguardarEnter() {
        System.out.println("\n ----Pressione ENTER para continuar ----");
        leitura.nextLine();
    }


    private void listarLivrosDoBanco() {
        System.out.println("==== Livros Registrados  no Banco ===");
        livros = repositorioLivro.findAll();

        if (livros.isEmpty()) {
            System.out.println("Nenhum livro encontrado no banco de dados");
        } else {
            livros.stream()
                    .forEach(System.out::println);
        }
    }

    private void listarAutorResgistrado() {
        System.out.println("==== Autor Registrado  no Banco ===");
        autores = repositorioAutor.listarAutorResgistrado();

        if (autores.isEmpty()) {
            System.out.println("Nenhum autor encontrado Registrado  no Banco");
        } else {
            autores.stream()
                    .map(autor -> autor.getNome())
                    .forEach(System.out::println);
        }

    }

    private void listarAutoresVivosNoAno() {
        System.out.println("Digite o ano que deseja pesquisa");
        try {
            var ano = Integer.parseInt(leitura.nextLine());
            autores = repositorioAutor.listarAutoresVivosNoAno(ano);

            if (autores.isEmpty()) {
                System.out.println("Nenhum autor vivo encontrado no ano de " + ano);
            } else {
                autores.stream().forEach(System.out::println);
            }
        } catch (NumberFormatException e) {
            System.out.println("Ano invalido!");
        }

    }

    private void listarLivrosPorIdioma() {
        System.out.println("""
                Insira o idioma:
                pt - Português
                en - Inglês
                es - Espanhol
                fr - Francês
                """);
        var idioma = leitura.nextLine().toLowerCase().trim();

        List<Livro> livrosPorIdioma = repositorioLivro.findByIdiomasContainingIgnoreCase(idioma);
        if(livrosPorIdioma.isEmpty()){
            System.out.println("Não encontrado  livro registrado nesse idioma");
        } else {
            System.out.println("\n === Livro encontrado em [" + idioma + "]");
            livrosPorIdioma.stream().forEach(System.out::println);
        }

    }

}


