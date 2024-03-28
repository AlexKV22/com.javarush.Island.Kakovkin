package IslandModel;

import AnimalPackage.Animal;
import AnimalPackage.Herbivore.*;
import AnimalPackage.Predator.*;
import PlantPackage.Plant;

import java.util.ArrayList;

public class Location extends Thread {

  public ArrayList<Animal> animal;
  public ArrayList<Predator> predators;
  public ArrayList<Herbivore> herbivores;
  public ArrayList<Plant> plant;

   public Location() {
      this.animal = new ArrayList<>();
      this.plant = new ArrayList<>();
      this.predators = new ArrayList<>();
      this.herbivores = new ArrayList<>();
   }

   public void startCell() {
       for (int i = 0; i < 4; i++) {
           animal.add(new Bear());
           animal.add(new Fox());
           animal.add(new Snake());
           animal.add(new Wolf());
           animal.add(new Eagle());
           animal.add(new Boar());
           animal.add(new Buffalo());
           animal.add(new Caterpillar());
           animal.add(new Dear());
           animal.add(new Duck());
           animal.add(new Goat());
           animal.add(new Horse());
           animal.add(new Mouse());
           animal.add(new Rabbit());
           animal.add(new Sheep());
       }
       for (int i = 0; i < 100; i++) {
           plant.add(new Plant());
       }
   }


    public void startLive() {
        for (Animal someAnimal : animal) {

            if (someAnimal != null) {
                someAnimal.move();
            }
                if (someAnimal instanceof Predator) {
                    predators.add((Predator) someAnimal);
                } else {
                    herbivores.add((Herbivore) someAnimal);
                }

                for (Predator predator : predators) {
                    for (Herbivore herbivore : herbivores) {
                        predator.eat(herbivore);
                    }
                }
                for (Herbivore herbivore : herbivores ) {
                    for (Plant plant1 : plant ) {
                        herbivore.eat(plant1);
                    }
                }                                                       //сделать питание определенных классов, типа гусеница у утки
                                                                        //сделать определенное количество циклов
                try {
                    someAnimal.multiple(someAnimal);
                } catch (CloneNotSupportedException e) {
                    throw new RuntimeException(e);
                }
            }


            for(Plant plant1 : plant) {
            try {
                plant1.multiple(plant1);
            } catch (CloneNotSupportedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}




