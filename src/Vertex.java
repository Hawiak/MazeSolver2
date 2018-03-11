import java.util.List;
import java.util.LinkedList;

public class Vertex {
    public String name;
    public List<Edge> adj;
    public double dist;
    public Vertex prev;
    public int scratch;

    public Vertex (String nm) {
        this.name = nm;
        this.adj = new LinkedList<>();
        reset();
    }

    public void reset() {
        this.dist = Graph.INFINITY;
        this.prev = null;
        // pos = null;
        scratch = 0;
    }
}
