package SistemaAnimais;

import java.util.List;

public class Operacaos {

    private List<Animal>animais;

    public Operacaos(List<Animal> animais) {
        this.animais = animais;
    }

    public void  cadastrarAnimal(Animal animal){
        this.animais.add(animal);
    }

    public String pesquisarAnimalPeloNomeCientifico(String nomeCientifico)throws NaoTemNomeCientificoException{

        for(Animal a: animais){
            if(a.getNomeCientifico().equalsIgnoreCase(nomeCientifico)){
                return a.getNomeDaEspecie();
            }
        }
      throw new NaoTemNomeCientificoException("O animal com o nome cientifico  "+nomeCientifico+" nao esta presente em nosso dados ");
    }

    public int quantidadeDeAves(String classeDoAnimal){
        int conte=0;
        for(Animal b: animais){
            if(b.getClasseDoAnimal().equalsIgnoreCase(classeDoAnimal)){
                conte+=1;
            }
        }
        return conte;
    }
    public int quantidadeDePeixes(String classeDoAnimal) {
        int cont = 0;
        for (Animal b : animais) {
            if (b.getClasseDoAnimal().equalsIgnoreCase(classeDoAnimal)) {
                cont += 1;
            }
        }
        return cont;
    }
}
