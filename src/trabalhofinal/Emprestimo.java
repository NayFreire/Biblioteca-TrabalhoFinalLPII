package trabalhofinal;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import static trabalhofinal.TrabalhoFinal.alunos;
import static trabalhofinal.TrabalhoFinal.emprestimos;
import static trabalhofinal.TrabalhoFinal.funcionarios;
import static trabalhofinal.TrabalhoFinal.professores;
import static trabalhofinal.TrabalhoFinal.quemE;

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
        Emprestimo devolucao = new Emprestimo();
        
        String quemEstaFazendoEmp = (String) JOptionPane.showInputDialog(null, "Qual a classificação da pessoa",
                "Qual o status?", JOptionPane.QUESTION_MESSAGE, null, quemE, quemE[0]);
        String nome = "";
        
        if(quemEstaFazendoEmp.equals("Aluno")){
            String matriculaDevolmendo = JOptionPane.showInputDialog("Matrícula do Aluno");
            for(Aluno devolvendo : alunos){
                if(matriculaDevolmendo.equals(devolvendo.getMatricula())){
                    nome = devolvendo.getNome();
                }
            }  
        }
        else if(quemEstaFazendoEmp.equals("Professor")){
            int idDevolmendo = Integer.parseInt(JOptionPane.showInputDialog("ID do Professor"));
            for(Professor devolvendo : professores){
                if(idDevolmendo==devolvendo.getId()){
                    nome = devolvendo.getNome();
                }
            }  
        }
        else{
            String pisDevolvendo = JOptionPane.showInputDialog("PIS do Funcionário");
            for(Funcionario devolvendo : funcionarios){
                if(pisDevolvendo.equals(devolvendo.getPis())){
                    nome = devolvendo.getNome();
                }
            }
        }
        int i;
        
        int qtdLivros = Integer.parseInt(JOptionPane.showInputDialog("Quantos livros deseja devolver?"));
        boolean vazia = false;
        
        for(i=0;i<qtdLivros;i++){
            String isbnBuscado = JOptionPane.showInputDialog("Informe o ISBN do exemplar");
            Exemplar devolvido = new Exemplar();

            for(Emprestimo emp : emprestimos){
                if(emp.quemEmprestou.getNome().equals(nome)){
                    System.out.println("Nome: " + emp.quemEmprestou.getNome());
                    for(Exemplar emprestado : emp.livros){
                        if(emprestado.getIsbn().equals(isbnBuscado)){
                            devolvido = emprestado;
                        }
                    }
                    emp.livros.remove(devolvido);
                    if(emp.livros.isEmpty()){
                        vazia = true;
                        devolucao = emp;
                    }
                }
            }
            
            if(vazia){
                emprestimos.remove(devolucao);
            }
            
        }
        return true;
    }

    @Override
    public void definirDataDeDevolucao() {
        LocalDate dataDevolucao = LocalDate.now().plusDays(5);
        setDataDevolucao(dataDevolucao);
    }

    
}
