
package model.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Usuario;

public class LoginDAO {
    
    private final Usuario usuario;
    private ConexaoDAO conexaoDAO;

    public LoginDAO(Usuario usuario) {
        this.usuario = usuario;
    }

    public void consultaNomeSenha() {
        conexaoDAO = new ConexaoDAO();
        conexaoDAO.conectar();
        String sql = "select * from usuarios where nome_usuario = '"+usuario.getNomeUsuario()+"';";
        //executa comando SQL
        try {
            PreparedStatement preparedStatement = conexaoDAO.conexao.prepareStatement(sql);
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getResultSet();
            resultSet.next();
            int codigo = resultSet.getInt("cod_usuario");
            String nome = resultSet.getString("nome_usuario");
            String senha = resultSet.getString("senha_usuario");
            String tipo = resultSet.getString("tipo_usuario");
            if (usuario.getNomeUsuario().equals(nome) && usuario.getSenhaUsuario().equals(senha)){
                usuario.setTipoUsuario(tipo);
                usuario.setCodUsuario(codigo);
            }
        }
         catch (SQLException ex) {
            
            }
        
        
        conexaoDAO.desconectar();
    }
}
