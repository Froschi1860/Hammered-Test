package se.hkr;

@FunctionalInterface

public interface MassOfRawAlcohol<T extends Drink> {
    double DENSITY_OF_ALCOHOL = 0.789;

    double findMassOfRawAlcohol(T drink);
}
