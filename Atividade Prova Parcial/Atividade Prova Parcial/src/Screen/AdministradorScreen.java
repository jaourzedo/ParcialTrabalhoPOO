package Screen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdministradorScreen extends JFrame {

    public AdministradorScreen() {
        super("Tela do Administrador");
        setSize(400, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JButton btnGestaoLivros = new JButton("Gestão de Livros");
        JButton btnCadastrarUsuario = new JButton("Cadastrar Usuário");

        setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));

        add(btnGestaoLivros);
        add(btnCadastrarUsuario);

        btnGestaoLivros.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Adicione aqui o código para abrir a tela de gestão de livros
                GestaoLivrosScreen gestaoLivrosScreen = new GestaoLivrosScreen();
                gestaoLivrosScreen.setVisible(true);
            }
        });

        btnCadastrarUsuario.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Adicione aqui o código para abrir a tela de cadastro de usuário
            }
        });

        setVisible(true);
    }
}
