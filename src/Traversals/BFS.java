package Traversals;

import Helpful.*;
import MyObjects.*;

import java.util.*;

public class BFS {

    public void breadthFirstSearch(Graph G, Vertex s) {
        Map<Vertex, String> color = new HashMap<>();
        Map<Vertex, Integer> distance = new HashMap<>();
        Map<Vertex, Vertex> parent = new HashMap<>();
        List<Vertex> orderList = new LinkedList<>();
        int step = 0;

        for (Vertex u : G.getVertices()) {
            color.put(u, "white");
            distance.put(u, Integer.MAX_VALUE);
            parent.put(u, null);
        }

        color.put(s, "grey");
        distance.put(s, 0);
        parent.put(s, null);

        Queue<Vertex> queue = new LinkedList<>();
        queue.add(s);

        StatePrinter.printBFSStateStart(G,s,color,distance,parent);

        while (!queue.isEmpty()) {
            Vertex u = queue.poll();

            for (Vertex v : G.getAdjacencyList(u)) {
                if (color.get(v).equals("white")) {
                    color.put(v, "grey");
                    distance.put(v, distance.get(u) + 1);
                    parent.put(v, u);
                    queue.add(v);
                }
            }

            color.put(u, "black");
            orderList.add(u);
            StatePrinter.printBFSState(G,u,color,distance,parent,++step);
        }

        StatePrinter.printVerticesOrder(orderList);
    }
}
