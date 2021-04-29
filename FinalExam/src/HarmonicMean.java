package src;

import java.util.ArrayList;

public class HarmonicMean implements MeanCalculator {

    @Override
    public Double meanCalc(ArrayList<Double> v) {
        Double denom = 0.0;
        for(Double i: v) {
            denom += 1/i;
        }
        return v.size()/denom;
    }
}