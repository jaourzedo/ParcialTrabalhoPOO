package ServicesImplements;

import Screen.UsuarioScreen;

import javax.swing.*;

public class Usuario {
    // Métodos para autenticar, pesquisar livro, pegar emprestado e devolver livro

    public void pesquisarLivro() {
        // Implemente a lógica de pesquisa de livro aqui
    }

    public void pegarEmprestado() {
        // Implemente a lógica para pegar emprestado um livro aqui
    }

    public void devolverLivro() {
        // Implemente a lógica para devolver um livro aqui
    }

    // Exemplo de uso
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            UsuarioScreen usuarioScreen = new UsuarioScreen();
            usuarioScreen.setVisible(true);
        });
    }
}
