package trabalhofinal;
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
    
}
