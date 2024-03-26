package AnimalPackage.Herbivore;

import AnimalPackage.Animal;
import PlantPackage.Plant;

public abstract class Herbivore extends Animal {
    @Override
    public void eat(Plant food) {
     food = null;
    }

    @Override
    public void move() {
    }

    @Override
    public void multiple(Animal partner) throws CloneNotSupportedException {
    }

    @Override
    public void die(Object death) {
    }

    @Override
    public void chooseDirectionAhead(int row) {
    }

    @Override
    public void chooseDirectionReverse(int row) {
    }

    @Override
    public void chooseDirectionLeft(int col) {
    }

    @Override
    public void chooseDirectionRight(int col) {
    }
}
