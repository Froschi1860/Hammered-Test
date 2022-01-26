package se.hkr;

import java.util.ArrayList;
import java.util.function.BinaryOperator;

public class User {
    double weight, height, bmi, duration;
    String gender;
    final double METABOLIC_RATE = 0.015;
    ArrayList drinkList = new ArrayList();

    User(double height, double weight, double duration, String gender) {
        this.weight = weight;
        this.height = height;
        this.duration = duration;
        this.bmi = calcBMI.apply(height, weight);
    }

    private BinaryOperator<Double> calcBMI = (height, weight) -> weight / Math.pow(height / 100, 2.0);
}
