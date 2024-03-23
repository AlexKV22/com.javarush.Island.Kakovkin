package AnimalPackage.Herbivore;

import AnimalPackage.Animal;
import IslandModel.Island;
import RandomizePackage.RandomizeClass;

public class Boar extends Herbivore {
    private RandomizeClass randomizeClass = new RandomizeClass();
    private int moverRandom;
    private static int counter = 0;
    public Boar() {
       setMaxWeigth(400);
       setMaxCapacity(50);
       setMaxFoodNeeded(50);
        this.moverRandom = this.randomizeClass.getMover().nextInt(0,3);
        counter++;
        setX(this.randomizeClass.getMover().nextInt(0,101));
        setY(this.randomizeClass.getMover().nextInt(0,21));
    }

    @Override
    public void eat(Object food) {
        setMaxWeigth(getMaxWeigth() + ((Herbivore) food).getMaxWeigth());
        super.eat(food);
    }

    public void eat(Mouse food) {
        if (randomizeClass.getRandomEat() < 0.5) {
            setMaxWeigth(getMaxWeigth() + food.getMaxWeigth());
            super.eat(food);
        }
    }

    public void eat(Caterpillar food) {
        if (randomizeClass.getRandomEat() < 0.9) {
            setMaxWeigth(getMaxWeigth() + food.getMaxWeigth());
            super.eat(food);
        }
    }

    @Override
    public void move() {
        if (randomizeClass.getRandomEat() < 0.25) {
            chooseDirectionAhead(this.getX());
            setMaxWeigth(getMaxWeigth() - 10);
            if (getMaxWeigth() <= 0) {
                die(this);
            }
        } else if (randomizeClass.getRandomEat() > 0.25 && randomizeClass.getRandomEat() < 0.5) {
            chooseDirectionReverse(this.getX());
            setMaxWeigth(getMaxWeigth() - 10);
            if (getMaxWeigth() <= 0) {
                die(this);
            }
        } else if (randomizeClass.getRandomEat() > 0.5 && randomizeClass.getRandomEat() < 0.75) {
            chooseDirectionLeft(this.getY());
            setMaxWeigth(getMaxWeigth() - 10);
            if (getMaxWeigth() <= 0) {
                die(this);
            }
        } else if (randomizeClass.getRandomEat() > 0.75 && randomizeClass.getRandomEat() < 0.1) {
            chooseDirectionRight(this.getY());
            setMaxWeigth(getMaxWeigth() - 10);
            if (getMaxWeigth() <= 0) {
                die(this);
            }
        }
    }

    @Override
    public void multiple(Animal partner) throws CloneNotSupportedException {
        if (Boar.counter < getMaxCapacity() && this.getClass().equals(partner.getClass())) {
            this.clone();
            Boar.counter++;
        }
    }

    @Override
    public void die(Object death) {
        if (death instanceof Boar && getMaxWeigth() <= 0) {
            Boar.counter--;
            System.out.println("Кабан, находящийся в координатах: х - " + getX() + ", y - " + getY() + "умер от голода :(((");
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
