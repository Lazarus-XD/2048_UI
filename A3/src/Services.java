package src;

public class Services {

    public double[] normal(double[] v) {
        double summ = 0;
        double[] output = new double[v.length];
        for (double i : v) summ += i;
        for (int i = 0; i < v.length; i++) {
            output[i] = v[i] / summ;
        }
        return output;
    }
}