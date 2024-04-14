package Screen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginScreen extends JFrame implements ActionListener {
    private final JLabel usernameLabel;
    private final JLabel passwordLabel;
    private final JTextField usernameField;
    private final JPasswordField passwordField;

    private final String userAdm = "admin";
    private final String admPassword = "admin123";
    private final String userNormal = "user";
    private final String userPassword = "user123";

    public LoginScreen() {
        setTitle("Login Screen");
        setSize(300, 150); // Configura tamanho da janela
        setDefaultCloseOperation(EXIT_ON_CLOSE); // Configura ação ao fechar janela
        setLocationRelativeTo(null); // Centraliza janela

        // Inicializa componentes
        usernameLabel = new JLabel("Usuário:");
        passwordLabel = new JLabel("Senha:");
        usernameField = new JTextField(20);
        passwordField = new JPasswordField(20);
        JButton loginButton = new JButton("Login");

        loginButton.addActionListener(this);

        // Set layout
        setLayout(new GridLayout(3, 2));

        // Adiciona componentes ao frame
        add(usernameLabel);
        add(usernameField);
        add(passwordLabel);
        add(passwordField);
        add(new JLabel());
        add(loginButton);
    }

    @Override
    public void actionPerformed(ActionEvent a) {
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());

        if (username.equals(userAdm) && password.equals(admPassword)){
            // Abrir Administrador Screen
        } else if (username.equals(userNormal) && password.equals(userPassword)){
            // Abrir Usuario Screen
        } else {
            JOptionPane.showMessageDialog(this, "Usuário não encontrado");
            SetNullFields();
        }
    }

    private void SetNullFields(){
        usernameField.setText("");
        passwordField.setText("");
    }
}
