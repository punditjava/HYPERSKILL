import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;

public class IndexSearchNONE implements Search
{
    @Override
    public void find(ArrayList<String> people, Map<String, HashSet<Integer>> list) throws IOException
    {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("\nEnter a name or email to search none suitable people.");
        String [] words = buf.readLine().toLowerCase().split(" ");

        ArrayList<Integer> set = new ArrayList<>();
        for (int i = 0; i <people.size();i++) {
            set.add(i);
        }

        for (String word : words) {
        if(list.containsKey(word))
            for (int num : list.get(word)) {
                if (set.contains(num)) {
                    set.remove((Integer) num);
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
