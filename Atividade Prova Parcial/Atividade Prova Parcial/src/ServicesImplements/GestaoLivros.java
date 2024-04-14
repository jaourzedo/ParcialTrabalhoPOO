package ServicesImplements;

import java.time.LocalDate;

public class GestaoLivros {

    // Método para adicionar um novo livro
    public static void adicionarLivro(Livro livro) {
//        livro.adicionarLivro();
    }

    // Método para editar informações de um livro existente
    public static void editarLivro(Livro livro, int id, String titulo, String autor, String categoria, String ISBN, boolean disponivel, LocalDate prazo_emprestimo) {
        livro.setIdLivro(id);
        livro.setTitulo(titulo);
        livro.setAutor(autor);
        livro.setCategoria(categoria);
        livro.setISBN(ISBN);
        livro.setDisponivel(disponivel);
        livro.setPrazo_emprestimo(prazo_emprestimo);
    }

    // Método para excluir um livro
    public static void excluirLivro(Livro livro) {
//        livro.excluirLivro();
    }

    // Método para atualizar o status de disponibilidade de um livro
    public static void atualizarStatusDisponibilidade(Livro livro, boolean disponivel) {
        livro.setDisponivel(disponivel);
    }

    // Método para definir o prazo de empréstimo de um livro
    public static void definirPrazoEmprestimo(Livro livro, LocalDate prazo) {
        livro.setPrazo_emprestimo(prazo);
    }
}
