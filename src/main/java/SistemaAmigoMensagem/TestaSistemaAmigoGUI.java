package SistemaAmigoMensagem;

import javax.swing.*;

public class TestaSistemaAmigoGUI {

    public static void  main (String[] args){

        SistemaAmigo sistema=new SistemaAmigo();
        JOptionPane.showMessageDialog(null,"ola vamos iniciar o sorteio");
        int quantidadeDeParticipantes=Integer.parseInt(JOptionPane.showInputDialog("digite a quantidade de pessoas que desejam participar de sorteio: "));
        for(int a=0;a<quantidadeDeParticipantes;a++){
            JOptionPane.showMessageDialog(null,"encira as informoes ");
            String nome=JOptionPane.showInputDialog("digite o nome:");
            String emailDaPesosa=JOptionPane.showInputDialog("digite o seu email");
            sistema.cadastraAmigo(nome,emailDaPesosa);
        }
        for(int b=0;b<quantidadeDeParticipantes;b++){
            String emailDaPessoa1=JOptionPane.showInputDialog("digite o email da pesosa que deseja vai ser colocada com seu amigo secreto: ");
            String emailAmigoSorteado = JOptionPane.showInputDialog("digite o email do amigo sorteado: ");
            try {
                sistema.configuraAmigoSecretoDe(emailDaPessoa1,emailAmigoSorteado );
                JOptionPane.showMessageDialog(null, "amigo secreto cadastrado com sucesso");
            }catch (AmigoInexistenteException e ){
                JOptionPane.showMessageDialog(null,e.getMessage());
            }
            JOptionPane.showMessageDialog(null,"a pessoa de email "+emailDaPessoa1+" teve o seu a amigo secreto  sendo a pesosa de email "+emailAmigoSorteado);
        }
        String textoParaTodos = JOptionPane.showInputDialog("escreva o texto que deseja enviar: ");
        String emailRemetente = JOptionPane.showInputDialog("digite o nome do seu email: ");
        String se_e_ou_nao_Anonimo1=JOptionPane.showInputDialog("digite (sim) se for anonima e (não) se não for");
        boolean ehAnonimoTodos;
        if(se_e_ou_nao_Anonimo1.equals("sim")){
            ehAnonimoTodos=true;
        }else{
            ehAnonimoTodos=false;
        }
        sistema.enviarMensagemParaTodos(textoParaTodos, emailRemetente,ehAnonimoTodos );
    }
}
