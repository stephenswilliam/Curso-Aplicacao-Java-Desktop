
package model.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Paciente;

 
public class PacienteDAO {
    
    private ConexaoDAO conexaoDAO;
    
    public void inserirPaciente(Paciente paciente) {
        conexaoDAO = new ConexaoDAO();
        conexaoDAO.conectar();
        String sql = "INSERT into " + 
                "pacientes (nome_paciente, rg_paciente, data_nasc_paciente, telefone_paciente, endereco_paciente, end_numero_paciente, end_compl_paciente, end_cep_paciente, end_bairro_paciente) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = conexaoDAO.conexao.prepareStatement(sql);
            preparedStatement.setString(1, paciente.getNome());
            preparedStatement.setString(2, paciente.getRg());
            preparedStatement.setString(3, paciente.getDataNascimento());
            preparedStatement.setString(4, paciente.getTelefone());
            preparedStatement.setString(5, paciente.getEndereco());
            preparedStatement.setString(6, paciente.getNumero());
            preparedStatement.setString(7, paciente.getComplemento());
            preparedStatement.setString(8, paciente.getCep());
            preparedStatement.setString(9, paciente.getBairro());
            preparedStatement.execute();
            JOptionPane.showMessageDialog(null,"Paciente Inserido com Sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao Inserir Paciente..\nErro: "+ex.getMessage());
        }
        conexaoDAO.desconectar();
    }

    public void alterarPaciente(Paciente paciente) {
        conexaoDAO = new ConexaoDAO();
        conexaoDAO.conectar();
        String sql = "UPDATE public.pacientes " +
                "SET nome_paciente=?, rg_paciente=?, data_nasc_paciente=?, telefone_paciente=?, endereco_paciente=?, end_numero_paciente=?, end_compl_paciente=?, end_cep_paciente=?, end_bairro_paciente=? " +
                "WHERE cod_paciente=?;";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = conexaoDAO.conexao.prepareStatement(sql);
            preparedStatement.setString(1, paciente.getNome());
            preparedStatement.setString(2, paciente.getRg());
            preparedStatement.setString(3, paciente.getDataNascimento());
            preparedStatement.setString(4, paciente.getTelefone());
            preparedStatement.setString(5, paciente.getEndereco());
            preparedStatement.setString(6, paciente.getNumero());
            preparedStatement.setString(7, paciente.getComplemento());
            preparedStatement.setString(8, paciente.getCep());
            preparedStatement.setString(9, paciente.getBairro());
            preparedStatement.setInt(10, paciente.getCod());
            preparedStatement.execute();
            JOptionPane.showMessageDialog(null,"Paciente Alterado com Sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao Alterar Paciente..\nErro: "+ex.getMessage());
        }
        conexaoDAO.desconectar();
    }

    public ArrayList<Paciente> pesquisaPaciente(Paciente paciente) {
        ArrayList<Paciente> pacientes = new ArrayList<>();
        String sql = "SELECT * from pacientes where nome_paciente LIKE '%"+paciente.getNome()+"%' order by nome_paciente;";
        conexaoDAO = new ConexaoDAO();
        conexaoDAO.conectar();
        try {    
            PreparedStatement preparedStatement = conexaoDAO.conexao.prepareStatement(sql);
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getResultSet();
            while (resultSet.next()) {
                Paciente pacientePesquisado = new Paciente();
                pacientePesquisado.setCod(resultSet.getInt("cod_paciente"));
                pacientePesquisado.setNome(resultSet.getString("nome_paciente"));
                pacientePesquisado.setRg(resultSet.getString("rg_paciente"));
                pacientePesquisado.setDataNascimento(resultSet.getString("data_nasc_paciente"));
                pacientePesquisado.setTelefone(resultSet.getString("telefone_paciente"));
                pacientePesquisado.setEndereco(resultSet.getString("endereco_paciente"));
                pacientePesquisado.setNumero(resultSet.getString("end_numero_paciente"));
                pacientePesquisado.setComplemento(resultSet.getString("end_compl_paciente"));
                pacientePesquisado.setCep(resultSet.getString("end_cep_paciente"));
                pacientePesquisado.setBairro(resultSet.getString("end_bairro_paciente"));
                pacientes.add(pacientePesquisado);
            }
         } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao Pesquisar Paciente..\nErro: "+ex.getMessage());
        }   
        conexaoDAO.desconectar();
        return pacientes;
        
    }

    public void excluiPaciente(Paciente paciente) {
        conexaoDAO = new ConexaoDAO();
        conexaoDAO.conectar();
        String sql = "DELETE from pacientes where cod_paciente = ?;";
        try {
            PreparedStatement preparedStatement = conexaoDAO.conexao.prepareStatement(sql);
            preparedStatement.setInt(1, paciente.getCod());
            preparedStatement.execute();
            JOptionPane.showMessageDialog(null,"Paciente Excluido com Sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao Excluir Paciente..\nErro: "+ex.getMessage());
        }
        conexaoDAO.desconectar();
    }
    
    
    
    
    
}
