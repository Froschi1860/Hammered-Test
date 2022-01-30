package se.hkr;

public class Liquor extends Drink implements MassOfRawAlcohol{
    Liquor(double volume, double percent) { super(volume, percent); }

    public void findMassOfRawAlcohol() {};
}
