package code.top100;

//TC - O(n^2)
//Sorting in palce, no extra space
public class InsertionSort {

    public static void main(String args[]){

        int arr[] = {12,11,13,5,6};

        insertionSort(arr);

        for(int i:arr){
            System.out.print(i+" ");
        }
    }

    public static void insertionSort(int arr[]){

        int n = arr.length;
        for(int i=1;i<n;i++){
            int elem = arr[i];
            int j = i-1;

            while(j>=0 && arr[j]>elem){
                arr[j+1] = arr[j];
                j--;
            }

            arr[j+1] = elem;
        }
    }
}
