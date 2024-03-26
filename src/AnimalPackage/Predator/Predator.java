package AnimalPackage.Predator;

import AnimalPackage.Animal;
import AnimalPackage.Herbivore.Herbivore;
import IslandModel.Island;
import IslandModel.Location;

public abstract class Predator extends Animal {

    @Override
    public void eat(Herbivore food) {
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
