package se.hkr;

public class Wine extends Drink implements MassOfRawAlcohol{
    Wine(double volume, double percent) { super(volume, percent); }

    public void findMassOfRawAlcohol() {};
}
