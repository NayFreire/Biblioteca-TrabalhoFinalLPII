package trabalhofinal;

import java.util.Date;

/**
 * @author nayfr
 */
public class Aluno extends Pessoa{
    private String matricula;
    private String curso;
    private String dataNasc;

    public Aluno() {
    }

    public Aluno(String matricula, String curso, String dataNasc, int cpf, String nome, String email, long telefone) {
        super(cpf, nome, email, telefone);
        this.matricula = matricula;
        this.curso = curso;
        this.dataNasc = dataNasc;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(String dataNasc) {
        this.dataNasc = dataNasc;
    }

    @Override
    public void bemVindo() {
        super.bemVindo(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setTelefone(long telefone) {
        super.setTelefone(telefone); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public long getTelefone() {
        return super.getTelefone(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setEmail(String email) {
        super.setEmail(email); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getEmail() {
        return super.getEmail(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setNome(String nome) {
        super.setNome(nome); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getNome() {
        return super.getNome(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setCpf(int cpf) {
        super.setCpf(cpf); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getCpf() {
        return super.getCpf(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
