package code.top100;

/**
 * Worst and Average Case Time Complexity: O(n*n). Worst case occurs when array is reverse sorted.
 * Best Case Time Complexity: O(n). Best case occurs when array is already sorted.
 * Auxiliary Space: O(1)
 * Boundary Cases: Bubble sort takes minimum time (Order of n) when elements are already sorted.
 * Sorting In Place: Yes
 * Stable: Yes
 */
public class BubbleSort {

    public static void main(String args[]){

        int arr[] = {12,11,13,5,6};

        bubbleSort(arr);

        for(int i:arr){
            System.out.print(i+" ");
        }
    }

    // in first iteration, largest element will go in last
    //then in second iteration, second largest will go in second last index
    public static void bubbleSort(int arr[]){

        int n = arr.length;

        for(int i=0;i<n-1;i++){
            boolean swapped = false;
            for(int j=0;j<n-i-1;j++){

                if(arr[j]>arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    swapped = true;
                }
            }
            if(swapped==false){
                break;
            }
        }
    }
}
