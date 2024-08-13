package SistemaAmigoMensagem;

import java.util.ArrayList;
import java.util.List;

public class SistemaAmigo {

    private List<Mensagem> mensagens;
    private List<Amigo> amigos;

    public SistemaAmigo() {
        this.mensagens =new ArrayList<>();
        this.amigos =new ArrayList<>();
    }

    public List<Mensagem> pesquisaMensagensAnonimas() {
        List<Mensagem> mensagensAnonimais = new ArrayList<>();
        for (Mensagem mensagem : mensagens) {
            if (mensagem.ehAnonima()) {
                mensagensAnonimais.add(mensagem);
            }
        }
        return mensagensAnonimais;
    }

    public void configuraAmigoSecretoDe(String emailDaPessoa, String emailAmigoSorteado) throws AmigoInexistenteException {
        for (Amigo amigoEscolido : amigos) {
            if (amigoEscolido.getEmail().equals(emailDaPessoa)) {
                amigoEscolido.setEmailAmigoSorteado(emailAmigoSorteado);
                return;
            }
        }
        throw new AmigoInexistenteException("a pessoa de email " + emailDaPessoa + " não esta cadastrada ");
    }

    public List<Mensagem> pesquisarTodasAsMensagens() {
        List<Mensagem> exibir = new ArrayList<>(mensagens);
        return exibir;
    }

    public String pesquisaAmigoSecretoDe(String emailDaPessoa) throws AmigoInexistenteException, AmigoNaoSorteadoException {
        for (Amigo amigo : amigos) {
            if (amigo.getEmail().equalsIgnoreCase(emailDaPessoa) && amigo.getEmailAmigoSorteado() == null) {
                throw new AmigoNaoSorteadoException("o email do amigo sorteado ainda não foi cadastrado");
            } else if (amigo.getEmail().equalsIgnoreCase(emailDaPessoa)) {
                return amigo.getEmailAmigoSorteado();
            }

        }
        throw new AmigoInexistenteException("a pessoa de email " + emailDaPessoa + " não esta cadastrada");
    }

    public void cadastraAmigo(String nomeAmigo, String emailAmigo) {
        amigos.add(new Amigo(nomeAmigo, emailAmigo));
    }


    public Amigo pesquisaAmigo(String emailAmigo) {
        for (Amigo amigo : amigos) {
            if (amigo.getEmail().equalsIgnoreCase(emailAmigo)) {
                return amigo;
            }
        }
        return null;//TODO
    }

    public void enviarMensagemParaTodos(String texto, String emailRemetente, boolean ehAnonimo) {
        Mensagem mensagemParaTodos = new MensagemParaTodos(texto, emailRemetente, ehAnonimo);
        mensagens.add(mensagemParaTodos);
    }

    public void enviarMensagemParaAlguem(String texto, String emailRemetente, String emailDestinatario, boolean ahAnonimo) {
        Mensagem mensagemParaAlquem = new MensagemParaAlguem(texto, emailRemetente, emailDestinatario, ahAnonimo);
        mensagens.add(mensagemParaAlquem);
    }
}
