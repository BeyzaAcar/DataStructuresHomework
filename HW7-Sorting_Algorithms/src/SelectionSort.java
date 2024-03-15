import javax.xml.crypto.dsig.keyinfo.KeyValue;

/**
 * SelectionSort class that sorts a given myMap object using selection sort algorithm
 * Created by Beyza Acar on 19.05.2023
 */
public class SelectionSort
{
    private myMap originalMap;
    private myMap sortedMap;
    private keyValuePair[] arr;

    /**
     * Constructor that takes a myMap object
     * @param originalMap
     */
    public SelectionSort(myMap originalMap)
    {
        this.originalMap = originalMap;
        sortedMap = null;
    }
    /**
     * Does the preparation for selection sort algorithm and calls real selectionSort method
     * selectionSort method sorts the originalMap using selection sort algorithm and stores the sorted map in sortedMap variable
     */
    public long selectionSort()
    {
        fillTheArray();
        long start = System.nanoTime();
        SelectionSortAlgorithm();
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
     * Sorts given myMap object using selection sort algorithm and stores the sorted map in sortedMap variable
     */
    private void SelectionSortAlgorithm()
    {
        fillTheArray();
        int mapSize = originalMap.size();
        int i, minIndex;
        keyValuePair temp;
        //Selection sort algorithm
        for(i = 0; i < mapSize; i++)
        {
            minIndex = findMin(i);
            swap(minIndex, i);
        }
    }

    /**
     * Finds the minimum value in the array starting from indexToStart
     * @param indexToStart
     * @return
     */
    private int findMin(int indexToStart)
    {
        int mapSize = originalMap.size();
        int minIndex = indexToStart;
        while(indexToStart<mapSize)
        {
            if(arr[indexToStart].getValue().getCount()<arr[minIndex].getValue().getCount())
                minIndex = indexToStart;
            indexToStart++;
        }
        return minIndex;
    }

    /**
     * Swaps the elements in the array
     * @param index1
     * @param index2
     */
    private void swap(int index1, int index2)
    {
        keyValuePair temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
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
        System.out.println("------------------Sorted Map (SELECTION SORT)---------------------");
        for(String key : sortedMap.keySet())
            System.out.println("Letter: " + key + " - " + sortedMap.get(key));
        System.out.println("Map Size: " + sortedMap.size());
    }
}
