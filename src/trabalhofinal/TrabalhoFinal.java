package trabalhofinal;

import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 * @author nayfr
 */
public class TrabalhoFinal {
    
    /*LISTAS DOS ELEMENTOS PRINCIPAIS DO PROJETO*/
    static ArrayList<Aluno> alunos = new ArrayList<>();
    static ArrayList<Funcionario> funcionarios = new ArrayList<>();
    static ArrayList<Professor> professores = new ArrayList<>();    
    static ArrayList<Exemplar> exemplares = new ArrayList<>();
    static ArrayList<Emprestimo> emprestimos = new ArrayList<>();
    
    /*ARRAYS USADOS NOS JOPTIONPANE'S DOS MENUS*/
    static String[] op2 = {"Adicionar", "Listar", "Atualizar", "Excluir", "Voltar"};
    static String[] sts = {"Contratado", "Substituto"};
    static String[] depts = {"Administrativo", "Comunicação", "Gestão de Pessoas", "Limpeza/Cozinha", "Financeiro"};
    static String[] quemE = {"Aluno", "Professor", "Funcionario"};
    
    /*VARIÁVEIS UTILIZADAS NO CÓDIGO DO EMPRÉSTIMO*/
    static String codigoTxt = "EMP2020000";
    static int cod;
        
    public static void main(String[] args)  {        
        menuPrincipal();
    }
    
    public static void menuPrincipal() {
        
        String[] op1 = {"Cadastros", "Emprestimos", "Exemplares", "Devoluções"};
        
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
            case 3:
                menuDevolucao();
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
                fazerEmprestimo();                
                menuEmprestimo();
            break;

            
            case 1: /*LISTAR EMPRÉSTIMOS*/                
                listarEmprestimos();
                menuEmprestimo();
            break;
            
            case 2: /*RENOVAR EMPRÉSTIMOS*/
                renovarEmprestimos();
                listarEmprestimos();
                menuEmprestimo();
            break;
            
            case 3: /*EXCLUIR EMPRÉSTIMOS*/
                excluirEmprestimos();
                listarEmprestimos();
                menuEmprestimo();
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
                addExemplares();
                menuExemplar();
            
            case 1: /*LISTA EXEMPLAR*/
                listarExemplares();
                menuExemplar();
            break;
            
            case 2: /*ATUALIZA EXEMPLAR*/
                atualizarExemplares();
                listarExemplares();
                menuExemplar();
            break;
            
            case 3: /*EXCLUIR EXEMPLAR*/
                excluirExemplares();
                listarExemplares();
                menuExemplar();
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
                addAlunos();
                menuAluno();
            break;

            
            case 1: /*LISTA ALUNOS*/
                listarAlunos();
                menuAluno();
            break;
            
            case 2: /*ATUALIZA ALUNO*/
                atualizarAlunos(); 
                listarAlunos();
                menuAluno();
            break;
            
            case 3: /*EXCLUI ALUNO*/
                excluirAlunos();
                listarAlunos();
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
                addProfessores();
                menuProfessor();                
            break;
            
            case 1: /*LISTA PROFESSOR*/
                listarProfessores();
                menuProfessor();
            break;
            
            case 2: /*ATUALIZA PROFESSOR*/
                atulizarProfessores();
                listarProfessores();
                menuProfessor();
            break;
            
            case 3: /*EXCLUI PROFESSOR*/               
                excluirProfessores();
                listarProfessores();
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
                addFuncionarios();
                menuFuncionario();
            break;
            
            case 1: /*LISTA FUNCIONÁRIO*/
                listarFuncionarios();
                menuFuncionario();
            break;
            
            case 2: /*ATUALIZA FUNCIONÁRIO*/
                atualizarFuncionarios();
                listarFuncionarios();
                menuFuncionario();
            break;
            
            case 3: /*EXCLUI FUNCIONÁRIO*/                
                excluirFuncionarios();
                listarFuncionarios();
                menuFuncionario();
            break;
            
            case 4: /*VOLTA*/
                menuPrincipal();
            break;
        }
    }
    
    public static void menuDevolucao(){
        Emprestimo devolucao = new Emprestimo();
        devolucao.devolverLivros();        
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
    
    public static void fazerEmprestimo(){
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

        if(quemEstaFazendoEmp.equals("Aluno")){                    
            alunoAchado = alunosEmprestimo();
            exemplarAchado = buscaExemplar();   

            Emprestimo emprestAluno = new Emprestimo();
            emprestAluno.setCodigo(codigo);
            emprestAluno.setDataEmprestimo(dataEmprestimo);
            emprestAluno.definirDataDeDevolucao();
            emprestAluno.setQuemEmprestou(alunoAchado);
            emprestAluno.addExemplar(exemplarAchado);

            emprestimos.add(emprestAluno);
            exemplares.remove(exemplarAchado);

            qtdExemplares++;

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
            emprestProf.definirDataDeDevolucao();
            emprestProf.setQuemEmprestou(professorAchado);
            emprestProf.addExemplar(exemplarAchado);

            emprestimos.add(emprestProf);
            exemplares.remove(exemplarAchado);

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
            emprestFunc.definirDataDeDevolucao();
            emprestFunc.setQuemEmprestou(funcAchado);
            emprestFunc.addExemplar(exemplarAchado);

            emprestimos.add(emprestFunc);
            exemplares.remove(exemplarAchado);

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
    }
    
    public static void listarEmprestimos(){
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
    }
    
    public static void renovarEmprestimos(){
        String codEmp = JOptionPane.showInputDialog("Informe o código do empréstimo");
        for(Emprestimo e : emprestimos){
            if(e.getCodigo().equals(codEmp)){
                int attDataEmp = JOptionPane.showConfirmDialog(null, "Atualizar a Data de Devolução?");
                if(attDataEmp==0){
                    e.definirDataDeDevolucao();
                }                        
            }
        }
    }
    
    public static void excluirEmprestimos(){
        Emprestimo excluido = new Emprestimo();
        int excluirEmp=-1;
        String codEmp = JOptionPane.showInputDialog("Informe o código do empréstimo");
        for(Emprestimo e : emprestimos){
            if(e.getCodigo().equals(codEmp)){
                excluirEmp = JOptionPane.showConfirmDialog(null, "Certeza que você deseja excluir esse registro?");
                excluido = e;
            }
        }
        
        if(excluirEmp==0){
            emprestimos.remove(excluido);
        }
    }
    
    public static void addExemplares(){
        String isbn = JOptionPane.showInputDialog("Informe o ISBN");               
        String titulo = JOptionPane.showInputDialog("Informe o Título");
        String editora = JOptionPane.showInputDialog("Informe a Editora");
        String autor = JOptionPane.showInputDialog("Informe o (a) Autor(a)");
        String idioma = JOptionPane.showInputDialog("Informe idioma");

        Exemplar exemplar = new Exemplar(isbn, titulo, editora, autor, idioma);

        exemplares.add(exemplar);                
    }
    
    public static void listarExemplares(){
        System.out.println("**************** Lista de Exemplares (\"****************");
        for(Exemplar ex : exemplares){
            System.out.println("\tISBN: " + ex.getIsbn());
            System.out.println("\tTítulo: " + ex.getTitulo());
            System.out.println("\tAutor(a)" + ex.getAutor());
            System.out.println("\tEditora: " + ex.getEditora());
            System.out.println("\tIdioma: " + ex.getIdioma());
            System.out.println("-------------------------");
        }
        System.out.println("********************************************************");
    }
    
    public static void atualizarExemplares(){
        boolean achadoAtualizaExemplar = false;
        Exemplar exBuscado = new Exemplar();
        String isbn = JOptionPane.showInputDialog("Informe o ISBN do exemplar buscado");

        for(Exemplar ex : exemplares){
            if(ex.getIsbn().equals(isbn)){
                achadoAtualizaExemplar = true;
                exBuscado = ex;
            }
        }  

        if(achadoAtualizaExemplar){
            isbn = JOptionPane.showInputDialog("Informe o ISBN");               
            String titulo = JOptionPane.showInputDialog("Informe o Título");
            String editora = JOptionPane.showInputDialog("Informe a Editora");
            String autor = JOptionPane.showInputDialog("Informe o (a) Autor(a)");
            String idioma = JOptionPane.showInputDialog("Informe idioma");

            exemplares.remove(exBuscado);

            Exemplar exemplarAtualizado = new Exemplar(isbn, titulo, editora, autor, idioma);

            exemplares.add(exemplarAtualizado);

            menuExemplar();
        }
        else{
            JOptionPane.showConfirmDialog(null, "Não foi encontrado exemplar com o ISBN informado");
        }
    }
    
    public static void excluirExemplares(){
        boolean achadoExemplar = false;
        Exemplar exRemover = new Exemplar();
        String isbn = JOptionPane.showInputDialog("Informe o ISBN do exemplar que deseja excluir");
        int excluirEmp=-1;
        
        for(Exemplar ex : exemplares){
            if(ex.getIsbn().equals(isbn)){
                excluirEmp = JOptionPane.showConfirmDialog(null, "Certeza que você deseja excluir esse registro?");
                achadoExemplar = true;
                exRemover = ex;
            }
        }       

        if(achadoExemplar){
            if(excluirEmp==0){
                exemplares.remove(exRemover);
            }            
        }
        else{
            JOptionPane.showConfirmDialog(null, "Não foi encontrado exemplar com o ISBN informado");
        }
    }
    
    public static void addAlunos(){        
        int cpf = Integer.parseInt(JOptionPane.showInputDialog("Informe o CPF"));               
        String nome = JOptionPane.showInputDialog("Informe o Nome");
        String email = JOptionPane.showInputDialog("Informe o E-mail");
        int tel = Integer.parseInt(JOptionPane.showInputDialog("Informe o Telefone"));
        String matricula = JOptionPane.showInputDialog("Informe a Matrícula");
        String curso = JOptionPane.showInputDialog("Informe curso em que está matriculado");
        String dataNasc = JOptionPane.showInputDialog("Informe a data de nascimento");   

        Aluno aluno = new Aluno(matricula, curso, dataNasc,cpf, nome, email, tel);

        alunos.add(aluno);
    }
    
    public static void atualizarAlunos(){
        boolean achadoAtualizaAluno = false;
        Aluno alunoBuscado = new Aluno();
        int cpf = Integer.parseInt(JOptionPane.showInputDialog("Informe o CPF do aluno buscado"));

        for(Aluno a : alunos){
            if(a.getCpf() == cpf){
                achadoAtualizaAluno = true;
                alunoBuscado = a;
            }
        }

        if(achadoAtualizaAluno){
            cpf = Integer.parseInt(JOptionPane.showInputDialog("Informe o CPF", alunoBuscado.getCpf()));               
            String nome = JOptionPane.showInputDialog("Informe o Nome", alunoBuscado.getNome());
            String email = JOptionPane.showInputDialog("Informe o E-mail", alunoBuscado.getEmail());
            int tel = Integer.parseInt(JOptionPane.showInputDialog("Informe o Telefone", alunoBuscado.getTelefone()));
            String matricula = JOptionPane.showInputDialog("Informe a Matrícula", alunoBuscado.getMatricula());
            String curso = JOptionPane.showInputDialog("Informe curso em que está matriculado", alunoBuscado.getCurso());
            String dataNasc = JOptionPane.showInputDialog("Informe a data de nascimento", alunoBuscado.getDataNasc());   

            alunos.remove(alunoBuscado);
            Aluno alunoAtualizado = new Aluno(matricula, curso, dataNasc,cpf, nome, email, tel);

            alunos.add(alunoAtualizado);
        }
        else{
            JOptionPane.showConfirmDialog(null, "Não foi encontrado registro com o CPF informado");
        }
    }
    
    public static void listarAlunos(){
        System.out.println("***************** Lista de Alunos *****************");
        for(Aluno a : alunos){
            System.out.println("\tCPF: " + a.getCpf());
            System.out.println("\tNome: " + a.getNome());
            System.out.println("\tMatrítcula: " + a.getMatricula());
            System.out.println("\tCurso: " + a.getCurso());
            System.out.println("\tData de Nascimento: " + a.getDataNasc());
            System.out.println("\tE-mail: " + a.getEmail());
            System.out.println("\tTelefone: " + a.getTelefone());
            System.out.println("-------------------------------------------");
        }
        System.out.println("***************************************************");
    }
    
    public static void excluirAlunos(){
        boolean achado = false;
        Aluno excluido = new Aluno();

        int cpf = Integer.parseInt(JOptionPane.showInputDialog("Informe o CPF buscado")); 
        int excluirAluno = -1;
        for(Aluno a : alunos){
            if(a.getCpf() == cpf){
                excluirAluno = JOptionPane.showConfirmDialog(null, "Certeza que você deseja excluir esse registro?");
                excluido = a;
                achado = true;
            }
        }

        if(achado){
            if(excluirAluno==0){
                alunos.remove(excluido);
            }            
        }
        else{
            JOptionPane.showConfirmDialog(null, "Não foi encontrado registro com o CPF informado");
        }
    }
    
    public static void addProfessores(){
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
    }
    
    public static void listarProfessores(){
        System.out.println("****************** Lista de Professores ******************");
        for(Professor p : professores){
            System.out.println("\tID: " + p.getId());
            System.out.println("\tNome: " + p.getNome());
            System.out.println("\tCPF: " + p.getCpf());
            System.out.println("\tPIS: " + p.getPis());
            System.out.println("\tE-mail: " + p.getEmail());
            System.out.println("\tTelefone: " + p.getTelefone());
            System.out.println("\tStatus: " + p.getStatus());
            System.out.println("------------------------------------------");
        }
        System.out.println("**********************************************************");
    }
    
    public static void atulizarProfessores(){
        boolean achouProfessor = false;
        Professor professorBuscado = new Professor();
        int id = Integer.parseInt(JOptionPane.showInputDialog("Informe o ID"));  

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
            int cpf = Integer.parseInt(JOptionPane.showInputDialog("Informe o CPF", professorBuscado.getCpf()));               
            String nome = JOptionPane.showInputDialog("Informe o Nome", professorBuscado.getNome());
            String email = JOptionPane.showInputDialog("Informe o E-mail", professorBuscado.getEmail());
            int tel = Integer.parseInt(JOptionPane.showInputDialog("Informe o Telefone", professorBuscado.getTelefone()));
            String pis = JOptionPane.showInputDialog("Informe o PIS", professorBuscado.getPis());   

            String status = (String) JOptionPane.showInputDialog(null, "Status do seu cargo como professor",
            "Qual o status?", JOptionPane.QUESTION_MESSAGE, null, sts, sts[0]);

            professores.remove(professorBuscado);

            Professor professorAtualizado = new Professor(id, pis, status, cpf, nome, email, tel);

            professores.add(professorAtualizado);
        }                
        else{
            JOptionPane.showConfirmDialog(null, "Não foi encontrado registro com o ID informado");
        }
    }
    
    public static void excluirProfessores(){
        boolean achado = false;
        Professor excluido = new Professor();

        int id = Integer.parseInt(JOptionPane.showInputDialog("Informe o ID do professor buscado")); 
        int excluirProf = -1;
        for(Professor p : professores){
            if(p.getId() == id){
                excluirProf = JOptionPane.showConfirmDialog(null, "Certeza que você deseja excluir esse registro?");
                excluido = p;
                achado = true;
            }
        }

        if(achado){
            if(excluirProf==0){
                professores.remove(excluido);
            }            
        }
        else{
            JOptionPane.showConfirmDialog(null, "Não foi encontrado registro com o ID informado");
        }
    }
    
    public static void addFuncionarios(){
        String pis = JOptionPane.showInputDialog("Informe o PIS");            
        String nome = JOptionPane.showInputDialog("Informe o Nome");
        int cpf = Integer.parseInt(JOptionPane.showInputDialog("Informe o CPF"));      
        String email = JOptionPane.showInputDialog("Informe o E-mail");
        int tel = Integer.parseInt(JOptionPane.showInputDialog("Informe o Telefone"));
        String departamento = (String) JOptionPane.showInputDialog(null, "Departamento",
        "Qual o seu departamento?", JOptionPane.QUESTION_MESSAGE, null, depts, depts[0]);
        String cargo = JOptionPane.showInputDialog("Informe o seu cargo");

        Funcionario funcionario = new Funcionario(departamento, pis, cargo, cpf, nome, email, tel);
        funcionario.definirHorario();

        funcionarios.add(funcionario);
    }
    
    public static void listarFuncionarios(){
        System.out.println("********************** Lista de Funcionarios **********************");
        for(Funcionario f : funcionarios){
            System.out.println("\tPIS: " + f.getPis());
            System.out.println("\tNome: " + f.getNome());
            System.out.println("\tCPF: " + f.getCpf());
            System.out.println("\tE-mail: " + f.getEmail());
            System.out.println("\tTelefone: " + f.getTelefone());
            System.out.println("\tDepartamento: " + f.getDepartamento());
            System.out.println("\tHora de Entrada: " + f.getEntrada());
            System.out.println("\tHora de Saída: " + f.getSaida());
            System.out.println("-----------------------------------------------");
        }
        System.out.println("********************************************************************");
    }
    
    public static void atualizarFuncionarios(){
        boolean achouFuncionario = false;
        Funcionario funcionarioBuscado = new Funcionario();
        String pis = JOptionPane.showInputDialog("Informe o PIS");  

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
            String nome = JOptionPane.showInputDialog("Informe o Nome", funcionarioBuscado.getNome());
            int cpf = Integer.parseInt(JOptionPane.showInputDialog("Informe o CPF", funcionarioBuscado.getCpf()));      
            String email = JOptionPane.showInputDialog("Informe o E-mail", funcionarioBuscado.getEmail());
            int tel = Integer.parseInt(JOptionPane.showInputDialog("Informe o Telefone", funcionarioBuscado.getTelefone()));
            String departamento = (String) JOptionPane.showInputDialog(null, "Departamento",
            "Qual o seu departamento?", JOptionPane.QUESTION_MESSAGE, null, depts, funcionarioBuscado.getDepartamento());
            String cargo = JOptionPane.showInputDialog("Informe o seu cargo");
            
            funcionarios.remove(funcionarioBuscado);

            Funcionario funcionarioAtualizado = new Funcionario(departamento, pis, cargo, cpf, nome, email, tel);
            funcionarioAtualizado.definirHorario();
            
            funcionarios.add(funcionarioAtualizado);
        }                
        else{
            JOptionPane.showConfirmDialog(null, "Não foi encontrado registro com o PIS informado");
        }
    }
    
    public static void excluirFuncionarios(){
        boolean achado = false;
        Funcionario excluido = new Funcionario();

        String pis = JOptionPane.showInputDialog("Informe o PIS do funcionario buscado"); 
        int excluirFunc = -1;
        
        for(Funcionario f : funcionarios){
            if(f.getPis().equals(pis)){
                excluirFunc = JOptionPane.showConfirmDialog(null, "Certeza que você deseja excluir esse registro?");
                excluido = f;
                achado = true;
            }
        }

        if(achado){
            if(excluirFunc==0){
                funcionarios.remove(excluido);
            }
        }
        else{
            JOptionPane.showConfirmDialog(null, "Não foi encontrado registro com o PIS informado");
        }                
    }
}
