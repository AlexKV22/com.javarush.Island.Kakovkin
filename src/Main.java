import AnimalPackage.Animal;
import AnimalPackage.Herbivore.Buffalo;
import AnimalPackage.Predator.Bear;
import AnimalPackage.Predator.Wolf;
import IslandModel.Island;
import IslandModel.Location;
import Statistics.Statistic;

import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        Island island = new Island();
        island.startIsland();
        ScheduledExecutorService scheduledExecutorService1 = Executors.newScheduledThreadPool(1);
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(4);
        scheduledExecutorService.scheduleAtFixedRate(island, 0, 2, TimeUnit.SECONDS);
        scheduledExecutorService1.scheduleAtFixedRate(new Statistic(), 0, 2, TimeUnit.SECONDS);




    }
}