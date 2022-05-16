package ro.fasttrackit.fs02.curs2_homework.enums;

public class PlanetMain {
    public static void main(String[] args) {
        for (Planet p : Planet.values()) {
            System.out.printf("Your weight on %s is %f%n",
                    p, p.earthWeightOnPlanet(175));
        }
    }

}
