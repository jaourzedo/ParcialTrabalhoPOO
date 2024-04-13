import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Emprestimo {
        private int idEmprestimo;
        private int idLivro;
        private int idUser;
        private String data;
        private String prazo;
        private String status;

        public void registrarDevolucao(int idEmprestimo, int idLivro, int idUser, String data, String prazo, String status){
            this.idEmprestimo = idEmprestimo;
            this.status = status;
            try (Connection connection = Conexao.getConexao()) {
                String sql = "UPDATE emprestimo SET status = ? WHERE id_emprestimo = ?";
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setString(1, status);
                statement.setInt(2, idEmprestimo);
                statement.executeUpdate();
                System.out.println("***** Devolução registrada com sucesso. *****");
            } catch (SQLException e) {
                System.out.println("***** Erro ao registrar a devolução! ***** " + e.getMessage());
            }
        }
        public void registrarEmprestimo(int idLivro, int idUser, String data, String prazo, String status) {
            this.idLivro = idLivro;
            this.idUser = idUser;
            this.data = data;
            this.prazo = prazo;
            this.status = "Em andamento";

            try (Connection connection = Conexao.getConexao()) {
                String sql = "INSERT INTO emprestimo (id_livro, id_usuario, data_emprestimo, prazo_devolucao, status) VALUES (?, ?, ?, ?, ?)";
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setInt(1, idLivro);
                statement.setInt(2, idUser);
                statement.setString(3, data);
                statement.setString(4, prazo);
                statement.setString(5, status);
                statement.executeUpdate();
                System.out.println("***** Empréstimo registrado com sucesso. *****");
            } catch (SQLException e) {
                System.out.println("***** Erro ao registrar o empréstimo! *****" + e.getMessage());
            }
        }
    }

