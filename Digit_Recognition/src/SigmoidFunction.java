import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Random;


public class SigmoidFunction implements Learn
{
    private final int WEIGHT_SIZE = 15;
    String filename;

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
    public void learning(String filename)
    {
        this.filename = filename;
        System.out.println("Learning...");
        double[][] weight = new double[10][WEIGHT_SIZE];
        for (int j = 0; j < 10; j++) {
            Arrays.setAll(weight[j], i -> new Random().nextGaussian());
        }
        double [][] dw = new double[10][WEIGHT_SIZE];
        final double RATE = 0.5;
        int l = 0;
        while (l < 100) {
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
        write(weight);
    }

    private double Sigma(double [] weight, int num)
    {
        double res = 0;
        for (int i = 0; i < WEIGHT_SIZE; i++) {
            res += weight[i] * a[num][i];
        }
        return  1/(1 + Math.exp(-res));
    }
    private void write(double [][] weight)
    {
        try {
            PrintWriter out = new PrintWriter(new FileOutputStream(filename));
            for (int i = 0; i < 10; i++) {
                Arrays.stream(weight[i]).forEach((d) -> out.print(d + " "));
                out.print("\n");
            }
            out.flush();
            System.out.println("Done! Saved to the file.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
