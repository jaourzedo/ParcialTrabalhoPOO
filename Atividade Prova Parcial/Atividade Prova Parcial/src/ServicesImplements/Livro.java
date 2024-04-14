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
        private String valor;
        private String criterio;

        private static final List <Livro> livros = new ArrayList<>();
    public Livro(String titulo, String autor, String categoria, String ISBN) {
        this.titulo = titulo;
        this.autor = autor;
        this.categoria = categoria;
        this.ISBN = ISBN;
        this.disponivel = true;
        this.prazo_emprestimo = LocalDate.now();
        this.valor = "";
        this.criterio = "";
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

        public String getValor(){
            return valor;
        }

        public void setValor(String valor){
            this.valor = valor;
        }

        public String getCriterio() {
            return criterio;
        }

        public void setCriterio(String criterio) {
            this.criterio = criterio;
        }

        public void setPrazo_emprestimo(LocalDate prazo_emprestimo) {
            this.prazo_emprestimo = prazo_emprestimo;
        }

    public static void pesquisarLivro(String criterio, String valor){
        boolean encontrado = false;
        String valorLowerCase = valor.toLowerCase();
        for(Livro livro : Livro.livros){
        switch (criterio.toLowerCase()) {
            case "titulo":
                if (livro.getTitulo().toLowerCase().contains(valorLowerCase)) {
                    System.out.println("Livro encontrado: " + livro.getTitulo());
                    encontrado = true;
                }
                break;
            case "autor":
                if (livro.getAutor().toLowerCase().contains(valorLowerCase)) {
                    System.out.println("Livro encontrado: " + livro.getTitulo() + " por " + livro.getAutor());
                    encontrado = true;
                }
                break;
            case "categoria":
                if (livro.getCategoria().toLowerCase().contains(valorLowerCase)) {
                    System.out.println("Livro encontrado na categoria: " + livro.getCategoria());
                    encontrado = true;
                }
                break;
            case "isbn":
                if (livro.getISBN().toLowerCase().contains(valorLowerCase)) {
                    System.out.println("Livro encontrado com ISBN: " + livro.getISBN());
                    encontrado = true;
                }
                break;
            }
        }
        if (!encontrado){
            System.out.println("Não há livros com o critério de pesquisa: " + criterio + "e valor: " + valor + ".");
        }
    }
}





