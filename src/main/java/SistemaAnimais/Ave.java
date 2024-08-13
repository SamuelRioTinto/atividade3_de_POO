package SistemaAnimais;

public class Ave extends Animal{

    private  String corDaPlumagen;
    private double invergaduraDasAssas;

    public Ave(String nomeDaEspecie, String nomeCientifico, String porte, String habitat, String corDaPlumagen, double invergaduraDasAssas) {
        super(nomeDaEspecie, nomeCientifico, porte, habitat);
        this.corDaPlumagen=corDaPlumagen;
        this.invergaduraDasAssas=invergaduraDasAssas;
    }

    public String getCorDaPlumagen() {
        return corDaPlumagen;
    }

    public void setCorDaPlumagen(String corDaPlumagen) {
        this.corDaPlumagen = corDaPlumagen;
    }

    public double getInvergaduraDasAssas() {
        return invergaduraDasAssas;
    }

    public void setInvergaduraDasAssas(double invergaduraDasAssas) {
        this.invergaduraDasAssas = invergaduraDasAssas;
    }
}
