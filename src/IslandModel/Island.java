package IslandModel;

import PlantPackage.Plant;
import Settings.Settings;

import java.util.Random;
import java.util.Set;

public class Island {
    private static Island island;

    public Location[][] locations;

    public Island() {
        this.locations = new Location[Settings.MAX_ROW_ISLAND][Settings.MAX_COL_ISLAND];
    }
    public static Island getInstance() {
        if (island == null) {
        }
        return island;
    }

}
