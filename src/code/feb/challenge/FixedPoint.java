package code.feb.challenge;

public class FixedPoint {

    public static void main(String args[]){

        int arr[] = {-10,-5,3,4,7,9};

        FixedPoint obj = new FixedPoint();

        System.out.println(obj.fixedPoint(arr));
    }
    public int fixedPoint(int[] arr) {

        return findUsingBS(arr,0,arr.length-1);
    }

    private int findUsingBS(int arr[],int left,int right){

        if(left>right){
            return -1;
        }

        int mid = left+(right-left)/2;

        if(arr[mid]==mid){
            return mid;
        }
        else if(arr[mid]<mid){
            return findUsingBS(arr,mid+1,right);
        }
        else{
            return findUsingBS(arr,left,mid-1);
        }
    }
}
