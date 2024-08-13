package SistemaAnimais;

public class Peixe extends Animal{

    private String corDasEscamas;

    public Peixe(String nomeDaEspecie, String nomeCientifico, String porte, String habitat, String corDasEscamas){
        super( nomeDaEspecie, nomeCientifico,  porte,  habitat, corDasEscamas);
        this.corDasEscamas=corDasEscamas;
    }

    public String getCorDasEscamas() {
        return corDasEscamas;
    }

    public void setCorDasEscamas(String corDasEscamas) {
        this.corDasEscamas = corDasEscamas;
    }
}
