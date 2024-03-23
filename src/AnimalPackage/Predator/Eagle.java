package AnimalPackage.Predator;

import AnimalPackage.Animal;
import AnimalPackage.Herbivore.*;
import IslandModel.Island;
import RandomizePackage.RandomizeClass;
import Settings.Settings;

public class Eagle extends Predator {
    private int moverRandom;
    private int counter = 0;
    private double eat;
    public Eagle() {
        setMaxWeigth(Settings.MAX_WEIGHT_EAGLE);
        setMaxCapacity(Settings.MAX_CAPACITY_IN_ONE_CELL_EAGLE);
        setMaxFoodNeeded(Settings.MAX_FOOD_NEEDED_EAGLE);
        counter++;
        setX(RandomizeClass.getRandom(Settings.MIN_ROW_ISLAND,Settings.MAX_ROW_ISLAND));
        setY(RandomizeClass.getRandom(Settings.MIN_COL_ISLAND, Settings.MAX_COL_ISLAND));
    }

    @Override
    public void eat(Object food) {
        this.eat = RandomizeClass.getRandom();

        if (food instanceof Rabbit && eat < 0.9) {
            if(((Rabbit) food).getMaxWeigth() >= Settings.MAX_FOOD_NEEDED_EAGLE) {
                setMaxWeigth(Settings.MAX_WEIGHT_EAGLE);
            }
            ((Rabbit) food).setCounter(getCounter() - 1);
            super.eat(food);
        }

        else if (food instanceof Mouse && eat < 0.9) {
            if(((Mouse) food).getMaxWeigth() >= Settings.MAX_FOOD_NEEDED_EAGLE) {
                setMaxWeigth(Settings.MAX_WEIGHT_EAGLE);
            }
            ((Mouse) food).setCounter(getCounter() - 1);
            super.eat(food);
        }

        else if (food instanceof Duck && eat < 0.8) {
            if(((Duck) food).getMaxWeigth() >= Settings.MAX_FOOD_NEEDED_EAGLE) {
                setMaxWeigth(Settings.MAX_WEIGHT_EAGLE);
            }
            ((Duck) food).setCounter(getCounter() - 1);
            super.eat(food);
        }
    }

    public void eat(Fox food) {
        if (eat < 0.1) {
            if(food.getMaxWeigth() >= Settings.MAX_FOOD_NEEDED_EAGLE) {
                setMaxWeigth(Settings.MAX_WEIGHT_EAGLE);
            }
            food.setCounter(getCounter() - 1);
            food = null;
        }
    }

    @Override
    public void move() {
        this.moverRandom = RandomizeClass.getRandom(0, Settings.MAX_SPEED_EAGLE);
        this.eat = RandomizeClass.getRandom();
        if (eat < 0.25) {
            chooseDirectionAhead(this.getX());
            setMaxWeigth(getMaxWeigth() - Settings.MINUS_HEALTH_ONE_STEP_EAGLE);
            if (getMaxWeigth() <= 0) {
                die(this);
            }
        } else if (eat > 0.25 && eat < 0.5) {
            chooseDirectionReverse(this.getX());
            setMaxWeigth(getMaxWeigth() - Settings.MINUS_HEALTH_ONE_STEP_EAGLE);
            if (getMaxWeigth() <= 0) {
                die(this);
            }
        } else if (eat > 0.5 && eat < 0.75) {
            chooseDirectionLeft(this.getY());
            setMaxWeigth(getMaxWeigth() - Settings.MINUS_HEALTH_ONE_STEP_EAGLE);
            if (getMaxWeigth() <= 0) {
                die(this);
            }
        } else if (eat > 0.75 && eat < 1) {
            chooseDirectionRight(this.getY());
            setMaxWeigth(getMaxWeigth() - Settings.MINUS_HEALTH_ONE_STEP_EAGLE);
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
        if (death instanceof Eagle && getMaxWeigth() <= 0) {
            death = null;
            counter--;
            System.out.println("Орел, находящийся в координатах: х - " + getX() + ", y - " + getY() + "умер от голода :(((");
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

    public void setCounter(int counter) {
        this.counter = counter;
    }
}
