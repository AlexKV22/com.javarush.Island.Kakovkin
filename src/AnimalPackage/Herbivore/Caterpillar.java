package AnimalPackage.Herbivore;

import AnimalPackage.Animal;
import RandomizePackage.RandomizeClass;

public class Caterpillar extends Herbivore {
    private RandomizeClass randomizeClass = new RandomizeClass();
    private static int counter = 0;
    public Caterpillar() {
        setMaxWeigth(0.01);
        setMaxCapacity(1000);
        counter++;
        setX(this.randomizeClass.getMover().nextInt(0,100));
        setY(this.randomizeClass.getMover().nextInt(0,20));
    }

    @Override
    public void eat(Object food) {
        setMaxWeigth(getMaxWeigth() + ((Herbivore) food).getMaxWeigth());
        super.eat(food);
    }

    @Override
    public void multiple(Animal partner) throws CloneNotSupportedException {
        if (Caterpillar.counter < getMaxCapacity() && this.getClass().equals(partner.getClass())) {
            this.clone();
            Caterpillar.counter++;
        }
    }

    @Override
    public void die(Object death) {
        if (death instanceof Caterpillar && getMaxWeigth() <= 0) {
            Caterpillar.counter--;
            System.out.println("Гусеница, находящаяся в координатах: х - " + getX() + ", y - " + getY() + "умерла от голода :(((");
        }
    }

    public static int getCounter() {
        return counter;
    }
}
