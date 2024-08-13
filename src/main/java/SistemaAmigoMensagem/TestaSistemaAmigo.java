package SistemaAmigoMensagem;

import javax.swing.*;
import java.util.List;

public class TestaSistemaAmigo {

    public static void main(String[] args)  {

        SistemaAmigo sistema = new SistemaAmigo();
        boolean continuar = true;
        while (continuar) {
            String opcao = JOptionPane.showInputDialog("digite uma das opção:\n1.cadastrar amigo\n2.para conficurar amigo secreto de uma pessoa\n3.enviar uma mensagen \n4.pesquisar todas as mensagens anonimais\n5.pesquisar email do seu amigo secreto\n6.sair ");
            if(opcao.equals("1")) {
                String nome = JOptionPane.showInputDialog("digite o seu nome: ");
                String emailDaPessoa = JOptionPane.showInputDialog("digite o seu email: ");
                sistema.cadastraAmigo(nome, emailDaPessoa);
            }else if (opcao.equals("2")) {
                String emailDaPessoa1=JOptionPane.showInputDialog("digite o email da pesosa que deseja vai ser colocada com seu amigo secreto: ");
                String emailAmigoSorteado = JOptionPane.showInputDialog("digite o email do amigo sorteado: ");
                try {
                    sistema.configuraAmigoSecretoDe(emailDaPessoa1,emailAmigoSorteado );
                    JOptionPane.showMessageDialog(null, "amigo secreto cadastrado com sucesso");
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null,e.getMessage());
                }
            }else if (opcao.equals("3")) {
                String tipoDaMensagem = JOptionPane.showInputDialog("escolha a opção :\n1. mensagem par todos\n2.mensagem para alquem");
                if (tipoDaMensagem.equals("1")) {
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
                } else if (tipoDaMensagem.equals("2")) {
                    String textoParaAlquem = JOptionPane.showInputDialog("digite o texto que voce dezeja enviar para alquem: ");
                    String emailRemetente1 = JOptionPane.showInputDialog("digite o seu email: ");
                    String emailDestinatario = JOptionPane.showInputDialog("digite o email da pessoa que voce deseja enviar uma mensagem:");
                    String se_e_ou_nao_Anonimo=JOptionPane.showInputDialog("digite (sim) se for anonima e (não) se não for ");
                    boolean ehAnonimoAlquem;
                    if(se_e_ou_nao_Anonimo.equals("sim")){
                        ehAnonimoAlquem=true;
                    }else{
                        ehAnonimoAlquem=false;
                    }
                    sistema.enviarMensagemParaAlguem(textoParaAlquem, emailRemetente1, emailDestinatario,ehAnonimoAlquem );
                }

            } else if (opcao.equals("4")) {
                List<Mensagem>listaDeMensagensAnonimais=sistema.pesquisaMensagensAnonimas();
                for(Mensagem mensagem : listaDeMensagensAnonimais){
                    JOptionPane.showMessageDialog(null,mensagem.getTextoCompletoAExibir());
                }
            } else if (opcao.equals("5")) {
                String emailDaPessoa = JOptionPane.showInputDialog("diigte o email da Pessoa para descobri seu amigo secreto: ");
                String emailComparacao = JOptionPane.showInputDialog("digite o email da pessoa que voce deseja vericar se o amigo secreto o email que voce digitou antes: ");
                try {
                    String paraComparacao = sistema.pesquisaAmigoSecretoDe(emailDaPessoa);
                    if (paraComparacao.equals(emailComparacao)) {
                        JOptionPane.showMessageDialog(null, "ok a pesosa de email " + emailComparacao + " amigo secreto da pessoa de email " + emailDaPessoa);
                    }
                } catch (AmigoInexistenteException |AmigoNaoSorteadoException e) {
                    JOptionPane.showMessageDialog(null,e.getMessage());
                }
            } else if (opcao.equals("6")) {
                continuar = false;
                JOptionPane.showMessageDialog(null, "O programa foi encerado");
            }

        }
    }
}






