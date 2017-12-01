import com.sun.org.apache.xpath.internal.operations.Bool;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Graph {
    private HashMap<String, Vertex> vertices;
    private HashMap<Integer, Edge> edges;

    public Graph() {
        this.vertices = new HashMap<String, Vertex>();
        this.edges = new HashMap<Integer, Edge>();
    }

    /**
     * @param vertices The initial vertices
     */
    public Graph(ArrayList<Vertex> vertices) {
        this.vertices = new HashMap<String, Vertex>();
        this.edges = new HashMap<Integer, Edge>();

        for (Vertex v : vertices) {
            this.vertices.put(v.getLabel(), v);
        }
    }

    /**
     * @param v1 The first Vertex.
     * @param v2 The second vertex.
     * @return
     */
    public boolean addEdge(Vertex v1, Vertex v2) {
        return addEdge(v1, v2, 1);
    }


    /**
     * @param v1     The first Vertex of the Edge.
     * @param v2     The second Vertex of the Edge.
     * @param weight The weight of the Edge.
     * @return true only if no Edge already exists in the Graph.
     */
    public boolean addEdge(Vertex v1, Vertex v2, int weight) {
        if (v1.equals(v2)) {
            return false;
        }

        //checks to see if edge is already in graph
        Edge e = new Edge(v1, v2, weight);
        if (edges.containsKey(e.hashCode())) {
            return false;
        }

        //and that it isnt already incident to one of the vertices
        else if (v1.hasConnection(e) || v2.hasConnection(e)) {
            return false;
        }

        edges.put(e.hashCode(), e);
        v1.addEdge(e);
        v2.addEdge(e);
        return true;
    }

    /**
     * @param e The edge to look up.
     * @return true only if this graph contains the edge e.
     */
    public boolean containsEdge(Edge e) {
        if (e.getV1() == null || e.getV2() == null) {
            return false;
        }
        return this.edges.containsKey(e.hashCode());
    }

    /**
     * @param e The Edge to remove from the Graph.
     * @return Edge The Edge removed from the Graph.
     */
    public Edge removeEdge(Edge e) {
        e.getV1().removeConnected(e);
        e.getV2().removeConnected(e);
        return this.edges.remove((e.hashCode()));
    }

    /**
     * @param vertex The vertex to look up.
     * @return true only if this Graph contains vertex.
     */
    public boolean containsVertex(Vertex vertex) {
        return this.vertices.get((vertex.getLabel())) != null;
    }

    /**
     * @param label The specified vertex label.
     * @return true only if vertex was added to graph.
     */

    public Vertex getVertex(String label) {
        return vertices.get(label);
    }

    /**
     * This method adds a Vertex to the Graph. If a Vertex with the same
     * label as the paramater exists in the Graph, the existing Vertex is
     * overwritten only if overwriteExisting is true. If the existing Vertex
     * is overwritten, the Edges incident to it are all removed from the Graph.
     *
     * @param vertex
     * @param overwriteExisting
     * @return true only if vertex was added to graph
     */
    public boolean addVertex(Vertex vertex, boolean overwriteExisting) {
        Vertex current = this.vertices.get(vertex.getLabel());
        if (current != null) {
            if (!overwriteExisting) {
                return false;
            }
            while (current.getconnectionCount() > 0) {
                this.removeEdge(current.getConnection(0));
            }
        }

        vertices.put(vertex.getLabel(), vertex);
        return true;
    }

    /**
     * @param label The label of the Vertex to remove.
     * @return Vertex The removed Vertex object.
     */
    public Vertex removeVertex(String label) {
        Vertex v = vertices.remove(label);
        while (v.getconnectionCount() > 0) {
            this.removeEdge(v.getConnection(0));
        }
        return v;
    }

    /**
     * @return Set<String> The unique labels of the Graph's Vertex objects
     */
    public Set<String> vertexKeys() {
        return this.vertices.keySet();
    }

    /**
     * @return Set<Edge> The Edges of this graph
     */
    public Set<Edge> getEdges() {
        return new HashSet<Edge>(this.edges.values());
    }
}
