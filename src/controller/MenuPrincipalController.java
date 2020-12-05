
package controller;

import javax.swing.JOptionPane;
import model.Usuario;
import view.CadAgendamento;
import view.CadPaciente;
import view.CadMedico;
import view.CadUsuario;
import view.Consulta;
import view.MenuPrincipal;

public class MenuPrincipalController {
    
    private final MenuPrincipal view;
    CadMedico telaCadMedico = new CadMedico();
    CadUsuario telaCadUsuario = new CadUsuario();
    CadPaciente telaCadPaciente = new CadPaciente();
    CadAgendamento telaCadAgendamento = new CadAgendamento();
    Consulta consultasAgendadas = new Consulta();
    

    public MenuPrincipalController(MenuPrincipal view) {
        this.view = view;
    }

    public void ativaCadMedico(Usuario usuarioLogado) {
        if (!"Administrador".equals(usuarioLogado.getTipoUsuario())){
            JOptionPane.showMessageDialog(null,"Acesso somente para Administradores");
        }else{  
            telaCadMedico.setVisible(true);
        }
    }

    public void ativaCadUsuario(Usuario usuarioLogado) {
        if (!"Administrador".equals(usuarioLogado.getTipoUsuario())){
            JOptionPane.showMessageDialog(null,"Acesso somente para Administradores");
        }else{  
            telaCadUsuario.setVisible(true);
        }
    }

    public void ativaCadPaciente(Usuario usuarioLogado) {
        if (!"Administrador".equals(usuarioLogado.getTipoUsuario())){
            JOptionPane.showMessageDialog(null,"Acesso somente para Administradores");
        }else{  
            telaCadPaciente.setVisible(true);
        }
    }

    public void artivaAgendamento(Usuario usuarioLogado) {
        telaCadAgendamento.setVisible(true);
    }

    public void ativaConsultas() {
        consultasAgendadas.setVisible(true);
    }
    
    
    
}
