package PlantPackage;

import AnimalPackage.Animal;
import AnimalPackage.Predator.Bear;
import Interfaces.Eatable;
import Settings.Settings;

public class Plant implements Eatable {
    private double maxWeigth;
    private int maxCapacity;
    private int counter = 0;

    public Plant() {
        this.maxWeigth = 1;
        this.maxCapacity = Settings.MAX_CAPACITY_PLANT;
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

    public void multiple(Animal partner) throws CloneNotSupportedException {
        if (counter < getMaxCapacity() && this.getClass().equals(partner.getClass())) {
            this.clone();
            counter++;
        }
    }
}
