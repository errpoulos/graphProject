import java.util.LinkedList;

public class Graph {

    int Vertex;
    LinkedList<Integer> adjListArray[];

    //constructor
    Graph(int Vertex) {
        this.Vertex = Vertex;
        adjListArray = new LinkedList[Vertex];
        for (int i = 0; i < Vertex; i++) {
            adjListArray[i] = new LinkedList<>();
        }
    }

    /**
     * Adds an edge to an undirected graph
     * @param graph
     * @param src
     * @param dest
     */
    static void addEdge(Graph graph, int src, int dest) {
        graph.adjListArray[src].addFirst(dest);
        graph.adjListArray[dest].addFirst(src);
    }

}

