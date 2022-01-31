package code.google;

import java.util.Arrays;
import java.util.List;

public class LowHighIndexInSortedArray {

    public static void main(String args[]){

        List<Integer> list = Arrays.asList(5,7,7,7,7,8,8,10);

        LowHighIndexInSortedArray obj = new LowHighIndexInSortedArray();

        System.out.println(obj.findLowIndex(list,8));

        System.out.println(obj.findHighIndex(list,8));

    }

    public int findLowIndex(List<Integer> arr, int key) {

        int left = 0;
        int right = arr.size()-1;
        while(left<=right){
            int mid = left+(right-left)/2;

            if((mid==0 && arr.get(mid)==key)
                    || arr.get(mid-1)!=key && arr.get(mid)==key){
                return mid;
            }
            else if(arr.get(mid)>=key){
                right = mid-1;
            }
            else{
                left = mid+1;
            }
        }
        return -1;
    }

    public int findHighIndex(List<Integer> arr, int key) {
        int left = 0;
        int right = arr.size()-1;
        while(left<=right){
            int mid = left+(right-left)/2;

            if((mid==arr.size()-1 && arr.get(mid)==key)
                    || (mid+1<arr.size() && arr.get(mid+1)!=key && arr.get(mid)==key)){

                return mid;
            }
            else if(arr.get(mid)<=key){
                left = mid+1;
            }
            else{
                right = mid-1;
            }
        }
        return -1;
    }
}
