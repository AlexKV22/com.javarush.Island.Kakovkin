package AnimalPackage;
import AnimalPackage.Herbivore.Herbivore;
import AnimalPackage.Predator.Predator;
import Interfaces.Eatable;
import PlantPackage.Plant;
import RandomizePackage.RandomizeClass;
import Settings.Settings;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;


public abstract class Animal implements Eatable {
    private double maxWeigth;
    private int maxCapacity;
    private double maxFoodNeeded;
    private int x;
    private int y;

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

    public double getMaxWeigth() {
        return maxWeigth;
    }

    public void setMaxWeigth(double maxWeigth) {
        this.maxWeigth = maxWeigth;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public double getMaxFoodNeeded() {
        return maxFoodNeeded;
    }

    public void setMaxFoodNeeded(double maxFoodNeeded) {
        this.maxFoodNeeded = maxFoodNeeded;
    }

    public void eat(Plant food) {
    }

    public void eat(Herbivore food) {
    }

    public abstract void move();

    public abstract void multiple(Animal partner) throws CloneNotSupportedException;

    public abstract void die(Object death);

    public abstract void chooseDirectionAhead(int row);
    public abstract void chooseDirectionReverse(int row);
    public abstract void chooseDirectionLeft(int col);
    public abstract void chooseDirectionRight(int col);


}

