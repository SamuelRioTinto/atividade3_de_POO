package SistemaAmigoMensagem1;

public class MensagemParaTodos extends Mensagem {

    public MensagemParaTodos(String texto, boolean anonima, String emailRemetente) {
        super(texto, anonima, emailRemetente);
    }

    @Override
    public String getTextoCompletoAExibir() {
        if (isAnonima()) {
            return "Mensagem para todos. Texto: " + getTexto();
        } else {
            return "Mensagem de " + getEmailRemetente() + " para todos. Texto: " + getTexto();
        }
    }
}

