package trabalhofinal;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

/**
 * @author nayfr
 */
public class Emprestimo implements IEmprestimo{
    
    private String codigo;
    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucao;
    private Pessoa quemEmprestou;
    private ArrayList<Exemplar> livros = new ArrayList<>();

    public Emprestimo() {
    }
    
    public Emprestimo(String codigo, LocalDate dataEmprestimo, LocalDate dataDevolucao, Pessoa quemEmprestou, ArrayList livros) {
        this.codigo = codigo;
        this.dataEmprestimo = dataEmprestimo;
        this.dataDevolucao = dataDevolucao;
        this.quemEmprestou = quemEmprestou;
        this.livros = livros;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public LocalDate getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(LocalDate dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(LocalDate dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public Pessoa getQuemEmprestou() {
        return quemEmprestou;
    }

    public void setQuemEmprestou(Pessoa quemEmprestou) {
        this.quemEmprestou = quemEmprestou;
    }

    public ArrayList<Exemplar> getLivros() {
        return livros;
    }

    public void setLivros(ArrayList<Exemplar> livros) {
        this.livros = livros;
    }
    
    @Override
    public void addExemplar(Exemplar exemplar) {
        livros.add(exemplar);
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
