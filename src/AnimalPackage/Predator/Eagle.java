package AnimalPackage.Predator;

import AnimalPackage.Animal;
import AnimalPackage.Herbivore.Duck;
import AnimalPackage.Herbivore.Herbivore;
import AnimalPackage.Herbivore.Mouse;
import AnimalPackage.Herbivore.Rabbit;
import IslandModel.Island;
import RandomizePackage.RandomizeClass;

public class Eagle extends Predator {
    private RandomizeClass randomizeClass = new RandomizeClass();
    private int moverRandom;
    private static int counter = 0;
    public Eagle() {
        setMaxWeigth(6);
        setMaxCapacity(20);
        setMaxFoodNeeded(1);
        this.moverRandom = this.randomizeClass.getMover().nextInt(0,4);
        counter++;
        setX(this.randomizeClass.getMover().nextInt(0,101));
        setY(this.randomizeClass.getMover().nextInt(0,21));
    }

    @Override
    public void eat(Object food) {
        if (food instanceof Rabbit || food instanceof Mouse && randomizeClass.getRandomEat() < 0.9) {
            setMaxWeigth(getMaxWeigth() + ((Herbivore) food).getMaxWeigth());
            super.eat(food);
        } else if (food instanceof Duck && randomizeClass.getRandomEat() < 0.8) {
            setMaxWeigth(getMaxWeigth() + ((Herbivore) food).getMaxWeigth());
            super.eat(food);
        }
    }

    public void eat(Fox food) {
        if (randomizeClass.getRandomEat() < 0.1) {
            setMaxWeigth(getMaxWeigth() + food.getMaxWeigth());
            food = null;
        }
    }

    @Override
    public void move() {
        if (randomizeClass.getRandomEat() < 0.25) {
            chooseDirectionAhead(this.getX());
            setMaxWeigth(getMaxWeigth() - 1);
            if (getMaxWeigth() <= 0) {
                die(this);
            }
        } else if (randomizeClass.getRandomEat() > 0.25 && randomizeClass.getRandomEat() < 0.5) {
            chooseDirectionReverse(this.getX());
            setMaxWeigth(getMaxWeigth() - 1);
            if (getMaxWeigth() <= 0) {
                die(this);
            }
        } else if (randomizeClass.getRandomEat() > 0.5 && randomizeClass.getRandomEat() < 0.75) {
            chooseDirectionLeft(this.getY());
            setMaxWeigth(getMaxWeigth() - 1);
            if (getMaxWeigth() <= 0) {
                die(this);
            }
        } else if (randomizeClass.getRandomEat() > 0.75 && randomizeClass.getRandomEat() < 0.1) {
            chooseDirectionRight(this.getY());
            setMaxWeigth(getMaxWeigth() - 1);
            if (getMaxWeigth() <= 0) {
                die(this);
            }
        }
    }

    @Override
    public void multiple(Animal partner) throws CloneNotSupportedException {
        if (Eagle.counter < getMaxCapacity() && this.getClass().equals(partner.getClass())) {
            this.clone();
            Eagle.counter++;
        }
    }

    @Override
    public void die(Object death) {
        if (death instanceof Eagle && getMaxWeigth() <= 0) {
            death = null;
            Eagle.counter--;
            System.out.println("Орел, находящийся в координатах: х - " + getX() + ", y - " + getY() + "умер от голода :(((");
        }
    }

    @Override
    public void chooseDirectionAhead(int row) {
        if (this.getX() > 0) {
            int result = this.getX() - moverRandom;
            if (result < 0) {
                result = 0;
            }
            this.setX(result);
        }
    }

    @Override
    public void chooseDirectionReverse(int row) {
        if (this.getX() < Island.getInstance().locations.length - 1) {
            int result = this.getX() + moverRandom;
            if (result > Island.getInstance().locations.length - 1) {
                result = Island.getInstance().locations.length - 1;
            }
            this.setX(result);
        }
    }

    @Override
    public void chooseDirectionLeft(int col) {
        if (this.getY() > 0) {
            int result = this.getY() - moverRandom;
            if (result < 0) {
                result = 0;
            }
            this.setY(result);
        }
    }

    @Override
    public void chooseDirectionRight(int col) {
        if (this.getY() < Island.getInstance().locations.length) {
            int result = this.getY() + moverRandom;
            if (result > Island.getInstance().locations.length) {
                result = Island.getInstance().locations.length;
            }
            this.setY(result);
        }
    }

    public static int getCounter() {
        return counter;
    }
}
