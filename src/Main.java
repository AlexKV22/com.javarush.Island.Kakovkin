import AnimalPackage.Animal;
import AnimalPackage.Herbivore.Buffalo;
import AnimalPackage.Predator.Bear;
import AnimalPackage.Predator.Wolf;
import IslandModel.Island;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        Island island = new Island();
        Animal bear = new Bear();
        System.out.println(bear.getMaxWeigth());
        System.out.println(bear.getX() + " " + bear.getY());
        bear.move();
        System.out.println(bear.getMaxWeigth());
        System.out.println(bear.getX() + " " + bear.getY());
        bear.move();
        System.out.println(bear.getMaxWeigth());
        System.out.println(bear.getX() + " " + bear.getY());
        bear.move();
        System.out.println(bear.getMaxWeigth());
        System.out.println(bear.getX() + " " + bear.getY());
        bear.move();
        System.out.println(bear.getMaxWeigth());
        System.out.println(bear.getX() + " " + bear.getY());

    }
}