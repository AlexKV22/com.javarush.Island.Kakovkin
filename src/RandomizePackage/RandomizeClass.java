package RandomizePackage;

import java.util.concurrent.ThreadLocalRandom;

public class RandomizeClass {
    public static double getRandom() {
        return ThreadLocalRandom.current().nextDouble(0, 1);
    }

    public static int getRandom(int from, int to) {
        return ThreadLocalRandom.current().nextInt(from, to +1);
    }

    public static int getRandomArray(int from, int to) {
        return ThreadLocalRandom.current().nextInt(from, to);
    }
}
