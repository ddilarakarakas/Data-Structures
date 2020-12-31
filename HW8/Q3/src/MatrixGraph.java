import java.util.Iterator;

public class MatrixGraph extends AbstractGraph {
    /** The two dimensional array to represent an edge */
    private int[][] edges;
    private int row;
    private int column;
    /** Construct a graph with the specified number of
     vertices and directionality
     @param numV - The number of vertices
     @param directed - The directionality flag
     */
    public MatrixGraph(int numV, boolean directed,int row, int column) {
        super(numV, directed);
        edges = new int[numV][];
        if (!directed) {
            for (int i = 0; i != numV; ++i) {
                edges[i] = new int[numV];
                for (int j = 0; j != numV; ++j) {
                    edges[i][j] = -1;
                }
            }
        }
        else {
            for (int i = 0; i != numV; ++i) {
                edges[i] = new int[i + 1];
                for (int j = 0; j != i + 1; ++j) {
                    edges[i][j] = -1;
                }
            }
        }
        this.row = row;
        this.column = column;
    }

    public int getColumn() {
        return column;
    }

    public int getRow() {
        return row;
    }
    /** Insert a new edge into the graph
     @param edge - The new edge
     */
    public void insert(Edge edge) {
        setEdgeValue(edge.getSource(), edge.getDest(), edge.getWeight());
    }

    /** Determine if an edge exists
     @param source - The source vertex
     @param dest - The destination vertex
     @return true if there is an edge from u to v
     */
    public boolean isEdge(int source, int dest) {
        return 0.0 != getEdgeValue(source, dest);
    }

    /** Get the edge between two vertices. If an
     edge does not exist, an Edge with a weight
     of POSITIVE_INFINITY is returned.
     @param source - The source
     @param dest - The destination
     @return the edge between these two vertices
     */
    public Edge getEdge(int source, int dest) {
        return new Edge(source, dest,
                getEdgeValue(source, dest));
    }

    /** Return an iterator to the edges connected
     to a given vertex.
     @param source - The source vertex
     @return an EdgeIterator to the vertices
     contacted to source
     */
    public Iterator < Edge > edgeIterator(int source) {
        return new Iter(source);
    }

    /** Method to set the value of an edge
     @param source - The source vertex
     @param dest - The destination vertex
     @param wt - The weight
     */
    private void setEdgeValue(int source, int dest, int wt) {
        edges[source][dest] = wt;
    }
    /** Method to get the value of an edge
     *  @param source - The source vertex
     *  @param dest - The destination vertex
     *  @return The weight of this edge or
     *  POSITIVE_INFINITY if no edge exists
     */
    private int getEdgeValue(int source, int dest) {
        if (isDirected() | source <= dest) {
            return edges[source][dest];
        }
        else {
            return edges[dest][source];
        }
    }

    // Iter class
    /** An iterator to the edges.  An Edge iterator is
     *  similar to an Iterator except that its
     *  next method will always return an edge
     */
    private class Iter
            implements Iterator < Edge > {
        // Data fields
        /** The source vertex for this iterator */
        private int source;

        /** The current index for this iterator */
        private int index;

        // Constructor
        /** Construct an EdgeIterator for a given vertex
         *  @param source - The source vertex
         */
        public Iter(int source) {
            this.source = source;
            index = -1;
            advanceIndex();
        }

        /** Return true if there are more edges
         *  @return true if there are more edges
         */
        public boolean hasNext() {
            return index != getNumV();
        }

        /** Return the next edge if there is one
         *  @return the next Edge in the iteration
         */
        public Edge next() {
            if (index == getNumV()) {
                throw new java.util.NoSuchElementException();
            }
            Edge returnValue = new Edge(source, index, getEdgeValue(source, index));
            advanceIndex();
            return returnValue;
        }

        /** Remove is not implemented
         */
        public void remove() {
            throw new UnsupportedOperationException();
        }

        /** Advance the index to the next edge */
        private void advanceIndex() {
            do {
                index++;
            }
            while (index != getNumV() && Double.POSITIVE_INFINITY == getEdgeValue(source, index));
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i=0;i<row;i++) {
            for (int j=0;j<column;j++) {
                if(edges[i][j] == -1)
                    stringBuilder.append("*");
                else
                    stringBuilder.append(edges[i][j]);
                stringBuilder.append(" ");
            }
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
}
