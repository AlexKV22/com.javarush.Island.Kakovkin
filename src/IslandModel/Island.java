package IslandModel;

import PlantPackage.Plant;

import java.util.Random;

public class Island {
    private static Island island;
    Location location = new Location();
    public Location[][] locations = new Location[100][20];

    private Island() {
    }
    public static Island getInstance() {
        if (island == null) {
            return new Island();
        }
        return island;
    }

    public void initialIsland() {
        location.entry();
    }
}
