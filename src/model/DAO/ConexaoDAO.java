
package model.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ConexaoDAO {
    /*
    Variáveis publicas, que serão acessadas por outras classes
    */
    public Connection   conexao;
    /*
    Variáveis privadas, que serão acessadas dentro da classe
    */
    private final String driver     =   "org.postgresql.Driver";
    private final String url        =   "jdbc:postgresql://localhost:5432/clinicamedica";
    private final String usuario    =   "william";
    private final String senha      =   "will";
    
public void conectar(){
    System.setProperty("jdbc.Drivers", driver);
        try {
            conexao = DriverManager.getConnection(url, usuario, senha);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na Conexão do Banco de Dados:\n"+ex.getMessage());
        }
    }
public void desconectar(){
        try {
            conexao.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na Desconexão do Bando de Dados:\n"+ex.getMessage());
        }
}


}
