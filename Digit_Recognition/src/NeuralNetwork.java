public class NeuralNetwork
{
    private String filename;
    private int [] inputNeurons;
    Learn learn;
    Guess guess;

    public void setLearn(Learn learn)
    {
        this.learn = learn;
    }

    public void learning()
    {
        learn.learning(filename);
    }

    public void setGuess(Guess guess)
    {
        this.guess = guess;
    }

    public void guessing()
    {
        guess.guessing(filename, this.inputNeurons);
    }

    public void setFilename(String filename)
    {
        this.filename = filename;
    }

    public void setInputNeurons(int[] inputNeurons)
    {
        this.inputNeurons = inputNeurons;
    }
}
