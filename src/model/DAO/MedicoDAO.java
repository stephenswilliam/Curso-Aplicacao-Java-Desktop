
package model.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Medico;

public class MedicoDAO {

   
    
    private Medico medico;
    private ConexaoDAO conexaoDAO;

    public void insertMedico(Medico medico) {
        conexaoDAO = new ConexaoDAO();
        conexaoDAO.conectar();
        // Formata comando SQL
        String comando =    "Insert into medicos ";
        String campos =     "(nome_medico, especialidade_medico, crm_medico)";
        String valores =    "values (?,?,?);";
        String sql = comando+campos+valores;
        // Executa comando SQL
        try {
            PreparedStatement preparedStatement = conexaoDAO.conexao.prepareStatement(sql);
            preparedStatement.setString(1, medico.getNomeMedico());
            preparedStatement.setString(2, medico.getEspecialidadeMedico());
            preparedStatement.setInt(3, medico.getCrmMedico());
            preparedStatement.execute();
            JOptionPane.showMessageDialog(null,"Medico Inserido com Sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao Inserir Medico..\nErro: "+ex.getMessage());
        }
        conexaoDAO.desconectar();
    }
    public ArrayList<Medico> pesquisaMedico(Medico medico){
        conexaoDAO = new ConexaoDAO();
        conexaoDAO.conectar();
        ArrayList<Medico> medicos = new ArrayList<>();
        // Executa comando SQL
        String sql = "Select * from medicos where nome_medico like '%"+medico.getNomeMedico()+"%' order by nome_medico;";
        try {
            PreparedStatement preparedStatement = conexaoDAO.conexao.prepareStatement(sql);
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getResultSet();
            while (resultSet.next()) {
                int codigo =            resultSet.getInt("cod_medico");
                String nome =           resultSet.getString("nome_medico");
                String especialidade =  resultSet.getString("especialidade_medico");
                int crm =               resultSet.getInt("crm_medico");
                Medico medicoPesquisado = new Medico(codigo, nome, crm, especialidade);
                medicos.add(medicoPesquisado);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao Pesquisar Medico..\nErro: "+ex.getMessage());
        }
     conexaoDAO.desconectar();
     return medicos;
     
    }

    public void alterarMedico(Medico medico) {
        conexaoDAO = new ConexaoDAO();
        conexaoDAO.conectar();
        // Formata comando SQL
        
        String sql = "UPDATE medicos SET nome_medico=?, especialidade_medico=?, crm_medico=? WHERE cod_medico=?;";
        // Executa comando SQL
        try {
            PreparedStatement preparedStatement = conexaoDAO.conexao.prepareStatement(sql);
            preparedStatement.setString(1, medico.getNomeMedico());
            preparedStatement.setString(2, medico.getEspecialidadeMedico());
            preparedStatement.setInt(3, medico.getCrmMedico());
            preparedStatement.setInt(4, medico.getCodMedico());
            preparedStatement.execute();
            JOptionPane.showMessageDialog(null,"Medico Alterado com Sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao Alterar Medico..\nErro: "+ex.getMessage());
        }
        conexaoDAO.desconectar();
    }
     public void excluirMedico(Medico medico) {
        conexaoDAO = new ConexaoDAO();
        conexaoDAO.conectar();
        // Formata comando SQL
        String sql = "Delete from medicos where cod_medico = ?;";
        // Executa comando SQL
        try {
            PreparedStatement preparedStatement = conexaoDAO.conexao.prepareStatement(sql);
            preparedStatement.setInt(1, medico.getCodMedico());
            preparedStatement.execute();
            JOptionPane.showMessageDialog(null,"Medico Excluido com Sucesso!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Erro ao Excluir Medico..\nErro: "+e.getMessage());
        }
        conexaoDAO.desconectar();
        
    }
}
