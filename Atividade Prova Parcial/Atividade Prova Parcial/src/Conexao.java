import java.time.LocalDate;
import java.util.List;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.ArrayList;
import java.sql.ResultSet;

public class Conexao {
    private static final String url = "jdbc:mysql://localhost:3306/javaprojetoparcial";
    private static final String user = "root";
    private static final String password = "1234";
    private static Connection conn;
    public static Connection getConexao() {
        try {
            if (conn == null || conn.isClosed()) {
                conn = DriverManager.getConnection(url, user, password);
                System.out.println("Conectado com sucesso ao Banco de Dados!");
            }
            return conn;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Não foi possível conectar com Banco de Dados!");
            return null;
        }
    }
}
