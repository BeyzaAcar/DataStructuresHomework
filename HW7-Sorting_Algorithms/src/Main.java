import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.Scanner;

/**
 * Main class
 */
public class Main {

    public static void pressButtonToContinue()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Press any key to continue...");
        sc.nextLine();
    }
    public static void main(String[] args) {
        String str;
        long time;
        System.out.println("TIME ANALYSIS FOR DIFFERENT INPUTS AND RESULTS");
        System.out.println("--------------------------------------------------");
        System.out.println("INPUT 1");
        System.out.println("--------------------------------------------------");
        str = "abbcccddddeeeeeffffffggggggghhhhhhhhiiiiiiiiijjjjjjjjjjkkkkkkkkkkkllllllllllllmmmmmmmmmmmmmnnnnnnnnnnnnnnoooooooooooooooppppppppppppppppqqqqqqqqqqqqqqqqqrrrrrrrrrrrrrrrrrrsssssssssssssssssssttttttttttttttttttttuuuuuuuuuuuuuuuuuuuuuu";
        myMap myMapObj1 = new myMap(str);

        BubbleSort bubbleSortObj = new BubbleSort(myMapObj1);
        time = bubbleSortObj.bubbleSort();
        System.out.println("time for bubbleSort = " + time + " ns");
        SelectionSort selectionSortObj = new SelectionSort(myMapObj1);
        time = selectionSortObj.selectionSort();
        System.out.println("time for selectionSort = " + time + " ns");
        InsertionSort insertionSortObj = new InsertionSort(myMapObj1);
        time = insertionSortObj.insertionSort();
        System.out.println("time for insertionSort = " + time + " ns");
        MergeSort mergeSortObj = new MergeSort(myMapObj1);
        time = mergeSortObj.mergeSort();
        System.out.println("time for mergeSort = " + time + " ns");
        QuickSort quickSortObj = new QuickSort(myMapObj1);
        time = quickSortObj.quickSort();
        System.out.println("time for quickSort = " + time + " ns");

        pressButtonToContinue();

        System.out.println("--------------------------------------------------");
        System.out.println("PRINTING SORTED MAPS");
        System.out.println("--------------------------------------------------");
        bubbleSortObj.view();
        selectionSortObj.view();
        insertionSortObj.view();
        mergeSortObj.view();
        quickSortObj.view();

        pressButtonToContinue();

        System.out.println("--------------------------------------------------");
        System.out.println("INPUT 2");
        System.out.println("--------------------------------------------------");
        str = "uuuuuuuuuuuuuuuuuuuuuuttttttttttttttttttttsssssssssssssssssssrrrrrrrrrrrrrrrrrrqqqqqqqqqqqqqqqqqpppppppppppppppppooooooooooooooonnnnnnnnnnnnnnnnmmmmmmmmmmmmmllllllllllllkkkkkkkkkkkjjjjjjjjjjjiiiiiiiiiiihhhhhhhhggggggggffffffeeeeeeeddddcccbbba";
        myMapObj1 = new myMap(str);

        bubbleSortObj = new BubbleSort(myMapObj1);
        time = bubbleSortObj.bubbleSort();
        System.out.println("time for bubbleSort = " + time + " ns");
        selectionSortObj = new SelectionSort(myMapObj1);
        time = selectionSortObj.selectionSort();
        System.out.println("time for selectionSort = " + time + " ns");
        insertionSortObj = new InsertionSort(myMapObj1);
        time = insertionSortObj.insertionSort();
        System.out.println("time for insertionSort = " + time + " ns");
        mergeSortObj = new MergeSort(myMapObj1);
        time = mergeSortObj.mergeSort();
        System.out.println("time for mergeSort = " + time + " ns");
        quickSortObj = new QuickSort(myMapObj1);
        time = quickSortObj.quickSort();

        pressButtonToContinue();

        System.out.println("time for quickSort = " + time + " ns");
        System.out.println("--------------------------------------------------");
        System.out.println("PRINTING SORTED MAPS");
        System.out.println("--------------------------------------------------");
        bubbleSortObj.view();
        selectionSortObj.view();
        insertionSortObj.view();
        mergeSortObj.view();
        quickSortObj.view();

        pressButtonToContinue();

        System.out.println("--------------------------------------------------");
        System.out.println("INPUT 3");
        System.out.println("--------------------------------------------------");
        str = "qqqqqqqqqqqqqqqqqacccttttttttttttttttttttssssssssssssssssssshhhhhhhhffffffiiiiiiiiiiinnnnnnnnnnnnnnnnbbrrrrrrrrrrrrrrrrrrddddjjjjjjjjjjjeeeeeeellllllllllllkkkkkkkkkkkmmmmmmmmmmmmmpppppppppppppppppooooooooooooooouuuuuuuuuuuuuuuuuuuuuu";
        myMapObj1 = new myMap(str);

        bubbleSortObj = new BubbleSort(myMapObj1);
        time = bubbleSortObj.bubbleSort();
        System.out.println("time for bubbleSort = " + time + " ns");
        selectionSortObj = new SelectionSort(myMapObj1);
        time = selectionSortObj.selectionSort();
        System.out.println("time for selectionSort = " + time + " ns");
        insertionSortObj = new InsertionSort(myMapObj1);
        time = insertionSortObj.insertionSort();
        System.out.println("time for insertionSort = " + time + " ns");
        mergeSortObj = new MergeSort(myMapObj1);
        time = mergeSortObj.mergeSort();
        System.out.println("time for mergeSort = " + time + " ns");
        quickSortObj = new QuickSort(myMapObj1);
        time = quickSortObj.quickSort();
        System.out.println("time for quickSort = " + time + " ns");

        pressButtonToContinue();

        System.out.println("--------------------------------------------------");
        System.out.println("PRINTING SORTED MAPS");
        System.out.println("--------------------------------------------------");
        bubbleSortObj.view();
        selectionSortObj.view();
        insertionSortObj.view();
        mergeSortObj.view();
        quickSortObj.view();

        str = "Hello World";
        System.out.println("--------------------------------------------------");
        System.out.println("STABILITY TEST");
        System.out.println("Input : " + str);
        System.out.println("--------------------------------------------------");

        pressButtonToContinue();

        myMapObj1 = new myMap(str);
        bubbleSortObj = new BubbleSort(myMapObj1);
        bubbleSortObj.bubbleSort();
        bubbleSortObj.view();
        selectionSortObj = new SelectionSort(myMapObj1);
        selectionSortObj.selectionSort();
        selectionSortObj.view();
        insertionSortObj = new InsertionSort(myMapObj1);
        insertionSortObj.insertionSort();
        insertionSortObj.view();
        mergeSortObj = new MergeSort(myMapObj1);
        mergeSortObj.mergeSort();
        mergeSortObj.view();
        quickSortObj = new QuickSort(myMapObj1);
        quickSortObj.quickSort();
        quickSortObj.view();

    }
}
