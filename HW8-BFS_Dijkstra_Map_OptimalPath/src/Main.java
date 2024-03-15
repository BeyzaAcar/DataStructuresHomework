/**
 * Main class that will run the test cases at once using threads
 * Created by Beyza Acar on 04.06.2023.
 */
public class Main {
    public static void main(String args[]) {
        //File Parameters explained:
            //File 1 : File that contains the map
            //File 2 : File that will be created by my program and will contain the BFS path png image
            //File 3 : File that will be created by my program and will contain the Dijkstra path png image
            //File 4 : File that will be created by my program and will contain the BFS path coordinates
            //File 5 : File that will be created by my program and will contain the Dijkstra path coordinates
        /*new Thread(new TestCases("Map01.txt", "BFS01.png", "Dijkstra01.png", "Path01BFS.txt", "Path01Dijkstra.txt")).start();
        new Thread(new TestCases("Map02.txt", "BFS02.png", "Dijkstra02.png", "Path02BFS.txt", "Path02Dijkstra.txt")).start();
        new Thread(new TestCases("Map03.txt", "BFS03.png", "Dijkstra03.png", "Path03BFS.txt", "Path03Dijkstra.txt")).start();
        new Thread(new TestCases("Map04.txt", "BFS04.png", "Dijkstra04.png", "Path04BFS.txt", "Path04Dijkstra.txt")).start();
        new Thread(new TestCases("Map05.txt", "BFS05.png", "Dijkstra05.png", "Path05BFS.txt", "Path05Dijkstra.txt")).start();
        new Thread(new TestCases("Map06.txt", "BFS06.png", "Dijkstra06.png", "Path06BFS.txt", "Path06Dijkstra.txt")).start();
        new Thread(new TestCases("Map07.txt", "BFS07.png", "Dijkstra07.png", "Path07BFS.txt", "Path07Dijkstra.txt")).start();
        new Thread(new TestCases("Map08.txt", "BFS08.png", "Dijkstra08.png", "Path08BFS.txt", "Path08Dijkstra.txt")).start();
        new Thread(new TestCases("Map09.txt", "BFS09.png", "Dijkstra09.png", "Path09BFS.txt", "Path09Dijkstra.txt")).start();
        new Thread(new TestCases("Map10.txt", "BFS10.png", "Dijkstra10.png", "Path10BFS.txt", "Path10Dijkstra.txt")).start();*/

        new Thread(new TestCases("vatican.txt", "BFSVatican.png", "DijkstraVatican.png", "PathBFSVatican.txt", "PathDijkstraVatican.txt")).start();
        new Thread(new TestCases("pisa.txt", "BFSPisa.png", "DijkstraPisa.png", "PathBFSPisa.txt", "PathDijkstraPisa.txt")).start();
        new Thread(new TestCases("triumph.txt", "BFSTriumph.png", "DijkstraTriumph.png", "PathBFSTriumph.txt", "PathDijkstraTriumph.txt")).start();
        new Thread(new TestCases("tokyo.txt", "BFSTokyo.png", "DijkstraTokyo.png", "PathBFSTokyo.txt", "PathDijkstraTokyo.txt")).start();
    }
}

