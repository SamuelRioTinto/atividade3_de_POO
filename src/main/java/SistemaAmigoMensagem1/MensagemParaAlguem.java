package SistemaAmigoMensagem1;

public class MensagemParaAlguem extends Mensagem {
    private String emailDestinatario;

    public MensagemParaAlguem(String texto, boolean anonima, String emailRemetente, String emailDestinatario) {
        super(texto, anonima, emailRemetente);
        this.emailDestinatario = emailDestinatario;
    }

    @Override
    public String getTextoCompletoAExibir() {
        if (isAnonima()) {
            return "Mensagem para " + emailDestinatario + ". Texto: " + getTexto();
        } else {
            return "Mensagem de: " + getEmailRemetente() + " para " + emailDestinatario + ". Texto: " + getTexto();
        }
    }
}

