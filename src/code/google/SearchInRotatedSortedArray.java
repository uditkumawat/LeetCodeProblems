package code.google;

public class SearchInRotatedSortedArray {

    static int binarySearchRotated(int[] arr,int key) {
        //TODO: Write - Your - Code

        return binarySearch(arr,0,arr.length-1,key);
    }

    public static int binarySearch(int arr[],int left,int right,int key){
        if(left>right){
            return -1;
        }

        int mid = left+(right-left)/2;

        if(arr[mid]==key){
            return mid;
        }

        //check if left half is sorted
        if(arr[left]<arr[mid]){
            if(key>=arr[left] && key<=arr[mid]){
                return binarySearch(arr,left,mid-1,key);
            }
            else{
                return binarySearch(arr,mid+1,right,key);
            }
        }
        else{
            if(key>=arr[mid] && key<=arr[right]){
                return binarySearch(arr,mid+1,right,key);
            }
            else{
                return binarySearch(arr,left,mid+1,key);
            }
        }
    }
}
