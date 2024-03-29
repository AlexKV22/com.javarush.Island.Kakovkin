package IslandModel;

import AnimalPackage.Herbivore.*;
import AnimalPackage.Predator.*;
import PlantPackage.Plant;

import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantLock;

public class Location extends Thread {

  public ArrayList<Predator> predators;
  public ArrayList<Herbivore> herbivores;
  public ArrayList<Plant> plant;
  public ReentrantLock reentrantLock = new ReentrantLock();

   public Location() {
      this.plant = new ArrayList<>();
      this.predators = new ArrayList<>();
      this.herbivores = new ArrayList<>();
   }

   public void startCell() {
       for (int i = 0; i < 1; i++) {
           predators.add(new Bear());
           predators.add(new Fox());
           predators.add(new Snake());
           predators.add(new Wolf());
           predators.add(new Eagle());
       }
       for (int i = 0; i < 200; i++) {
           plant.add(new Plant());
       }

       for (int i = 0; i < 40; i++) {
           herbivores.add(new Boar());
           herbivores.add(new Buffalo());
           herbivores.add(new Caterpillar());
           herbivores.add(new Dear());
           herbivores.add(new Duck());
           herbivores.add(new Goat());
           herbivores.add(new Horse());
           herbivores.add(new Mouse());
           herbivores.add(new Rabbit());
           herbivores.add(new Sheep());

       }

   }


    public void startLive() {
            reentrantLock.lock();
        for (Predator predator : predators) {
            if (predator != null) {
                predator.move();
            }

            try {
                if(predator != null) {
                    predator.multiple(predator);
                }
            } catch (CloneNotSupportedException e) {
                throw new RuntimeException(e);
            }
        }
        reentrantLock.unlock();


        reentrantLock.lock();
        for (Herbivore herbivore : herbivores ) {
            if (herbivore != null) {
                herbivore.move();
            }

            try {
                if(herbivore != null) {
                    herbivore.multiple(herbivore);
                }
            } catch (CloneNotSupportedException e) {
                throw new RuntimeException(e);
            }
        }
        reentrantLock.unlock();

        reentrantLock.lock();
        for (Predator predator : predators) {
            for (Herbivore herbivore : herbivores) {
                predator.eat(herbivore);
            }
        }
        for (Herbivore herbivore : herbivores ) {
            for (Plant plant1 : plant ) {
                herbivore.eat(plant1);
            }
        }
        reentrantLock.unlock();

            reentrantLock.lock();
            for(Plant plant1 : plant) {
            try {
                plant1.multiple(plant1);
            } catch (CloneNotSupportedException e) {
                throw new RuntimeException(e);
            }
        }
        reentrantLock.unlock();
    }
}




