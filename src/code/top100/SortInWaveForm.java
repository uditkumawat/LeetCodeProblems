package code.top100;

//https://www.geeksforgeeks.org/sort-array-wave-form-2/
//TC - O(N)
public class SortInWaveForm {

    public static void main(String args[]){

        int arr[] = {1,2,3,4,5,5,6};

        sortInWaveForm(arr);
        for(int i:arr){
            System.out.print(i+" ");
        }
    }

    public static void sortInWaveForm(int arr[]){

        int n = arr.length;

        for(int i=0;i<n;i=i+2){

            if(i>0 && arr[i-1]>arr[i]){
                swap(arr,i-1,i);
            }

            if(i<n-1 && arr[i+1]>arr[i]){
                swap(arr,i,i+1);
            }
        }

        return;
    }

    public static void swap(int arr[],int t1,int t2){
        int temp = arr[t1];
        arr[t1] = arr[t2];
        arr[t2] = temp;
    }
}
