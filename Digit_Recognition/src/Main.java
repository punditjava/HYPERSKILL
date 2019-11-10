import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main
{

    public static void main(String[] args) throws IOException
    {
        boolean flag = true;

        NeuralNetwork network = new NeuralNetwork();
        network.setFilename("/home/andrey/HYPERSKILL/Digit_Recognition/text.txt");
        network.setLearn(new SigmoidFunction());
        network.setGuess(new StadartGuess());


        while (flag) {
            BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("1. Learn the network\n" +
                    "2. Guess a number\n" +
                    "Your choice:");
            switch (buf.readLine()) {
                case "1" :
                    network.learning();
                    break;
                case "2" :
                    int [] inputNeurons = new int[15];
                    int j = 0;
                    System.out.println("Input grid:");
                    for (int i = 0; i < 5;i++) {
                        String []line = buf.readLine().split("");
                        for (String l : line) {
                            inputNeurons[j] = l.equals("X") ? 1 : 0;
                            j++;
                        }
                    }
                    network.setInputNeurons(inputNeurons);
                    network.guessing();
                    flag = false;
                    break;
            }
        }
    }
}
