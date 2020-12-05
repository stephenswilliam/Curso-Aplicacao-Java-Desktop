
package model.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Bairro;

public class BairroDAO {
    
    private Bairro bairro;
    private ConexaoDAO conexaoDAO;
    
    public ArrayList<Bairro> obtemBairros() {
        conexaoDAO = new ConexaoDAO();
        conexaoDAO.conectar();
        ArrayList<Bairro> bairros = new ArrayList<>();
        // Executa comando SQL
        String sql = "Select * from bairros order by nome_bairro;";
        try {
            PreparedStatement preparedStatement = conexaoDAO.conexao.prepareStatement(sql);
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getResultSet();
            while (resultSet.next()) {
                int codigo =            resultSet.getInt("cod_bairro");
                String nome =           resultSet.getString("nome_bairro");
                Bairro bairroPesquisado = new Bairro(codigo, nome);
                bairros.add(bairroPesquisado);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao Pesquisar Bairro.\nErro: "+ex.getMessage());
        }
       conexaoDAO.desconectar();
       return bairros;
    }
    
    
    
}
