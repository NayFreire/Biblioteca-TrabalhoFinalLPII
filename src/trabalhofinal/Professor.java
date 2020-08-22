package trabalhofinal;
/**
 * @author nayfr
 */
public class Professor extends Pessoa{
    private int id;
    private String pis; /*Código da carteira de trabalho*/
    private String status; /*contratado ou substituto*/

    public Professor() {
    }

    public Professor(int id, String pis, String status, int cpf, String nome, String email, long telefone) {
        super(cpf, nome, email, telefone);
        this.id = id;
        this.pis = pis;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPis() {
        return pis;
    }

    public void setPis(String pis) {
        this.pis = pis;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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
