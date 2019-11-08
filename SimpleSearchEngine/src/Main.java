import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;


public class Main
{

    private static Map<String, HashSet<Integer>> list = new HashMap<>();
    private static ArrayList<String> people = new ArrayList<>();
    private static SearchEngine engine = new SearchEngine();

    public static void main(String[] args) throws IOException
    {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));

        reader(args[1]);

        boolean search = true;
        while (search) {
            System.out.println("\n=== Menu ===\n" +
                    "1. Find a person\n" +
                    "2. Print all people\n" +
                    "0. Exit");
            switch (Integer.parseInt(buf.readLine())) {
                case 1:
                    find();
                    break;
                case 2:
                    print();
                    break;
                case 0:
                    search = false;
                    System.out.println("\nBye!");
                    break;
                default:
                    System.out.println("\nIncorrect option! Try again.");
                    break;
            }
        }
    }

    private static void find() throws IOException
    {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("\nSelect a matching strategy");

        switch (buf.readLine()){
            case "ALL":
                engine.setSearch(new IndexSearchALL());
                engine.find(people,list);
                break;
            case "ANY":
               engine.setSearch(new IndexSearchANY());
               engine.find(people,list);
               break;
            case "NONE":
                engine.setSearch(new IndexSearchNONE());
                engine.find(people,list);
                break;
            default: break;
        }
    }

    private static void reader(String file) throws IOException
    {
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line;
        int i = 0;
        while ((line = reader.readLine()) != null) {
            people.add(line);
            String[] words = line.toLowerCase().split(" ");
            for (String word : words) {
                if(!list.containsKey(word)) {
                    list.put(word,new HashSet<>());
                }
                list.get(word).add(i);
            }
            i++;
        }
        reader.close();
    }

    private static void print()
    {
        System.out.println("\n=== List of people ===");
        for (String pep : people) {
            System.out.println(pep);
        }
    }
}