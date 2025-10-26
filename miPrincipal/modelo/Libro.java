package miPrincipal.modelo;

public class Libro {
    private String titulo;
    private String autor;
    private String codigo;

    public Libro(String titulo, String autor, String codigo) {
        this.titulo = titulo;
        this.autor = autor;
        this.codigo = codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getIsbn() {
        return codigo;
    }

    public void setIsbn(String isbn) {
        this.codigo = isbn;
    }

    @Override
    public String toString() {
        return "Libro: " + titulo + " - Autor: " + autor + " - codigo: " + codigo;
    }
    
}