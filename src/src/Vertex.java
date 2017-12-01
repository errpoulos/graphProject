import java.util.ArrayList;
import java.util.List;

public class Vertex {
    private ArrayList<Edge> connections;
    private String label;

    /**
     * @param label The Unique label for this vertex.
     */
    public Vertex(String label) {
        this.label = label;
        this.connections = new ArrayList<Edge>();
    }

    /**
     * Adds an edge to the group of connections if the edge is not already present.
     *
     * @param edge The edge to add.
     */
    public void addEdge(Edge edge) {
        if (this.connections.contains(edge)) {
            return;
        }
        this.connections.add(edge);
    }

    /**
     * @param other The edge to search for.
     * @return true iff other is in this.connections.
     */
    public Boolean hasConnection(Edge other) {
        return this.connections.contains(other);
    }

    /**
     * @param index The index of the Edge to Retrieve
     * @return The Edge at the specified index.
     */
    public Edge getConnection(int index) {
        return this.connections.get(index);
    }

    /**
     * @param index The index of the edge to remove.
     * @return
     */
    Edge removeConnected(int index) {
        return this.connections.remove(index);
    }

    /**
     * @param e the Edge to remove from this.connections
     */
    public void removeConnected(Edge e) {
        this.connections.remove(e);
    }

    /**
     * @return The number of Nodes connected to this vertex.
     */
    public int getconnectionCount() {
        return this.connections.size();
    }

    /**
     * @return The label of the Vertex.
     */
    public String getLabel() {
        return this.label;
    }

    /**
     * @return The hash code of this vertex's label.
     */
    public int hashCOde() {
        return this.label.hashCode();
    }

    /**
     * @param other The other object to compare to.
     * @return true only if  other instance of Vertex and the two Vertex
     * objects have the same label.
     */
    public boolean equals(Object other) {
        if (!(other instanceof Vertex)) {
            return false;
        }

        Vertex v = (Vertex) other;
        return this.label.equals(v.label);
    }

    /**
     *
     * @return ArrayList<Edge> A copy of this.connections
     * which can be modified without changing the original list of connections.
     */
    public ArrayList<Edge> getConnections() {
        return new ArrayList<Edge>(this.connections);
    }
}
