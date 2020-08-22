package trabalhofinal;

import java.util.ArrayList;
import java.util.Date;

/**
 * @author nayfr
 */
public class Emprestimo implements IEmprestimo{
    
    private String codigo;
    private Date dataEmprestimo;
    private Date dataDevolucao;
    private Pessoa quemEmprestou;
    private int qtdLivros;
    private ArrayList<Exemplar> livros = new ArrayList<>();

    public Emprestimo() {
    }
    
    public Emprestimo(String codigo, Date dataEmprestimo, Date dataDevolucao, Pessoa quemEmprestou, int qtdLivros) {
        this.codigo = codigo;
        this.dataEmprestimo = dataEmprestimo;
        this.dataDevolucao = dataDevolucao;
        this.quemEmprestou = quemEmprestou;
        this.qtdLivros = qtdLivros;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Date getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(Date dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public Date getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(Date dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public Pessoa getQuemEmprestou() {
        return quemEmprestou;
    }

    public void setQuemEmprestou(Pessoa quemEmprestou) {
        this.quemEmprestou = quemEmprestou;
    }

    public int getQtdLivros() {
        return qtdLivros;
    }

    public void setQtdLivros(int qtdLivros) {
        this.qtdLivros = qtdLivros;
    }

    public ArrayList<Exemplar> getLivros() {
        return livros;
    }

    public void setLivros(ArrayList<Exemplar> livros) {
        this.livros = livros;
    }
    
    @Override
    public void addExemplar(Exemplar exemplar) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean devolverLivros() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void definirDataDeDevolucao() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
