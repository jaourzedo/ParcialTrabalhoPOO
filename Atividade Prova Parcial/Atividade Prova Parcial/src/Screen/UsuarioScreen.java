package Screen;

import ServicesImplements.Livro;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class UsuarioScreen extends JFrame {
    public UsuarioScreen() {
        setTitle("Usuário Screen");
        setSize(400, 150);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

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

                Livro.pesquisarLivro("");
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