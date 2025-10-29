package back_implementation;
import java.text.DateFormat;

public class Relatorio {
    //Atributos da Classe
    private int id;
    private String tipo_Relatorio;
    private DateFormat data_Geracao;

    //Getters e Setters
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getTipo_Relatorio() {
        return tipo_Relatorio;
    }
    public void setTipo_Relatorio(String tipo_Relatorio) {
        this.tipo_Relatorio = tipo_Relatorio;
    }
    public DateFormat getData_Geracao() {
        return data_Geracao;
    }
    public void setData_Geracao(DateFormat data_Geracao) {
        this.data_Geracao = data_Geracao;
    }
    //Métodos da Classe
    public void gerar(){
        
    }
    
}
