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
    
    

    @Override
    public void definirHorario() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
