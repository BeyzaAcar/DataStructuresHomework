/**
 * BubbleSort class sorts the given myMap object with bubble sort algorithm
 * Created by Beyza Acar on 19.05.2023
 */
public class BubbleSort
{
    private myMap originalMap;
    private myMap sortedMap;
    private keyValuePair[] arr;

    /**
     * Constructor that takes a myMap object
     * @param originalMap
     */
    public BubbleSort(myMap originalMap)
    {
        this.originalMap = originalMap;
        sortedMap = null;
    }

    /**
     * Does the preparation for bubble sort algorithm and calls real bubbleSort method
     * bubbleSort method sorts the originalMap with bubble sort algorithm and stores the sorted map in sortedMap variable
     */
    public long bubbleSort()
    {
        fillTheArray();
        long start = System.nanoTime();
        bubbleSortAlgorithm();
        long time = System.nanoTime() - start;
        copyToSortedMap();
        return time;
    }

    /**
     * Fills the keyValuePair member array with originalMap's data
     */
    private void fillTheArray()
    {
        int mapSize = originalMap.size();
        int i = 0;
        arr = new keyValuePair[mapSize];
        //Fill the array with keyValuePair objects
        for(String key : originalMap.keySet())
        {
            arr[i] = new keyValuePair();
            arr[i].setData(key, originalMap.get(key));
            i++;
        }
    }
    /**
     * Does the actual bubble sort algorithm here
     */
    private void bubbleSortAlgorithm()
    {
        int mapSize = originalMap.size();
        int i, j;
        keyValuePair temp;
        //Bubble sort algorithm
        for(i = 0; i < mapSize; i++)
        {
            for(j = 0; j < mapSize - i - 1; j++)
            {
                if(arr[j].getValue().getCount()>arr[j+1].getValue().getCount())
                {
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }
    /**
     * Copies the keyValuePair array to the sortedMap
     */
    private void copyToSortedMap()
    {
        sortedMap = new myMap();
        for(int i = 0;i<arr.length;i++)
            sortedMap.put(arr[i].getKey(), arr[i].getValue());
    }
    /**
     * Prints the original and sorted map
     */
    public void view()
    {
        System.out.println("------------------Original Map---------------------");
        for(String key : originalMap.keySet())
            System.out.println("Letter: " + key + " - " + originalMap.get(key));
        System.out.println("Map Size: " + originalMap.size());
        System.out.println("------------------Sorted Map (BUBBLE SORT)---------------------");
        for(String key : sortedMap.keySet())
            System.out.println("Letter: " + key + " - " + sortedMap.get(key));
        System.out.println("Map Size: " + sortedMap.size());

    }
}
