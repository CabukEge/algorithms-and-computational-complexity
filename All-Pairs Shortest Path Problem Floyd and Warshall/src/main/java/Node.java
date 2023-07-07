import java.util.ArrayList;

public class Node implements Comparable<Node> {
    //I think quick and dirty is "ok" for this program
    public int Number;
    public int Distance;
    public Node Predecessor;
    public ArrayList<Edge> Edges;

    public Node(int number, int distance, Node predecessor){
        Number = number;
        Distance = distance;
        Predecessor = predecessor;
        Edges = new ArrayList<>();
    }
    public Integer getDistance() {
        return Distance;
    }

    @Override
    public int compareTo(Node o) {
        if(getDistance() == -1){
            return 0;
        }else{
            return getDistance().compareTo(o.getDistance());
        }


    }
}

