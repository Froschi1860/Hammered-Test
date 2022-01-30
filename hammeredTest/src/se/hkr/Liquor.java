package se.hkr;

public class Liquor extends Drink implements MassOfRawAlcohol <Liquor> {
    Liquor(double volume, double percent) { super(volume, percent); }

    public void findMassOfRawAlcohol(Liquor liquor) {};
}
