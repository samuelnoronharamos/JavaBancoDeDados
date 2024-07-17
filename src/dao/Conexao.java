package dao;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;




public class Conexao {

        public Connection getConnection() throws SQLException{
            Connection conexao = DriverManager.getConnection("jdbc:postgresql://localhost:5432/cursojava", "postgres","1234");
            return conexao;

}
}