import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

public interface Learn
{
    void learning(String filename);
    void searchIdealNeurons(int [] quantity);

    default void write(double[][] weight, String filename)
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
