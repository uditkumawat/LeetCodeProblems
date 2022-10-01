package code.september2022.challenge;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/find-k-closest-elements/submissions/
//TC - O(n)
//https://www.youtube.com/watch?v=C_kHKUJuK0Y
public class FindKClosestElements {

    public List<Integer> findClosestElements(int[] arr, int k, int x) {

        if(arr==null || arr.length==0){
            return new ArrayList();
        }

        List<Integer> res = new ArrayList();

        int left = 0;
        int right = arr.length-1;

        while(right-left>=k){

            if(Math.abs(arr[left]-x)>Math.abs(arr[right]-x)){
                left++;
            }
            else{
                right--;
            }
        }

        for(int i=left;i<=right;i++){
            res.add(arr[i]);
        }

        return res;
    }


}
