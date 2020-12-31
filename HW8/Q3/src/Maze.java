import java.io.*;
import java.util.*;

public class Maze {
    private int[][] mazeArr;
    private MatrixGraph graph;
    public Maze(String name) throws IOException {
        int row = 0;
        int column = 0;
        FileReader fr = new FileReader(name);
        BufferedReader br = new BufferedReader(fr);
        String st;
        while((st = br.readLine()) != null){
            row++;
            column = st.length();
        }
        mazeArr = new int[row][column];
        if(row < column)
            graph = new MatrixGraph(column,false,row,column);
        else
            graph = new MatrixGraph(row,false,row,column);
        FileReader fr1 = new FileReader(name);
        BufferedReader br1 = new BufferedReader(fr1);
        int k = 0;
        while((st = br1.readLine()) != null){
            for(int i=0;i<column;i++){
                mazeArr[k][i] = Character.getNumericValue(st.charAt(i));
            }
            k++;
        }
        insertGraph();
        System.out.println(graph.toString());
    }
    private void insertGraph(){
        for(int i=0;i<mazeArr.length;i++){
            for(int j=0;j<mazeArr[i].length;j++){
               if(mazeArr[i][j] == 0){
                   graph.insert(new Edge(i,j,1));
               }
            }
        }
    }
    public Graph getGraph(){
        return graph;
    }
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for(int i=0;i<mazeArr.length;i++){
            for(int j=0;j<mazeArr[i].length;j++){
                stringBuilder.append(mazeArr[i][j]);
                stringBuilder.append(" ");
            }
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
    /**
     * Perform a breadth first search of a graph.
     * post: The array parent will contain the predecessor
     * of each vertex in the breadth first search graph.
     * @param start The start vertex
     */
    public int [] breadthFirstSearch(int start, LinkedList<Edge> tempEdge) {
        int [] parent = new int[graph.getNumV() + 1];
        parent[0] = -1;
        boolean [] visited = new boolean[graph.getNumV()];
        LinkedList<Integer> linkedList = new LinkedList<>();
        visited[start]=true;
        linkedList.add(start);
        int k = 1;
        while (linkedList.size() != 0) {
            start = linkedList.poll();
            parent[k] = start;
            k++;
            Iterator<Edge> i = graph.edgeIterator(start);
            while (i.hasNext()) {
                Edge edge = i.next();
                if (!visited[edge.getDest()]) {
                    visited[edge.getDest()] = true;
                    linkedList.add(edge.getDest());
                    tempEdge.add(edge);
                }
            }
        }
        return parent;
    }

    /**
     * Program to solve a maze represented as a graph.
     * This program performs a breadth first search of the graph
     * to find the "shortest" path from the start vertex to the end.
     * It is assumed that the start vertex is 0, and the end vertex is numV 1.
     */
    public void path(){
        int weight = 0;
        LinkedList<Edge> tempEdge = new LinkedList<>();
        int [] parent = breadthFirstSearch(0,tempEdge);
        Deque<Integer> path = new ArrayDeque<>();
        int v = graph.getNumV() - 1;
        while(parent[v] != -1){
            path.push(v);
            v = parent[v];
        }
        while (!path.isEmpty()){
            path.pop();
            weight++;
        }
        System.out.println("Shortest path weight : " + weight);
    }
}