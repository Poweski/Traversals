import MyObjects.*;
import Traversals.*;
import DisjointSet.DSF;

public class Main {

    public static void main(String[] args) {

        Graph graphTraversals = new Graph();
        Graph graphForest = new Graph();

        Vertex va = new Vertex("a");
        Vertex vb = new Vertex("b");
        Vertex vc = new Vertex("c");
        Vertex vd = new Vertex("d");
        Vertex ve = new Vertex("e");
        Vertex vf = new Vertex("f");
        Vertex vg = new Vertex("g");
        Vertex vh = new Vertex("h");
        Vertex vi = new Vertex("i");
        Vertex vs = new Vertex("s");
        Vertex vt = new Vertex("t");

        graphTraversals.addVertex(va);
        graphTraversals.addVertex(vb);
        graphTraversals.addVertex(vc);
        graphTraversals.addVertex(vd);
        graphTraversals.addVertex(ve);
        graphTraversals.addVertex(vf);
        graphTraversals.addVertex(vg);
        graphTraversals.addVertex(vh);
        graphTraversals.addVertex(vi);
        graphTraversals.addVertex(vs);
        graphTraversals.addVertex(vt);

        graphForest.addVertex(va);
        graphForest.addVertex(vb);
        graphForest.addVertex(vc);
        graphForest.addVertex(vd);
        graphForest.addVertex(ve);
        graphForest.addVertex(vf);
        graphForest.addVertex(vg);
        graphForest.addVertex(vh);
        graphForest.addVertex(vi);

        graphTraversals.addEdge(vf, vc);
        graphTraversals.addEdge(vc, vs);
        graphTraversals.addEdge(vs, va);
        graphTraversals.addEdge(vs, vb);
        graphTraversals.addEdge(va, vd);
        graphTraversals.addEdge(vb, vd);
        graphTraversals.addEdge(vb, ve);
        graphTraversals.addEdge(vd, vg);
        graphTraversals.addEdge(ve, vg);
        graphTraversals.addEdge(ve, vh);
        graphTraversals.addEdge(ve, vi);
        graphTraversals.addEdge(vg, vh);
        graphTraversals.addEdge(vg, vi);
        graphTraversals.addEdge(vg, vt);
        graphTraversals.addEdge(vh, vt);
        graphTraversals.addEdge(vh, vi);
        graphTraversals.addEdge(vi, vt);

        graphForest.addEdge(va, vc);
        graphForest.addEdge(vd, vf);
        graphForest.addEdge(vd, vi);
        graphForest.addEdge(vf, vi);
        graphForest.addEdge(ve, vh);
        graphForest.addEdge(vb, vg);
        graphForest.addEdge(va, vb);
        graphForest.addEdge(vb, vc);
        graphForest.addEdge(vc, vg);

        BFS bfs = new BFS();
        bfs.breadthFirstSearch(graphTraversals, vs);

        DFS dfs = new DFS();
        dfs.depthFirstSearch(graphTraversals, vs);

        DSF dsf = new DSF();
        dsf.findConnectedComponents(graphForest);
    }
}
