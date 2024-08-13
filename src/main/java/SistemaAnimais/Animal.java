package SistemaAnimais;

import java.util.Objects;

public class Animal implements ComparasonDeAnimaisPeloNomeCientifico{

    private String nomeDaEspecie;
    private String nomeCientifico;
    private String classeDoAnimal;
    private String porte;
    private String habitat;

    public Animal (String nomeDaEspecie, String nomeCientifico, String classeDoAnimal, String porte, String habitat){
        this.nomeDaEspecie=nomeDaEspecie;
        this.nomeCientifico=nomeCientifico;
        this.classeDoAnimal=classeDoAnimal;
        this.porte=porte;
        this.habitat=habitat;
    }

    public Animal(String nomeDaEspecie, String nomeCientifico, String porte, String habitat){
        this.nomeDaEspecie=nomeDaEspecie;
        this.nomeCientifico=nomeCientifico;
        this.porte=porte;
        this.habitat=habitat;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return Objects.equals(nomeDaEspecie, animal.nomeDaEspecie) && Objects.equals(nomeCientifico, animal.nomeCientifico) && Objects.equals(classeDoAnimal, animal.classeDoAnimal) && Objects.equals(porte, animal.porte) && Objects.equals(habitat, animal.habitat);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nomeDaEspecie, nomeCientifico, classeDoAnimal, porte, habitat);
    }

    @Override
    public int compareTo(Animal o) {
        return this.nomeCientifico.compareTo(o.nomeCientifico);
    }

    public String getNomeDaEspecie() {
        return nomeDaEspecie;
    }

    public void setNomeDaEspecie(String nomeDaEspecie) {
        this.nomeDaEspecie = nomeDaEspecie;
    }

    public String getNomeCientifico() {
        return nomeCientifico;
    }

    public void setNomeCientifico(String nomeCientifico) {
        this.nomeCientifico = nomeCientifico;
    }

    public String getClasseDoAnimal() {
        return classeDoAnimal;
    }

    public void setClasseDoAnimal(String classeDoAnimal) {
        this.classeDoAnimal = classeDoAnimal;
    }

    public String getPorte() {
        return porte;
    }

    public void setPorte(String porte) {
        this.porte = porte;
    }

    public String getHabitat() {
        return habitat;
    }

    public void setHabitat(String habitat) {
        this.habitat = habitat;
    }


}
