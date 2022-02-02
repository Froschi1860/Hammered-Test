package se.hkr;

@FunctionalInterface

public interface MassOfRawAlcohol<T> {
    double DENSITY = 0.789;

    double findMassOfRawAlcohol(Drink drink);
}
