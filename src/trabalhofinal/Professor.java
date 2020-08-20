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
}
