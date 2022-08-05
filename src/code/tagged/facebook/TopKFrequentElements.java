package code.tagged.facebook;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

//https://leetcode.com/problems/top-k-frequent-elements/solution/
//TC - O(N)
//SC - O(N)
public class TopKFrequentElements {

    public static void main(String args[]){

        TopKFrequentElements obj = new TopKFrequentElements();

        int res[] = obj.topKFrequent(new int[]{1,1,1,2,2,3},2);

        for(int num:res){
            System.out.println(num);
        }
    }
    int unique[];
    Map<Integer,Integer> count;

    public int[] topKFrequent(int[] nums, int k) {

        if(nums==null || nums.length==0){
            return new int[]{};
        }

        count = new HashMap<>();
        for(int num:nums){
            count.put(num,count.getOrDefault(num,0)+1);
        }

        int n = count.size();
        unique = new int[n];

        int i = 0;

        for(int num:count.keySet()){
            unique[i] = num;
            i++;
        }

        quickSelect(0,n-1,n-k);

        return Arrays.copyOfRange(unique,n-k,n);
    }

    public void quickSelect(int left,int right,int k_smallest){

        if(left==right){
            return;
        }

        int pivotIndex = partition(left,right,unique.length-1);

        if(k_smallest==pivotIndex){
            return;
        }
        else if(k_smallest<pivotIndex){
            quickSelect(left, pivotIndex-1, k_smallest);
        }
        else{
            quickSelect(pivotIndex+1, right, k_smallest);
        }
    }

    public int partition(int left,int right,int pivotIndex){

        int pivotFrequency = count.get(unique[pivotIndex]);

        //move to end
        swap(pivotIndex,right);

        int storeIndex = left;

        for(int i=left;i<=right;i++){
            if(count.get(unique[i])<pivotFrequency){
                swap(storeIndex,i);
                storeIndex++;
            }
        }

        swap(storeIndex,right);

        return storeIndex;
    }

    public void swap(int a, int b) {
        int tmp = unique[a];
        unique[a] = unique[b];
        unique[b] = tmp;
    }

}
