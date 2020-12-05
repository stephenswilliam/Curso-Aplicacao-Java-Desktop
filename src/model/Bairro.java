
package model;


public class Bairro {
    
    private int codBairro;
    private String nomeBairro;

    public Bairro(int codBairro, String nomeBairro) {
        this.codBairro = codBairro;
        this.nomeBairro = nomeBairro;
    }

    
    /**
     * @return the codBairro
     */
    public int getCodBairro() {
        return codBairro;
    }

    /**
     * @param codBairro the codBairro to set
     */
    public void setCodBairro(int codBairro) {
        this.codBairro = codBairro;
    }

    /**
     * @return the nomeBairro
     */
    public String getNomeBairro() {
        return nomeBairro;
    }

    /**
     * @param nomeBairro the nomeBairro to set
     */
    public void setNomeBairro(String nomeBairro) {
        this.nomeBairro = nomeBairro;
    }
   
    
}
