package Statistics;

import AnimalPackage.Herbivore.*;
import AnimalPackage.Predator.*;
import PlantPackage.Plant;

public class Statistic implements Runnable {


    @Override
    public void run() {
        System.err.println("Количество медведей: " + Bear.atomicInteger.get() +
                "\nКоличество орлов:  " + Eagle.atomicInteger.get() +
                "\nКоличество орлов:  " + Eagle.atomicInteger.get() +
                "\nКоличество лис:  "+ Fox.atomicInteger.get() +
                "\nКоличество змей:  "+ Snake.atomicInteger.get() +
                "\nКоличество волков:  "+ Wolf.atomicInteger.get() +
                "\nКоличество кабанов:  "+ Boar.atomicInteger.get() +
                "\nКоличество буйволов:  "+ Buffalo.atomicInteger.get() +
                "\nКоличество гусениц:  "+ Caterpillar.atomicInteger.get() +
                "\nКоличество оленей:  "+ Dear.atomicInteger.get() +
                "\nКоличество уток:  "+ Duck.atomicInteger.get() +
                "\nКоличество коз:  "+ Goat.atomicInteger.get() +
                "\nКоличество лошадей:  "+ Horse.atomicInteger.get() +
                "\nКоличество мышей:  "+ Mouse.atomicInteger.get() +
                "\nКоличество зайцев:  "+ Rabbit.atomicInteger.get() +
                "\nКоличество овец:  "+ Sheep.atomicInteger.get() +
                "\nКоличество травы:  "+ Plant.atomicInteger.get());
    }
}
