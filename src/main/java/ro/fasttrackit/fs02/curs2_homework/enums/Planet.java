package ro.fasttrackit.fs02.curs2_homework.enums;

public enum Planet {
    MERCURY (0.3),
    VENUS (0.9),
    MOON (0.1),
    MARS (0.3),
    JUPITER (2.5),
    SATURN (1),
    URANUS (0.8),
    NEPTUNE (1.1),
    PLUTO (0),
    IO (0.18),
    EUROPA (0.13),
    GANYMEDE (0.14),
    CALLISTO (0.12),
    SUN (27),
    WHITE_DWARF (1300000);

    private double surfaceGravity;

    Planet(double surfaceGravity) {
        this.surfaceGravity = surfaceGravity;
    }

    double earthWeightOnPlanet(double earthWeight){

        return (earthWeight/0.98)*surfaceGravity;
    }
}
