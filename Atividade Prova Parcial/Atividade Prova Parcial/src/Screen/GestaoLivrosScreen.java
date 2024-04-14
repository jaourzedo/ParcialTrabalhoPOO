package Screen;

import javax.swing.*;
import java.awt.*;

public class GestaoLivrosScreen extends JFrame {

    public GestaoLivrosScreen() {
        super("Gestão de Livros");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        getContentPane().add(panel);
        panel.setLayout(new BorderLayout());

        // Lista de Livros
        JTextArea listaLivros = new JTextArea();
        listaLivros.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(listaLivros);
        panel.add(scrollPane, BorderLayout.CENTER);

        // Botões
        JPanel botoesPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton btnAdicionar = new JButton("Adicionar");
        JButton btnEditar = new JButton("Editar");
        JButton btnExcluir = new JButton("Excluir");
        botoesPanel.add(btnAdicionar);
        botoesPanel.add(btnEditar);
        botoesPanel.add(btnExcluir);
        panel.add(botoesPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

}
