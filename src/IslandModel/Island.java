package IslandModel;

import AnimalPackage.Animal;
import AnimalPackage.Herbivore.Herbivore;
import AnimalPackage.Predator.Predator;
import PlantPackage.Plant;
import Settings.Settings;

import java.util.Random;
import java.util.Set;

public class Island implements Runnable {
    public Location[][] locations = new Location[Settings.MAX_ROW_ISLAND][Settings.MAX_COL_ISLAND];

    public void startIsland() {
        for (int i = 0; i < locations.length; i++) {
            for (int j = 0; j < locations[i].length; j++) {
                locations[i][j] = new Location();
                locations[i][j].startCell();
            }
        }
    }

    @Override
    public void run() {
        for (int i = 0; i < locations.length; i++) {
            for (int j = 0; j < locations[i].length; j++) {
                locations[i][j].startLive();
            }
        }

    }
}

