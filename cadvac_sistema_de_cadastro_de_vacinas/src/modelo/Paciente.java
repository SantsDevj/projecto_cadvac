package back_implementation;
import java.text.DateFormat;
import java.util.List;

public class Paciente extends Usuario{
    //Atributos da Classe
    private DateFormat data_nasc;
    private String sexo;
    private String endereco;
    private int telefone;

    //Getters e Setters
    public DateFormat getData_nasc() {
        return data_nasc;
    }
    public void setData_nasc(DateFormat data_nasc) {
        this.data_nasc = data_nasc;
    }
    public String getSexo() {
        return sexo;
    }
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
    public String getEndereco() {
        return endereco;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    public int getTelefone() {
        return telefone;
    }
    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    //Métodos da Classe
    public List<VacinaAplicada> consultarHistorico(){
        return null;
    }
}
