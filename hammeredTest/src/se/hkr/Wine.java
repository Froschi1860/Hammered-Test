package se.hkr;

public class Wine extends Drink implements MassOfRawAlcohol<Drink> {

    public Wine (double volumeInMillilitres, double alcoholContentInPercent) {
        super(volumeInMillilitres, alcoholContentInPercent);
    }

    @Override
    public double findMassOfRawAlcohol(Drink wine) {
        return wine.volumeInMillilitres * MassOfRawAlcohol.DENSITY_OF_ALCOHOL * wine.alcoholContentInPercent / 100;
    }
}
