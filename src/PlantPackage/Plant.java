package PlantPackage;

import AnimalPackage.Animal;
import AnimalPackage.Predator.Bear;
import Interfaces.Eatable;
import RandomizePackage.RandomizeClass;
import Settings.Settings;

public class Plant implements Eatable {
    private double maxWeigth;
    private int maxCapacity;
    private int counter = 0;
    private int x;
    private int y;

    public Plant() {
        this.maxWeigth = Settings.MAX_WEIGHT_PLANT;
        this.maxCapacity = Settings.MAX_CAPACITY_PLANT;
        counter++;
        x = RandomizeClass.getRandom(Settings.MIN_ROW_ISLAND,Settings.MAX_ROW_ISLAND);
        y = RandomizeClass.getRandom(Settings.MIN_COL_ISLAND, Settings.MAX_COL_ISLAND);
    }

    public double getMaxWeigth() {
        return maxWeigth;
    }

    public void setMaxWeigth(double maxWeigth) {
        this.maxWeigth = maxWeigth;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void multiple(Plant partner) throws CloneNotSupportedException {
        if (counter < getMaxCapacity() && this.getClass().equals(partner.getClass())) {
            this.clone();
            counter++;
        }
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }
}
