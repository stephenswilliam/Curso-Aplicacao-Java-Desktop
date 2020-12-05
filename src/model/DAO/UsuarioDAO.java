
package model.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Usuario;

public class UsuarioDAO {

   
    
    private Usuario usuario;
    private ConexaoDAO conexaoDAO;

    public void insertUsuario(Usuario usuario) {
        conexaoDAO = new ConexaoDAO();
        conexaoDAO.conectar();
        // Formata comando SQL
        String comando =    "Insert into usuarios ";
        String campos =     "(nome_usuario, senha_usuario, tipo_usuario)";
        String valores =    "values (?,?,?);";
        String sql = comando+campos+valores;
        // Executa comando SQL
        try {
            PreparedStatement preparedStatement = conexaoDAO.conexao.prepareStatement(sql);
            preparedStatement.setString(1, usuario.getNomeUsuario());
            preparedStatement.setString(2, usuario.getSenhaUsuario());
            preparedStatement.setString(3, usuario.getTipoUsuario());
            preparedStatement.execute();
            JOptionPane.showMessageDialog(null,"Usuario Inserido com Sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao Inserir Usuario..\nErro: "+ex.getMessage());
        }
        conexaoDAO.desconectar();
    }
    public ArrayList<Usuario> pesquisaUsuario(Usuario usuario){
        conexaoDAO = new ConexaoDAO();
        conexaoDAO.conectar();
        ArrayList<Usuario> usuarios = new ArrayList<>();
        // Executa comando SQL
        String sql = "Select * from usuarios where nome_usuario like '%"+usuario.getNomeUsuario()+"%' order by nome_usuario;";
        try {
            PreparedStatement preparedStatement = conexaoDAO.conexao.prepareStatement(sql);
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getResultSet();
            while (resultSet.next()) {
                int codigo =            resultSet.getInt("cod_usuario");
                String nome =           resultSet.getString("nome_usuario");
                String senha =          resultSet.getString("senha_usuario");
                String tipo =           resultSet.getString("tipo_usuario");
                Usuario usuarioPesquisado = new Usuario(codigo, nome, senha, tipo);
                usuarios.add(usuarioPesquisado);
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao Pesquisar Usuario.\nErro: "+ex.getMessage());
        }
     conexaoDAO.desconectar();
     return usuarios;
     
    }

    public void alterarUsuario(Usuario usuario) {
        conexaoDAO = new ConexaoDAO();
        conexaoDAO.conectar();
        // Formata comando SQL
        
        String sql = "UPDATE usuarios SET nome_usuario=?, senha_usuario=?, tipo_usuario=? WHERE cod_usuario=?;";
        // Executa comando SQL
        try {
            PreparedStatement preparedStatement = conexaoDAO.conexao.prepareStatement(sql);
            preparedStatement.setString(1, usuario.getNomeUsuario());
            preparedStatement.setString(2, usuario.getSenhaUsuario());
            preparedStatement.setString(3, usuario.getTipoUsuario());
            preparedStatement.setInt(4, usuario.getCodUsuario());
            preparedStatement.execute();
            JOptionPane.showMessageDialog(null,"Usuario Alterado com Sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao Alterar Usuario..\nErro: "+ex.getMessage());
        }
        conexaoDAO.desconectar();
    }
     public void excluirUsuario(Usuario usuario) {
        conexaoDAO = new ConexaoDAO();
        conexaoDAO.conectar();
        // Formata comando SQL
        String sql = "Delete from usuarios where cod_usuario = ?;";
        // Executa comando SQL
        try {
            PreparedStatement preparedStatement = conexaoDAO.conexao.prepareStatement(sql);
            preparedStatement.setInt(1, usuario.getCodUsuario());
            preparedStatement.execute();
            JOptionPane.showMessageDialog(null,"Usuario Excluido com Sucesso!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Erro ao Excluir Usuario..\nErro: "+e.getMessage());
        }
        conexaoDAO.desconectar();
        
    }
}
