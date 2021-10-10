package code.top100;

import java.util.HashMap;

//https://www.youtube.com/watch?v=j48e8ac7r20
//TC - O(n)
//SC - O(k)
public class DistinctNumbersInEachSubArray {

    public static void main(String args[]){

        int arr[] = {1,2,3,2,2,1,3};
        int k = 3;
        int output[] = getArray(arr,k);

        for(int i:output){
            System.out.print(i+" ");
        }
    }

    public static int[] getArray(int arr[],int k){
        int n = arr.length;
        int left=0;
        int right=0;
        HashMap<Integer,Integer> map = new HashMap<>();
        int output[] = new int[n-k+1];
        int index = 0;

        while(right<arr.length){

            if(!map.isEmpty() && right-left>=k){
                map.put(arr[left],map.get(arr[left])-1);
                if(map.get(arr[left])<=0){
                    map.remove(arr[left]);
                }
                left++;
            }
            map.put(arr[right],map.getOrDefault(arr[right],0)+1);
            right++;

            if(right>=k){
                output[index++] = map.size();
            }
        }

        return output;
    }
}
