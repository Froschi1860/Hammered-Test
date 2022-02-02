package se.hkr;

public class Beer extends Drink implements MassOfRawAlcohol <Drink> {
    Beer(double volume, double percent) {
        super(volume, percent);
    }
    public double findMassOfRawAlcohol(Drink drink) {
       return this.volume * MassOfRawAlcohol.DENSITY * this.percent / 100;
    }

    /* Ranges: Volume = 0.33 - 1.00
                Alcohol 2 - 9 */
}
