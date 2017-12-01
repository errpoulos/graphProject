import java.security.PublicKey;
import java.util.ArrayList;
import java.util.HashMap;

public class Graph {
   private HashMap<String, Vertex> vertices;
   private HashMap<Integer, Edge> edges;

   public Graph(){
       this.vertices = new HashMap<String, Vertex>();
       this.edges = new HashMap<Integer, Edge>();
   }

    /**
     *
     * @param vertices The initial vertices
     */
   public Graph (ArrayList<Vertex> vertices){       
       this.vertices = new HashMap<String, Vertex>();
       this.edges = new HashMap<Integer, Edge>();

       for (Vertex v: vertices){
           this.vertices.put(v.getLabel(),v);
       }

   }
}