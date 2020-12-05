
package controller.helper;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import model.Usuario;
import view.CadUsuario;


public class CadUsuarioHelper {
    
    CadUsuario view; 

    public CadUsuarioHelper(CadUsuario view) {
        this.view = view;
    }

    public Usuario obterUsuario() {
        Usuario usuario = new Usuario();
        try {
            usuario.setCodUsuario(Integer.parseInt(view.getjTextFieldCodUsuario().getText()));
        } catch (Exception e) {
            usuario.setCodUsuario(0);
        }
        usuario.setNomeUsuario(view.getjTextFieldNome().getText());
        usuario.setSenhaUsuario(view.getjTextFieldSenha().getText());
        usuario.setTipoUsuario( (String) view.getjComboBoxTipo().getSelectedItem());
        return usuario;
    } 
    public void limparCadUsuario(){
        
        view.getjLabelCodUsuario().setVisible(false);
        view.getjTextFieldCodUsuario().setVisible(false);
        view.getjTextFieldCodUsuario().setText("0"); 
        view.getjTextFieldNome().setText("");
        view.getjTextFieldNome().setEnabled(false);
        view.getjTextFieldSenha().setText("");
        view.getjTextFieldSenha().setEnabled(false);
        view.getjComboBoxTipo().setEnabled(false);
        view.getjButtonNovo().setEnabled(true);
        view.getjButtonSalvar().setEnabled(false);
        view.getjButtonCancelar().setEnabled(false);
        view.getjButtonEditar().setEnabled(false);
        view.getjButtonExcluir().setEnabled(false);
        view.getjTextFieldNomePesquisa().setText("");
        view.getjTextFieldNomePesquisa().setEnabled(true);
        view.getjButtonPesquisar().setEnabled(true);
        view.getjTableUsuarios().getColumnModel().getColumn(0).setPreferredWidth(40);
        view.getjTableUsuarios().getColumnModel().getColumn(1).setPreferredWidth(220);
        view.getjTableUsuarios().getColumnModel().getColumn(2).setPreferredWidth(80);
        view.getjTableUsuarios().getColumnModel().getColumn(3).setPreferredWidth(120);
        DefaultTableModel tableModel = (DefaultTableModel) view.getjTableUsuarios().getModel();
        tableModel.setNumRows(0);
        
        
    }

    public void preparaNovoUsuario() {
        this.limparCadUsuario();
        view.getjTextFieldNome().setEnabled(true);
        view.getjTextFieldSenha().setEnabled(true);
        view.getjComboBoxTipo().setEnabled(true);
        view.getjButtonNovo().setEnabled(false);
        view.getjButtonSalvar().setEnabled(true);
        view.getjButtonCancelar().setEnabled(true);
        view.getjButtonEditar().setEnabled(false);
        view.getjButtonExcluir().setEnabled(false);
        view.getjButtonPesquisar().setEnabled(false);
        view.getjTextFieldNomePesquisa().setEnabled(false);
        
        
    }

    public Usuario obterUsuarioPesquisa() {
        Usuario usuarioPesquisa = new Usuario();
        usuarioPesquisa.setNomeUsuario(view.getjTextFieldNomePesquisa().getText());
        return usuarioPesquisa;
    }

    public void preencherTabelaUsuarios(ArrayList<Usuario> usuarios){
        //Monta tabela de usuarios
        DefaultTableModel tableModel = (DefaultTableModel) view.getjTableUsuarios().getModel();
        tableModel.setNumRows(0);
        for (Usuario usuario : usuarios) {
            tableModel.addRow(new Object[]{
                usuario.getCodUsuario(),
                usuario.getNomeUsuario(),
                usuario.getSenhaUsuario(),
                usuario.getTipoUsuario()
              });
        }
    }
        
       
    public void preparaEditarUsuario() {
        view.getjTextFieldNome().setEnabled(true);
        view.getjTextFieldSenha().setEnabled(true);
        view.getjComboBoxTipo().setEnabled(true);
        view.getjButtonCancelar().setEnabled(true);
        view.getjButtonSalvar().setEnabled(true);
        view.getjButtonEditar().setEnabled(false);
        view.getjButtonExcluir().setEnabled(false);
      
    }

    public void prepararUsuarioSelecionado() {
        // obtem dados do usuario que foi selecionado na tabela de usuarios
        int     cod_usuario             = (int) view.getjTableUsuarios().getValueAt(view.getjTableUsuarios().getSelectedRow(),0);
        String  nome_usuario            = ""+view.getjTableUsuarios().getValueAt(view.getjTableUsuarios().getSelectedRow(),1);
        String  senha_usuario           = ""+view.getjTableUsuarios().getValueAt(view.getjTableUsuarios().getSelectedRow(),2);
        String  tipo_usuario            = ""+view.getjTableUsuarios().getValueAt(view.getjTableUsuarios().getSelectedRow(),3);
        
        view.getjTextFieldCodUsuario().setText(String.valueOf(cod_usuario));
        view.getjTextFieldCodUsuario().setVisible(true);
        view.getjLabelCodUsuario().setVisible(true);
        view.getjTextFieldNome().setText(nome_usuario);
        view.getjTextFieldSenha().setText(senha_usuario);
        view.getjComboBoxTipo().setSelectedItem(tipo_usuario);
        view.getjButtonNovo().setEnabled(false);
        view.getjButtonEditar().setEnabled(true);
        view.getjButtonExcluir().setEnabled(true);
        view.getjButtonCancelar().setEnabled(true);
        view.getjButtonPesquisar().setEnabled(false);
        view.getjTextFieldNomePesquisa().setEnabled(false);
        DefaultTableModel tableModel = (DefaultTableModel) view.getjTableUsuarios().getModel();
        tableModel.setNumRows(0);
        
    

    }

}

    
