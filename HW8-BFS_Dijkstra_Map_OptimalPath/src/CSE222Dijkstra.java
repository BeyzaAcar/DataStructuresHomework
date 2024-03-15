import java.util.ArrayList;
import java.util.Stack;

/**
 * Class that holds the Dijkstra algorithm and the methods to find the path and the distance
 * Created by Beyza Acar on 04.06.2023.
 */
public class CSE222Dijkstra {
    /**graph to be used*/ CSE222Graph graph;

    /**
     * Constructor that takes a graph as a parameter
     * @param graph : CSE222Graph
     */
    CSE222Dijkstra(CSE222Graph graph)
    {
        this.graph = graph;
    }

    /**
     * Finds the shortest path from the start node to the end node using Dijkstra's algorithm
     * @return : ArrayList(int)
     */
    public ArrayList<Integer> findPath()
    {
        ArrayList<ArrayList<Integer>> vertices = graph.getGraph();
        int numVertices = vertices.size();
        Stack<Integer> tempPath = new Stack<Integer>(); //temporary path to be reversed
        ArrayList<Integer> path = new ArrayList<Integer>(); //path to be returned
        boolean[] visited = new boolean[vertices.size()]; //indicates whether a node is visited or not
        int[] parents = new int[vertices.size()]; //indicates from which node we came to the current node
        int[] distances = new int[vertices.size()]; //indicates the distance of the current node from the start node

        //PREPARATIONS
        //set all distances to MAX meaning that they aren't set
        for(int i = 0;i<distances.length;i++)
            distances[i] = Integer.MAX_VALUE;
        //set all parents to -1 meaning that they aren't set
        for(int i = 0;i<parents.length;i++)
            parents[i] = -1;
        //set all visited to false meaning that they aren't visited
        for(int i = 0;i<visited.length;i++)
            visited[i] = false;
        distances[graph.getStart()] = 0;         //set the distance of the start node to 0
        int current = graph.getStart();           //set the current node to the start node
        //LOOP
        for(int i = 0;i<numVertices-1;i++)
        {
            //set neighbors of the current node's distance to the current node's distance + 1
            for (int j = 0; j < vertices.get(current).size(); j++)
            {
                int neighbor = vertices.get(current).get(j);
                if (distances[neighbor] > distances[current] + 1)
                {
                    distances[neighbor] = distances[current] + 1;
                    parents[neighbor] = current; //set the parent of the neighbor to the current node to be able to obtain the path later
                }
            }
            //mark the current node as visited
            visited[current] = true;
            //find minimum distance node that is not visited
            int min = Integer.MAX_VALUE;
            int minIndex = -1;
            for (int j = 0; j < numVertices; j++)
            {
                if (!visited[j] && distances[j] < min)
                {
                    min = distances[j];
                    minIndex = j;
                }
            }
            //if there is no minimum distance node that is not visited then we have found the path or there is no path
            if (minIndex == -1)
            {
                //if the end node is visited then we have found the path
                if (visited[graph.getEnd()] || current == graph.getEnd())
                {          //PATH FOUND!!!!!!!
                    //add the end node to the path
                    tempPath.push(graph.getEnd());
                    //from the end node we go to its parent and then to its parent and so on
                    int currentParent = parents[graph.getEnd()];
                    while (currentParent != -1)
                    {
                        tempPath.push(currentParent);
                        currentParent = parents[currentParent];
                    }
                    //reverse the path
                    while (!tempPath.isEmpty())
                        path.add(tempPath.pop());
                    return path;
                } else {
                    System.out.println("No path found");
                    return null;
                }
            } else
                current = minIndex; //set the current node to the minimum distance node that is not visited and continue
        }
        System.out.println("No path found");
        return null;
    }
}
