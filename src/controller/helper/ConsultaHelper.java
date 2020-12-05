
package controller.helper;

import view.Consulta;

public class ConsultaHelper {
    
    Consulta view;

    public ConsultaHelper(Consulta view) {
        this.view = view;
        view.getjTableConsulta().getColumnModel().getColumn(0).setPreferredWidth(220);
        view.getjTableConsulta().getColumnModel().getColumn(1).setPreferredWidth(220);
        view.getjTableConsulta().getColumnModel().getColumn(2).setPreferredWidth(100);
        view.getjTableConsulta().getColumnModel().getColumn(3).setPreferredWidth(100);
    }
    
    
    
    
}
