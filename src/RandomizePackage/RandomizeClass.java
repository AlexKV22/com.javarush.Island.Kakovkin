package RandomizePackage;

import java.util.concurrent.ThreadLocalRandom;

public class RandomizeClass {
    private double randomEat;
    private ThreadLocalRandom mover;

    public static double getRandom() {
        return ThreadLocalRandom.current().nextDouble(0, 1);
    }

    public static int getRandom(int from, int to) {
        return ThreadLocalRandom.current().nextInt(from, to +1);
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
