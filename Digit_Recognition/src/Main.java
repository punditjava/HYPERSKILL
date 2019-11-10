import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

public class Main
{

    public static void main(String[] args) throws IOException
    {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        int [] inputNeurons = new int[15];
        int j = 0;
        for (int i = 0; i < 5;i++) {
            String []line = buf.readLine().split("");
            for (String l : line) {
                inputNeurons[j] = l.equals("X") ? 1 : 0;
                j++;
            }
        }

        NeuralNetwork network = new NeuralNetwork();
        network.setLearn(new SigmoidFunction());
        network.learning();
        network.setGuess(new StadartGuess());
        network.setInputNeurons(inputNeurons);
        network.guessing();

    }
}
