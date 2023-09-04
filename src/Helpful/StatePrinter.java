package Helpful;

import java.util.List;
import java.util.Map;

import MyObjects.*;

public class StatePrinter {

    public static void printBFSStateStart(Graph G, Vertex s, Map<Vertex, String> color, Map<Vertex, Integer> distance,
                                          Map<Vertex, Vertex> parent) {
        System.out.println("\nKrok: 0");
        System.out.println("Start: " + s.getId());
        printBFSLoop(G, color, distance, parent);
    }

    public static void printBFSState(Graph G, Vertex u, Map<Vertex, String> color, Map<Vertex, Integer> distance,
                                     Map<Vertex, Vertex> parent, int step) {
        System.out.println("\nKrok: " + step);
        System.out.println("Przetwarzanie wierzchołka: " + u.getId());
        printBFSLoop(G, color, distance, parent);
    }

    private static void printBFSLoop(Graph G, Map<Vertex, String> color, Map<Vertex, Integer> distance,
                                     Map<Vertex, Vertex> parent) {
        System.out.println("\nObecne kolory:");
        for (Vertex v : G.getVertices())
            System.out.println("Wierzchołek " + v.getId() + ": " + color.get(v));

        System.out.println("\nLista odległości:");
        for (Vertex v : G.getVertices())
            System.out.println("Wierzchołek " + v.getId() + ": " + distance.get(v));

        System.out.println("\nLista rodziców:");
        for (Vertex v : G.getVertices())
            System.out.println("Wierzchołek " + v.getId() + ": "
                    + (parent.get(v) == null ? null : parent.get(v).getId()));
        for (int i = 0; i < 69; i++)
            System.out.print("-");
        System.out.println();
    }

    public static void printDFSStateStart(Graph G, Vertex s, Map<Vertex, String> color, Map<Vertex, Integer> discoveryTime,
                                          Map<Vertex, Integer> finishTime, Map<Vertex, Vertex> parent) {
        System.out.println("\nKrok: 0");
        System.out.println("Start: " + s.getId());
        printDFSLoop(G, color, discoveryTime, finishTime, parent);
    }

    public static void printDFSState(Graph G, Vertex u, Map<Vertex, String> color, Map<Vertex, Integer> discoveryTime,
                                     Map<Vertex, Integer> finishTime, Map<Vertex, Vertex> parent, int step) {
        System.out.println("\nKrok: " + step);
        System.out.println("Przetwarzanie wierzchołka: " + u.getId());
        printDFSLoop(G, color, discoveryTime, finishTime, parent);
    }

    public static void printDFSStateFinish(Graph G, Map<Vertex, String> color, Map<Vertex, Integer> discoveryTime,
                                          Map<Vertex, Integer> finishTime, Map<Vertex, Vertex> parent) {
        System.out.println("\nStan końcowy:");
        printDFSLoop(G, color, discoveryTime, finishTime, parent);
    }

    private static void printDFSLoop(Graph G, Map<Vertex, String> color, Map<Vertex, Integer> discoveryTime,
                                     Map<Vertex, Integer> finishTime, Map<Vertex, Vertex> parent) {
        System.out.println("\nObecne kolory:");
        for (Vertex v : G.getVertices())
            System.out.println("Wierzchołek " + v.getId() + ": " + color.get(v));

        System.out.println("\nCzasy przybycia do wierzchołka:");
        for (Vertex v : G.getVertices())
            System.out.println("Wierzchołek " + v.getId() + ": " + discoveryTime.get(v));

        System.out.println("\nCzasy opuszczenia wierzchołka:");
        for (Vertex v : G.getVertices())
            System.out.println("Wierzchołek " + v.getId() + ": " + finishTime.get(v));

        System.out.println("\nLista rodziców:");
        for (Vertex v : G.getVertices())
            System.out.println("Wierzchołek " + v.getId() + ": "
                    + (parent.get(v) == null ? null : parent.get(v).getId()));
        for (int i = 0; i < 69; i++)
            System.out.print("-");
        System.out.println();
    }

    public static void printVerticesOrder(List<Vertex> orderList) {
        System.out.print("\nKolejność odwiedzania wierzchołków: ");
        for (Vertex v : orderList)
            System.out.print(v.getId() + "; ");
        System.out.println();
    }
}
