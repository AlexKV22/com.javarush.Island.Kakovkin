package AnimalPackage.Herbivore;

import AnimalPackage.Animal;
import PlantPackage.Plant;
import RandomizePackage.RandomizeClass;
import Settings.Settings;

import java.util.concurrent.atomic.AtomicInteger;

public class Caterpillar extends Herbivore {
    public static AtomicInteger atomicInteger = new AtomicInteger(0);
    public Caterpillar() {
        setMaxWeigth(Settings.MAX_WEIGHT_CATERPILLAR);
        setMaxCapacity(Settings.MAX_CAPACITY_IN_ONE_CELL_CATERPILLAR);
        setX(RandomizeClass.getRandom(Settings.MIN_ROW_ISLAND,Settings.MAX_ROW_ISLAND));
        setY(RandomizeClass.getRandom(Settings.MIN_COL_ISLAND, Settings.MAX_COL_ISLAND));
        atomicInteger.getAndIncrement();
    }

    @Override
    public void eat(Plant food) {
        if(food.getX() == this.getX() && food.getY() == this.getY() && Plant.atomicInteger.get() > 0) {
            Plant.atomicInteger.getAndDecrement();
            super.eat(food);
        }
    }

    @Override
    public void multiple(Animal partner) throws CloneNotSupportedException {
        if (atomicInteger.get() < getMaxCapacity() && this.getClass().equals(partner.getClass()) && partner.getX() == this.getX() && partner.getY() == this.getY()) {
            this.clone();
            atomicInteger.getAndIncrement();
        }
    }

    @Override
    public void die(Object death) {
        if (death instanceof Caterpillar && getMaxWeigth() <= 0) {
            atomicInteger.getAndDecrement();
            System.out.println("Гусеница, находящаяся в координатах: х - " + getX() + ", y - " + getY() + "умерла от голода :(((");
        }
    }
}
