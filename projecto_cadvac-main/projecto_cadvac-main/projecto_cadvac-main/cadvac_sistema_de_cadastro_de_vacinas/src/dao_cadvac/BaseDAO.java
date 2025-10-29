package dao_cadvac;

import java.sql.*;

public abstract class BaseDAO {
    private String url = "jdbc:mysql://127.0.0.1:3306/cadvac";
    private String user = "root";
    private String pass = "santosucmdb";
    //Criando o constructor para inicializar a conexão com o JDBC
    public BaseDAO(){

        try (Connection connect = DriverManager.getConnection(url, user, pass)) {
            System.out.println("Conexão feita com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao estabelecer a conexão com a base de dados!");
        }
    }
}
