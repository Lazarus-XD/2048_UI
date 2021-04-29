package src;

import src.MeanCalculator;

import java.util.ArrayList;

public class Seq1D {

    private ArrayList<Double> s;
    private MeanCalculator meanCalculator;

    public Seq1D(ArrayList<Double> x, MeanCalculator m) {
        if(x.size() == 0) {
            throw new IllegalArgumentException("Length of x cannot be zero");
        }
        s = x;
        meanCalculator = m;
    }

    public void setMeanCalculator(MeanCalculator m) {
        meanCalculator = m;
    }

    public Double mean() {
        return meanCalculator.meanCalc(s);
    }
}