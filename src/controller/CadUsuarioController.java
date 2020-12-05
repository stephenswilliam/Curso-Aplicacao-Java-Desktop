
package controller;

import controller.helper.CadUsuarioHelper;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import model.DAO.UsuarioDAO;
import model.Usuario;
import view.CadUsuario;

public class CadUsuarioController {
    
    CadUsuario view;
    CadUsuarioHelper helper;
    Usuario usuario = new Usuario();

    public CadUsuarioController(CadUsuario view) {
        this.view = view;
        this.helper = new CadUsuarioHelper(view);
        this.helper.limparCadUsuario();
    }

    public void salvarUsuario() {
        //obter usuario
        this.usuario = helper.obterUsuario();
        //validar usuario
        boolean usuarioValido = this.validarUsuario();
        //chamar dao para incluir usuario
        if (usuarioValido){
            UsuarioDAO usuarioDAO = new UsuarioDAO();
            if (this.usuario.getCodUsuario()==0){
                usuarioDAO.insertUsuario(this.usuario);
                helper.limparCadUsuario();
            }else{
                usuarioDAO.alterarUsuario(this.usuario);
                helper.limparCadUsuario();
            }
        }
    }
        
    public void pesquisarUsuario(){
        //limpa tabela
        DefaultTableModel tableModel = (DefaultTableModel) view.getjTableUsuarios().getModel();
        tableModel.setNumRows(0);
        //
        this.usuario = helper.obterUsuarioPesquisa();
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        ArrayList<Usuario> usuariosPesquisados = usuarioDAO.pesquisaUsuario(this.usuario);
        if (!usuariosPesquisados.isEmpty()){
            helper.preencherTabelaUsuarios(usuariosPesquisados);
        }
    } 
    
    
    private boolean validarUsuario() {
        if (usuario.getNomeUsuario().isEmpty()){
           view.mostraMensagem("Nome do usuário invalido!");
           view.getjTextFieldNome().requestFocus();
           return (false);
        }else{
        if (usuario.getSenhaUsuario().isEmpty() ){
            view.mostraMensagem("Senha do usuário invalido!");
            view.getjTextFieldSenha().requestFocus();
            return (false);
        }
        }
        
        return (true);
    }
    public void excluirUsuario() {
        int resposta = view.confirmaAção("Confirma a Exclusão do Usuário ?");
        if (resposta == 0){ //0 = sim, 1 = não, 2= cancelar
            this.usuario = helper.obterUsuario();
            UsuarioDAO usuarioDAO = new UsuarioDAO();
            usuarioDAO.excluirUsuario(usuario);
            helper.limparCadUsuario();
        }
    }
    
    public void novoUsuario() {
        helper.preparaNovoUsuario();
    }

    private boolean validarUsuarioPesquisa() {
        if ("".equals(usuario.getNomeUsuario())){
           view.mostraMensagem("Usuario não encontrado!");
           return (false);
        }else{
           return (true);
        }
    }

    public void cancelarUsuario() {
        helper.limparCadUsuario();
    }

    public void editarUsuario() {
        helper.preparaEditarUsuario();
    }

    public void usuarioSelecionado() {
        helper.prepararUsuarioSelecionado();
        
    }

    
}