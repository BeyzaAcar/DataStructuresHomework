/**
 * Coordinate class for 2D coordinates (x,y)
 * x is the row number and y is the column number
 * Contains a static method to convert 1D index to 2D index (see the method for more details)
 * Created by Beyza Acar on 04.06.2023.
 */
class Coordinate {
    /** row number */ private int x;
    /** column number */ private int y;

    /**
     * Constructor for the Coordinate class
     * @param x : row number
     * @param y : column number
     */
    Coordinate(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
    @Override
    public String toString()
    {
        return x + "," + y;
    }

    /**
     * Converts 1D index to 2D index
     * Example : 1D array : 1 2 3 4 5 6 7 8 9       2D array : 1 2 3
     *                                                         4 5 6
     *                                                         7 8 9
     * indexes are found by the formula : x : index/size , y : index%size ( index is the linear index)
     * 1D index of 5 is 4 and 2D index of 5 is (1,1)
     * @param index : 1D index
     * @param size : row size of the 2D array
     * @return 2D coordinate : (x,y) where x is the row number and y is the column number
     */
    public static Coordinate convertTo2DIndex(int index, int size)
    {
        Coordinate coordinate = new Coordinate(index/size, index%size);
        return coordinate;
    }
    /**
     * Getter for x
     * @return x : row number
     */
    public int getX()
    {
        return x;
    }
    /**
     * Getter for y
     * @return y : column number
     */
    public int getY()
    {
        return y;
    }
}