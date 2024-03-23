package RandomizePackage;

import java.util.concurrent.ThreadLocalRandom;

public class RandomizeClass {
    private double randomEat;
    private ThreadLocalRandom mover;

    public RandomizeClass() {
        randomEat = ThreadLocalRandom.current().nextDouble(0,1);
        this.mover = ThreadLocalRandom.current();
    }

    public double getRandomEat() {
        return randomEat;
    }

    public void setRandomEat(double randomEat) {
        this.randomEat = randomEat;
    }

    public ThreadLocalRandom getMover() {
        return mover;
    }

    public void setMover(ThreadLocalRandom mover) {
        this.mover = mover;
    }
}
