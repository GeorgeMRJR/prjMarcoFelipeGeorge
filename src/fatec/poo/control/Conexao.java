package fatec.poo.control;

import java.net.URL;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

public class Conexao {    
    public  Connection connection;
    private String caminho;     
    private String usuario;
    private String senha;
    private String driver;
    private String stringConexao;

    public Conexao(String usuario, String senha) {
        this.usuario = usuario;
        this.senha = senha;
    }

    public Connection conectar() {
        if (connection == null) {
            try {
                Class.forName(driver);
                
                connection = DriverManager.getConnection(stringConexao + caminho, usuario, senha);
                System.out.println("Conexão Ok");
                return (connection); 
            } catch (Exception ex) {
                System.out.println("Falha na Conexão"); 
                System.out.println(ex.toString());
            }
        }
        return connection;

    }

    public void fecharConexao() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException ex) {
                System.out.println(ex.toString());
            }
        }
    }

    public void setCaminho(String caminho) {
         this.caminho=caminho;        
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public void setStringConexao(String stringConexao) {
        this.stringConexao = stringConexao;
    }
    
}
