/**
 * @file CourseT.java
 * @author Rizwan Ahsan, ahsanm7
 * @description contains class for CourseT
 * @date March 29, 2021
 */

package src;

import src.Measures;
import src.AttributeT;
import src.IndicatorT;
import src.Services;
import src.Norm;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 * @brief An ADT that represents courses
 * @details The course contains information of students taking various courses
 */
public class CourseT implements Measures {

    protected String name;
    protected HashMap<IndicatorT, HashSet<LOsT>> m = new HashMap<IndicatorT, HashSet<LOsT>>();

    /**
     * @brief Initializes a CourseT object.
     * @param courseName name of the course
     * @param indicators list of all indicators regarding to that course
     */
    public CourseT(String courseName, IndicatorT[] indicators) {
        this.name = courseName;
        for(IndicatorT i : indicators) {
            HashSet<LOsT> s = new HashSet<LOsT>();
            this.m.put(i, s);
        }
    }

    /**
     * @brief Gets the course name
     * @return The name of the course
     */
    public String getName() {
        return this.name;
    }

    /**
     * @brief Gets the list of indicators
     * @return The indicators list regarding the course
     */
    public IndicatorT[] getIndicators() {
        int val = 0;
        IndicatorT[] out = new IndicatorT[m.size()];
        for(IndicatorT i : m.keySet()) {
            out[val] = i;
            val++;
        }
        return out;
    }

    /**
     * @brief Gets the learning outcomes
     * @return The learning outcomes of the particular course
     */
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

    /**
     * @brief Adds a learning outcome set to the particular indicator
     * @param indicator name of the indicator
     * @param outcome the learning outcome to be added to the indicator
     */
    public void addLO(IndicatorT indicator, LOsT outcome) {
         for(IndicatorT key : m.keySet()) {
             if(key == indicator) m.get(key).add(outcome);
         }
    }

    /**
     * @brief Removes a learning outcome set from the particular indicator
     * @param indicator name of the indicator
     * @param outcome the learning outcome to be removed to the indicator
     */
    public void delLO(IndicatorT indicator, LOsT outcome) {
        for(IndicatorT key : m.keySet()) {
            if(key == indicator) m.get(key).remove(outcome);
        }
    }

    /**
     * @brief Checks if the indicator and LO belong in this object
     * @param indicator name of the indicator
     * @param outcomes the list of learning outcomes
     * @return Boolean indicating if the indicator and LO is member or not
     */
    public boolean member(IndicatorT indicator, LOsT[] outcomes) {
        if(!m.containsKey(indicator)) return false;
        HashSet<LOsT> l = new HashSet<LOsT>(Arrays.asList(outcomes));
        return m.get(indicator).equals(l);
    }

    @Override
    public double[] measures(){
        throw new UnsupportedOperationException("This operation is not supported");
    }

    /**
     * @brief Measures the student in terms of the indicators
     * @param ind the provided indicators
     * @return Array of 4 representing the value of indicators
     */
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

    /**
     * @brief Measures the student in terms of the provided attributes
     * @param att the provided attributes
     * @return Array of 4 representing the value of attributes
     */
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