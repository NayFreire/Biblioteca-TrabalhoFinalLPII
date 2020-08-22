package trabalhofinal;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
            case 0:
                
            break;
            
            case 1:
                
            break;
            
            case 2:
                
            break;
            
            case 3:
                
            break;
            
            case 4:
                menuPrincipal();
            break;
        }
    }
    
    public static void menuExemplar() {
        
        int selected4 = JOptionPane.showOptionDialog(null, "O que deseja fazer a respeito de exemplares?", "Exemplares", 
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, op2, op2[0]);
        
        switch(selected4){
            case 0:
                
            break;
            
            case 1:
                
            break;
            
            case 2:
                
            break;
            
            case 3:
                
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
        int selected7 = JOptionPane.showOptionDialog(null, "O que deseja fazer a respeito de alunos?", "Alunos", 
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
                    System.out.println("ID: " + f.getPis());
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
                    if(f.getPis() == pis){
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
                
                menuProfessor();
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
}
