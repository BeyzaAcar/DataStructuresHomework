import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

/**
 * Class that holds the map and the coordinates of the start and end points
 * Also holds the methods to read the file and write the path to the file
 * Created by Beyza Acar on 04.06.2023.
 */
public class CSE222Map {
    /**coordinates of the start point*/ private Coordinate start ;
    /** coordinates of the end point*/ private Coordinate end;
    /** matrix of the map that holds 1's and 0's*/ private int matrix[][];

    /**
     * Constructor of the class
     * Reads the file and initializes the matrix
     * @param fileName : name of the file that holds the map
     */
    public CSE222Map(String fileName)
    {
        int lineCount = 0;
        try
        {
            BufferedReader stream = new BufferedReader(new FileReader(fileName));
            // count the number of lines in the file to initialize the matrix
            while(stream.readLine() != null)
                lineCount++;
            matrix = new int[lineCount - 2][lineCount - 2]; // The reason why we subtract 2 is because the first two lines are the coordinates of start and end points
            stream.close(); // close the stream to reread the file
            stream = new BufferedReader(new FileReader(fileName)); // reopen the stream
            // read the file and initialize the start and end points
            String line;
            for(int i = 0; i < 2; i++)
            {
                line = stream.readLine();
                String[] coordinates = line.split(",");
                if(i == 0)
                    start = new Coordinate(Integer.parseInt(coordinates[0]), Integer.parseInt(coordinates[1]));
                else
                    end = new Coordinate(Integer.parseInt(coordinates[0]), Integer.parseInt(coordinates[1]));
            }
            int j = 0;
            String[] rowOfMatrix;
            while((line = stream.readLine()) != null)
            {
                rowOfMatrix = line.split(",");
                for(int i = 0; i < rowOfMatrix.length; i++) {
                    matrix[j][i] = Integer.parseInt(rowOfMatrix[i]);
                    if(matrix[i][j]==-1)
                        matrix[i][j]=1;
                }
                j++;
            }
            stream.close();
        }
        catch (Exception e) {
            System.out.println("File not found!");
        }
    }

    /**
     * Writes the map to two files with the path
     * @param fileName : path.png -> Contains image of the map( Gray for empty spaces, black for obstacles and red for the path)
     * @param fileName2 : path.txt -> Contains coordinates of the path
     * @param path : ArrayList of the coordinates of the path
     */
    public void writePath(ArrayList<Integer> path, String fileName, String fileName2) //fileName is for png file and fileName2 is for txt file for writing the path
    {
        if(path == null || path.size() == 0) // if there is no path, write the map without the path
        {
            System.out.println("No path found!");
            //writing map without path to the png file
            int n = matrix.length;
            BufferedImage image = new BufferedImage(n, n, BufferedImage.TYPE_INT_RGB);
            Graphics2D gr = image.createGraphics(); //Creating for using drawLine() method
            for(int i = 0; i < n; i++)
            {
                for (int j = 0; j < n; j++)
                {
                    if (matrix[i][j] == 1 || matrix[i][j] == -1) // if the current coordinate is an obstacle, color it black
                        gr.setColor(Color.BLACK);
                    else
                        gr.setColor(Color.GRAY); // if the current coordinate is empty, color it gray
                    gr.fillRect(j, i, 1, 1);
                }
            }
            return;
        }
        //Using black for obstacles, gray for empty spaces and red for the path
        int n = matrix.length;
        BufferedImage image = new BufferedImage(n, n, BufferedImage.TYPE_INT_RGB);
        Graphics2D gr = image.createGraphics(); //Creating for using drawLine() method
        for(int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++)
            {
                if(path.contains(i*n+j)) // if the current coordinate is in the path, color it red
                    gr.setColor(Color.RED);
                else if (matrix[i][j] == 1 || matrix[i][j] == -1) // if the current coordinate is an obstacle, color it black
                    gr.setColor(Color.BLACK);
                else
                    gr.setColor(Color.GRAY); // if the current coordinate is empty, color it gray
                gr.fillRect(j, i, 1, 1);
            }
        }
        gr.dispose();
        //Writing the image to the file
        try {
            javax.imageio.ImageIO.write(image, "png", new java.io.File(fileName));
        } catch (Exception e) {
            System.out.println("Error while writing the image!");
        }

        //writing coordinates to the file
        int pathSize = path.size();
        try {
            java.io.FileWriter writer = new java.io.FileWriter(fileName2);
            for(int i = 0; i < pathSize; i++)
            {
                int x = path.get(i) / n;
                int y = path.get(i) % n;
                writer.write(x + "," + y + "\n");
            }
            //adding distance to the end of the file
            writer.write("Distance: " + (pathSize-1) + "\n");
            writer.close();
        } catch (Exception e) {
            System.out.println("Error while writing the coordinates!");
        }
    }

    /**
     * Getter for map matrix
     * @return matrix
     */
    public int[][] getMatrix()
    {
        return matrix;
    }

    /**
     * Getter for start point
     * @return start
     */
    public Coordinate getStart()
    {
        return start;
    }

    /**
     * Getter for end point
     * @return end
     */
    public Coordinate getEnd()
    {
        return end;
    }
}
