package AnimalPackage.Predator;

import AnimalPackage.Animal;
import AnimalPackage.Herbivore.*;
import IslandModel.Island;
import RandomizePackage.RandomizeClass;
import Settings.Settings;

import java.util.concurrent.atomic.AtomicInteger;

public class Snake extends Predator {
    private int moverRandom;
    public static AtomicInteger atomicInteger = new AtomicInteger(0);
    private double eat;
    public Snake() {
        setMaxWeigth(Settings.MAX_WEIGHT_SNAKE);
        setMaxCapacity(Settings.MAX_CAPACITY_IN_ONE_CELL_SNAKE);
        setMaxFoodNeeded(Settings.MAX_FOOD_NEEDED_SNAKE);
        setX(RandomizeClass.getRandom(Settings.MIN_ROW_ISLAND,Settings.MAX_ROW_ISLAND));
        setY(RandomizeClass.getRandom(Settings.MIN_COL_ISLAND, Settings.MAX_COL_ISLAND));
        atomicInteger.getAndIncrement();
    }

    @Override
    public void eat(Herbivore food) {
        this.eat = RandomizeClass.getRandom();

        if (food instanceof Mouse && eat < 0.4 && food.getX() == this.getX() && food.getY() == this.getY()) {
            if(food.getMaxWeigth() >= Settings.MAX_FOOD_NEEDED_SNAKE) {
                setMaxWeigth(Settings.MAX_WEIGHT_SNAKE);
            }
            Mouse.atomicInteger.getAndDecrement();
            super.eat(food);
        }

        else if (food instanceof Rabbit && eat < 0.2 && food.getX() == this.getX() && food.getY() == this.getY()) {
            if(food.getMaxWeigth() >= Settings.MAX_FOOD_NEEDED_SNAKE) {
                setMaxWeigth(Settings.MAX_WEIGHT_SNAKE);
            }
            Rabbit.atomicInteger.getAndDecrement();
            super.eat(food);
        }

        else if (food instanceof Duck && eat < 0.1 && food.getX() == this.getX() && food.getY() == this.getY()) {
            if(food.getMaxWeigth() >= Settings.MAX_FOOD_NEEDED_SNAKE) {
                setMaxWeigth(Settings.MAX_WEIGHT_SNAKE);
            }
            Duck.atomicInteger.getAndDecrement();
            super.eat(food);
        }
    }

    public void eat(Fox food) {
        if (eat < 0.15 && food.getX() == this.getX() && food.getY() == this.getY()) {
            if(food.getMaxWeigth() >= Settings.MAX_FOOD_NEEDED_SNAKE) {
                setMaxWeigth(Settings.MAX_WEIGHT_SNAKE);
            }
             Fox.atomicInteger.getAndDecrement();
            food = null;
        }
    }

    @Override
    public void move() {
        this.moverRandom = RandomizeClass.getRandom(0, Settings.MAX_SPEED_SNAKE);
        this.eat = RandomizeClass.getRandom();

        if (eat < 0.25) {
            chooseDirectionAhead(this.getX());
            setMaxWeigth(getMaxWeigth() - Settings.MINUS_HEALTH_ONE_STEP_SNAKE);
            if (getMaxWeigth() <= 0) {
                die(this);
            }
        }
        else if (eat > 0.25 && eat < 0.5) {
            chooseDirectionReverse(this.getX());
            setMaxWeigth(getMaxWeigth() - Settings.MINUS_HEALTH_ONE_STEP_SNAKE);
            if (getMaxWeigth() <= 0) {
                die(this);
            }
        }
        else if (eat > 0.5 && eat < 0.75) {
            chooseDirectionLeft(this.getY());
            setMaxWeigth(getMaxWeigth() - Settings.MINUS_HEALTH_ONE_STEP_SNAKE);
            if (getMaxWeigth() <= 0) {
                die(this);
            }
        }
        else if (eat > 0.75 && eat < 1) {
            chooseDirectionRight(this.getY());
            setMaxWeigth(getMaxWeigth() - Settings.MINUS_HEALTH_ONE_STEP_SNAKE);
            if (getMaxWeigth() <= 0) {
                die(this);
            }
        }
    }

    @Override
    public void multiple(Animal partner) throws CloneNotSupportedException {
        if (atomicInteger.get()< getMaxCapacity() && this.getClass().equals(partner.getClass()) && partner.getX() == this.getX() && partner.getY() == this.getY()) {
            this.clone();
            atomicInteger.getAndIncrement();
        }
    }

    @Override
    public void die(Object death) {
        if (death instanceof Snake && getMaxWeigth() <= 0) {
            death = null;
            atomicInteger.getAndDecrement();
            System.out.println("Змея, находящаяся в координатах: х - " + getX() + ", y - " + getY() + "умерла от голода :(((");
        }
    }

    @Override
    public void chooseDirectionAhead(int row) {
        if (row > Settings.MIN_ROW_ISLAND) {
            int result = row - moverRandom;
            if (result < Settings.MIN_ROW_ISLAND) {
                result = Settings.MIN_ROW_ISLAND;
            }
            this.setX(result);
        }
    }

    @Override
    public void chooseDirectionReverse(int row) {
        if (row < Settings.MAX_ROW_ISLAND) {
            int result = row + moverRandom;
            if (result > Settings.MAX_ROW_ISLAND) {
                result = Settings.MAX_ROW_ISLAND;
            }
            this.setX(result);
        }
    }

    @Override
    public void chooseDirectionLeft(int col) {
        if (col > Settings.MIN_COL_ISLAND) {
            int result = col - moverRandom;
            if (result < Settings.MIN_COL_ISLAND) {
                result = Settings.MIN_COL_ISLAND;
            }
            this.setY(result);
        }
    }

    @Override
    public void chooseDirectionRight(int col) {
        if (col < Settings.MAX_COL_ISLAND) {
            int result = col + moverRandom;
            if (result > Settings.MAX_COL_ISLAND) {
                result = Settings.MAX_COL_ISLAND;
            }
            this.setY(result);
        }
    }
}
