
package model.DAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.Agendamento;


public class AgendamentoDAO {
    
    //private Agendamento agendamento;
    private ConexaoDAO conexaoDAO;

    public void insertAgendamento(Agendamento agendamento) {
        conexaoDAO = new ConexaoDAO();
        conexaoDAO.conectar();
        // Formata comando SQL
        String comando =    "Insert into agendamentos ";
        String campos =     "(cod_paciente, cod_medico, sintomas_agendamento, data_agendamento, periodo_agendamento, status_agendamento)";
        String valores =    "values (?,?,?,?,?,?);";
        String sql = comando+campos+valores;
        // Executa comando SQL
        try {
            PreparedStatement preparedStatement = conexaoDAO.conexao.prepareStatement(sql);
            preparedStatement.setInt(1, agendamento.getCodPaciente());
            preparedStatement.setInt(2, agendamento.getCodMedico());
            preparedStatement.setString(3, agendamento.getSintomasAgendamento());
            preparedStatement.setDate(4, agendamento.getDataAgendamento());
            preparedStatement.setString(5, agendamento.getPeriodoAgendamento());
            preparedStatement.setString(6, agendamento.getStatusAgendamento());
            preparedStatement.execute();
            JOptionPane.showMessageDialog(null,"Agendamento efetuado com Sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao Inserir Agendamento..\nErro: "+ex.getMessage());
        }
        conexaoDAO.desconectar();
    }
}
