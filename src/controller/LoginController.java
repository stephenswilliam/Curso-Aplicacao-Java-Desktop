
package controller;

import controller.helper.LoginHelper;
import model.DAO.LoginDAO;
import model.Usuario;
import view.Login;
import view.MenuPrincipal;

public class LoginController {
    
    Login view;
    private Usuario usuarioLogin = new Usuario();
    LoginHelper helper;

    public LoginController(Login view) {
        this.view = view;
        this.helper = new LoginHelper(this.view);
        
    }

    public void validaLogin() {
        // obter usuario
        this.usuarioLogin = helper.obterUsuario();
        // validar usuario no banco
        LoginDAO loginDAO = new LoginDAO(usuarioLogin);
        loginDAO.consultaNomeSenha();
        if (usuarioLogin.getCodUsuario() == 0){
            view.mostraMensagem("Usuário ou Senha Invalido");
        }else{
            MenuPrincipal menuPrincipal = new MenuPrincipal();
            menuPrincipal.recebeUsuarioLogado(usuarioLogin);
            menuPrincipal.setVisible(true);
            view.dispose();
        }
    }
    
}
