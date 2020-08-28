package trabalhofinal;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ListModel;

/**
 * @author nayfr
 */
public class TrabalhoFinal {
    
    static ArrayList<Aluno> alunos = new ArrayList<>();
    static ArrayList<Funcionario> funcionarios = new ArrayList<>();
    static ArrayList<Professor> professores = new ArrayList<>();
    
    static ArrayList<Exemplar> exemplares = new ArrayList<>();
    static ArrayList<Emprestimo> emprestimos = new ArrayList<>();
    
    static String[] op2 = {"Adicionar", "Listar", "Atualizar", "Excluir", "Voltar"};
    static String[] sts = {"Contratado", "Substituto"};
    static String[] depts = {"Administrativo", "Comunicação", "Gestão de Pessoas", "Limpeza/Cozinha", "Financeiro"};
    static String[] quemE = {"Aluno", "Professor", "Funcionario"};
    
    static String codigoTxt = "EMP2020000";
    static int cod;
        
    public static void main(String[] args)  {
        
        menuPrincipal();
    }
    
    public static void menuPrincipal() {
        
        String[] op1 = {"Ver Cadastros", "Ver Emprestimos", "Ver Exemplares"};
        
        int selected1 = JOptionPane.showOptionDialog(null, "O que deseja fazer?", "Bem-vindo(a)", 
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, op1, op1[0]);
        
        switch(selected1){
            case 0:
                menuCadastro();
            break;
            
            case 1:
                menuEmprestimo();
            break;
            
            case 2:
                menuExemplar();
            break;
        }
    }
    
    public static void menuCadastro() {
        String[] op3 = {"Aluno(a)", "Professor(a)", "Funcionario(a)", "Voltar"};
        
        int selected2 = JOptionPane.showOptionDialog(null, "Qual você deseja cadastrar?", "Cadastros", 
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, op3, op3[0]);
        
        switch(selected2){
            case 0:
                menuAluno();
            break;
            
            case 1:
                menuProfessor();
            break;
            
            case 2:
                menuFuncionario();
            break;
            
            case 3:
                menuPrincipal();
            break;
        }
    }
    
    public static void menuEmprestimo() {        
        
        int selected3 = JOptionPane.showOptionDialog(null, "O que deseja fazer a respeito de empréstimos?", "Empréstimos",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, op2, op2[0]);
        
        switch(selected3){
            
            case 0:/*FAZER EMPRÉSTIMO*/   
                Aluno alunoAchado = new Aluno();
                Exemplar exemplarAchado = new Exemplar();
                Professor professorAchado = new Professor();
                Funcionario funcAchado = new Funcionario();
                int qtdExemplares = 0;
                String quemEstaFazendoEmp = (String) JOptionPane.showInputDialog(null, "Qual a classificação da pessoa",
                "Qual o status?", JOptionPane.QUESTION_MESSAGE, null, quemE, quemE[0]);
                
                String codigo = codigoTxt + cod;
                cod++;
                LocalDate dataEmprestimo = LocalDate.now();
                LocalDate dataDevolucao = LocalDate.now().plusDays(5);
                
                if(quemEstaFazendoEmp.equals("Aluno")){                    
                    alunoAchado = alunosEmprestimo();
                    exemplarAchado = buscaExemplar();   
                    
                    Emprestimo emprestAluno = new Emprestimo();
                    emprestAluno.setCodigo(codigo);
                    emprestAluno.setDataEmprestimo(dataEmprestimo);
                    emprestAluno.setDataDevolucao(dataDevolucao);
                    emprestAluno.setQuemEmprestou(alunoAchado);
                    emprestAluno.addExemplar(exemplarAchado);
                    
                    emprestimos.add(emprestAluno);
                    
                    qtdExemplares++;
                    System.out.println("qtd: " + qtdExemplares);
                    int multExemplares = JOptionPane.showConfirmDialog(null, "Adicionar mais algum exemplar?");
                                   
                    while(qtdExemplares<3){
                        if(multExemplares == 0){
                            exemplarAchado = buscaExemplar();
                            emprestAluno.addExemplar(exemplarAchado);
                            qtdExemplares++;
                            multExemplares = JOptionPane.showConfirmDialog(null, "Adicionar mais algum exemplar?");
                        }
                        else{
                            break;
                        }
                    }
                    
                    if(qtdExemplares==3){
                        JOptionPane.showConfirmDialog(null, "O número máximo de exemplares por empréstimo é 3");
                    }
                }
                
                else if(quemEstaFazendoEmp.equals("Professor")){
                    professorAchado = professoresEmprestimo();
                    exemplarAchado = buscaExemplar();
                    
                    Emprestimo emprestProf = new Emprestimo();
                    emprestProf.setCodigo(codigo);
                    emprestProf.setDataEmprestimo(dataEmprestimo);
                    emprestProf.setDataDevolucao(dataDevolucao);
                    emprestProf.setQuemEmprestou(professorAchado);
                    emprestProf.addExemplar(exemplarAchado);
                    
                    emprestimos.add(emprestProf);
                    
                    qtdExemplares++;
                    
                    int multExemplares = JOptionPane.showConfirmDialog(null, "Adicionar mais algum exemplar?");
                                   
                    while(qtdExemplares<3){
                        if(multExemplares == 0){
                            exemplarAchado = buscaExemplar();
                            emprestProf.addExemplar(exemplarAchado);
                            qtdExemplares++;
                            multExemplares = JOptionPane.showConfirmDialog(null, "Adicionar mais algum exemplar?");
                        }
                        else{
                            break;
                        }
                    }
                    
                    if(qtdExemplares==3){
                        JOptionPane.showConfirmDialog(null, "O número máximo de exemplares por empréstimo é 3");
                    }
                }
                else{
                    funcAchado = funcionariosEmprestimo();
                    exemplarAchado = buscaExemplar();
                    
                    Emprestimo emprestFunc = new Emprestimo();
                    emprestFunc.setCodigo(codigo);
                    emprestFunc.setDataEmprestimo(dataEmprestimo);
                    emprestFunc.setDataDevolucao(dataDevolucao);
                    emprestFunc.setQuemEmprestou(funcAchado);
                    emprestFunc.addExemplar(exemplarAchado);
                    
                    emprestimos.add(emprestFunc);
                    
                    qtdExemplares++;
                    
                    int multExemplares = JOptionPane.showConfirmDialog(null, "Adicionar mais algum exemplar?");
                                   
                    while(qtdExemplares<3){
                        if(multExemplares == 0){
                            exemplarAchado = buscaExemplar();
                            emprestFunc.addExemplar(exemplarAchado);
                            qtdExemplares++;
                            multExemplares = JOptionPane.showConfirmDialog(null, "Adicionar mais algum exemplar?");
                        }
                        else{
                            break;
                        }
                    }
                    
                    if(qtdExemplares==3){
                        JOptionPane.showConfirmDialog(null, "O número máximo de exemplares por empréstimo é 3");
                    }
                    
                }
                
                menuEmprestimo();
            break;

            
            case 1: /*LISTAR EMPRÉSTIMOS*/
                System.out.println("***************** Lista de Empréstimos *****************");
                for(Emprestimo emp : emprestimos){
                    System.out.println("Código: " + emp.getCodigo());
                    System.out.println("Nome: " + emp.getQuemEmprestou().getNome());
                    System.out.println("Data do Empréstimo: " + emp.getDataEmprestimo());
                    System.out.println("Data da Devolução: " + emp.getDataDevolucao());
                    System.out.println("Exemplar(es): ");
                    for(Exemplar e : emp.getLivros()){
                        System.out.println(e.getTitulo());
                    }
                    System.out.println("-------------------------------------------------");
                }
                System.out.println("********************************************************");
                
                menuEmprestimo();
            break;
            
            case 2: /*ATUALIZAR EMPRÉSTIMOS*/
                
            break;
            
            case 3: /*EXCLUIR EMPRÉSTIMOS*/
                
            break;
            
            case 4: /*VOLTAR*/
                menuPrincipal();
            break;
        }
    }
    
    public static void menuExemplar() {
        
        int selected4 = JOptionPane.showOptionDialog(null, "O que deseja fazer a respeito de exemplares?", "Exemplares", 
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, op2, op2[0]);
        
        switch(selected4){
            case 0: /*ADICIONA EXEMPLAR*/
                String isbn = JOptionPane.showInputDialog("Informe o ISBN");               
                String titulo = JOptionPane.showInputDialog("Informe o Título");
                String editora = JOptionPane.showInputDialog("Informe a Editora");
                String autor = JOptionPane.showInputDialog("Informe o (a) Autor(a)");
                String idioma = JOptionPane.showInputDialog("Informe idioma");
                
                Exemplar exemplar = new Exemplar(isbn, titulo, editora, autor, idioma);
                
                exemplares.add(exemplar);
                
                menuExemplar();
            
            case 1: /*LISTA EXEMPLAR*/
                for(Exemplar ex : exemplares){
                    System.out.println("ISBN: " + ex.getIsbn());
                    System.out.println("Título: " + ex.getTitulo());
                    System.out.println("*********************");
                }
                System.out.println("-----------------------------");
                menuExemplar();
            break;
            
            case 2: /*ATUALIZA EXEMPLAR*/
                boolean achadoAtualizaExemplar = false;
                Exemplar exBuscado = new Exemplar();
                isbn = JOptionPane.showInputDialog("Informe o ISBN do exemplar buscado");
                
                for(Exemplar ex : exemplares){
                    if(ex.getIsbn().equals(isbn)){
                        achadoAtualizaExemplar = true;
                        exBuscado = ex;
                    }
                }  
                
                if(achadoAtualizaExemplar){
                    isbn = JOptionPane.showInputDialog("Informe o ISBN");               
                    titulo = JOptionPane.showInputDialog("Informe o Título");
                    editora = JOptionPane.showInputDialog("Informe a Editora");
                    autor = JOptionPane.showInputDialog("Informe o (a) Autor(a)");
                    idioma = JOptionPane.showInputDialog("Informe idioma");
                    exemplares.remove(achadoAtualizaExemplar);
                    
                    Exemplar exemplarAtualizado = new Exemplar(isbn, titulo, editora, autor, idioma);
                
                    exemplares.add(exemplarAtualizado);

                    menuExemplar();
                }
                else{
                    JOptionPane.showConfirmDialog(null, "Não foi encontrado exemplar com o ISBN informado");
                }
            break;
            
            case 3: /*EXCLUIR EXEMPLAR*/
                boolean achadoExemplar = false;
                Exemplar exRemover = new Exemplar();
                isbn = JOptionPane.showInputDialog("Informe o ISBN do exemplar que deseja excluir");
                
                for(Exemplar ex : exemplares){
                    if(ex.getIsbn().equals(isbn)){
                        achadoExemplar = true;
                        exRemover = ex;
                    }
                }       
                
                if(achadoExemplar){
                    exemplares.remove(exRemover);
                }
                else{
                    JOptionPane.showConfirmDialog(null, "Não foi encontrado exemplar com o ISBN informado");
                }
            break;
            
            case 4:
                menuPrincipal();
            break;
        }
    }    
    
    public static void menuAluno() {
        int selected5 = JOptionPane.showOptionDialog(null, "O que deseja fazer a respeito de alunos?", "Alunos", 
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, op2, op2[0]);
        
        
        switch(selected5){
            case 0: /*ADICIONA ALUNO*/
                
                int cpf = Integer.parseInt(JOptionPane.showInputDialog("Informe o CPF"));               
                String nome = JOptionPane.showInputDialog("Informe o Nome");
                String email = JOptionPane.showInputDialog("Informe o E-mail");
                int tel = Integer.parseInt(JOptionPane.showInputDialog("Informe o Telefone"));
                String matricula = JOptionPane.showInputDialog("Informe a Matrícula");
                String curso = JOptionPane.showInputDialog("Informe curso em que está matriculado");
                String dataNasc = JOptionPane.showInputDialog("Informe a data de nascimento");   
                
                Aluno aluno = new Aluno(matricula, curso, dataNasc,cpf, nome, email, tel);
                
                alunos.add(aluno);
                
                menuAluno();
            break;

            
            case 1: /*LISTA ALUNOS*/
                for(Aluno a : alunos){
                    System.out.println("CPF: " + a.getCpf());
                    System.out.println("Nome: " + a.getNome());
                    System.out.println("*********************");
                }
                System.out.println("-----------------------------");
                menuAluno();
            break;
            
            case 2: /*ATUALIZA ALUNO*/
                boolean achadoAtualizaAluno = false;
                Aluno alunoBuscado = new Aluno();
                cpf = Integer.parseInt(JOptionPane.showInputDialog("Informe o CPF do aluno buscado"));
                
                for(Aluno a : alunos){
                    if(a.getCpf() == cpf){
                        achadoAtualizaAluno = true;
                        alunoBuscado = a;
//                        System.out.println("Registro com esse CPF: ");
//                        System.out.println("Nome: " + a.getNome());
                    }
                }
                
                if(achadoAtualizaAluno){
                    cpf = Integer.parseInt(JOptionPane.showInputDialog("Informe o CPF", alunoBuscado.getCpf()));               
                    nome = JOptionPane.showInputDialog("Informe o Nome", alunoBuscado.getNome());
                    email = JOptionPane.showInputDialog("Informe o E-mail", alunoBuscado.getEmail());
                    tel = Integer.parseInt(JOptionPane.showInputDialog("Informe o Telefone", alunoBuscado.getTelefone()));
                    matricula = JOptionPane.showInputDialog("Informe a Matrícula", alunoBuscado.getMatricula());
                    curso = JOptionPane.showInputDialog("Informe curso em que está matriculado", alunoBuscado.getCurso());
                    dataNasc = JOptionPane.showInputDialog("Informe a data de nascimento", alunoBuscado.getDataNasc());   

                    alunos.remove(alunoBuscado);
                    Aluno alunoAtualizado = new Aluno(matricula, curso, dataNasc,cpf, nome, email, tel);

                    alunos.add(alunoAtualizado);
                }
                else{
                    JOptionPane.showConfirmDialog(null, "Não foi encontrado registro com o CPF informado");
                }
                                
                menuAluno();
            break;
            
            case 3: /*EXCLUI ALUNO*/
                boolean achado = false;
                Aluno excluido = new Aluno();
                
                cpf = Integer.parseInt(JOptionPane.showInputDialog("Informe o CPF buscado")); 
                
                for(Aluno a : alunos){
                    if(a.getCpf() == cpf){
                        excluido = a;
                        System.out.println("Nome: " + a.getNome());
                        achado = true;
                    }
                }
                
                if(achado){
                    alunos.remove(excluido);
                }
                else{
                    JOptionPane.showConfirmDialog(null, "Não foi encontrado registro com o CPF informado");
                }
                
                menuAluno();
            break;
            
            case 4: /*VOLTA*/
                menuPrincipal();
            break;
        }
    }
    
    public static void menuProfessor() {
        int selected6 = JOptionPane.showOptionDialog(null, "O que deseja fazer a respeito de professores?", "Professores", 
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, op2, op2[0]);
        
        switch(selected6){
            case 0: /*ADICIONA PROFESSOR*/ 
                int id = Integer.parseInt(JOptionPane.showInputDialog("Informe o ID"));           
                String nome = JOptionPane.showInputDialog("Informe o Nome");
                int cpf = Integer.parseInt(JOptionPane.showInputDialog("Informe o CPF"));      
                String email = JOptionPane.showInputDialog("Informe o E-mail");
                int tel = Integer.parseInt(JOptionPane.showInputDialog("Informe o Telefone"));
                String pis = JOptionPane.showInputDialog("Informe o PIS");   
                
                String status = (String) JOptionPane.showInputDialog(null, "Status do seu cargo como professor",
                "Qual o status?", JOptionPane.QUESTION_MESSAGE, null, sts, sts[0]);
                
                Professor professor = new Professor(id, pis, status, cpf, nome, email, tel);
                
                professores.add(professor);
                
                menuProfessor();                
            break;
            
            case 1: /*LISTA PROFESSOR*/
                for(Professor p : professores){
                    System.out.println("ID: " + p.getId());
                    System.out.println("Nome: " + p.getNome());
                    System.out.println("*********************");
                }
                System.out.println("-----------------------------");
                menuProfessor();
            break;
            
            case 2: /*ATUALIZA PROFESSOR*/
                boolean achouProfessor = false;
                Professor professorBuscado = new Professor();
                id = Integer.parseInt(JOptionPane.showInputDialog("Informe o ID"));  
                
                for(Professor p : professores){
                    if(p.getId() == id){
                        achouProfessor = true;
                        professorBuscado = p;
                        System.out.println("Registro com esse ID: ");
                        System.out.println("Nome: " + p.getNome());
                    }
                }
                
                if(achouProfessor){
                    id = Integer.parseInt(JOptionPane.showInputDialog("Informe o ID", professorBuscado.getId()));  
                    cpf = Integer.parseInt(JOptionPane.showInputDialog("Informe o CPF", professorBuscado.getCpf()));               
                    nome = JOptionPane.showInputDialog("Informe o Nome", professorBuscado.getNome());
                    email = JOptionPane.showInputDialog("Informe o E-mail", professorBuscado.getEmail());
                    tel = Integer.parseInt(JOptionPane.showInputDialog("Informe o Telefone", professorBuscado.getTelefone()));
                    pis = JOptionPane.showInputDialog("Informe o PIS", professorBuscado.getPis());   

                    status = (String) JOptionPane.showInputDialog(null, "Status do seu cargo como professor",
                    "Qual o status?", JOptionPane.QUESTION_MESSAGE, null, sts, sts[0]);

                    professores.remove(professorBuscado);

                    Professor professorAtualizado = new Professor(id, pis, status, cpf, nome, email, tel);

                    professores.add(professorAtualizado);
                }                
                else{
                    JOptionPane.showConfirmDialog(null, "Não foi encontrado registro com o ID informado");
                }
                
                menuProfessor();
            break;
            
            case 3: /*EXCLUI PROFESSOR*/                
                boolean achado = false;
                Professor excluido = new Professor();
                
                id = Integer.parseInt(JOptionPane.showInputDialog("Informe o ID do professor buscado")); 
                
                for(Professor p : professores){
                    if(p.getId() == id){
                        excluido = p;
                        System.out.println("Nome: " + p.getNome());
                        achado = true;
                    }
                }
                
                if(achado){
                    professores.remove(excluido);
                }
                else{
                    JOptionPane.showConfirmDialog(null, "Não foi encontrado registro com o ID informado");
                }
                
                menuProfessor();
            break;
            
            case 4: /*VOLTA*/
                menuPrincipal();
            break;
        }
    }
    
    public static void menuFuncionario() {
        int selected7 = JOptionPane.showOptionDialog(null, "O que deseja fazer a respeito de funcionários?", "Funcionários", 
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, op2, op2[0]);
        
        switch(selected7){
            case 0: /*ADICIONA FUNCIONÁRIO*/ 
                String pis = JOptionPane.showInputDialog("Informe o PIS");            
                String nome = JOptionPane.showInputDialog("Informe o Nome");
                int cpf = Integer.parseInt(JOptionPane.showInputDialog("Informe o CPF"));      
                String email = JOptionPane.showInputDialog("Informe o E-mail");
                int tel = Integer.parseInt(JOptionPane.showInputDialog("Informe o Telefone"));
                String departamento = (String) JOptionPane.showInputDialog(null, "Departamento",
                "Qual o seu departamento?", JOptionPane.QUESTION_MESSAGE, null, depts, depts[0]);
                String cargo = JOptionPane.showInputDialog("Informe o seu cargo");
                
                Funcionario funcionario = new Funcionario(departamento, pis, cargo, cpf, nome, email, tel);
                
                funcionarios.add(funcionario);
                
                menuFuncionario();
            break;
            
            case 1: /*LISTA FUNCIONÁRIO*/
                for(Funcionario f : funcionarios){
                    System.out.println("PIS: " + f.getPis());
                    System.out.println("Nome: " + f.getNome());
                    System.out.println("*********************");
                }
                System.out.println("-----------------------------");
                menuFuncionario();
            break;
            
            case 2: /*ATUALIZA FUNCIONÁRIO*/
                boolean achouFuncionario = false;
                Funcionario funcionarioBuscado = new Funcionario();
                pis = JOptionPane.showInputDialog("Informe o PIS");  
                
                for(Funcionario f : funcionarios){
                    if(f.getPis().equals(pis)){
                        achouFuncionario = true;
                        funcionarioBuscado = f;
                        System.out.println("Registro com esse ID: ");
                        System.out.println("Nome: " + f.getNome());
                    }
                }
                
                if(achouFuncionario){
                    pis = JOptionPane.showInputDialog("Informe o PIS", funcionarioBuscado.getPis());            
                    nome = JOptionPane.showInputDialog("Informe o Nome", funcionarioBuscado.getNome());
                    cpf = Integer.parseInt(JOptionPane.showInputDialog("Informe o CPF", funcionarioBuscado.getCpf()));      
                    email = JOptionPane.showInputDialog("Informe o E-mail", funcionarioBuscado.getEmail());
                    tel = Integer.parseInt(JOptionPane.showInputDialog("Informe o Telefone", funcionarioBuscado.getTelefone()));
                    departamento = (String) JOptionPane.showInputDialog(null, "Departamento",
                    "Qual o seu departamento?", JOptionPane.QUESTION_MESSAGE, null, depts, funcionarioBuscado.getDepartamento());
                    cargo = JOptionPane.showInputDialog("Informe o seu cargo");
                
                    funcionarios.remove(funcionarioBuscado);

                    Funcionario funcionarioAtualizado = new Funcionario(departamento, pis, cargo, cpf, nome, email, tel);

                    funcionarios.add(funcionarioAtualizado);
                }                
                else{
                    JOptionPane.showConfirmDialog(null, "Não foi encontrado registro com o PIS informado");
                }
                
                menuFuncionario();
            break;
            
            case 3: /*EXCLUI FUNCIONÁRIO*/                
                boolean achado = false;
                Funcionario excluido = new Funcionario();
                
                pis = JOptionPane.showInputDialog("Informe o PIS do funcionario buscado"); 
                
                for(Funcionario f : funcionarios){
                    if(f.getPis().equals(pis)){
                        excluido = f;
                        System.out.println("Nome: " + f.getNome());
                        achado = true;
                    }
                }
                
                if(achado){
                    funcionarios.remove(excluido);
                }
                else{
                    JOptionPane.showConfirmDialog(null, "Não foi encontrado registro com o PIS informado");
                }
                
                menuFuncionario();
            break;
            
            case 4: /*VOLTA*/
                menuPrincipal();
            break;
        }
    }
    
    public static Aluno alunosEmprestimo(){
        boolean achouAluno = false;
        Aluno alunoQueQuerEmprestar = new Aluno();
        
        String matriculaBuscada = JOptionPane.showInputDialog("Matrícula do aluno");
        for(Aluno aluno : alunos){
            if(aluno.getMatricula().equals(matriculaBuscada)){
                achouAluno = true;
                alunoQueQuerEmprestar = aluno;
            }                    
        }
        
        if(achouAluno){
            JOptionPane.showConfirmDialog(null, "Nome: " + alunoQueQuerEmprestar.getNome());
        }
        else{
            JOptionPane.showConfirmDialog(null, "Não foi achado um aluno com essa matrícula");
        }
        return alunoQueQuerEmprestar;
    }
    
    public static Professor professoresEmprestimo(){
        boolean achouProf = false;
        Professor profQueQuerEmprestar = new Professor();
        
        int idBuscado = Integer.parseInt(JOptionPane.showInputDialog("ID do professor"));
        for(Professor prof : professores){
            if(prof.getId()==idBuscado){
                achouProf = true;
                profQueQuerEmprestar = prof;
            }                    
        }
        
        if(achouProf){
            JOptionPane.showConfirmDialog(null, "Nome: " + profQueQuerEmprestar.getNome());
        }
        else{
            JOptionPane.showConfirmDialog(null, "Não foi achado um aluno com essa matrícula");
        }
        return profQueQuerEmprestar;
    }
    
    public static Funcionario funcionariosEmprestimo(){
        boolean achouFunc = false;
        Funcionario funcQueQuerEmprestar = new Funcionario();
        
        String pisBuscado = JOptionPane.showInputDialog("PIS do funcionario");
        for(Funcionario func : funcionarios){
            if(func.getPis().equals(pisBuscado)){
                achouFunc = true;
                funcQueQuerEmprestar = func;
            }                    
        }
        
        if(achouFunc){
            JOptionPane.showConfirmDialog(null, "Nome: " + funcQueQuerEmprestar.getNome());
        }
        else{
            JOptionPane.showConfirmDialog(null, "Não foi achado um aluno com essa matrícula");
        }
        return funcQueQuerEmprestar;
    }
    
    public static Exemplar buscaExemplar(){
        boolean achouExemplar = false;
        Exemplar exemplarBuscado = new Exemplar();
        
        String isbnBuscada = JOptionPane.showInputDialog("ISBN do exemplar");
        
        for(Exemplar ex : exemplares){
            if(ex.getIsbn().equals(isbnBuscada)){
                achouExemplar = true;
                exemplarBuscado = ex;
            }
        }
        
        if(achouExemplar){
            JOptionPane.showConfirmDialog(null, exemplarBuscado.getTitulo());
        }
        else{
            JOptionPane.showConfirmDialog(null, "Não foi achado um exemplar com esse ISBN");
        }
        return exemplarBuscado;
    }
}
