
package model;

import java.sql.Date;


public class Agendamento {
    
    private int codAgendamento;
    private int codPaciente;
    private int codMedico;
    private String sintomasAgendamento;
    private Date dataAgendamento;
    private String periodoAgendamento;
    private String statusAgendamento;

    public Agendamento() {
    }

    public Agendamento(int codAgendamento, int codPaciente, int codMedico, String sintomasAgendamento, Date dataAgendamento, String periodoAgendamento, String statusAgendamento) {
        this.codAgendamento = codAgendamento;
        this.codPaciente = codPaciente;
        this.codMedico = codMedico;
        this.sintomasAgendamento = sintomasAgendamento;
        this.dataAgendamento = dataAgendamento;
        this.periodoAgendamento = periodoAgendamento;
        this.statusAgendamento = statusAgendamento;
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

    public int getCodMedico() {
        return codMedico;
    }

    public void setCodMedico(int codMedico) {
        this.codMedico = codMedico;
    }

    public String getSintomasAgendamento() {
        return sintomasAgendamento;
    }

    public void setSintomasAgendamento(String sintomasAgendamento) {
        this.sintomasAgendamento = sintomasAgendamento;
    }

    public Date getDataAgendamento() {
        return dataAgendamento;
    }

    public void setDataAgendamento(Date dataAgendamento) {
        this.dataAgendamento = dataAgendamento;
    }

    public String getPeriodoAgendamento() {
        return periodoAgendamento;
    }

    public void setPeriodoAgendamento(String periodoAgendamento) {
        this.periodoAgendamento = periodoAgendamento;
    }

    public String getStatusAgendamento() {
        return statusAgendamento;
    }

    public void setStatusAgendamento(String statusAgendamento) {
        this.statusAgendamento = statusAgendamento;
    }

    
    
    }
