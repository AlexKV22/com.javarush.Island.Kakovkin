package IslandModel;

import AnimalPackage.Animal;
import AnimalPackage.Herbivore.*;
import AnimalPackage.Predator.*;
import PlantPackage.Plant;

import java.util.ArrayList;

public class Location extends Thread {

  public ArrayList<Animal> animal;
  public ArrayList<Plant> plant;

   public Location() {
      this.animal = new ArrayList<>();
      this.plant = new ArrayList<>();
   }

   public void startCell() {
       for (int i = 0; i < 1; i++) {
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
       for (int i = 0; i < 10; i++) {
           plant.add(new Plant());
       }
   }

    @Override
    public void run() {
        for (Animal animal1 : animal) {
            animal1.move();
            animal1.eat(animal1);
            try {
                animal1.multiple(animal1);
            } catch (CloneNotSupportedException e) {
                throw new RuntimeException(e);
            }
        }

        for (Plant plant1 : plant) {
            try {
                plant1.multiple(plant1);
            } catch (CloneNotSupportedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}





