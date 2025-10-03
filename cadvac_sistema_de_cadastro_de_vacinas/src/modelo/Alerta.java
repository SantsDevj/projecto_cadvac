package back_implementation;
import java.text.DateFormat;

public class Alerta {
    //Atributos da Classe
    private int id;
    private String tipo;
    private String descricao;
    private DateFormat data;

    //Getters e Setters
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public DateFormat getData() {
        return data;
    }
    public void setData(DateFormat data) {
        this.data = data;
    }
    //Métodos da Classe
    public void gerarAlerta(){

    }
    public void notificarPaciente(){
        
    }

}
