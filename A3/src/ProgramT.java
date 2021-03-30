package src;

import src.Measures;
import src.AttributeT;
import src.IndicatorT;
import src.Services;
import src.Norm;
import src.CourseT;

import java.util.HashSet;

public class ProgramT extends HashSet<CourseT> implements Measures{

    @Override
    public double[] measures() {
        throw new UnsupportedOperationException("This operation is not supported");
    }

    @Override
    public double[] measures(IndicatorT ind) {
        throw new UnsupportedOperationException("This operation is not supported");
    }

    @Override
    public double[] measures(AttributeT att) {
        double[] measureInd = new double[]{0,0,0,0};
        for(CourseT c : this) {
            double[] val = c.measures(att);
            for(int j = 0; j < 4; j++)
                measureInd[j] = measureInd[j] + val[j];
        }
        return Services.normal(measureInd);
    }
}