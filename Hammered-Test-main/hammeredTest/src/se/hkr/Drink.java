package se.hkr;

public abstract class Drink implements MassOfRawAlcohol<Drink> {
    double volume, percent;

    Drink(double volume, double percent) {
        this.volume = volume;
        this.percent = percent;
    }

    public abstract double findMassOfRawAlcohol(Drink drink);

    @Override
    public String toString() {
        return "You have had a total of %d ml and %d.2f of alcohol to drink tonight" + volume + percent;

    }
}
