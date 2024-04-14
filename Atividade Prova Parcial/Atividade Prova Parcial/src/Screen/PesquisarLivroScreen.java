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
        setSize(300, 150);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        titleLabel = new JLabel("Título do Livro");
        titleField = new JTextField(20);
        searchButton = new JButton("Pesquisar");

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pesquisarLivro();
            }
        });

        setLayout(new GridLayout(2, 2, 5, 5));

        add(titleLabel);
        add(titleField);
        add(new JLabel());
        add(searchButton);
    }

    private void pesquisarLivro() {
        String titulo = titleField.getText();
        Livro.pesquisarLivro("", "");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            PesquisarLivroScreen pesquisarLivroScreen = new PesquisarLivroScreen();
            pesquisarLivroScreen.setVisible(true);

        });
    }
}