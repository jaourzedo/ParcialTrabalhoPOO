package Screen;

import ServicesImplements.Livro;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PesquisarLivroScreen extends JFrame {
    private final JLabel titleLabel;
    private final JTextField titleField;
    private final JButton searchButton;

    public PesquisarLivroScreen() {
        setTitle("Pesquisar Livro");
        setSize(300, 150); // Configura tamanho da janela
        setDefaultCloseOperation(DISPOSE_ON_CLOSE); // Fecha apenas esta janela
        setLocationRelativeTo(null); // Centraliza janela

        // Inicializa componentes
        titleLabel = new JLabel("Título do Livro");
        titleField = new JTextField(20);
        searchButton = new JButton("Pesquisar");

        // Adiciona ActionListener para o botão de pesquisa
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pesquisarLivro();
            }
        });

        // Configura layout da tela
        setLayout(new GridLayout(2, 2, 5, 5));

        // Adiciona componentes à tela
        add(titleLabel);
        add(titleField);
        add(new JLabel());
        add(searchButton);
    }

    // Método para realizar a pesquisa do livro
    private void pesquisarLivro() {
        // Obter o título do livro a ser pesquisado
        String titulo = titleField.getText();

        // Criar uma instância da classe Usuario para chamar o método pesquisarLivro
        Livro livro = new Livro();
        Livro.pesquisarLivro(titulo);
    }

    // Método principal para teste
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            PesquisarLivroScreen pesquisarLivroScreen = new PesquisarLivroScreen();
            pesquisarLivroScreen.setVisible(true);
        });
    }
}