import java.util.ArrayList;

/**
 * Class that holds all file names for the test cases
 * Explanation of the file names are given in javadoc as member variables explanations or comment in the code
 */
public class TestCases implements Runnable {

    /** name of the file that holds the map*/ private  String FileName;
    /** name of the file that is going to contain png of the BFS path*/ private String BFSFile;
    /** name of the file that is going to contain png of the Dijkstra path*/private String DijkstraFile;
    /** name of the file that is going to contain coordinates of the BFS path*/private String BFSPathCoordinatesFile;
    /** name of the file that is going to contain coordinates of the Dijkstra path*/private String DijkstraPathCoordinatesFile;

    /**
     * Constructor of the class
     * @param FileName : name of the file that holds the map
     * @param BFSFile : name of the file that is going to contain png of the BFS path
     * @param DijkstraFile : name of the file that is going to contain png of the Dijkstra path
     * @param BFSPathCoordinatesFile : name of the file that is going to contain coordinates of the BFS path
     * @param DijkstraPathCoordinatesFile : name of the file that is going to contain coordinates of the Dijkstra path
     */
    public TestCases(String FileName, String BFSFile, String DijkstraFile, String BFSPathCoordinatesFile, String DijkstraPathCoordinatesFile)
    {
        this.FileName = FileName;
        this.BFSFile = BFSFile;
        this.DijkstraFile = DijkstraFile;
        this.BFSPathCoordinatesFile = BFSPathCoordinatesFile;
        this.DijkstraPathCoordinatesFile = DijkstraPathCoordinatesFile;
    }

    /**
     * Test method that runs BFS and Dijkstra algorithms on the map
     * Writes the paths to the files that are given in the constructor of the class as parameters
     */
    public void test(){

        System.out.println("\n\n*******************\nMap is " + this.FileName + "\n********************\n");
        CSE222Map map = new CSE222Map(this.FileName);
        CSE222Graph graph = new CSE222Graph(map);
        ArrayList<Integer> path;

        //BFS Algorithm
        CSE222BFS bfs = new CSE222BFS(graph);
        path = bfs.findPath();
        System.out.println("BFS Path ("+ FileName+") :" + (path.size()-1));
        map.writePath(path, this.BFSFile, this.BFSPathCoordinatesFile);

        //Dijkstra Algorithm
        CSE222Dijkstra dijkstra = new CSE222Dijkstra(graph);
        path = dijkstra.findPath();
        System.out.println("Dijkstra Path (" + FileName+ ") : "+ (path.size()-1));
        map.writePath(path, this.DijkstraFile, this.DijkstraPathCoordinatesFile);
    }

    /**
     * Run method of the class
     */
    @Override
    public void run() {
        test();
    }
}

