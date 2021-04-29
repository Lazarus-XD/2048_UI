package src;

import java.util.ArrayList;

public class QuadraticMean implements MeanCalculator {

    @Override
    public Double meanCalc(ArrayList<Double> v) {
        Double num = 0.0;
        for(Double i: v) {
            num += i*i;
        }
        return Math.sqrt(num/v.size());
    }
}