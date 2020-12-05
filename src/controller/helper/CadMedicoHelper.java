
package controller.helper;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.DAO.MedicoDAO;
import model.Medico;
import view.CadMedico;


public class CadMedicoHelper {
    
    CadMedico view; 

    public CadMedicoHelper(CadMedico view) {
        this.view = view;
    }

    public Medico obterMedico() {
        Medico medico = new Medico();
        try {
            medico.setCodMedico(Integer.parseInt(view.getjTextFieldCodMedico().getText()));
        } catch (Exception e) {
            medico.setCodMedico(0);
        }
        medico.setNomeMedico(view.getjTextFieldNome().getText());
        try {
            medico.setCrmMedico(Integer.parseInt(view.getjFormattedTextFieldCRM().getText()));
        } catch (Exception ex) {
            medico.setCrmMedico(0);
        }
        medico.setEspecialidadeMedico((String)view.getjComboBoxEspecialidade().getSelectedItem());
        return medico;
    } 
    public void limparCadMedico(){
        
        view.getjLabelCodMedico().setVisible(false);
        view.getjTextFieldCodMedico().setVisible(false);
        view.getjTextFieldCodMedico().setText("0"); 
        view.getjTextFieldNome().setText("");
        view.getjTextFieldNome().setEnabled(false);
        view.getjFormattedTextFieldCRM().setText("");
        view.getjFormattedTextFieldCRM().setEnabled(false);
        view.getjComboBoxEspecialidade().setEnabled(false);
        view.getjButtonNovo().setEnabled(true);
        view.getjButtonSalvar().setEnabled(false);
        view.getjButtonCancelar().setEnabled(false);
        view.getjButtonEditar().setEnabled(false);
        view.getjButtonExcluir().setEnabled(false);
        view.getjTextFieldNomePesquisa().setText("");
        view.getjTextFieldNomePesquisa().setEnabled(true);
        view.getjButtonPesquisar().setEnabled(true);
        view.getjTableMedicos().getColumnModel().getColumn(0).setPreferredWidth(40);
        view.getjTableMedicos().getColumnModel().getColumn(1).setPreferredWidth(220);
        view.getjTableMedicos().getColumnModel().getColumn(2).setPreferredWidth(60);
        view.getjTableMedicos().getColumnModel().getColumn(3).setPreferredWidth(100);
        DefaultTableModel tableModel = (DefaultTableModel) view.getjTableMedicos().getModel();
        tableModel.setNumRows(0);
        
        
    }

    public void preparaNovoMedico() {
        this.limparCadMedico();
        view.getjTextFieldNome().setEnabled(true);
        view.getjFormattedTextFieldCRM().setEnabled(true);
        view.getjComboBoxEspecialidade().setEnabled(true);
        view.getjButtonNovo().setEnabled(false);
        view.getjButtonSalvar().setEnabled(true);
        view.getjButtonCancelar().setEnabled(true);
        view.getjButtonEditar().setEnabled(false);
        view.getjButtonExcluir().setEnabled(false);
        view.getjButtonPesquisar().setEnabled(false);
        view.getjTextFieldNomePesquisa().setEnabled(false);
        
        
    }

    public Medico obterMedicoPesquisa() {
        Medico medicoPesquisa = new Medico();
        medicoPesquisa.setNomeMedico(view.getjTextFieldNomePesquisa().getText());
        return medicoPesquisa;
    }

    public void preencherTabelaMedicos(ArrayList<Medico> medicos){
        //Monta tabela de medicos
       
        DefaultTableModel tableModel = (DefaultTableModel) view.getjTableMedicos().getModel();
        tableModel.setNumRows(0);
        for (Medico medico : medicos) {
            tableModel.addRow(new Object[]{
                medico.getCodMedico(),
                medico.getNomeMedico(),
                medico.getCrmMedico(),
                medico.getEspecialidadeMedico()
              });
        }
    }
        
       
public void preparaEditarMedico() {
        view.getjTextFieldNome().setEnabled(true);
        view.getjFormattedTextFieldCRM().setEnabled(true);
        view.getjComboBoxEspecialidade().setEnabled(true);
        view.getjButtonCancelar().setEnabled(true);
        view.getjButtonSalvar().setEnabled(true);
        view.getjButtonEditar().setEnabled(false);
        view.getjButtonExcluir().setEnabled(false);
      
    }

    public void prepararMedicoSelecionado() {
        // obtem dados do medico que foi selecionado na tabela de medicosview.getjTableMedicos().getValueAt(view.getjTableMed
        int     cod_medico              = (int) view.getjTableMedicos().getValueAt(view.getjTableMedicos().getSelectedRow(),0);
        String  nome_medico             = ""+view.getjTableMedicos().getValueAt(view.getjTableMedicos().getSelectedRow(),1);
        int     crm_medico              = (int) view.getjTableMedicos().getValueAt(view.getjTableMedicos().getSelectedRow(),2);
        String  especialidade_medico    = ""+view.getjTableMedicos().getValueAt(view.getjTableMedicos().getSelectedRow(),3);
        view.getjTextFieldCodMedico().setText(String.valueOf(cod_medico));
        view.getjTextFieldCodMedico().setVisible(true);
        view.getjLabelCodMedico().setVisible(true);
        view.getjTextFieldNome().setText(nome_medico);
        view.getjFormattedTextFieldCRM().setText(String.valueOf(crm_medico));
        view.getjComboBoxEspecialidade().setSelectedItem(especialidade_medico);
        view.getjButtonNovo().setEnabled(false);
        view.getjButtonEditar().setEnabled(true);
        view.getjButtonExcluir().setEnabled(true);
        view.getjButtonCancelar().setEnabled(true);
        view.getjButtonPesquisar().setEnabled(false);
        view.getjTextFieldNomePesquisa().setEnabled(false);
        DefaultTableModel tableModel = (DefaultTableModel) view.getjTableMedicos().getModel();
        tableModel.setNumRows(0);
        
    

    }

}

    
