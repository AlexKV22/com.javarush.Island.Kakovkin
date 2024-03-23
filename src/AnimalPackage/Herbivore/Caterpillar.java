package AnimalPackage.Herbivore;

import AnimalPackage.Animal;
import PlantPackage.Plant;
import RandomizePackage.RandomizeClass;
import Settings.Settings;

public class Caterpillar extends Herbivore {
    private int counter = 0;
    public Caterpillar() {
        setMaxWeigth(Settings.MAX_WEIGHT_CATERPILLAR);
        setMaxCapacity(Settings.MAX_CAPACITY_IN_ONE_CELL_CATERPILLAR);
        counter++;
        setX(RandomizeClass.getRandom(Settings.MIN_ROW_ISLAND,Settings.MAX_ROW_ISLAND));
        setY(RandomizeClass.getRandom(Settings.MIN_COL_ISLAND, Settings.MAX_COL_ISLAND));
    }

    @Override
    public void eat(Object food) {
        ((Plant) food).setCounter(getCounter() - 1);
        super.eat(food);
    }

    @Override
    public void multiple(Animal partner) throws CloneNotSupportedException {
        if (counter < getMaxCapacity() && this.getClass().equals(partner.getClass())) {
            this.clone();
            counter++;
        }
    }

    @Override
    public void die(Object death) {
        if (death instanceof Caterpillar && getMaxWeigth() <= 0) {
            counter--;
            System.out.println("Гусеница, находящаяся в координатах: х - " + getX() + ", y - " + getY() + "умерла от голода :(((");
        }
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }
}
