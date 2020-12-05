
package model;

public class Medico {

    private int codMedico;
    private String nomeMedico;
    private int crmMedico;
    private String especialidadeMedico;

    public Medico(int codMedico, String nomeMedico, int crmMedico, String especialidadeMedico) {
        this.codMedico = codMedico;
        this.nomeMedico = nomeMedico;
        this.crmMedico = crmMedico;
        this.especialidadeMedico = especialidadeMedico;
    }

    public Medico() {
    }
    
    /**
     * @return the codMedico
     */
    public int getCodMedico() {
        return codMedico;
    }

    /**
     * @param codMedico the codMedico to set
     */
    public void setCodMedico(int codMedico) {
        this.codMedico = codMedico;
    }

    /**
     * @return the nomeMedico
     */
    public String getNomeMedico() {
        return nomeMedico;
    }

    /**
     * @param nomeMedico the nomeMedico to set
     */
    public void setNomeMedico(String nomeMedico) {
        this.nomeMedico = nomeMedico;
    }

    /**
     * @return the crmMedico
     */
    public int getCrmMedico() {
        return crmMedico;
    }

    /**
     * @param crmMedico the crmMedico to set
     */
    public void setCrmMedico(int crmMedico) {
        this.crmMedico = crmMedico;
    }

    /**
     * @return the especialidadeMedico
     */
    public String getEspecialidadeMedico() {
        return especialidadeMedico;
    }

    /**
     * @param especialidadeMedico the especialidadeMedico to set
     */
    public void setEspecialidadeMedico(String especialidadeMedico) {
        this.especialidadeMedico = especialidadeMedico;
    }
    
    

    
}