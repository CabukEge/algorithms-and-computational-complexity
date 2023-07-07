import java.util.Random;

public class ApproxMaxCut {

    static public void main(String[] args) {

        Graph graph = generateGraphTypeA();

        //choose two different random  nodes
        Random rand = new Random();

        int i = rand.nextInt(graph.nodes.size());

        int j = rand.nextInt(graph.nodes.size());
        while (j == i){
            j = rand.nextInt(graph.nodes.size());
        }

        Graph S = new Graph();
        S.addNode(graph.getNodes().get(i));
        graph.nodes.remove(i);

        Graph T = new Graph();
        S.addNode(graph.getNodes().get(j));
        graph.nodes.remove(j);

        while (graph.nodes.size() > 0){
            int r = rand.nextInt(graph.nodes.size());
            int id = graph.getNodes().get(r).id;
            int countS = 0;
            int countT = 0;
            for (Edge e:S.edges) {
                if(e.startNode.id == id || e.endNode.id == id){
                    countS ++;
                    continue;
                }
            }
            for (Edge e:T.edges) {
                if(e.startNode.id == id || e.endNode.id == id){
                    countT ++;
                    continue;
                }
            }

            if(countS < countT){
                S.addNode(graph.getNodes().get(r));
                graph.nodes.remove(r);
            }
            else
            {
                T.addNode(graph.getNodes().get(r));
                graph.nodes.remove(r);
            }

        }

        System.out.println("S:");

        for (Node n:S.nodes) {
            System.out.println(n.id);
        }

        System.out.println("T:");

        for (Node n:T.nodes) {
            System.out.println(n.id);
        }

    }

    private static Graph generateGraphTypeA(){
        Graph graph = new Graph();

        graph.addNode(new Node(1));
        graph.addNode(new Node(2));
        graph.addNode(new Node(3));
        graph.addNode(new Node(4));
        graph.addNode(new Node(5));

        graph.addEdge(new Edge(graph.getNodes().get(0), graph.getNodes().get(2)));
        graph.addEdge(new Edge(graph.getNodes().get(0), graph.getNodes().get(4)));
        graph.addEdge(new Edge(graph.getNodes().get(1), graph.getNodes().get(3)));
        graph.addEdge(new Edge(graph.getNodes().get(4), graph.getNodes().get(2)));

        return graph;
    }

}
