package src;

import src.Measures;
import src.AttributeT;
import src.IndicatorT;
import src.Services;
import src.Norm;

public class LOsT implements Measures {

    private String name;
    private int n_blw;
    private int n_mrg;
    private int n_mts;
    private int n_exc;

    public LOsT(String topic, int nblw, int nmrg, int nmts, int nexc) {
        boolean first = (nblw < 0) || (nmrg < 0) || (nmts < 0) || (nexc < 0);
        boolean second = (nblw == 0) && (nmrg == 0) && (nmts == 0) && (nexc == 0);
        if(first || second) throw new IllegalArgumentException();

        this.name = topic;
        this.n_blw = nblw;
        this.n_mrg = nmrg;
        this.n_mts = nmts;
        this.n_exc = nexc;
    }

    public String getName() {
        return this.name;
    }

    public boolean equals(LOsT o) {
        return o.getName().equals(this.getName());
    }

    @Override
    public double[] measures(){
        if(!Norm.getNLOs()) return new double[] {n_blw, n_mrg, n_mts, n_exc};
        else return Services.normal(new double[] {n_blw, n_mrg, n_mts, n_exc});
    }

    @Override
    public double[] measures(AttributeT att){
        throw new UnsupportedOperationException();
    }

    @Override
    public double[] measures(IndicatorT ind){
        throw new UnsupportedOperationException();
    }
}