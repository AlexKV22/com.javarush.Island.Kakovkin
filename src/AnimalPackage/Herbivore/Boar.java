package AnimalPackage.Herbivore;

import AnimalPackage.Animal;
import IslandModel.Island;
import PlantPackage.Plant;
import RandomizePackage.RandomizeClass;
import Settings.Settings;

import java.util.concurrent.atomic.AtomicInteger;

public class Boar extends Herbivore {
    private int moverRandom;
    public static AtomicInteger atomicInteger = new AtomicInteger(0);
    private double eat;
    public Boar() {
       setMaxWeigth(Settings.MAX_WEIGHT_BOAR);
       setMaxCapacity(Settings.MAX_CAPACITY_IN_ONE_CELL_BOAR);
       setMaxFoodNeeded(Settings.MAX_FOOD_NEEDED_BOAR);
        setX(RandomizeClass.getRandom(Settings.MIN_ROW_ISLAND,Settings.MAX_ROW_ISLAND));
        setY(RandomizeClass.getRandom(Settings.MIN_COL_ISLAND, Settings.MAX_COL_ISLAND));
        atomicInteger.getAndIncrement();
    }

    @Override
    public void eat(Plant food) {
        if(food.getX() == this.getX() && food.getY() == this.getY() && Plant.atomicInteger.get() > 0) {
            Plant.atomicInteger.getAndDecrement();
            super.eat(food);
        }
    }

    public void eat(Mouse food) {
        this.eat = RandomizeClass.getRandom();
        if (eat < 0.5 && food.getX() == this.getX() && food.getY() == this.getY() && Mouse.atomicInteger.get() > 0) {
            Mouse.atomicInteger.getAndDecrement();
            super.eat(food);
        }
    }

    public void eat(Caterpillar food) {
        this.eat = RandomizeClass.getRandom();
        if (eat < 0.9 && food.getX() == this.getX() && food.getY() == this.getY() && Caterpillar.atomicInteger.get() > 0) {
            Caterpillar.atomicInteger.getAndDecrement();
            super.eat(food);
        }
    }

    @Override
    public void move() {
        this.moverRandom = RandomizeClass.getRandom(0, Settings.MAX_SPEED_BOAR);
        this.eat = RandomizeClass.getRandom();

        if (eat < 0.25) {
            chooseDirectionAhead(this.getX());
            setMaxWeigth(getMaxWeigth() - Settings.MINUS_HEALTH_ONE_STEP_BOAR);
            if (getMaxWeigth() <= 0) {
                die(this);
            }
        } else if (eat > 0.25 && eat < 0.5) {
            chooseDirectionReverse(this.getX());
            setMaxWeigth(getMaxWeigth() - Settings.MINUS_HEALTH_ONE_STEP_BOAR);
            if (getMaxWeigth() <= 0) {
                die(this);
            }
        } else if (eat > 0.5 && eat < 0.75) {
            chooseDirectionLeft(this.getY());
            setMaxWeigth(getMaxWeigth() - Settings.MINUS_HEALTH_ONE_STEP_BOAR);
            if (getMaxWeigth() <= 0) {
                die(this);
            }
        } else if (eat > 0.75 && eat < 1) {
            chooseDirectionRight(this.getY());
            setMaxWeigth(getMaxWeigth() - Settings.MINUS_HEALTH_ONE_STEP_BOAR);
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
        if (death instanceof Boar && getMaxWeigth() <= 0) {
            atomicInteger.getAndDecrement();
            System.out.println("Кабан, находящийся в координатах: х - " + getX() + ", y - " + getY() + "умер от голода :(((");
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
