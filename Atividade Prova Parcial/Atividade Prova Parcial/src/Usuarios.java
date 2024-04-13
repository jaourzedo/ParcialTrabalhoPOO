import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Usuarios {
    private String nome;
    private String sobrenome;
    private String endereco;
    private String username;
    private String senha;
    private int UserID;
    private boolean isAdmin;

    private static List<Usuarios> listaUsuarios = new ArrayList<>();

    public Usuarios(String nome, String sobrenome, String endereco, String username, String senha, boolean isAdmin) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.endereco = endereco;
        this.username = username;
        this.senha = senha;
        this.isAdmin = isAdmin;
    }

    public boolean autenticar(String nome, String sobrenome) {
        return this.equals(username) && this.senha.equals(senha);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }
    public int getUserID() {
        return UserID;
    }

    public void setUserID(int userID) {
        this.UserID = userID;
    }

    public List<Livro> pesquisarLivro() {
        List<Livro> livrosEncontrados = new ArrayList<>();

        try (Connection connection = Conexao.getConexao()) {
            String sql = "SELECT * FROM LIVRO";
            PreparedStatement statement = connection.prepareStatement(sql);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {

                Livro livro = new Livro();
                livro.setIdLivro(resultSet.getInt("IDLIVRO"));
                livro.setTitulo(resultSet.getString("TITULO"));
                livro.setAutor(resultSet.getString("AUTOR"));
                livro.setCategoria(resultSet.getString("CATEGORIA"));
                livro.setISBN(resultSet.getString("ISBN"));
                livro.setDisponivel(resultSet.getBoolean("DISPONIVEL"));
                livro.setPrazo_emprestimo(resultSet.getDate("PRAZO_EMPRESTIMO").toLocalDate());

                livrosEncontrados.add(livro);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return livrosEncontrados;
    }

    public void pegarEmprestado(Livro livro) {
        if (livro.isDisponivel()) {
            livro.setDisponivel(false); //definido como false pois se uma pessoa pega o livro ele não fica mais disponível
            System.out.println("O livro " + livro.getTitulo() + "foi emprestado com sucesso para" + this.nome + "" + this.sobrenome + "\n");
        } else {
            System.out.println("Este livro não está disponível para empréstimo no momento.\n");
        }
    }

    private Livro livro;

    public void devolverLivro() {
        if (!livro.isDisponivel()) {
            livro.setDisponivel(true);
            System.out.println("Livro \"" + livro.getTitulo() + "\" foi devolvido com sucesso por " + this.nome + " " + this.sobrenome + ".\n");
        } else {
            System.out.println("Este livro já está disponível.\n");
        }
    }
    public static Usuarios recuperarUsuarioPorID(int id) {
        for (Usuarios usuario : listaUsuarios) {
            if (usuario.getUserID() == id) {
                return usuario;
            }
        }
        return null;
    }

    public static List<Usuarios> recuperarUsuariosDoBancoDeDados() {
        List<Usuarios> usuarios = new ArrayList<>();

        try (Connection connection = Conexao.getConexao()) {
            String sql = "SELECT * FROM USUARIOS";
            PreparedStatement statement = connection.prepareStatement(sql);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Usuarios usuario = new Usuarios(
                        resultSet.getString("NOME"),
                        resultSet.getString("SOBRENOME"),
                        resultSet.getString("ENDERECO"),
                        resultSet.getString("USERNAME"),
                        resultSet.getString("SENHA"),
                        resultSet.getBoolean("IS_ADMIN")
                );
                usuario.setUserID(resultSet.getInt("ID_USUARIO")); // Define o ID do usuário
                usuarios.add(usuario);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return usuarios;
    }

    public void devolverLivro(Livro livro) {
        if (!livro.isDisponivel()) {
            livro.setDisponivel(true);
            System.out.println("Livro \"" + livro.getTitulo() + "\" foi devolvido com sucesso por " + this.nome + " " + this.sobrenome + ".\n");
        } else {
            System.out.println("Este livro já está disponível.\n");
        }
    }
}
