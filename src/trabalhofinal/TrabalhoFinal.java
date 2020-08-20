package trabalhofinal;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 * @author nayfr
 */
public class TrabalhoFinal {
    
    ArrayList<Pessoa> alunos = new ArrayList<>();
    ArrayList<Pessoa> funcionarios = new ArrayList<>();
    ArrayList<Pessoa> professores = new ArrayList<>();
    
    ArrayList<Exemplar> exemplares = new ArrayList<>();
    ArrayList<Emprestimo> emprestimos = new ArrayList<>();
    
    static String[] op2 = {"Adicionar", "Listar", "Atualizar", "Excluir", "Voltar"};
    
    public static void main(String[] args) {
        
        menuPrincipal();
    }
    
    public static void menuPrincipal(){
        
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
    
    public static void menuCadastro(){
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
    
    public static void menuEmprestimo(){        
        
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
    
    public static void menuExemplar(){
        
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
    
    public static void menuAluno(){
        int selected5 = JOptionPane.showOptionDialog(null, "O que deseja fazer a respeito de alunos?", "Alunos", 
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, op2, op2[0]);
        
        switch(selected5){
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
    
    public static void menuProfessor(){
        int selected6 = JOptionPane.showOptionDialog(null, "O que deseja fazer a respeito de alunos?", "Alunos", 
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, op2, op2[0]);
        
        switch(selected6){
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
    
    public static void menuFuncionario(){
        int selected7 = JOptionPane.showOptionDialog(null, "O que deseja fazer a respeito de alunos?", "Alunos", 
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, op2, op2[0]);
        
        switch(selected7){
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
}