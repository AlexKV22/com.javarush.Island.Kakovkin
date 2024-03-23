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

public class Bear extends Predator {
    private int moverRandom;
    private int counter = 0;
    private double eat;


    public Bear() {
        setMaxWeigth(Settings.MAX_WEIGHT_BEAR);
        setMaxCapacity(Settings.MAX_CAPACITY_IN_ONE_CELL_BEAR);
        setMaxFoodNeeded(Settings.MAX_FOOD_NEEDED_BEAR);
        counter++;
        setX(RandomizeClass.getRandom(Settings.MIN_ROW_ISLAND,Settings.MAX_ROW_ISLAND));
        setY(RandomizeClass.getRandom(Settings.MIN_COL_ISLAND, Settings.MAX_COL_ISLAND));
    }

    @Override
    public void eat(Object food) {
        this.eat = RandomizeClass.getRandom();

        if (food instanceof Horse && eat < 0.4) {
            if(((Horse) food).getMaxWeigth() >= Settings.MAX_FOOD_NEEDED_BEAR) {
                setMaxWeigth(Settings.MAX_WEIGHT_BEAR);
            }
            ((Horse) food).setCounter(getCounter() - 1);
            super.eat(food);
        }

        else if (food instanceof Dear && eat < 0.8) {
            if(((Dear) food).getMaxWeigth() >= Settings.MAX_FOOD_NEEDED_BEAR) {
                setMaxWeigth(Settings.MAX_WEIGHT_BEAR);
            }
            ((Dear) food).setCounter(getCounter() - 1);
            super.eat(food);
        }

        else if (food instanceof Rabbit && eat < 0.8) {
            if(((Rabbit) food).getMaxWeigth() >= Settings.MAX_FOOD_NEEDED_BEAR) {
                setMaxWeigth(Settings.MAX_WEIGHT_BEAR);
            }
            ((Rabbit) food).setCounter(getCounter() - 1);
            super.eat(food);
        }

        else if (food instanceof Mouse && eat < 0.9) {
            if(((Mouse) food).getMaxWeigth() >= Settings.MAX_FOOD_NEEDED_BEAR) {
                setMaxWeigth(Settings.MAX_WEIGHT_BEAR);
            }
            ((Mouse) food).setCounter(getCounter() - 1);
            super.eat(food);
        }

        else if (food instanceof Sheep && eat < 0.7) {
            if(((Sheep) food).getMaxWeigth() >= Settings.MAX_FOOD_NEEDED_BEAR) {
                setMaxWeigth(Settings.MAX_WEIGHT_BEAR);
            }
            ((Sheep) food).setCounter(getCounter() - 1);
            super.eat(food);
        }

        else if (food instanceof Goat && eat < 0.7) {
            if(((Goat) food).getMaxWeigth() >= Settings.MAX_FOOD_NEEDED_BEAR) {
                setMaxWeigth(Settings.MAX_WEIGHT_BEAR);
            }
            ((Goat) food).setCounter(getCounter() - 1);
            super.eat(food);
        }

        else if (food instanceof Boar && eat < 0.5) {
            if(((Boar) food).getMaxWeigth() >= Settings.MAX_FOOD_NEEDED_BEAR) {
                setMaxWeigth(Settings.MAX_WEIGHT_BEAR);
            }
            ((Boar) food).setCounter(getCounter() - 1);
            super.eat(food);
        }

        else if (food instanceof Buffalo && eat < 0.2) {
            if(((Buffalo) food).getMaxWeigth() >= Settings.MAX_FOOD_NEEDED_BEAR) {
                setMaxWeigth(Settings.MAX_WEIGHT_BEAR);
            }
            ((Buffalo) food).setCounter(getCounter() - 1);
            super.eat(food);
        }

        else if (food instanceof Duck && eat < 0.1) {
            if(((Duck) food).getMaxWeigth() >= Settings.MAX_FOOD_NEEDED_BEAR) {
                setMaxWeigth(Settings.MAX_WEIGHT_BEAR);
            }
            ((Duck) food).setCounter(getCounter() - 1);
            super.eat(food);
        }
    }


    public void eat(Snake food) {
        if (eat < 0.8) {
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
        if (counter < getMaxCapacity() && this.getClass().equals(partner.getClass())) {
            this.clone();
            counter++;
        }
    }

    @Override
    public void die(Object death) {
        if (death instanceof Bear && getMaxWeigth() <= 0) {
            death = null;
            counter--;
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

    public int getCounter() {
        return counter;
    }
}
