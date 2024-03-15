import java.util.ArrayList;

/**
 * Class that holds the map and the coordinates of the start and end points
 * Creates adjacency list of the graph
 * Created by Beyza Acar on 04.06.2023.
 */
public class CSE222Graph {

    /** linear start index */ int start;
    /**linear end index */ int end;
    /**adjacency list of the graph*/ private ArrayList<ArrayList<Integer>> graph;

    /**
     * Constructor of the CS222Graph class
     * It takes a CSE222Map object and converts it to a graph
     * The graph is represented as an ArrayList of ArrayLists
     * Each ArrayList represents a node and the elements of the ArrayList are the neighbors of the node
     * I linearized the 2d array to reduce complexity. so I can access it with O(1) complexity, but since I've added all
     * the nodes I'm using a little more memory than usual. For example, if I need to convert a map consisting of 0 and 1
     * in half to graph, I use twice as much memory as normal, but the processing time is much faster.
     *
     * EXAMPLE OF LINEARIZATION:
     * 2D ARRAY : 1 2 3  LINEAR ARRAY : 1 2 3 4 5 6 7 8 9
     *            4 5 6
     *            7 8 9
     * indexes are found by the formula : i*matrix.length + j ( i is the row number and j is the column number)
     * index of 5 is 1*3 + 1 = 4
     * @param map : CSE222Map object
     *
     */
    public CSE222Graph(CSE222Map map)
    {
        int[][] matrix = map.getMatrix();
        this.start = map.getStart().getX()*matrix.length + map.getStart().getY();
        this.end = map.getEnd().getX()*matrix.length + map.getEnd().getY();
        //initialize the graph
        graph = new ArrayList<ArrayList<Integer>>();
        //fill the graph
        for(int i = 0; i < matrix.length; i++)
        {
            for(int j = 0; j < matrix.length; j++)
            {
                graph.add(new ArrayList<Integer>());
                ArrayList<Integer> currentNode =graph.get(i*matrix.length + j);
                //check the neighbors of the current node and add them to the graph if they are 0
                if(matrix[i][j] == 0)
                {
                    if(i!=0)                             // check upper row
                    {
                        if(j!=0 && matrix[i-1][j-1] == 0)               // left up
                            currentNode.add((i-1)*matrix.length + (j-1));
                        if(matrix[i-1][j] == 0)                         // up
                            currentNode.add((i-1)*matrix.length + j);
                        if(j!=matrix.length-1 && matrix[i-1][j+1] == 0) // right up
                            currentNode.add((i-1)*matrix.length + (j+1));
                    }
                    if(j!=0 && matrix[i][j-1] == 0)                      // left
                        currentNode.add(i*matrix.length + (j-1));
                    if(j!=matrix.length-1 && matrix[i][j+1] == 0)        // right
                        currentNode.add(i*matrix.length + (j+1));
                    if(i!=matrix.length-1)                  // check lower row
                    {
                        if(j!=0 && matrix[i+1][j-1] == 0)               // left down
                            currentNode.add((i+1)*matrix.length + (j-1));
                        if(matrix[i+1][j] == 0)                         // down
                            currentNode.add((i+1)*matrix.length + j);
                        if(j!=matrix.length-1 && matrix[i+1][j+1] == 0) // right down
                            currentNode.add((i+1)*matrix.length + (j+1));
                    }
                }
            }
        }
    }

    //GETTERS :

    /**
     * Getter for the graph
     * @return : graph
     */
    public ArrayList<ArrayList<Integer>> getGraph()
    {
        return graph;
    }
    /**
     * Getter for the start
     * @return : start
     */
    public int getStart()
    {
        return start;
    }
    /**
     * Getter for the end
     * @return : end
     */
    public int getEnd()
    {
        return end;
    }
}
