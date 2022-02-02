package se.hkr;

public class Liquor extends Drink implements MassOfRawAlcohol<Drink> {

    public Liquor (double volumeInMillilitres, double alcoholContentInPercent) {
        super(volumeInMillilitres, alcoholContentInPercent);
    }

    @Override
    public double findMassOfRawAlcohol(Drink liquor) {
        return liquor.volumeInMillilitres * MassOfRawAlcohol.DENSITY_OF_ALCOHOL * liquor.alcoholContentInPercent / 100;
    }

        /* Ranges: Volume = 0.04 - 0.10
                Alcohol 15 - 70 */
}


