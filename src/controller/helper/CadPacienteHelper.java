
package controller.helper;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import model.Bairro;
import model.Paciente;
import view.CadPaciente;


public class CadPacienteHelper {
    
    CadPaciente view;

    public CadPacienteHelper(CadPaciente view) {
        this.view = view;
    }

    public void iniciaCadPaciente() {
        view.getjLabelCodigo().setVisible(false);
        view.getjTextFieldCodigo().setVisible(false);
        view.getjTextFieldCodigo().setEnabled(false);
        view.getjTextFieldCodigo().setText("0");
        view.getjTextFieldNome().setText("");
        view.getjTextFieldNome().setEnabled(false);
        view.getjTextFieldRg().setText("");
        view.getjTextFieldRg().setEnabled(false);
        view.getjTextFieldDataNascimento().setText("");
        view.getjTextFieldDataNascimento().setEnabled(false);
        view.getjTextTelefone().setText("");
        view.getjTextTelefone().setEnabled(false);
        view.getjTextEndereco().setText("");
        view.getjTextEndereco().setEnabled(false);
        view.getjTextFieldNumero().setText("");
        view.getjTextFieldNumero().setEnabled(false);
        view.getjTextFieldComplemento().setText("");
        view.getjTextFieldComplemento().setEnabled(false);
        view.getjComboBoxBairro().setEnabled(false);
        view.getjComboBoxBairro().setSelectedIndex(0);
        view.getjTextFieldCep().setText("");
        view.getjTextFieldCep().setEnabled(false);
        view.getjButtonNovo().setEnabled(true);
        view.getjButtonSalvar().setEnabled(false);
        view.getjButtonCancelar().setEnabled(false);
        view.getjButtonEditar().setEnabled(false);
        view.getjButtonExcluir().setEnabled(false);
        view.getjButtonPesquisar().setEnabled(true);
        view.getjTextFieldNomePesquisa().setText("");
        view.getjTextFieldNomePesquisa().setEnabled(true);
        view.getjTablePaciente().getColumnModel().getColumn(0).setPreferredWidth(220);
        view.getjTablePaciente().getColumnModel().getColumn(1).setPreferredWidth(100);
        view.getjTablePaciente().getColumnModel().getColumn(2).setPreferredWidth(100);
        view.getjTablePaciente().getColumnModel().getColumn(3).setPreferredWidth(100);
        DefaultTableModel tableModel = (DefaultTableModel) view.getjTablePaciente().getModel();
        tableModel.setNumRows(0);
    }

    public void iniciaTabelaBairros(ArrayList<Bairro> bairros) {
        for (Bairro bairro : bairros) {
            view.getjComboBoxBairro().addItem(bairro.getNomeBairro());
        }
    }

    public void preparaNovoPaciente() {
        view.getjTextFieldNome().setEnabled(true);
        view.getjTextFieldRg().setEnabled(true);
        view.getjTextFieldDataNascimento().setEnabled(true);
        view.getjTextTelefone().setEnabled(true);
        view.getjTextEndereco().setEnabled(true);
        view.getjTextFieldNumero().setEnabled(true);
        view.getjTextFieldComplemento().setEnabled(true);
        view.getjComboBoxBairro().setEnabled(true);
        view.getjTextFieldCep().setEnabled(true);
        view.getjButtonNovo().setEnabled(false);
        view.getjButtonSalvar().setEnabled(true);
        view.getjButtonCancelar().setEnabled(true);
        view.getjButtonPesquisar().setEnabled(false);
        view.getjTextFieldNomePesquisa().setText("");
        view.getjTextFieldNomePesquisa().setEnabled(false);
    }

    public void obtemPaciente(Paciente paciente) {
        try {
            paciente.setCod(Integer.parseInt(view.getjTextFieldCodigo().getText()));
        }
        catch (Exception e){
            paciente.setCod(0);
        } 
        paciente.setNome(view.getjTextFieldNome().getText());
        paciente.setDataNascimento(view.getjTextFieldDataNascimento().getText());
        paciente.setRg(view.getjTextFieldRg().getText());
        paciente.setTelefone(view.getjTextTelefone().getText());
        paciente.setEndereco(view.getjTextEndereco().getText());
        paciente.setNumero(view.getjTextFieldNumero().getText());
        paciente.setComplemento(view.getjTextFieldComplemento().getText());
        paciente.setBairro((String) view.getjComboBoxBairro().getSelectedItem());
        paciente.setCep(view.getjTextFieldCep().getText());
       }
    
        public void preencherTabelaPacientes(ArrayList<Paciente> pacientes){
        //Monta tabela de pacientes
        DefaultTableModel tableModel = (DefaultTableModel) view.getjTablePaciente().getModel();
        tableModel.setNumRows(0);
        for (Paciente paciente : pacientes) {
            tableModel.addRow(new Object[]{
                paciente.getNome(),
                paciente.getDataNascimento(),
                paciente.getRg(),
                paciente.getTelefone()
              });
        }
    }

    public Paciente obterPacientePesquisa() {
        Paciente paciente = new Paciente();
        paciente.setCod(0);
        paciente.setNome(view.getjTextFieldNomePesquisa().getText());
        return paciente;
    }

    public void montaPacienteSelecionado(ArrayList<Paciente> pacientes, ArrayList<Bairro> bairros) {
        //como foi montado um ArrayList de Pacientes para montar a tabela de Pacientes,
        //obtem o paciente neste Array, com o indice do row selecionado na tabela
        Paciente pacienteSelecionado = pacientes.get(view.getjTablePaciente().getSelectedRow());
        view.getjLabelCodigo().setVisible(true);
        view.getjTextFieldCodigo().setText(""+pacienteSelecionado.getCod());
        view.getjTextFieldCodigo().setVisible(true);
        view.getjTextFieldNome().setText(pacienteSelecionado.getNome());
        view.getjTextFieldRg().setText(pacienteSelecionado.getRg());
        view.getjTextFieldDataNascimento().setText(pacienteSelecionado.getDataNascimento());
        view.getjTextTelefone().setText(pacienteSelecionado.getTelefone());
        view.getjTextEndereco().setText(pacienteSelecionado.getEndereco());
        view.getjTextFieldNumero().setText(pacienteSelecionado.getNumero());
        view.getjTextFieldComplemento().setText(pacienteSelecionado.getComplemento());
        int i = 0;
        int indice = 0;
        for (Bairro bairro : bairros) {
            if  (bairro.getNomeBairro().equals(pacienteSelecionado.getBairro())){
                indice = i;
            }else{
                i ++;}       
        }   
        view.getjComboBoxBairro().setSelectedIndex(indice);
        view.getjTextFieldCep().setText(pacienteSelecionado.getCep());
        view.getjButtonNovo().setEnabled(false);
        view.getjButtonSalvar().setEnabled(false);
        view.getjButtonCancelar().setEnabled(true);
        view.getjButtonEditar().setEnabled(true);
        view.getjButtonExcluir().setEnabled(true);
        view.getjButtonPesquisar().setEnabled(false);
        view.getjTextFieldNomePesquisa().setText("");
        view.getjTextFieldNomePesquisa().setEnabled(false);
        DefaultTableModel tableModel = (DefaultTableModel) view.getjTablePaciente().getModel();
        tableModel.setNumRows(0);
    }
    public void prepararEditarPaciente(){    
        view.getjTextFieldNome().setEnabled(true);
        view.getjTextFieldRg().setEnabled(true);
        view.getjTextFieldDataNascimento().setEnabled(true);
        view.getjTextTelefone().setEnabled(true);
        view.getjTextEndereco().setEnabled(true);
        view.getjTextFieldNumero().setEnabled(true);
        view.getjTextFieldComplemento().setEnabled(true);
        view.getjComboBoxBairro().setEnabled(true);
        view.getjTextFieldCep().setEnabled(true);
        view.getjButtonEditar().setEnabled(false);
        view.getjButtonExcluir().setEnabled(false);
        view.getjButtonSalvar().setEnabled(true);
    }
}