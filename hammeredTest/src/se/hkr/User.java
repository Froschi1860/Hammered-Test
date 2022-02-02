package se.hkr;

import java.util.ArrayList;
import java.util.function.BinaryOperator;

public class User {

    public final double METABOLIC_RATE_OF_ALCOHOL = 0.015D;
    private double weightInKg;
    private double heightInCentimeters;
    private double bmi;
    private double durationOfDrinkingInHours;
    private String gender;
    private ArrayList<Drink> consumedDrinks = new ArrayList<>();
    private double individualWidmarkFactor;


    public User(double heightInCentimeters, double weightInKg, double durationOfDrinkingInHours, String gender) {
        this.weightInKg = weightInKg;
        this.heightInCentimeters = heightInCentimeters;
        this.durationOfDrinkingInHours = durationOfDrinkingInHours;
        this.gender = gender;
        this.bmi = this.calculateBMI.apply(heightInCentimeters, weightInKg);
        this.individualWidmarkFactor = this.calculateIndividualWidmarkFactor(this.bmi, gender);
    }

    public static double calculateBloodAlcoholContent(User user) {
        double bloodAlcoholContent =
            ((100 * calculateTotalMassOfConsumedAlcohol(user)) / (user.individualWidmarkFactor * user.weightInKg))
            - (user.METABOLIC_RATE_OF_ALCOHOL * user.durationOfDrinkingInHours);
        return (bloodAlcoholContent > 0) ? bloodAlcoholContent : 0;
    }

    public static double calculateTimeToSobrietyInHours(User user) {
        return calculateTotalMassOfConsumedAlcohol(user) / user.METABOLIC_RATE_OF_ALCOHOL;
    }

    private static double calculateTotalMassOfConsumedAlcohol (User user){
        return user.consumedDrinks.stream()
                .mapToDouble(drink -> drink.findMassOfRawAlcohol(drink))
                .sum();
    }

   public void setConsumedDrinks(ArrayList<Drink> consumedDrinks) {
        this.consumedDrinks = consumedDrinks;
   }

    public void setWeightInKg(double weightInKg) {
        this.weightInKg = weightInKg;
        this.setBmi(this.heightInCentimeters, weightInKg);
        this.setIndividualWidmarkFactor(this.bmi, this.gender);
    }

    public void setHeightInCentimeters(double heightInCentimeters) {
        this.heightInCentimeters = heightInCentimeters;
        this.setBmi(heightInCentimeters, this.weightInKg);
        this.setIndividualWidmarkFactor(this.bmi, this.gender);
    }

    private final BinaryOperator<Double> calculateBMI =
            (heightInCentimeters, weightInKg) -> weightInKg / Math.pow(heightInCentimeters / 100, 2.0D);

    private void setBmi(double heightInCentimeters, double weightInKg) {
        this.bmi = calculateBMI.apply(heightInCentimeters, weightInKg);
    }

    private double calculateIndividualWidmarkFactor(double bmi, String gender){
        // Derive Widmark factor from table in source
        return switch (gender) {
            case "M" -> (bmi < 19.9) ? 0.8 : (bmi < 23.3) ? 0.75 : (bmi < 25.95) ? 0.72 : (bmi < 28.4) ? 0.69 : 0.66;
            case "F" -> (bmi < 17.85) ? 0.74 : (bmi < 21.45) ? 0.69 : (bmi < 24.05) ? 0.65 : (bmi < 26.3) ? 0.62 : 0.6;
            default -> 0.0;
        };
    }

    private void setIndividualWidmarkFactor(double bmi, String gender) {
        this.individualWidmarkFactor = calculateIndividualWidmarkFactor(bmi, gender);
   }

    @Override
    public String toString() {
        return "It will take you %d hours to get sober" +
                "         . .\n" +
                "       .. . *.\n" +
                "- -_ _-__-0oOo\n" +
                " _-_ -__ -||||)\n" +
                "    ______||||______\n" +
                "~~~~~~~~~~`\"\"'" + calculateTimeToSobrietyInHours(this);
                // ASCII art taken from ASCII art archive (source in presentation)
    }
}
