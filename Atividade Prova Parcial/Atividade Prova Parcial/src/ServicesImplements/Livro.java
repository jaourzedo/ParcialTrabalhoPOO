package ServicesImplements;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Livro {
        private int idLivro;
        public String titulo;
        private String autor;
        private String categoria;
        private String ISBN;
        private boolean disponivel;
        private LocalDate prazo_emprestimo;

        private static final List <Livro> livros = new ArrayList<>();
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

        public boolean isDisponivel() {
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

    public static void pesquisarLivro(String titulo){
        boolean encontrado = false;
        for(Livro livro : Livro.livros){
            if(livro.getTitulo().equalsIgnoreCase(titulo)){
                System.out.println("Livro Encontrado: " + livro);
                encontrado = true;
                break;
            }
        }
        if (!encontrado){
            System.out.println("Não há livros com o título: " + titulo + ".");
        }
    }
}





