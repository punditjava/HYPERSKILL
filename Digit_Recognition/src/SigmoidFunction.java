
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;


public class SigmoidFunction implements Learn
{
    private final int WEIGHT_SIZE = 15;
    String filename;
    private HashMap<Integer,Matrix> idealNeurons = new HashMap<>();
    private HashMap<Integer,Matrix> weight = new HashMap<>();

    private final int [][] a = { {+1, +1, +1, +1, 0, +1, +1, 0, +1, +1, 0, +1, +1, +1, +1},//0
            {0, +1, 0, 0, +1, 0, 0, +1, 0, 0, +1, 0, 0, +1, 0},//1
            {+1, +1, +1, 0, 0, +1, +1, +1, +1, +1, 0, 0, +1, +1, +1},//2
            {+1, +1, +1, 0, 0, +1, +1, +1, +1, 0, 0, +1, +1, +1, +1},//3
            {+1, 0, +1, +1, 0, +1, +1, +1, +1, 0, 0, +1, 0, 0, +1},//4
            {+1, +1, +1, +1, 0, 0, +1, +1, +1, 0, 0, +1, +1, +1, +1},//5
            {+1, +1, +1, +1, 0, 0, +1, +1, +1, +1, 0, +1, +1, +1, +1},//6
            {+1, +1, +1, 0, 0, +1, 0, 0, +1, 0, 0, +1, 0, 0, +1},//7
            {+1, +1, +1, +1, 0, +1, +1, +1, +1, +1, 0, +1, +1, +1, +1},//8
            {+1, +1, +1, +1, 0, +1, +1, +1, +1, 0, 0, +1, +1, +1, +1}};//9

    @Override
    public void searchIdealNeurons(int[] quantity)
    {
        final int length = quantity.length;

        double [] [] E = new double[quantity[length - 1]][quantity[length - 1]];
        for (int i = 0; i < length; i ++ )
            E[i][i] = 1;
            idealNeurons.put(length - 1, new Matrix(E));

        for (int i = length - 2; i > 0; i--) {

            double [][] randomWeight = new double[quantity[length - 2]][idealNeurons.get(i + 1).getColumns()];
            for (int j = 0; j < 10; j++) {
                Arrays.setAll(randomWeight[j], e -> new Random().nextGaussian());
            }
            weight.put(i, new Matrix(randomWeight));

            for (int k = 0; k < quantity[i]; k++) {
                double res = 0;
                for (int l = 0; l < idealNeurons.get(i + 1).getColumns(); l++) {
                    res +=
                }
            }




        }

    }

    @Override
    public void learning(String filename)
    {
        this.filename = filename;
        System.out.println("Learning...");
        double [][] dw = new double[10][WEIGHT_SIZE];
        final double RATE = 0.5;
        int l = 0;
        while (l < 1000) {
            for (int i = 0; i < 10; i++) {

                for (int k = 0; k < 10; k++) {
                    double sigma = Sigma(weight[i], k);
                    for (int j = 0; j < WEIGHT_SIZE; j++) {
                        int ideal = (k == i) ? 1 : 0;
                        dw[k][j] = RATE * a[k][j] * (ideal - sigma);
                    }
                }

                for (int k = 0; k < WEIGHT_SIZE; k++) {
                    double mean = 0;
                    for (int j = 0; j < 10; j++) {
                        mean += dw[j][k];
                    }
                    weight[i][k] += (mean / 10);
                }
            }
            l++;
        }
        write(weight, this.filename);
    }

    private double Sigma(double [] weight, int num)
    {
        double res = 0;
        for (int i = 0; i < WEIGHT_SIZE; i++) {
            res += weight[i] * a[num][i];
        }
        return  1/(1 + Math.exp(-res));
    }

}
