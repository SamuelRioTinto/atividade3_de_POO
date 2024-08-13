package SistemaAmigoMensagem1;

public abstract class Mensagem {
    private String texto;
    private boolean anonima;
    private String emailRemetente;

    public Mensagem(String texto, boolean anonima, String emailRemetente) {
        this.texto = texto;
        this.anonima = anonima;
        this.emailRemetente = emailRemetente;
    }

    public String getTexto() {
        return texto;
    }

    public boolean isAnonima() {
        return anonima;
    }

    public String getEmailRemetente() {
        return emailRemetente;
    }

    public abstract String getTextoCompletoAExibir();
}

