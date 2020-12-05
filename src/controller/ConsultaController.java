
package controller;

import controller.helper.ConsultaHelper;
import view.Consulta;


public class ConsultaController {
    
    Consulta view;
    ConsultaHelper helper;;

    public ConsultaController(Consulta view) {
        this.view = view;
        this.helper = new ConsultaHelper(view);
    }
    
    
    
}
