package trabalhofinal;
/**
 * @author nayfr
 */
public class Exemplar {
    private int isbn;
    private String titulo;
    private String editora;
    private String autor;
    private String idioma;

    public Exemplar() {
    }
    
    public Exemplar(int isbn, String titulo, String editora, String autor, String idioma) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.editora = editora;
        this.autor = autor;
        this.idioma = idioma;
    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }
    
    
}
