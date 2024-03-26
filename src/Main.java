import AnimalPackage.Animal;
import AnimalPackage.Herbivore.Buffalo;
import AnimalPackage.Predator.Bear;
import AnimalPackage.Predator.Wolf;
import IslandModel.Island;
import IslandModel.Location;

import java.util.HashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        Island island = new Island();
        island.startIsland();
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(4);
        executorService.scheduleAtFixedRate(island, 0, 1, TimeUnit.SECONDS);


    }
}