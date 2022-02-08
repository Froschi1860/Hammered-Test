package se.hkr;

public class Beer extends Drink implements MassOfRawAlcohol<Drink> {

    public Beer (double volumeInMillilitres, double alcoholContentInPercent) {
        super(volumeInMillilitres, alcoholContentInPercent);
    }

    @Override
    public double findMassOfRawAlcohol(Drink beer) {
       return beer.volumeInMillilitres * MassOfRawAlcohol.DENSITY_OF_ALCOHOL * beer.alcoholContentInPercent / 100;
    }
}
