import java.util.ArrayList;
import java.util.List;

class Graph {
    List<Edge> edges = new ArrayList<>();
    List<Node> nodes = new ArrayList<>();

    void addNode(Node n) {
        nodes.add(n);
    }

    void addEdge(Edge e) {
        edges.add(e);
    }

    List<Edge> getEdges() {
        return edges;
    }

    List<Node> getNodes() {
        return nodes;
    }
}