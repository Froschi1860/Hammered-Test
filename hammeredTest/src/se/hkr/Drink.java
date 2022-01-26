package se.hkr;

public abstract class Drink implements MassOfRawAlcohol{
    double volume, percent;
    Drink(double volume, double percent) {
        this.volume = volume;
        this.percent = percent;
    }

    public abstract void findMassOfRawAlcohol();
}
