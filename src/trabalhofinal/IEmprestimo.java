package trabalhofinal;
/**
 * @author nayfr
 */
public interface IEmprestimo {
    int qtdLivrosPorEmprestimo = 3;
    
    void addExemplar(Exemplar exemplar);
    boolean devolverLivros();
    void definirDataDeDevolucao();
}
