import java.util.*;

/** A ListGraph is an extension of the AbstractGraph abstract class
 *   that uses an array of lists to represent the edges.
 *   @author Dilara Karakas
 */
public class ListGraph extends AbstractGraph {
    private List < Edge > [][] edges;
    private List <Edge> [] iterEdge;
    /** Construct a graph with the specified number of
     vertices and directionality.
     @param numV The number of vertices
     @param directed The directionality flag
     */
    public ListGraph(int numV, boolean directed) {
        super(numV, directed);
        edges = new LinkedList[numV][numV];
        for (int i = 0; i < numV; i++) {
            edges[i] = new LinkedList[numV];
            for(int j=0;j<numV;j++)
                edges[i][j] = new LinkedList<>();
        }
        iterEdge = new List[numV];
        for (int i = 0; i < numV; i++) {
            iterEdge[i] = new LinkedList <>();
        }
    }
    /** Determine whether an edge exists.
     @param source The source vertex
     @param dest The destination vertex
     @return true if there is an edge from source to dest
     */
    public boolean isEdge(int source, int dest) {
        return edges[source][dest].contains(new Edge(source, dest));
    }
    /** Remove a edge into the graph.
     @param edge The deleted edge
     */
    public void removeEdge(Edge edge){
        edges[edge.getSource()][edge.getDest()].remove(edge);
        if (!isDirected()) {
            edges[edge.getDest()][edge.getSource()].remove(new Edge(edge.getDest(), edge.getSource(), edge.getWeight()));
        }
        iterEdge[edge.getSource()].remove(edge);
        if (!isDirected()) {
            iterEdge[edge.getDest()].remove(new Edge(edge.getDest(), edge.getSource(), edge.getWeight()));
        }
    }
    /** Remove a vertex into the graph.
     @param source The deleted vertex
     */
    public void removeVertex(int source){
        for(int i=0;i<getNumV();i++){
            Edge temp = getEdge(source,i);
            if(temp.getWeight() != Double.POSITIVE_INFINITY){
                removeEdge(temp);
            }
        }
        for(int i=0;i<getNumV();i++){
            Edge temp = getEdge(i,source);
            if(temp.getWeight() != Double.POSITIVE_INFINITY){
                removeEdge(temp);
            }
        }
    }
    /** Insert a new edge into the graph.
     @param edge The new edge
     */
    public void insert(Edge edge) {
        edges[edge.getSource()][edge.getDest()].add(edge);
        if (!isDirected()) {
            edges[edge.getDest()][edge.getSource()].add(new Edge(edge.getDest(), edge.getSource(), edge.getWeight()));
        }
        iterEdge[edge.getSource()].add(edge);
        if (!isDirected()) {
            iterEdge[edge.getDest()].add(new Edge(edge.getDest(), edge.getSource(), edge.getWeight()));
        }
    }
    public Iterator < Edge > edgeIterator(int source) {
        return iterEdge[source].iterator();
    }
    /** Get the edge between two vertices. If an
     edge does not exist, an Edge with a weight
     of Double.POSITIVE_INFINITY is returned.
     @param source The source
     @param dest The destination
     @return the edge between these two vertices
     */
    public Edge getEdge(int source, int dest) {
        Edge target = new Edge(source, dest, Double.POSITIVE_INFINITY);
        for (Edge edge : edges[source][dest]) {
            if (edge.equals(target))
                return edge; // Desired edge found, return it.
        }
        // Assert: All edges for source checked.
        return target; // Desired edge not found.
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<getNumV();i++){
            sb.append(i).append(") ");
            for(int j=0;j<getNumV();j++){
                //if(edges[i][j].size() != 0)
                    sb.append(edges[i][j].toString());
                sb.append("\t\t\t");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
    /**
     * Recursively depth-first search the graph starting at vertex current.
     * @param current The start vertex
     * @param visited Flag to indicate whether this vertex has been visited.
     */
    private void DepthFirstSearch(int current,boolean [] visited) {
        visited[current] = true;
        System.out.print(current + " ");
        Iterator<Edge> iterator = edgeIterator(current);
        while (iterator.hasNext()) {
            Edge edge = iterator.next();
            if (!visited[edge.getDest()])
                DepthFirstSearch(edge.getDest(), visited);
        }
    }
    /**
     * Helper function for DepthFirstSearch
     * @param current The start vertex
     */
    public void depthFirstSearch(int current) {
        boolean [] visited = new boolean[getNumV()];
        DepthFirstSearch(current, visited);
    }
    /**
     * Perform a breadth-first search of a graph.
     * post: The array parent will contain the predecessor
     * of each vertex in the breadth-first search graph.
     * @param start The start vertex
     */
    public void breadthFirstSearch(int start) {
        boolean [] visited = new boolean[getNumV()];
        LinkedList<Integer> linkedList = new LinkedList<>();
        visited[start]=true;
        linkedList.add(start);
        while (linkedList.size() != 0) {
            start = linkedList.poll();
            System.out.print(start + " ");
            Iterator<Edge> i = edgeIterator(start);
            while (i.hasNext()) {
                Edge edge = i.next();
                if (!visited[edge.getDest()]) {
                    visited[edge.getDest()] = true;
                    linkedList.add(edge.getDest());
                }
            }
        }
    }
}