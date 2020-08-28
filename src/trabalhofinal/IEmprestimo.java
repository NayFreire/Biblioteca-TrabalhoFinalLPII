package trabalhofinal;
/**
 * @author nayfr
 */
public interface IEmprestimo {
    public final static int qtdLivrosPorEmprestimo = 3;
    
    void addExemplar(Exemplar exemplar);
    boolean devolverLivros();
    void definirDataDeDevolucao();
}
