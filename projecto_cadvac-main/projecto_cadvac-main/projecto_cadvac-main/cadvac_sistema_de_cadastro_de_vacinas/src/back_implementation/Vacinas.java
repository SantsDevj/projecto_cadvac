package back_implementation;
import java.text.DateFormat;

public class Vacinas {

    //Atributos da Classe
    private int id;
    private String nome;
    private String fabricante;
    private DateFormat validade;
    private int quant_dispon;

    //Getters e Setters dos atributos encapulados
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getFabricante() {
        return fabricante;
    }
    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }
    public DateFormat getValidade() {
        return validade;
    }
    public void setValidade(DateFormat validade) {
        this.validade = validade;
    }
    public int getQuant_dispon() {
        return quant_dispon;
    }
    public void setQuant_dispon(int quant_dispon) {
        this.quant_dispon = quant_dispon;
    }

    //Métodos desta Classe
    public void actualizarEstoque(){

    }

    public boolean verificarDisponiblidade(){
        return false;
    }
}
