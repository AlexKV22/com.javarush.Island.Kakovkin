package AnimalPackage.Predator;
import AnimalPackage.Animal;
import AnimalPackage.Herbivore.*;
import IslandModel.Island;
import RandomizePackage.RandomizeClass;
import IslandModel.Location;
import Settings.Settings;
import lombok.AllArgsConstructor;
import lombok.Setter;

import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public class Bear extends Predator {
    private int moverRandom;
    public static AtomicInteger atomicInteger = new AtomicInteger(0);
    private double eat;

    public Bear() {
        setMaxWeigth(Settings.MAX_WEIGHT_BEAR);
        setMaxCapacity(Settings.MAX_CAPACITY_IN_ONE_CELL_BEAR);
        setMaxFoodNeeded(Settings.MAX_FOOD_NEEDED_BEAR);
        setX(RandomizeClass.getRandom(Settings.MIN_ROW_ISLAND,Settings.MAX_ROW_ISLAND));
        setY(RandomizeClass.getRandom(Settings.MIN_COL_ISLAND, Settings.MAX_COL_ISLAND));
        atomicInteger.getAndIncrement();
    }

    @Override
    public void eat(Herbivore food) {
        this.eat = RandomizeClass.getRandom();

        if (food instanceof Horse && eat < 0.4 && food.getX() == this.getX() && food.getY() == this.getY()) {
            if(food.getMaxWeigth() >= Settings.MAX_FOOD_NEEDED_BEAR) {
                setMaxWeigth(Settings.MAX_WEIGHT_BEAR);
            }
            ((Horse) food).setCounter(getCounter() - 1);
            super.eat(food);
        }

        else if (food instanceof Dear && eat < 0.8 && food.getX() == this.getX() && food.getY() == this.getY()) {
            if(food.getMaxWeigth() >= Settings.MAX_FOOD_NEEDED_BEAR) {
                setMaxWeigth(Settings.MAX_WEIGHT_BEAR);
            }
            ((Dear) food).setCounter(getCounter() - 1);
            super.eat(food);
        }

        else if (food instanceof Rabbit && eat < 0.8 && food.getX() == this.getX() && food.getY() == this.getY()) {
            if(food.getMaxWeigth() >= Settings.MAX_FOOD_NEEDED_BEAR) {
                setMaxWeigth(Settings.MAX_WEIGHT_BEAR);
            }
            ((Rabbit) food).setCounter(getCounter() - 1);
            super.eat(food);
        }

        else if (food instanceof Mouse && eat < 0.9 && food.getX() == this.getX() && food.getY() == this.getY()) {
            if(food.getMaxWeigth() >= Settings.MAX_FOOD_NEEDED_BEAR) {
                setMaxWeigth(Settings.MAX_WEIGHT_BEAR);
            }
            ((Mouse) food).setCounter(getCounter() - 1);
            super.eat(food);
        }

        else if (food instanceof Sheep && eat < 0.7 && food.getX() == this.getX() && food.getY() == this.getY()) {
            if(food.getMaxWeigth() >= Settings.MAX_FOOD_NEEDED_BEAR) {
                setMaxWeigth(Settings.MAX_WEIGHT_BEAR);
            }
            ((Sheep) food).setCounter(getCounter() - 1);
            super.eat(food);
        }

        else if (food instanceof Goat && eat < 0.7 && food.getX() == this.getX() && food.getY() == this.getY()) {
            if(food.getMaxWeigth() >= Settings.MAX_FOOD_NEEDED_BEAR) {
                setMaxWeigth(Settings.MAX_WEIGHT_BEAR);
            }
            ((Goat) food).setCounter(getCounter() - 1);
            super.eat(food);
        }

        else if (food instanceof Boar && eat < 0.5 && food.getX() == this.getX() && food.getY() == this.getY()) {
            if(food.getMaxWeigth() >= Settings.MAX_FOOD_NEEDED_BEAR) {
                setMaxWeigth(Settings.MAX_WEIGHT_BEAR);
            }
            ((Boar) food).setCounter(getCounter() - 1);
            super.eat(food);
        }

        else if (food instanceof Buffalo && eat < 0.2 && food.getX() == this.getX() && food.getY() == this.getY()) {
            if(food.getMaxWeigth() >= Settings.MAX_FOOD_NEEDED_BEAR) {
                setMaxWeigth(Settings.MAX_WEIGHT_BEAR);
            }
            ((Buffalo) food).setCounter(getCounter() - 1);
            super.eat(food);
        }

        else if (food instanceof Duck && eat < 0.1 && food.getX() == this.getX() && food.getY() == this.getY()) {
            if(food.getMaxWeigth() >= Settings.MAX_FOOD_NEEDED_BEAR) {
                setMaxWeigth(Settings.MAX_WEIGHT_BEAR);
            }
            ((Duck) food).setCounter(getCounter() - 1);
            super.eat(food);
        }
    }


    public void eat(Snake food) {
        if (eat < 0.8 &&  food.getX() == this.getX() && food.getY() == this.getY()) {
            if(food.getMaxWeigth() >= Settings.MAX_FOOD_NEEDED_BEAR) {
                setMaxWeigth(Settings.MAX_WEIGHT_BEAR);
            }
            food.setCounter(getCounter() - 1);
            food = null;
        }
    }

    @Override
    public void move() {

        this.moverRandom = RandomizeClass.getRandom(0, Settings.MAX_SPEED_BEAR);
        this.eat = RandomizeClass.getRandom();
        if (eat < 0.25) {
            chooseDirectionAhead(this.getX());
            setMaxWeigth(getMaxWeigth() - Settings.MINUS_HEALTH_ONE_STEP_BEAR);
            if (getMaxWeigth() <= 0) {
                die(this);
            }
        } else if (eat > 0.25 && eat < 0.5) {
            chooseDirectionReverse(this.getX());
            setMaxWeigth(getMaxWeigth() - Settings.MINUS_HEALTH_ONE_STEP_BEAR);
            if (getMaxWeigth() <= 0) {
                die(this);
            }
        } else if (eat > 0.5 && eat < 0.75) {
            chooseDirectionLeft(this.getY());
            setMaxWeigth(getMaxWeigth() - Settings.MINUS_HEALTH_ONE_STEP_BEAR);
            if (getMaxWeigth() <= 0) {
                die(this);
            }
        } else if (eat > 0.75 && eat < 1) {
            chooseDirectionRight(this.getY());
            setMaxWeigth(getMaxWeigth() - Settings.MINUS_HEALTH_ONE_STEP_BEAR);
            if (getMaxWeigth() <= 0) {
                die(this);
            }
        }
    }

    @Override
    public void multiple(Animal partner) throws CloneNotSupportedException {
        if (atomicInteger.get() < getMaxCapacity() && this.getClass().equals(partner.getClass()) && partner.getX() == this.getX() && partner.getY() == this.getY()) {
            this.clone();
            atomicInteger.getAndIncrement();
        }
    }

    @Override
    public void die(Object death) {
        if (death instanceof Bear && getMaxWeigth() <= 0) {
            death = null;
            atomicInteger.getAndDecrement();
            System.out.println("Медведь, находящийся в координатах: х - " + getX() + ", y - " + getY() + "умер от голода :(((");
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
