package trabalhofinal;
/**
 * @author nayfr
 */
public class Funcionario extends Pessoa implements HorarioDeTrabalho{
    private String departamento;
    private String pis; /*Código da carteira de trabalho*/
    private String cargo;

    public Funcionario() {
    }

    public Funcionario(String departamento, String pis, String cargo, int cpf, String nome, String email, long telefone) {
        super(cpf, nome, email, telefone);
        this.departamento = departamento;
        this.pis = pis;
        this.cargo = cargo;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getPis() {
        return pis;
    }

    public void setPis(String pis) {
        this.pis = pis;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    @Override
    public void definirHorario() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
