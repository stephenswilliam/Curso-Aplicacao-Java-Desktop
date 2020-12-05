
package model;

import java.sql.Date;


public class Consulta {
    
    int codAgendamento;
    int codPaciente;
    String nomePaciente;
    int codMedico;
    String nomeMedico;
    Date dataConsulta;
    String periodoConsulta;
    String sintomasConsulta;
    String statusConsulta;
    String diagnosticoMedico;
    String prescricao;

    public Consulta() {
    }

    public int getCodAgendamento() {
        return codAgendamento;
    }

    public void setCodAgendamento(int codAgendamento) {
        this.codAgendamento = codAgendamento;
    }

    public int getCodPaciente() {
        return codPaciente;
    }

    public void setCodPaciente(int codPaciente) {
        this.codPaciente = codPaciente;
    }

    public String getNomePaciente() {
        return nomePaciente;
    }

    public void setNomePaciente(String nomePaciente) {
        this.nomePaciente = nomePaciente;
    }

    public int getCodMedico() {
        return codMedico;
    }

    public void setCodMedico(int codMedico) {
        this.codMedico = codMedico;
    }

    public String getNomeMedico() {
        return nomeMedico;
    }

    public void setNomeMedico(String nomeMedico) {
        this.nomeMedico = nomeMedico;
    }

    public Date getDataConsulta() {
        return dataConsulta;
    }

    public void setDataConsulta(Date dataConsulta) {
        this.dataConsulta = dataConsulta;
    }

    public String getPeriodoConsulta() {
        return periodoConsulta;
    }

    public void setPeriodoConsulta(String periodoConsulta) {
        this.periodoConsulta = periodoConsulta;
    }

    public String getSintomasConsulta() {
        return sintomasConsulta;
    }

    public void setSintomasConsulta(String sintomasConsulta) {
        this.sintomasConsulta = sintomasConsulta;
    }

    public String getStatusConsulta() {
        return statusConsulta;
    }

    public void setStatusConsulta(String statusConsulta) {
        this.statusConsulta = statusConsulta;
    }

    public String getDiagnosticoMedico() {
        return diagnosticoMedico;
    }

    public void setDiagnosticoMedico(String diagnosticoMedico) {
        this.diagnosticoMedico = diagnosticoMedico;
    }

    public String getPrescricao() {
        return prescricao;
    }

    public void setPrescricao(String prescricao) {
        this.prescricao = prescricao;
    }

    
    
    
    
}
