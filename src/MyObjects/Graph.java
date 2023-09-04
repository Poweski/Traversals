package MyObjects;

import java.util.*;

public class Graph {
    private final Map<Vertex, List<Vertex>> adjacencyList;

    public Graph() {
        adjacencyList = new HashMap<>();
    }

    public void addVertex(Vertex v) {
        adjacencyList.put(v, new ArrayList<>());
    }

    public void addEdge(Vertex u, Vertex v) {
        adjacencyList.get(u).add(v);
        adjacencyList.get(v).add(u);
    }

    public List<Vertex> getVertices() {
        List<Vertex> list = new ArrayList<>(adjacencyList.keySet());
        list.sort(Comparator.comparing(Vertex::getId));
        return list;
    }

    public List<Vertex> getAdjacencyList(Vertex v) {
        List<Vertex> list = adjacencyList.get(v);
        list.sort(Comparator.comparing(Vertex::getId));
        return list;
    }

    public List<Vertex> getAdjacencyListNonSorted(Vertex v) {
        return adjacencyList.get(v);
    }
}