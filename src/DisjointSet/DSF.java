package DisjointSet;

import MyObjects.Graph;
import MyObjects.Vertex;

import java.util.stream.Collectors;

public class DSF {

    public void findConnectedComponents(Graph G) {

        DisjointSetForest dsf = new DisjointSetForest();

        for (Vertex u : G.getVertices())
            dsf.makeSet(u);

        for (Vertex u : G.getVertices())
            for (Vertex v : G.getAdjacencyListNonSorted(u))
                if (dsf.findSet(u) != dsf.findSet(v))
                {
                    System.out.println("Union: " + u.getId() + " and " + v.getId());
                    dsf.union(u, v);
                    System.out.println("Sets: " + formatSetKeys(dsf));
                    System.out.println("Ranks: " + dsf.rank.values());
                    System.out.println();
                }
    }

    private String formatSetKeys(DisjointSetForest dsf) {
        return "{" + dsf.parent.keySet().stream()
                .map(Vertex::getId)
                .map(String::valueOf)
                .collect(Collectors.joining(", ")) + "}";
    }
}
