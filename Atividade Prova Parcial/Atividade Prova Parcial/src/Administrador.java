import java.time.LocalDate;
import java.util.List;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.time.format.DateTimeFormatter;


public class Administrador extends Usuarios {
        private String email;
        private long telefone;

        public Administrador(String nome, String email, long telefone){
            super(nome, "", "", "", "", false);
            this.email = email;
            this.telefone = telefone;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public void setTelefone(long telefone) {
            this.telefone = telefone;
        }

        public String getEmail() {
            return email;
        }

        public long getTelefone() {
            return telefone;
        }

        public void AtribuirPrivilegios(Usuarios usuario, boolean isAdmin){
            usuario.setAdmin(isAdmin);
            System.out.println("Privilégios atribuidos com sucesso!\n");
        }

        public void AddLivro(Livro livro) {
            try {
                Scanner scanner = new Scanner(System.in);

                System.out.println("***** Adicionar Novo Livro *****\n\n");
                System.out.println("Digite o título do livro: ");
                String titulo = scanner.nextLine();
                System.out.println("Digite o autor do livro: ");
                String autor = scanner.nextLine();
                System.out.println("Digite a categoria do livro: ");
                String categoria = scanner.nextLine();
                System.out.println("Digite o ISBN do livro: ");
                String isbn = scanner.nextLine();
                System.out.println("O livro está disponível? (true/false):");
                boolean disponivel = scanner.nextBoolean();
                scanner.nextLine(); // Limpar o buffer
                System.out.println("Digite o prazo de empréstimo do livro (DD-MM-AAAA):");
                String prazo = scanner.nextLine();

                String sql = "INSERT INTO LIVRO (TITULO, AUTOR, CATEGORIA, ISBN, DISPONIVEL, PRAZO_EMPRESTIMO) VALUES(?, ?, ?, ?, ?, ?)";

                try (Connection connection = Conexao.getConexao();
                     PreparedStatement ps = connection.prepareStatement(sql)) {
                    ps.setString(1, titulo); // Use os valores obtidos do usuário, não do objeto Livro
                    ps.setString(2, autor);
                    ps.setString(3, categoria);
                    ps.setString(4, isbn);
                    ps.setBoolean(5, disponivel);
                    LocalDate dataPrazo = LocalDate.parse(prazo, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
                    ps.setDate(6, java.sql.Date.valueOf(dataPrazo));
                    ps.executeUpdate();
                    System.out.println("Livro adicionado com sucesso!\n");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    public void EditLivro(int idLivro, Livro livro) {

        if (livro != null) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("***** Editar Livro *****");
            System.out.println("1. Título");
            System.out.println("2. Autor");
            System.out.println("3. Categoria");
            System.out.println("4. ISBN");
            System.out.println("5. Disponível");
            System.out.println("6. Prazo de empréstimo");
            System.out.println("Escolha o que deseja editar:");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("Digite o novo título:");
                    livro.setTitulo(scanner.nextLine());
                    break;
                case 2:
                    System.out.println("Digite o novo autor:");
                    livro.setAutor(scanner.nextLine());
                    break;
                case 3:
                    System.out.println("Digite a nova categoria:");
                    livro.setCategoria(scanner.nextLine());
                    break;
                case 4:
                    System.out.println("Digite o novo ISBN:");
                    livro.setISBN(scanner.nextLine());
                    break;
                case 5:
                    System.out.println("O livro está disponível? (true/false):");
                    livro.setDisponivel(scanner.nextBoolean());
                    scanner.nextLine();
                    break;
                case 6:
                    System.out.println("Digite o novo prazo de empréstimo (AAAA-MM-DD):");
                    livro.setPrazo_emprestimo(LocalDate.parse(scanner.nextLine()));
                    break;
                default:
                    System.out.println("Opção inválida!");
            }

                atualizarLivro(livro, idLivro);
            } else {
                System.out.println("Livro não encontrado!");
            }
        }

    private Livro buscarLivroPorId(int idLivro) {
        Livro livro = null;
        String sql = "SELECT * FROM LIVRO WHERE IDLIVRO = ?";
        try (Connection connection = Conexao.getConexao();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, idLivro);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    livro = new Livro();
                    livro.setIdLivro(rs.getInt("IDLIVRO"));
                    livro.setTitulo(rs.getString("TITULO"));
                    livro.setAutor(rs.getString("AUTOR"));
                    livro.setCategoria(rs.getString("CATEGORIA"));
                    livro.setISBN(rs.getString("ISBN"));
                    livro.setDisponivel(rs.getBoolean("DISPONIVEL"));
                    livro.setPrazo_emprestimo(rs.getDate("PRAZO_EMPRESTIMO").toLocalDate());
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return livro;
    }
    private void atualizarLivro(Livro livro, int idLivro) {
            String sql = "UPDATE LIVRO SET TITULO = ?, AUTOR = ?, CATEGORIA = ?, ISBN = ?, DISPONIVEL = ?, PRAZO_EMPRESTIMO = ? WHERE IDLIVRO = ?";
            try (Connection connection = Conexao.getConexao();
                 PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setString(1, livro.getTitulo());
                ps.setString(2, livro.getAutor());
                ps.setString(3, livro.getCategoria());
                ps.setString(4, livro.getISBN());
                ps.setBoolean(5, livro.isDisponivel());
                ps.setDate(6, java.sql.Date.valueOf(livro.getPrazo_emprestimo()));
                ps.setInt(7, idLivro);
                ps.executeUpdate();
                System.out.println("Livro editado com sucesso!\n");
                } catch (SQLException e) {
            e.printStackTrace();
            }
        }

        public void DeleteLivro(int idLivro) {
            try {
                String sql = "DELETE FROM LIVRO WHERE IDLIVRO = ?";
                try (PreparedStatement ps = Conexao.getConexao().prepareStatement(sql)) {
                    ps.setInt(1, idLivro);
                    ps.executeUpdate();
                }
                System.out.println("Livro excluído com sucesso!\n");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


    public void AddUser(Usuarios usuario) {
        try (Connection connection = Conexao.getConexao()) {
            String sql = "INSERT INTO USUARIOS (NOME, SOBRENOME, ENDERECO, USERNAME, SENHA, IS_ADMIN) VALUES (?, ?, ?, ?, ?, ?)";
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setString(1, usuario.getNome());
                ps.setString(2, usuario.getSobrenome());
                ps.setString(3, usuario.getEndereco());
                ps.setString(4, usuario.getUsername());
                ps.setString(5, usuario.getSenha());
                ps.setBoolean(6, usuario.isAdmin());
                ps.executeUpdate();
                System.out.println("Usuário adicionado com sucesso!\n");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

        public void EditUser(int idUsuario, Usuarios usuario) {
            try {
                String sql = "UPDATE USUARIOS SET NOME = ?, SOBRENOME = ?, ENDERECO = ?, USERNAME = ?, SENHA = ?, ISADMIN = ? WHERE ID_USUARIO = ?";
                try (Connection connection = Conexao.getConexao();
                     PreparedStatement ps = connection.prepareStatement(sql)) {

                    ps.setString(1, usuario.getNome());
                    ps.setString(2, usuario.getSobrenome());
                    ps.setString(3, usuario.getEndereco());
                    ps.setString(4, usuario.getUsername());
                    ps.setString(5, usuario.getSenha());
                    ps.setBoolean(6, usuario.isAdmin());
                    ps.setInt(7, idUsuario);
                    ps.executeUpdate();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            System.out.println("Usuário editado com sucesso!\n");
        }
        public void DeleteUser(int idUsuario) {
            try {
                String sql = "DELETE FROM USUARIOS WHERE ID_USUARIO = ?";
                try (Connection connection = Conexao.getConexao();
                     PreparedStatement ps = connection.prepareStatement(sql)) {
                    ps.setInt(1, idUsuario);
                    ps.executeUpdate();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            System.out.println("Usuário excluído com sucesso!\n");
        }
    }


