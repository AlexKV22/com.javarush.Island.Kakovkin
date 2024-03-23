package AnimalPackage.Predator;

import AnimalPackage.Animal;
import AnimalPackage.Herbivore.*;
import IslandModel.Island;
import RandomizePackage.RandomizeClass;

public class Wolf extends Predator {
    private RandomizeClass randomizeClass = new RandomizeClass();
    private int moverRandom;
    private static int counter = 0;
    public Wolf() {
        setMaxWeigth(50);
        setMaxCapacity(30);
        setMaxFoodNeeded(8);
        this.moverRandom = this.randomizeClass.getMover().nextInt(0,3);
        counter++;
        setX(this.randomizeClass.getMover().nextInt(0,100));
        setY(this.randomizeClass.getMover().nextInt(0,20));
    }

    @Override
    public void eat(Object food) {
        if (food instanceof Horse && randomizeClass.getRandomEat() < 0.1) {
            setMaxWeigth(getMaxWeigth() + ((Herbivore) food).getMaxWeigth());
            super.eat(food);
        } else if (food instanceof Dear && randomizeClass.getRandomEat() < 0.15) {
            setMaxWeigth(getMaxWeigth() + ((Herbivore) food).getMaxWeigth());
            super.eat(food);
        } else if (food instanceof Rabbit && randomizeClass.getRandomEat() < 0.6) {
            setMaxWeigth(getMaxWeigth() + ((Herbivore) food).getMaxWeigth());
            super.eat(food);
        } else if (food instanceof Mouse && randomizeClass.getRandomEat() < 0.8) {
            setMaxWeigth(getMaxWeigth() + ((Herbivore) food).getMaxWeigth());
            super.eat(food);
        } else if (food instanceof Sheep && randomizeClass.getRandomEat() < 0.7) {
            setMaxWeigth(getMaxWeigth() + ((Herbivore) food).getMaxWeigth());
            super.eat(food);
        } else if (food instanceof Goat && randomizeClass.getRandomEat() < 0.6) {
            setMaxWeigth(getMaxWeigth() + ((Herbivore) food).getMaxWeigth());
            super.eat(food);
        } else if (food instanceof Boar && randomizeClass.getRandomEat() < 0.15) {
            setMaxWeigth(getMaxWeigth() + ((Herbivore) food).getMaxWeigth());
            super.eat(food);
        } else if (food instanceof Buffalo && randomizeClass.getRandomEat() < 0.1) {
            setMaxWeigth(getMaxWeigth() + ((Herbivore) food).getMaxWeigth());
            super.eat(food);
        } else if (food instanceof Duck && randomizeClass.getRandomEat() < 0.4) {
            setMaxWeigth(getMaxWeigth() + ((Herbivore) food).getMaxWeigth());
            super.eat(food);
        }
    }

    @Override
    public void move() {
        if (randomizeClass.getRandomEat() < 0.25) {
            chooseDirectionAhead(this.getX());
            setMaxWeigth(getMaxWeigth() - 5);
            if (getMaxWeigth() <= 0) {
                die(this);
            }
        } else if (randomizeClass.getRandomEat() > 0.25 && randomizeClass.getRandomEat() < 0.5) {
            chooseDirectionReverse(this.getX());
            setMaxWeigth(getMaxWeigth() - 5);
            if (getMaxWeigth() <= 0) {
                die(this);
            }
        } else if (randomizeClass.getRandomEat() > 0.5 && randomizeClass.getRandomEat() < 0.75) {
            chooseDirectionLeft(this.getY());
            setMaxWeigth(getMaxWeigth() - 5);
            if (getMaxWeigth() <= 0) {
                die(this);
            }
        } else if (randomizeClass.getRandomEat() > 0.75 && randomizeClass.getRandomEat() < 0.1) {
            chooseDirectionRight(this.getY());
            setMaxWeigth(getMaxWeigth() - 5);
            if (getMaxWeigth() <= 0) {
                die(this);
            }
        }
    }

    @Override
    public void multiple(Animal partner) throws CloneNotSupportedException {
        if (Wolf.counter < getMaxCapacity() && this.getClass().equals(partner.getClass())) {
            this.clone();
            Wolf.counter++;
        }
    }

    @Override
    public void die(Object death) {
        if (death instanceof Wolf && getMaxWeigth() <= 0) {
            death = null;
            Wolf.counter--;
            System.out.println("Волк, находящийся в координатах: х - " + getX() + ", y - " + getY() + "умер от голода :(((");
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
