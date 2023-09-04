package DisjointSet;

import java.util.HashMap;
import java.util.Map;

import MyObjects.Vertex;

public class DisjointSetForest {
    public final Map<Vertex, Vertex> parent = new HashMap<>();
    public final Map<Vertex, Integer> rank = new HashMap<>();

    public void makeSet(Vertex x)
    {
        parent.put(x, x);
        rank.put(x, 0);
    }

    public Vertex findSet(Vertex x)
    {
        if (x != parent.get(x))
            parent.put(x, findSet(parent.get(x)));

        return parent.get(x);
    }

    public void union(Vertex x, Vertex y)
    {
        link(findSet(x), findSet(y));
    }

    private void link(Vertex x, Vertex y)
    {
        if (rank.get(x) > rank.get(y))
            parent.put(y, x);
        else
        {
            parent.put(x, y);

            if (rank.get(x).equals(rank.get(y)))
                rank.put(y, rank.get(y) + 1);
        }
    }
}
