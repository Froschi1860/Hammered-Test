package se.hkr;

public class Liquor extends Drink implements MassOfRawAlcohol <Drink> {
    Liquor(double volume, double percent) { super(volume, percent); }

    public void findMassOfRawAlcohol() {};
}
