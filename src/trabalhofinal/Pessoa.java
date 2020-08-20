package trabalhofinal;
/**
 * @author nayfr
 */
public abstract class Pessoa {
    
    private int cpf;
    private String nome;
    private String email;
    private long telefone;    

    public Pessoa() {
    }

    public Pessoa(int cpf, String nome, String email, long telefone) {
        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
    }

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
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

    public long getTelefone() {
        return telefone;
    }

    public void setTelefone(long telefone) {
        this.telefone = telefone;
    }
    
    public void bemVindo(){
        System.out.println("Bem-Vindo");
    }
}
