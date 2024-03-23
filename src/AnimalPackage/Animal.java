package AnimalPackage;
import Interfaces.Eatable;

public abstract class Animal implements Eatable {
    private double maxWeigth;
    private int maxCapacity;
    private int maxSpeed;
    private double maxFoodNeeded;
    private int x;
    private int y;

    public int getX() {
        return x;
    }

    public int setX(int x) {
        this.x = x;
        return x;
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

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public double getMaxFoodNeeded() {
        return maxFoodNeeded;
    }

    public void setMaxFoodNeeded(double maxFoodNeeded) {
        this.maxFoodNeeded = maxFoodNeeded;
    }

    public abstract void eat(Object food);

    public abstract void move();

    public abstract void multiple(Animal partner) throws CloneNotSupportedException;

    public abstract void die(Object death);

    public abstract void chooseDirectionAhead(int row);
    public abstract void chooseDirectionReverse(int row);
    public abstract void chooseDirectionLeft(int col);
    public abstract void chooseDirectionRight(int col);


}

