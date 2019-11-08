import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;

class SearchEngine
{
    private Search search;

    void setSearch(Search search)
    {
        this.search = search;
    }

    void find(ArrayList<String> people, Map<String, HashSet<Integer>> list) throws IOException
    {
        this.search.find(people,list);
    }
}
