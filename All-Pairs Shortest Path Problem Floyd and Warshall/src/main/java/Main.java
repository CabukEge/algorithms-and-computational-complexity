import java.util.ArrayList;
import java.util.Collections;

public class Main {
    private static ArrayList<Edge> edges;
    private static ArrayList<Node> nodes;
    //index of row is current node and the collumn is the Node we want to reach
    private static int matrix[][];
    private static boolean isSetMatrix[][]; //inidcates if the current value of matrix has already been set

    public static void main(String[] args) {
        edges = new ArrayList<>();
        nodes = new ArrayList<>();
        Inizialize_Nodes();
        matrix = new int[nodes.size()][nodes.size()]; // First index rows and second is collumns
        isSetMatrix = new boolean[nodes.size()][nodes.size()];
        System.out.println(Boolean.toString(isSetMatrix[0][0]));
        System.out.println(Integer.toString(matrix[0][0]));
        System.out.println(Integer.toString(isSetMatrix.length) + " : " + Integer.toString(isSetMatrix[0].length));
        FloydAndWarshall();
        for (int i = 0; i < matrix.length ; i++) {
            for (int n: matrix[i]) {
                System.out.print(Integer.toString(n) + " : ");
            }
            System.out.print("\n");
        }






    }
    //0 0 0 0
    //0 0 0 0
    //0 0 0 0
    //0 0 0 0
    public static void FloydAndWarshall(){
        ArrayList<Node> reachableNodes = new ArrayList<>(); // K for reachable Nodes

        for (int k = 0; k < nodes.size(); k++) {
            reachableNodes.add(nodes.get(k));
            for (int i = 0; i < nodes.size() ; i++) {
                for (int j = 0; j < nodes.size(); j++) {
                    if(isSetMatrix[i][j] == false){
                        for (Edge e: nodes.get(i).Edges) {
                            if(nodes.get(j) == e.EndNode) {
                                matrix[i][j] = e.Weight;
                            }
                        }
                        isSetMatrix[i][j] = true;
                    }
                   /* if(isSetMatrix[i][j] == true && isSetMatrix[i][k] == true && isSetMatrix[k][j] == true && matrix[i][j] > matrix[i][k] + matrix[k][j]){
                        matrix[i][j] = matrix[i][k] + matrix[k][j];
                        System.out.print("i: "+ Integer.toString(i) + " - j: " +Integer.toString(j) + " - k:" +Integer.toString(k) + " : ");
                        System.out.print("\n");
                        for (int b = 0; b < matrix.length ; b++) {
                            for (int n: matrix[b]) {
                                System.out.print(Integer.toString(n) + " : ");
                            }
                            System.out.print("\n");
                        }
                        System.out.print("\n");
                    }*/

                }
            }

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
        for (int i = 0; i < 4; i++) {
            nodes.add(new Node( i, 1000000000, null));
        }
        //we have 11 edges
        edges = new ArrayList<>();
        edges.add(new Edge(nodes.get(0), nodes.get(1),8));
        edges.add(new Edge(nodes.get(0), nodes.get(3),3));
        edges.add(new Edge(nodes.get(1), nodes.get(0),6));
        edges.add(new Edge(nodes.get(2), nodes.get(0),12));
        edges.add(new Edge(nodes.get(2), nodes.get(1),1));
        edges.add(new Edge(nodes.get(3), nodes.get(2),3));
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
