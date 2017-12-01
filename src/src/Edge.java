public class Edge implements Comparable<Edge> {
    private Vertex v1, v2;
    private int weight;

    /**
     * @param v1 The first vertex of the Edge
     * @param v2 The second vertex of the Edge
     *           Note that the default weight is 1.
     */
    public Edge(Vertex v1, Vertex v2) {
        this(v1, v2, -1);
    }

    public Edge(Vertex v1, Vertex v2, int weight) {
        this.v1 = (v1.getLabel().compareTo(v2.getLabel()) <= 0) ? v1 : v2;
        this.v2 = (this.v2 == v2) ? v2 : v1;
        this.weight = weight;
    }

    /**
     * @param current The current node
     * @return The node currently connected along this edge
     */
    public Vertex getConnected(Vertex current) {
        if (!(current.equals(v1) || current.equals(v2))) {
            return null;
        }
        return (current.equals(v1)) ? v2 : v1;
    }

    /**
     * @return this.v1
     */
    public Vertex getV1() {
        return this.v1;
    }

    /**
     * @return this.v2
     */
    public Vertex getV2() {
        return this.v2;
    }

    /**
     * @return the weight of this Edge.
     */
    public int getWeight() {
        return this.weight;
    }

    /**
     * @param weight The new weight of this edge
     */
    public void setWeight(int weight) {
        this.weight = weight;
    }

    /**
     *
     * @param other The Edge to compare against this.
     * @return
     */
    public int compareTo(Edge other) {
        return this.weight - other.weight;
    }

    /**
     * @return A String representation of this Edge.
     */
    public String toString(){
        return "({" + v1 + ", " + v2 + "}, " + weight + ")";
    }

    /**
     *
     * @return The Hashcode of this Edge.
     */
    public int hashCode(){
        return (v1.getLabel() + v2.getLabel()).hashCode();
    }

    /**
     *
     * @param other the Object to compare against
     * @return True only if other is an Edge with the same Vertices as this.
     */
    public boolean equals(Object other){
        if(!(other instanceof Edge)){
            return false;
        }
        Edge e = (Edge)other;
        return e.v1.equals(this.v1) && e.v2.equals(this.v2);
    }
}
