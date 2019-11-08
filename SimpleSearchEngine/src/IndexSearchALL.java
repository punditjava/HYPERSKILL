import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;

public class IndexSearchALL implements Search
{
    @Override
    public void find(ArrayList<String> people, Map<String, HashSet<Integer>> list) throws IOException
    {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("\nEnter a name or email to search all suitable people.");
        String[] words = buf.readLine().toLowerCase().split(" ");

        ArrayList<Integer> set = new ArrayList<>();
        boolean flag = true;

        if (list.containsKey(words[0])) {
            for (int num : list.get(words[0])) {
                for (String word : words) {
                    if (!list.get(word).contains(num)) {
                        flag = false;
                    }
                }
                if (flag) {
                    set.add(num);
                }
                flag = true;
            }

            if (set.size() != 0) {
                System.out.println(set.size() + " persons found");
                for (Integer i : set) {
                    System.out.println(people.get(i));
                }
            } else System.out.println("No matching found");
            
        } else System.out.println("No matching found");
    }
}
