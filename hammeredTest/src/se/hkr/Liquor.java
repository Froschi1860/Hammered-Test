package se.hkr;

public class Liquor extends Drink implements MassOfRawAlcohol <Drink> {
    Liquor(double volume, double percent) { super(volume, percent); }

    public double findMassOfRawAlcohol( Drink drink) {
        return this.volume * MassOfRawAlcohol.DENSITY * this.percent / 100;
    }

        /* Ranges: Volume = 0.04 - 0.10
                Alcohol 15 - 70 */
}


