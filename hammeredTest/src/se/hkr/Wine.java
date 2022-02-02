package se.hkr;

public class Wine extends Drink implements MassOfRawAlcohol <Drink> {
    Wine(double volume, double percent) { super(volume, percent); }

    public double findMassOfRawAlcohol(Drink drink) {
        return this.volume * MassOfRawAlcohol.DENSITY * this.percent / 100;

    }

        /* Ranges: Volume = 0.2 - 0.5
                Alcohol 7 - 15 */
}
