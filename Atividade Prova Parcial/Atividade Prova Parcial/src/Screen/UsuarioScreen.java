package Screen;

import ServicesImplements.Livro;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class UsuarioScreen extends JFrame {
    private final Livro[] livros = new Livro[5];
    public UsuarioScreen() {
        setTitle("Usuário Screen");
        setSize(400, 150);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        livros[0] = new Livro("O pequeno Príncipe", "Antoine de Saint-Exupéry", "Infantil", "9788582862328");
        livros[1] = new Livro("Romeu e Julieta", "William Shakespeare", "Drama", "9788538068104");
        livros[2] = new Livro("Moby Dick", "Herman Melville", "Aventura", "9788537808324");
        livros[3] = new Livro("Pinóquio", "Carlo Collodi", "Infantil", "9788594890011");
        livros[4] = new Livro("Alice no País das Maravilhas", "Lewis Carroll", "Fantasia", "9788533614001");

        JButton pesquisarLivroButton = new JButton("Pesquisar Livro");
        JButton pegarEmprestadoButton = new JButton("Pegar Emprestado");
        JButton devolverLivroButton = new JButton("Devolver Livro");

        setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));

        add(pesquisarLivroButton);
        add(pegarEmprestadoButton);
        add(devolverLivroButton);

        pesquisarLivroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PesquisarLivroScreen pesquisarLivroScreen = new PesquisarLivroScreen();
                pesquisarLivroScreen.setVisible(true);
                dispose();

                Livro.pesquisarLivro("", "");
                System.out.println("botão PesquisarLivro Clicado");
            }
        });

        pegarEmprestadoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //pegarEmprestado();
                System.out.println("botão PegarEmprestado Clicado");
            }
        });

        devolverLivroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //devolverLivro();
                System.out.println("botão DevolverLivro Clicado");
            }
        });
    }
}