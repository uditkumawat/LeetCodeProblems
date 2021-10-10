package code.top100;

/**
 * Time Complexity: O(n2) as there are two nested loops.
 * Auxiliary Space: O(1)
 * The good thing about selection sort is it never makes more than O(n) swaps and can be useful when memory write is a costly operation.
 */
public class SelectionSort {

    public static void main(String args[]){

        int arr[] = {12,11,13,5,6};

        selectionSort(arr);

        for(int i:arr){
            System.out.print(i+" ");
        }
    }

    public static void selectionSort(int arr[]){

        int n = arr.length;

        for(int i=0;i<n;i++){

            int minIndex = i;
            for(int j=i+1;j<n;j++){
                if(arr[j]<arr[minIndex]){
                    minIndex = j;
                }
            }

            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }
}
