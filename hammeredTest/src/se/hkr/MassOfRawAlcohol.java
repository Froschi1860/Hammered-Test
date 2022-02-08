package se.hkr;

@FunctionalInterface

public interface MassOfRawAlcohol {
    double DENSITY_OF_ALCOHOL = 0.789;

    double findMassOfRawAlcohol(Drink drink);
}
