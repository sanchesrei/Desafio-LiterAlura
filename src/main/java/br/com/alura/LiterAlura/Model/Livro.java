package br.com.alura.LiterAlura.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "livros")
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String titulo;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "autor_id")
    private Autor autor;
    private String idiomas;
    private Double numeroDownloads;

    public Livro(){}

    public Livro(DadosLivro dadosLivro) {
        this.titulo = dadosLivro.titulo();

        if (dadosLivro.autores() != null && !dadosLivro.autores().isEmpty()) {
              this.autor = new Autor(dadosLivro.autores().get(0));
        }else {
            this.autor  = null;
        }

        if ( dadosLivro.idiomas() != null && ! dadosLivro.idiomas().isEmpty()){
            this.idiomas = String.join(",", dadosLivro.idiomas());
        }

    }

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

    public String getIdiomas() {
        return idiomas;
    }

    public void setIdiomas(String idiomas) {
        this.idiomas = idiomas;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public Double getNumeroDownloads() {
        return numeroDownloads;
    }

    public void setNumeroDownloads(Double numeroDownloads) {
        this.numeroDownloads = numeroDownloads;
    }

    @Override
    public String toString() {
        return "titulo: '" + titulo + '\'' +
                "\nAutor: " +(autor != null ? autor.getNome() : "Desconhecido") +
                "\nIdioma: " + idiomas +
                "\nNúmero de Downloads:" + numeroDownloads + "\n";
    }

}
