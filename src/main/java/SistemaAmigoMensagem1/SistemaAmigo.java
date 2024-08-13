package SistemaAmigoMensagem1;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SistemaAmigo {
    private List<Amigo> amigos;
    private List<Mensagem> mensagens;

    public SistemaAmigo() {
        this.amigos = new ArrayList<>();
        this.mensagens = new ArrayList<>();
    }

    public void cadastraAmigo(String nome, String email) {
        amigos.add(new Amigo(nome, email));
    }

    public void enviaMensagem(Mensagem mensagem) {
        mensagens.add(mensagem);
    }

    public List<Mensagem> pesquisaMensagensAnonimas() {
        return mensagens.stream()
                .filter(Mensagem::isAnonima)
                .collect(Collectors.toList());
    }

    public void configuraAmigoSecretoDe(String emailDaPessoa, String emailAmigoSorteado) throws AmigoInexistenteException {
        Amigo amigo = amigos.stream()
                .filter(a -> a.getEmail().equals(emailDaPessoa))
                .findFirst()
                .orElseThrow(AmigoInexistenteException::new);
        amigo.setEmailAmigoSecreto(emailAmigoSorteado);
    }

    public List<Mensagem> pesquisaTodasAsMensagens() {
        return new ArrayList<>(mensagens);
    }

    public String pesquisaAmigoSecretoDe(String emailDaPessoa) throws AmigoInexistenteException, AmigoNaoSorteadoException {
        Amigo amigo = amigos.stream()
                .filter(a -> a.getEmail().equals(emailDaPessoa))
                .findFirst()
                .orElseThrow(AmigoInexistenteException::new);
        String emailAmigoSecreto = amigo.getEmailAmigoSecreto();
        if (emailAmigoSecreto == null) {
            throw new AmigoNaoSorteadoException();
        }
        return emailAmigoSecreto;
    }

    public void sortear() {
        List<Amigo> naoSorteados = new ArrayList<>(amigos);
        for (Amigo amigo : amigos) {
            int posicaoSorteada = (int) (Math.random() * naoSorteados.size());
            Amigo amigoSorteado = naoSorteados.get(posicaoSorteada);
            while (amigoSorteado.getEmail().equals(amigo.getEmail())) {
                posicaoSorteada = (int) (Math.random() * naoSorteados.size());
                amigoSorteado = naoSorteados.get(posicaoSorteada);
            }
            amigo.setEmailAmigoSecreto(amigoSorteado.getEmail());
            naoSorteados.remove(posicaoSorteada);
        }
    }

    public List<Amigo> getAmigos() {
        return new ArrayList<>(amigos);
    }
}

