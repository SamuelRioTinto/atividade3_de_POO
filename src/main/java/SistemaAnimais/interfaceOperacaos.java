package SistemaAnimais;

import java.util.List;


public interface interfaceOperacaos {

    List<Animal> cadastrarAnimal(Animal animais);

    String pesquisarAnimalPeloNomeCientifico(String nomeCientifico)throws NaoTemNomeCientificoException;

    int quantidadeDeAves(String classeDoAnimal);

    int quantidadeDePeixes(String classeDoAnimal);

}
