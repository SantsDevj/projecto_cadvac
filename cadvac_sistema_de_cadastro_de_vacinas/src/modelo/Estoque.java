package back_implementation;
import java.text.DateFormat;

public class Estoque {
    //Atributos da Classe
    private int id;
    private int quant;
    private String local;
    private DateFormat dada_Validade;

    //Getters e Setters
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getQuant() {
        return quant;
    }
    public void setQuant(int quant) {
        this.quant = quant;
    }
    public String getLocal() {
        return local;
    }
    public void setLocal(String local) {
        this.local = local;
    }
    public DateFormat getDada_Validade() {
        return dada_Validade;
    }
    public void setDada_Validade(DateFormat dada_Validade) {
        this.dada_Validade = dada_Validade;
    }

    //Métodos da Classe
    public void actualizarEstoque(){

    }
    public void gerarRelatorio(){

    }
    
}
