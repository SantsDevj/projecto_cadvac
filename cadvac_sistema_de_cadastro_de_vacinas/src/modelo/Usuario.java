package back_implementation;
public abstract class Usuario{ //abstract quer dizer que esta classe não pode ser herdada
    //Atributos desta classe

    //Encapsulei os atributos, colocando o modficador de acesso para 'private'
    private int id;
    private String nome;
    private String email;
    private String senha;
    
    //Getters e Setters da Classe
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
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    //Métodos da Classe usuário
    public void cadastarUsuario(){
        
    }
    public boolean autenticar(){

        return true;
    }

    public void actualizarPerfil(){

    }
}
