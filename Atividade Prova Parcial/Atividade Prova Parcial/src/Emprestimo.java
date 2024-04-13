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
            //exibir mensagem de devolução registrada
            System.out.println("***** Devolução registrada *****");
        }
        public void registrarEmprestimo(int idLivro, int idUser, String data, String prazo, String status) {
            this.idLivro = idLivro;
            this.idUser = idUser;
            this.data = data;
            this.prazo = prazo;
            this.status = "Em andamento";
            System.out.println("***** Empréstimo registrado com sucesso. *****");
        }
    }

