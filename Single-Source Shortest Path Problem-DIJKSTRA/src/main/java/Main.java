import java.util.*;

public class Main {
    private static ArrayList<Edge> edges;
    private static ArrayList<Node> nodes;

    public static void main(String[] args) {
        edges = new ArrayList<>();
        nodes = new ArrayList<>();
        Inizialize_Nodes();
        System.out.println("\n");
        for (Node n : nodes) {
            System.out.println("Start: " + Integer.toString(n.Number) + " Distance: " + Integer.toString(n.Distance));

        }
        System.out.println("\n");
        DIJKSTRA(0);
        System.out.println("\n");
        for (Node n:nodes) {
            System.out.println("Start: " + Integer.toString(n.Number) + " Distance: " + Integer.toString(n.Distance));
        }





    }
    public static void DIJKSTRA(int startnodeIndex) {
        int currentindex = startnodeIndex;

        ArrayList<Node> nodesFinished = new ArrayList<>();

        ArrayList<Node> reachableNodes = new ArrayList<>();

        nodes.get(currentindex).Distance = 0;

        MakeCurrentNode(nodes.get(currentindex));

        while(nodes.size() != 0){
            reachableNodes = new ArrayList<>();
            System.out.println("reachablenodes run: ");
            for (Edge e : nodes.get(currentindex).Edges) {
                reachableNodes.add(e.EndNode);
                //i want to check if the edges are correct
                System.out.println("FROM: " + nodes.get(currentindex).Number + " TO: " + Integer.toString(e.EndNode.Number));
            }
            System.out.println("\n");
            Collections.sort(reachableNodes);
            while(reachableNodes.size() != 0){
                for (Node n : reachableNodes) {
                    MakeCurrentNode(n);
                }
                reachableNodes.removeAll(reachableNodes);


            }
            nodesFinished.add(nodes.get(currentindex));
            nodes.remove(currentindex);
            Collections.sort(nodes);
            currentindex = 0;
        }
        nodes = nodesFinished;




    }

    public static void MakeCurrentNode(Node currentnode){
        for (int i = 0; i < currentnode.Edges.size(); i++) {
            if (currentnode.Distance + currentnode.Edges.get(i).Weight < currentnode.Edges.get(i).EndNode.Distance) {
                currentnode.Edges.get(i).EndNode.Distance = currentnode.Distance + currentnode.Edges.get(i).Weight;
            }
        }
    }


    public static void Inizialize_Nodes()
    {
        //Adding the graph with no database :(
        //i think i will add a Database later haha#
        for (int i = 0; i < 7; i++) {
            nodes.add(new Node( i, 1000000000, null));
        }
        //we have 11 edges
        edges = new ArrayList<>();
        edges.add(new Edge(nodes.get(0), nodes.get(1),2));
        edges.add(new Edge(nodes.get(0), nodes.get(2),4));
        edges.add(new Edge(nodes.get(1), nodes.get(3),4));
        edges.add(new Edge(nodes.get(1), nodes.get(4),4));
        edges.add(new Edge(nodes.get(1), nodes.get(2),3));
        edges.add(new Edge(nodes.get(2), nodes.get(4),3));
        edges.add(new Edge(nodes.get(3), nodes.get(1),6));
        edges.add(new Edge(nodes.get(3), nodes.get(5),1));
        edges.add(new Edge(nodes.get(3), nodes.get(6),3));
        edges.add(new Edge(nodes.get(4), nodes.get(6),2));
        edges.add( new Edge(nodes.get(6), nodes.get(5),2));
        for (Edge e : edges) {
            for (Node n : nodes){
                if(e.StartNode == n){
                    n.Edges.add(e);
                }
            }
        }
        //Check Console
        for (Node n: nodes) {
            for (Edge e: n.Edges){
                System.out.println("Start: " + Integer.toString(n.Number) + " -Check Start: " + Integer.toString(e.StartNode.Number) + " -End: " + Integer.toString(e.EndNode.Number) + " -Weigth: " + Integer.toString(e.Weight));
            }
        }

    }
}
