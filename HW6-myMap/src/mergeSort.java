import java.lang.constant.Constable;

/**
 * Class that sorts myMap objects using merge sort and stores the sorted and unsorted map of the given myMap object
 */
public class mergeSort
{
    myMap originalMap;
    myMap sortedMap;
    keyValuePair[] arr;

    /**
     * A nested class that stores key and value of a map
     */
    protected class keyValuePair
    {
        String key;
        Info value;

        /**
         * Constructor that takes a string for key and an Info object for value
         * @param key
         * @param value
         */
        protected keyValuePair(String  key, Info value)
        {
            this.key = key;
            this.value = value;
        }

        /**
         * No parameter constructor for keyValuePair
         */
        protected keyValuePair()
        {
            this.key = null;
            this.value = null;
        }

        /**
         * Sets the key and value of the keyValuePair object
         * @param key
         * @param value
         */
        protected void setData(String key, Info value)
        {
            this.key = key;
            this.value = value;
        }

        /**
         * Getter for key
         * @return
         */
        protected String getKey()
        {
            return key;
        }

        /**
         * Getter for value
         * @return
         */
        protected Info getValue()
        {
            return value;
        }
    }

    /**
     * Getter for sortedMap
     * @return
     */
    public myMap getSortedMap() {
        return sortedMap;
    }

    /**
     * Constructor that takes a myMap object
     * @param originalMap
     */
    public mergeSort(myMap originalMap)
    {
        this.originalMap = originalMap;
        sortedMap = null;
    }

    /**
     * No parameter constructor
     */
    public void mergeSort()
    {
        mergeSortAlgorithm(0, originalMap.size()-1);
        copyToSortedMap();

    }
    /**
     * Creates a keyValuePair array from the originalMap and calls other mergeSort method
     * Does the merge sort algorithm
     * @param left
     * @param right
     */
    private void mergeSortAlgorithm(int left, int right)
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
        mergeSort(left, right);
    }

    /**
     * Does the merge sort algorithm
     * @param left
     * @param right
     */
    private void mergeSort(int left, int right) //The reason that arr is 2d is because first element stores index and second stores the count
    {
        if(left >= right)
            return;
        int middle = (left + right) / 2;
        mergeSort(left, middle);
        mergeSort(middle + 1, right);
        merge(left, right, middle);
    }

    /**
     * Merges the left and right arrays
     * @param left
     * @param right
     * @param middle
     */
    private void merge(int left, int right, int middle) //middle parameter is not necesarry, but therefore we have already calculate the value of middle, I thought there is no need to calculate it again
    {
        int leftMapSize = middle-left+1;
        int rightMapSize = right-middle;
        keyValuePair[] leftArr = new keyValuePair[leftMapSize];
        keyValuePair[] rightArr = new keyValuePair[rightMapSize];
        // Copy the left part of the array to the leftArr
        for(int i = 0;i<leftMapSize;i++)
        {
            leftArr[i] = new keyValuePair();
            leftArr[i].setData(arr[i+left].getKey(), arr[i+left].getValue());
        }
        // Copy the right part of the array to the rightArr
        for(int i = 0;i<rightMapSize;i++)
        {
            rightArr[i] = new keyValuePair();
            rightArr[i].setData(arr[i+middle+1].getKey(), arr[i+middle+1].getValue());
        }

        int i=0,j=0,k=left;
        while(i<leftMapSize && j<rightMapSize)
        {
            if(leftArr[i].getValue().getCount() <= rightArr[j].getValue().getCount())
            {
                arr[k].setData(leftArr[i].getKey(), leftArr[i].getValue());
                i++;
            }
            else
            {
                arr[k].setData(rightArr[j].getKey(), rightArr[j].getValue());
                j++;
            }
            k++;
        }
        while(i<leftMapSize)
        {
            arr[k].setData(leftArr[i].getKey(), leftArr[i].getValue());
            i++;
            k++;
        }
        while(j<rightMapSize)
        {
            arr[k].setData(rightArr[j].getKey(), rightArr[j].getValue());
            j++;
            k++;
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
        System.out.println("------------------Sorted Map---------------------");
        for(String key : sortedMap.keySet())
            System.out.println("Letter: " + key + " - " + sortedMap.get(key));
        System.out.println("Map Size: " + sortedMap.size());

    }
}
