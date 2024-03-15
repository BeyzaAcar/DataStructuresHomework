/**
 * InsertionSort class that sorts the given myMap object using insertion sort algorithm
 * Created by Beyza Acar on 19.05.2023
 */
public class InsertionSort
{
    private myMap originalMap;
    private myMap sortedMap;
    private keyValuePair[] arr;

    /**
     * Constructor of InsertionSort class that takes a myMap object
     * @param map
     */
    public InsertionSort(myMap map)
    {
        this.originalMap = map;
        sortedMap = null;
    }

    /**
     * Does the preparation for insertion sort algorithm and calls real insertionSort method
     * insertionSort method sorts the originalMap using insertion sort algorithm and stores the sorted map in sortedMap variable
     */
    public long insertionSort()
    {
        fillTheArray();
        long start = System.nanoTime();
        insertionSortAlgorithm();
        long time = System.nanoTime() - start;
        copyToSortedMap();
        return time;
    }

    /**
     * Sorts given myMap object using insertion sort algorithm and stores the sorted map in sortedMap variable
     */
    private void insertionSortAlgorithm()
    {
        int j=0, mapSize = originalMap.size(), holder;
        keyValuePair temp;
        //Insertion sort algorithm
        for(int i = 1;i< mapSize;i++)
        {
            holder = arr[i].getValue().getCount();
            j = i-1;
            while(j>=0 && holder<arr[j].getValue().getCount()) //instead of holder, arr[j+1] can be written but it is more readable this way
            {
                temp = arr[j+1];
                arr[j+1] = arr[j];
                arr[j] = temp;
                j--;
            }
        }
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
        System.out.println("------------------Sorted Map (INSERTION SORT)---------------------");
        for(String key : sortedMap.keySet())
            System.out.println("Letter: " + key + " - " + sortedMap.get(key));
        System.out.println("Map Size: " + sortedMap.size());

    }
}
