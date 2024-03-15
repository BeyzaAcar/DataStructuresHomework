/**
 * QuickSort class sorts the given myMap object using quick sort algorithm
 * Created by Beyza Acar on 19.05.2023
 */
public class QuickSort
{
    private myMap originalMap;
    private myMap sortedMap;
    private keyValuePair[] arr;

    /**
     * Constructor that takes a myMap object
     * @param originalMap
     */
    public QuickSort(myMap originalMap)
    {
        this.originalMap = originalMap;
        sortedMap = null;
    }

    /**
     * Does the preparation for quick sort algorithm and calls real quickSort method
     * quickSort method sorts the originalMap using quick sort algorithm and stores the sorted map in sortedMap variable
     */
    public long quickSort()
    {
        fillTheArray();
        long start = System.nanoTime();
        QuickSortAlgorithm(0, originalMap.size()-1);
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
     * Does the actual quick sort algorithm here
     * @param left
     * @param right
     */
    private void QuickSortAlgorithm(int left, int right)
    {
        if(left < right)
        {
            int pivot = partition(left, right);
            QuickSortAlgorithm(left, pivot-1);
            QuickSortAlgorithm(pivot+1, right);
        }
    }

    /**
     * Swaps the elements in the array (keyValuePair)
     * @param a is the index of the element that will be swapped
     * @param b is the index of the element that will be swapped
     */
    private void swap(int a, int b)
    {
        if(a!=b)
        {
            keyValuePair temp = arr[a];
            arr[a] = arr[b];
            arr[b] = temp;
        }
    }

    /**
     * Partitions the array (keyValuePair) according to the pivot
     * @param left is the index of the first element
     * @param right is the index of the last element
     * @return the element that is in the correct position (sorted) so that next sorting operation is done left side and right side of this element anymore
     */
    private int partition(int left, int right)
    {
        int pivot = arr[right].getValue().getCount();
        int last_smaller_index = left; //indicates the last  element smaller than the pivot that has been checked in the for loop
        for(int current = left;current<right;current++)
        {
            if(arr[current].getValue().getCount()<pivot)
            {
                swap(current, last_smaller_index);
                last_smaller_index++;
            }
        }
        swap(last_smaller_index, right);//to get the pivot to the correct position
        /*returns the element that is in the correct position (sorted)
        so that next sorting operation is done left side and right side of this element anymore*/
        return last_smaller_index;
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
        System.out.println("------------------Sorted Map (QUICK SORT)---------------------");
        for(String key : sortedMap.keySet())
            System.out.println("Letter: " + key + " - " + sortedMap.get(key));
        System.out.println("Map Size: " + sortedMap.size());
    }

}
