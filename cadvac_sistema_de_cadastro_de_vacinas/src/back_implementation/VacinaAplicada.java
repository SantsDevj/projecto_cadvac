package back_implementation;
import java.text.DateFormat;

public class VacinaAplicada {
    //Atributos da Classe
    private int id_Aplicacao;
    private DateFormat data_Aplicacao;
    private String lote;
    private String dose;
    private String local_Aplicacao;

    //Getters e Setters 
    public int getId_Aplicacao() {
        return id_Aplicacao;
    }
    
    public void setId_Aplicacao(int id_Aplicacao) {
        this.id_Aplicacao = id_Aplicacao;
    }

    public DateFormat getData_Aplicacao() {
        return data_Aplicacao;
    }
    
    public void setData_Aplicacao(DateFormat data_Aplicacao) {
        this.data_Aplicacao = data_Aplicacao;
    }
    
    public String getLote() {
        return lote;
    }
    
    public void setLote(String lote) {
        this.lote = lote;
    }
    
    public String getDose() {
        return dose;
    }
    
    public void setDose(String dose) {
        this.dose = dose;
    }
    
    public String getLocal_Aplicacao() {
        return local_Aplicacao;
    }
    
    public void setLocal_Aplicacao(String local_Aplicacao) {
        this.local_Aplicacao = local_Aplicacao;
    }

    //Métodos desta Classe
    public void registrarAplicacao(){
    
    }
}
