import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Class that holds the BFS algorithm and the methods to find the path and the distance
 * Created by Beyza Acar on 04.06.2023.
 */
public class CSE222BFS
{
    /**graph to be used*/ private CSE222Graph graph;
    /**
     * Constructor that takes a graph as a parameter
     * @param graph : CSE222Graph
     */
    public CSE222BFS(CSE222Graph graph)
    {
        this.graph = graph;
    }

    /**
     * Finds the path from start to end using BFS algorithm
     * @return ArrayList(int)
     */
    public ArrayList<Integer> findPath()
    {
        ArrayList<ArrayList<Integer>> vertices = graph.getGraph();
        Queue<Integer> queue = new LinkedList<Integer>(); //queue for BFS Traversal
        Stack<Integer> tempPath = new Stack<Integer>(); //temporary path to be reversed
        ArrayList<Integer> path = new ArrayList<Integer>(); //path to be returned
        boolean[] visited = new boolean[vertices.size()]; //indicates whether a node is visited or not
        int[] parents = new int[vertices.size()]; //indicates from which node we came to the current node
        int[] distances = new int[vertices.size()]; //indicates the distance of the current node from the start node
        //PREPARATIONS

        //at first all parents are -1 meaning that they aren't set
        for(int i = 0; i<parents.length;i++)
            parents[i] = -1;
        //at first all distances are 0 meaning that they aren't set
        for(int i = 0;i<distances.length;i++)
            distances[i] = 0;
        //at first all visited are false meaning that they aren't visited
        for(int i = 0;i<visited.length;i++)
            visited[i] = false;
        //add the neighbors of the start node to the queue to start the loop
        queue.add(graph.getStart());
        //mark the start node as visited because its neighbors are added to the queue
        visited[graph.getStart()] = true;

        while(!queue.isEmpty())
        {
            int current = queue.poll();
            // if the current node is the end node then we have found the path
            if(current == graph.getEnd())
            {
                //add the end node to the path
                tempPath.push(current);
                //from the end node we go to its parent and then to its parent and so on
                int currentParent = parents[current];
                while(currentParent != -1)
                {
                    tempPath.push(currentParent);
                    currentParent = parents[currentParent];
                }
                //reverse the path
                while(!tempPath.isEmpty())
                    path.add(tempPath.pop());
                return path;
            }
            else
            {
                int neighborsNum = vertices.get(current).size();
                for(int i = 0;i<neighborsNum;i++)
                {
                    int currentNeighbor = vertices.get(current).get(i);
                    if(!visited[currentNeighbor])
                    {
                        queue.add(currentNeighbor);
                        visited[currentNeighbor] = true;
                        parents[currentNeighbor] = current;
                        //set distance
                        if(distances[current]+1 < distances[currentNeighbor] || distances[currentNeighbor] == 0)
                            distances[currentNeighbor] = distances[current]+1;
                    }
                }
            }
        }
        System.out.println("No path found");
        return null;
    }
}
