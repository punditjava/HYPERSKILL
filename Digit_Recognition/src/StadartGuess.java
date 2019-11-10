import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

public class StadartGuess implements Guess
{
    private String filename;
    private static final int WEIGHT_SIZE = 15;

    @Override
    public void guessing(String filename, int [] inputNeurons)
    {
        this.filename = filename;
        double [][] weight = read();
        ArrayList<Double> outputNeurons = new ArrayList<>();

        if(weight != null) {
            for (int i = 0; i < 10; i++) {
                double r = 0;
                for (int k = 0; k < 15; k++) {
                    r += weight[i][k] * inputNeurons[k];
                }
                outputNeurons.add(r);
                System.out.println(r);
            }
            System.out.println("This number is " + outputNeurons.indexOf(Collections.max(outputNeurons)));

        } else System.out.println("Fail with file");
    }

    private double [][] read() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            double[][] weight = new double[10][WEIGHT_SIZE];
            for (int j =0; j < 10; j++) {
                String [] words = reader.readLine().split(" ");
                for (int i = 0; i < WEIGHT_SIZE; i++) {
                    weight[j][i] = Double.parseDouble(words[i]);
                }
            }
            return weight;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
