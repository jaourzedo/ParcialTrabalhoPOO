import java.time.LocalDate;

public class Livro {
    private int idLivro;
    private String titulo;
    private String autor;
    private String categoria;
    private String ISBN;
    private boolean disponivel;
    private LocalDate prazo_emprestimo;

    public Livro() {
        this.idLivro = 1;
        this.titulo = "";
        this.autor = "";
        this.categoria = "";
        this.ISBN = "";
        this.disponivel = true;
        this.prazo_emprestimo = LocalDate.now();
    }

    public int getIdLivro() {
        return idLivro;
    }

    public void setIdLivro(int idLivro) {
        this.idLivro = idLivro;
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

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public boolean isDisponivel(){
        return disponivel;
    }
    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public LocalDate getPrazo_emprestimo() {
        return prazo_emprestimo;
    }

    public void setPrazo_emprestimo(LocalDate prazo_emprestimo) {
        this.prazo_emprestimo = prazo_emprestimo;
    }

    public String obterDetalhes(){
        return "**********Detalhes do seu livro**********" +
                "\n\n idLivro = " + idLivro +
                ", \n Título = " + titulo +
                ", \n autor = " + autor +
                ", \n categoria = " + categoria +
                ", \n ISBN = " + ISBN +
                ", \n Está Disponível = " +(disponivel ? "Sim": "Não") +
                ", \n Prazo Empréstimo = " +prazo_emprestimo +
                "\n\n";

    }
}
