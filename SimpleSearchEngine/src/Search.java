import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;

public interface Search
{
    void find(ArrayList<String> people, Map<String, HashSet<Integer>> list) throws IOException;
}
