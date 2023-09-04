package Traversals;

import MyObjects.*;
import Helpful.*;

import java.util.*;

public class DFS {
    private final Map<Vertex, String> color = new HashMap<>();
    private final Map<Vertex, Integer> discoveryTime = new HashMap<>();
    private final Map<Vertex, Integer> finishTime = new HashMap<>();
    private final Map<Vertex, Vertex> parent = new HashMap<>();
    private final List<Vertex> orderList = new LinkedList<>();
    private int time = 0;
    private int step = 0;

    public void depthFirstSearch(Graph G, Vertex s)
    {
        for (Vertex u : G.getVertices())
        {
            color.put(u, "white");
            discoveryTime.put(u, 0);
            finishTime.put(u, 0);
            parent.put(u, null);
        }

        StatePrinter.printDFSStateStart(G, s, color,  discoveryTime, finishTime, parent);

        dfsVisit(G, s);

        for (Vertex u : G.getVertices())
            if (color.get(u).equals("white"))
                dfsVisit(G, u);

        StatePrinter.printDFSStateFinish(G, color, discoveryTime, finishTime, parent);
        StatePrinter.printVerticesOrder(orderList);
    }

    private void dfsVisit(Graph G, Vertex u) {

        color.put(u, "grey");
        discoveryTime.put(u, ++time);

        StatePrinter.printDFSState(G, u, color, discoveryTime, finishTime, parent, ++step);

        for (Vertex v : G.getAdjacencyList(u))
            if (color.get(v).equals("white"))
            {
                parent.put(v, u);
                dfsVisit(G, v);
            }

        color.put(u, "black");
        finishTime.put(u, ++time);
        orderList.add(u);
    }
}
