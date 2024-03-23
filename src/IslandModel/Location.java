package IslandModel;

import AnimalPackage.Animal;
import AnimalPackage.Predator.Bear;
import PlantPackage.Plant;

import java.util.ArrayList;

public class Location {

  public ArrayList<Animal> animal = new ArrayList<>();
   public Plant plant;

   public Location() {
      this.animal = animal;
      this.plant = plant;
   }
   public void entry() {
       animal.add(new Bear());
       for (Animal animaly: animal) {
           System.out.println(animaly.getMaxCapacity());
           System.out.println(animaly.getX() + " " + animaly.getY());
           animaly.move();
           System.out.println(animaly.getX() + " " + animaly.getY());
           System.out.println(animaly.getMaxWeigth());
       }
   }
}





//Локация является многопоточной, я буду загружать в локации животных и траву, и буду запускать многопоточно методы каждого животного.
