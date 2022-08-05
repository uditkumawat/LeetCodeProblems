package code.blind75;

//https://www.youtube.com/watch?v=CihX9yKR2xk
//TC - O(logn)
public class FindMinimumInSortedArray {

    public int minimum(int arr[]){

        int low = 0;
        int high = arr.length-1;

        while(low<high){
            int mid = low+(high-low)/2;
            if(arr[high]>=arr[mid]){
                high = mid;
            }
            else{
                low = mid+1;
            }
        }

        return arr[low];
    }
}
