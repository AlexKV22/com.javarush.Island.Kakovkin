package PlantPackage;

import AnimalPackage.Animal;
import AnimalPackage.Predator.Bear;
import Interfaces.Eatable;

public class Plant implements Eatable {
    private double maxWeigth;
    private int maxCapacity;
    private static int counter = 0;

    public Plant() {
        this.maxWeigth = 1;
        this.maxCapacity = 200;
        counter++;
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

    public void multiple(Animal partner) throws CloneNotSupportedException {
        if (Plant.counter < getMaxCapacity() && this.getClass().equals(partner.getClass())) {
            this.clone();
            Plant.counter++;
        }
    }
}
