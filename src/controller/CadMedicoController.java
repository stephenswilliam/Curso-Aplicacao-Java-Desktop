
package controller;

import controller.helper.CadMedicoHelper;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import model.DAO.MedicoDAO;
import model.Medico;
import view.CadMedico;

public class CadMedicoController {
    
    CadMedico view;
    CadMedicoHelper helper;
    Medico medico = new Medico();

    public CadMedicoController(CadMedico view) {
        this.view = view;
        this.helper = new CadMedicoHelper(view);
        helper.limparCadMedico();
    }

    public void salvarMedico() {
        //obter medico
        this.medico = helper.obterMedico();
        //validar medico
        boolean medicoValido = this.validarMedico();
        //chamar dao para incluir medico
        if (medicoValido){
            MedicoDAO medicoDAO = new MedicoDAO();
            if (this.medico.getCodMedico()==0){
                medicoDAO.insertMedico(this.medico);
                helper.limparCadMedico();
            }else{
                medicoDAO.alterarMedico(this.medico);
                helper.limparCadMedico();
            }
        }
    }
        
    public void pesquisarMedico(){
        //limpa tabela
        DefaultTableModel tableModel = (DefaultTableModel) view.getjTableMedicos().getModel();
        tableModel.setNumRows(0);
        //
        this.medico = helper.obterMedicoPesquisa();
        MedicoDAO medicoDAO = new MedicoDAO();
        ArrayList<Medico> medicosPesquisados = medicoDAO.pesquisaMedico(this.medico);
        if (!medicosPesquisados.isEmpty()){
            helper.preencherTabelaMedicos(medicosPesquisados);
        }
    } 
    
    
    private boolean validarMedico() {
        if (medico.getNomeMedico().isEmpty()){
           view.mostraMensagem("Nome do médico invalido!");
           view.getjTextFieldNome().requestFocus();
           return (false);
        }else{
        if (medico.getCrmMedico() == 0 ){
            view.mostraMensagem("CRM do médico invalido!");
            view.getjFormattedTextFieldCRM().requestFocus();
            return (false);
        }
        }
        
        return (true);
    }
    public void excluirMedico() {
        int resposta = view.confirmaAção("Confirma a Exclusão do Médico ?");
        if (resposta == 0){ //0 = sim, 1 = não, 2= cancelar
            this.medico = helper.obterMedico();
            MedicoDAO medicoDAO = new MedicoDAO();
            medicoDAO.excluirMedico(medico);
            helper.limparCadMedico();
        }
    }
    
    public void novoMedico() {
        helper.preparaNovoMedico();
    }

    private boolean validarMedicoPesquisa() {
        if ("".equals(medico.getNomeMedico())){
           view.mostraMensagem("Medico não encontrado!");
           return (false);
        }else{
           return (true);
        }
    }

    public void cancelarMedico() {
        helper.limparCadMedico();
    }

    public void editarMedico() {
        helper.preparaEditarMedico();
    }

    public void medicoSelecionado() {
        helper.prepararMedicoSelecionado();
        
    }

    
}