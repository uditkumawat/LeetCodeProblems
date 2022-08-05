package code.bloomberg;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

//https://www.geeksforgeeks.org/sort-given-array-which-is-already-sorted-based-on-absolute-values-of-elements/
public class SortAnArray {

    // Function to sort
    public static void SortWithoutSorting(int arr[], int N)
    {
        Deque<Integer> dq = new ArrayDeque<Integer>();
        for (int i = 0; i < N; i++) {

            // Pushing negative elements in
            // the front of the deque
            if (arr[i] < 0) {
                dq.addFirst(arr[i]);
            }

            // Pushing positive elements in
            // the back of the deque
            else {
                dq.addLast(arr[i]);
            }
        }

        // Preparing the output array
        int i = 0;
        for (Iterator it = dq.iterator();
             it.hasNext();) {
            arr[i++] = (int)it.next();
        }

    }

    // Function to print the array.
    public static void showArray(int arr[], int N)
    {
        for (int i = 0; i < N; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    // Driver Code
    public static void main (String[] args)
    {
        int arr[] = { 1, -2, 3, -4, -5, 6 };
        int N = arr.length;

        SortWithoutSorting(arr, N);
        showArray(arr, N);
    }
}
