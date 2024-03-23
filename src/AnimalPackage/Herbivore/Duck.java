package AnimalPackage.Herbivore;

import AnimalPackage.Animal;
import IslandModel.Island;
import RandomizePackage.RandomizeClass;

public class Duck extends Herbivore {
    private RandomizeClass randomizeClass = new RandomizeClass();
    private int moverRandom;
    private static int counter = 0;
    public Duck() {
        setMaxWeigth(1);
        setMaxCapacity(200);
        setMaxFoodNeeded(0.15);
        this.moverRandom = this.randomizeClass.getMover().nextInt(0,5);
        counter++;
        setX(this.randomizeClass.getMover().nextInt(0,101));
        setY(this.randomizeClass.getMover().nextInt(0,21));
    }

    @Override
    public void eat(Object food) {
        setMaxWeigth(getMaxWeigth() + ((Herbivore) food).getMaxWeigth());
        super.eat(food);
    }

    public void eat(Caterpillar food) {
        if(randomizeClass.getRandomEat() < 0.9) {
            setMaxWeigth(getMaxWeigth() + food.getMaxWeigth());
            super.eat(food);
        }
    }

    @Override
    public void move() {
        if (randomizeClass.getRandomEat() < 0.25) {
            chooseDirectionAhead(this.getX());
            setMaxWeigth(getMaxWeigth() - 0.02);
            if (getMaxWeigth() <= 0) {
                die(this);
            }
        } else if (randomizeClass.getRandomEat() > 0.25 && randomizeClass.getRandomEat() < 0.5) {
            chooseDirectionReverse(this.getX());
            setMaxWeigth(getMaxWeigth() - 0.02);
            if (getMaxWeigth() <= 0) {
                die(this);
            }
        } else if (randomizeClass.getRandomEat() > 0.5 && randomizeClass.getRandomEat() < 0.75) {
            chooseDirectionLeft(this.getY());
            setMaxWeigth(getMaxWeigth() - 0.02);
            if (getMaxWeigth() <= 0) {
                die(this);
            }
        } else if (randomizeClass.getRandomEat() > 0.75 && randomizeClass.getRandomEat() < 0.1) {
            chooseDirectionRight(this.getY());
            setMaxWeigth(getMaxWeigth() - 0.02);
            if (getMaxWeigth() <= 0) {
                die(this);
            }
        }
    }

    @Override
    public void multiple(Animal partner) throws CloneNotSupportedException {
        if (Duck.counter < getMaxCapacity() && this.getClass().equals(partner.getClass())) {
            this.clone();
            Duck.counter++;
        }
    }

    @Override
    public void die(Object death) {
        if (death instanceof Duck && getMaxWeigth() <= 0) {
            Duck.counter--;
            System.out.println("Утка, находящаяся в координатах: х - " + getX() + ", y - " + getY() + "умерла от голода :(((");
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
