/**
 * Main class
 */
public class Main {
    public static void main(String[] args) {
        String str1 = "Buzzing bees buzz.";
        String str2 = "'Hush, hush!' whispered the rushing wind.";
        String str3 = "abc aba";

        myMap myMapObj1 = new myMap(str1);
        mergeSort mergeSortObj1 = new mergeSort(myMapObj1);
        mergeSortObj1.mergeSort();
        mergeSortObj1.view();
        System.out.println("\n");

        myMap myMapObj2 = new myMap(str2);
        mergeSort mergeSortObj2 = new mergeSort(myMapObj2);
        mergeSortObj2.mergeSort();
        mergeSortObj2.view();
        System.out.println("\n");

        myMap myMapObj3 = new myMap(str3);
        mergeSort mergeSortObj3 = new mergeSort(myMapObj3);
        mergeSortObj3.mergeSort();
        mergeSortObj3.view();
        System.out.println("\n");
        /*
        **************ERROR CASE****************
        myMap myMapObj4 = new myMap("      ");
        mergeSort mergeSortObj4 = new mergeSort(myMapObj4);
        mergeSortObj4.mergeSort();
        mergeSortObj4.view();
        System.out.println("\n");
        */
    }
}
