package SchedulePackage;

import IslandModel.Island;
import Statistics.Statistic;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduleWork {
    public Island island;

    public ScheduleWork() {
        this.island = new Island();
    }

    public void startSimulation() {
        ScheduledExecutorService scheduledExecutorService1 = Executors.newScheduledThreadPool(1);
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(4);
        scheduledExecutorService.scheduleAtFixedRate(island, 0, 2, TimeUnit.SECONDS);
        scheduledExecutorService1.scheduleAtFixedRate(new Statistic(), 0, 2, TimeUnit.SECONDS);
        try {
            Thread.sleep(10000);
            scheduledExecutorService.shutdown();
            scheduledExecutorService1.shutdown();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
