import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;

public class IndexSearchANY implements Search
{

    @Override
    public void find(ArrayList<String> people, Map<String, HashSet<Integer>> list) throws IOException
    {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("\nEnter a name or email to search any suitable people.");
        String [] words = buf.readLine().toLowerCase().split(" ");
        ArrayList<Integer> set = new ArrayList<>();

        for (String word : words) {
            if(list.containsKey(word))
            for (int num : list.get(word)) {
                if (!set.contains(num)) {
                    set.add(num);
                }
            }
        }
        if(set.size() != 0) {
            System.out.println(set.size() + " persons found");
            for(Integer i : set) {
                System.out.println(people.get(i));
            }
        } else System.out.println("No matching found");
    }
}
