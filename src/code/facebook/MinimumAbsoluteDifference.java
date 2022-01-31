package code.facebook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimumAbsoluteDifference {

    public static void main(String args[]){

        MinimumAbsoluteDifference obj = new MinimumAbsoluteDifference();
        int arr[] = {3,8,-10,23,19,-4,-14,27};

        List<List<Integer>> res = obj.minimumAbsDifference(arr);

        for(List<Integer> list:res){
            System.out.println(list.get(0)+","+list.get(1));
        }
    }
    public List<List<Integer>> minimumAbsDifference(int[] arr) {

        if(arr==null || arr.length==0){
            return null;
        }

        return getList(arr);
    }

    public List<List<Integer>> getList(int arr[]){

        Arrays.sort(arr);

        int minDiff = Integer.MAX_VALUE;

        for(int i=0;i<arr.length-1;i++){
            int diff = Math.abs(arr[i+1]-arr[i]);
            if(diff<minDiff){
                minDiff = diff;
            }
        }

        List<List<Integer>> res = new ArrayList<>();

        for(int i=0;i<arr.length-1;i++){
            int diff = Math.abs(arr[i+1]-arr[i]);
            if(diff==minDiff){
                List<Integer> list = new ArrayList<>();
                list.add(arr[i]);
                list.add(arr[i+1]);
                res.add(list);
            }
        }

        return res;
    }
}
