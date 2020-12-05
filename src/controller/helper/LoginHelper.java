
package controller.helper;

import model.Usuario;
import view.Login;

public class LoginHelper {
    
    Login view;

    public LoginHelper(Login view) {
        this.view = view;
    }

    public Usuario obterUsuario() {
        Usuario usuario = new Usuario();
        usuario.setCodUsuario(0);
        usuario.setNomeUsuario(""+view.getjTextFieldUsuario().getText());
        usuario.setSenhaUsuario(""+view.getjPasswordFieldSenha().getText());
        usuario.setTipoUsuario("");
        return usuario;
    }
}

