package code.leetcode.doordash;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*

[P1, D1, P1, D1]==>invalid
0 1 2 3

[P1, P2, D1, D2]==>valid
[P1, D1, P2, D2]==>valid
[P1, D2, D1, P2]==>invalid
[P1, D2]==>invalid
[P1, P2]==>invalid
[P1, D1, D1]==>invalid
[]==>valid
[P1, P1, D1]==>invalid
[P1, P1, D1, D1]==>invalid
[P1, D1, P1]==>invalid
[P1, D1, P1, D1]==>invalid
*/

public class LongestValidSubarray {

    Map<Integer,Integer> pickupIndexes;
    Map<Integer,Integer> deliveryIndexes;
    Set<Integer> orders;

    public static void main(String[] args) {
        LongestValidSubarray obj = new LongestValidSubarray();
        String[] arr = {"P1", "D1", "P1", "D1"};
        obj.longestValidSubArray(arr);
    }

    public void longestValidSubArray(String arr[]){
        pickupIndexes = new HashMap<>();
        deliveryIndexes = new HashMap<>();
        orders = new HashSet<>();
        int maxSoFar = 0;
        int startIndex = -1;
        int leftIndex = -1;
        int rightIndex = -1;

        for(int i=0;i<arr.length;i++){
            char orderType = arr[i].charAt(0);
            int orderNumber = Integer.parseInt(arr[i].substring(1));

            if(orderType=='P'){
                if(pickupIndexes.containsKey(orderNumber)){
                    startIndex = i;
                    orders.clear();
                    orders.add(orderNumber);
                }
                else{
                    pickupIndexes.put(orderNumber,i);
                    if(startIndex==-1){
                        startIndex = i;
                    }
                    orders.add(orderNumber);
                }
            }
            else if(orderType=='D'){
                if(deliveryIndexes.containsKey(orderNumber) || !orders.contains(orderNumber)){
                    orders.clear();
                    startIndex = -1;
                }
                else{
                    deliveryIndexes.put(orderNumber,i);
                    orders.remove(orderNumber);
                    if(orders.size()==0 && (i-startIndex+1>maxSoFar)){
                        maxSoFar = i-startIndex+1;
                        leftIndex = startIndex;
                        rightIndex = i;
                    }
                }
            }
        }

        System.out.println(maxSoFar);
    }
}

