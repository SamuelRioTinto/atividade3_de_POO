package SistemaAmigoMensagem1;

public class AmigoInexistenteException extends Exception {
    public AmigoInexistenteException() {
        super("Amigo inexistente");
    }
}
