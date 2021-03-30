package src;

import src.Measures;
import src.AttributeT;
import src.IndicatorT;
import src.Services;
import src.Norm;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class CourseT implements Measures {

    protected String name;
    protected HashMap<IndicatorT, HashSet<LOsT>> m = new HashMap<IndicatorT, HashSet<LOsT>>();

    public CourseT(String courseName, IndicatorT[] indicators) {
        this.name = courseName;
        for(IndicatorT i : indicators) {
            HashSet<LOsT> s = new HashSet<LOsT>();
            this.m.put(i, s);
        }
    }

    public String getName() {
        return this.name;
    }

    public IndicatorT[] getIndicators() {
        int val = 0;
        IndicatorT[] out = new IndicatorT[m.size()];
        for(IndicatorT i : m.keySet()) {
            out[val] = i;
            val++;
        }
        return out;
    }

    public LOsT[] getLOs(IndicatorT indicator) {
        if(!this.m.containsKey(indicator)) return new LOsT[]{};

        LOsT[] out = new LOsT[m.get(indicator).size()];
        int val = 0;
        for(LOsT i : m.get(indicator)) {
            out[val] = i;
            val++;
        }
        return out;
    }

    public void addLO(IndicatorT indicator, LOsT outcome) {
         for(IndicatorT key : m.keySet()) {
             if(key == indicator) m.get(key).add(outcome);
         }
    }

    public void delLO(IndicatorT indicator, LOsT outcome) {
        for(IndicatorT key : m.keySet()) {
            if(key == indicator) m.get(key).remove(outcome);
        }
    }

    public boolean member(IndicatorT indicator, LOsT[] outcomes) {
        if(!m.containsKey(indicator)) return false;
        HashSet<LOsT> l = new HashSet<LOsT>(Arrays.asList(outcomes));
        return m.get(indicator).equals(l);
    }

    @Override
    public double[] measures(){
        throw new UnsupportedOperationException();
    }

    @Override
    public double[] measures(IndicatorT ind){
        double[] measureInd = new double[]{0,0,0,0};
        if(Arrays.equals(getLOs(ind), new LOsT[]{})) return new double[]{0,0,0,0};
        else {
            for(LOsT i : getLOs(ind)) {
                double[] val = i.measures();
                for(int j = 0; j < 4; j++)
                    measureInd[j] = measureInd[j] + val[j];
            }
            if(Norm.getNInd()) return Services.normal(measureInd);
            else return measureInd;
        }
    }

    @Override
    public double[] measures(AttributeT att){
        double[] measureInd = new double[]{0,0,0,0};
        if(Arrays.equals(att.getIndicators(), new IndicatorT[]{})) return new double[]{0,0,0,0};
        else {
            for(IndicatorT i : att.getIndicators()) {
                double[] val = measures(i);
                for(int j = 0; j < 4; j++)
                    measureInd[j] = measureInd[j] + val[j];
            }
            if(Norm.getNAtt()) return Services.normal(measureInd);
            else return measureInd;
        }
    }
}