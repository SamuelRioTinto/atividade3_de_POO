package SistemaAmigoMensagem1;

import java.util.List;

public class TestaSistemaAmigo {
    public static void main(String[] args) {
        SistemaAmigo sistema = new SistemaAmigo();

        // a) Cadastrar dois amigos
        sistema.cadastraAmigo("José", "jose@example.com");
        sistema.cadastraAmigo("Maria", "maria@example.com");

        // b) Configurar o amigo secreto
        try {
            sistema.configuraAmigoSecretoDe("jose@example.com", "maria@example.com");
            sistema.configuraAmigoSecretoDe("maria@example.com", "jose@example.com");
        } catch (AmigoInexistenteException e) {
            System.out.println(e.getMessage());
        }

        // c) Enviar mensagem anônima de Maria para José
        sistema.enviaMensagem(new MensagemParaAlguem("Olá José!", true, "maria@example.com", "jose@example.com"));

        // d) Enviar mensagem anônima de Maria para todos
        sistema.enviaMensagem(new MensagemParaTodos("Feliz Natal a todos!", true, "maria@example.com"));

        // e) Pesquisar e imprimir mensagens anônimas
        List<Mensagem> mensagensAnonimas = sistema.pesquisaMensagensAnonimas();
        for (Mensagem mensagem : mensagensAnonimas) {
            System.out.println(mensagem.getTextoCompletoAExibir());
        }

        // f) Verificar amigo secreto de José
        try {
            String amigoSecreto = sistema.pesquisaAmigoSecretoDe("jose@example.com");
            if (amigoSecreto.equals("maria@example.com")) {
                System.out.println("Ok");
            }
        } catch (AmigoInexistenteException | AmigoNaoSorteadoException e) {
            System.out.println(e.getMessage());
        }
    }
}