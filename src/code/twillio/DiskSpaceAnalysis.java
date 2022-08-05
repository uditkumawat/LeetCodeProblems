package code.twillio;

import java.util.Collection;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

//HackerRank OA question
//https://leetcode.com/discuss/interview-question/1975461/Twilio-L3-or-OA-or-Reject
public class DiskSpaceAnalysis {

    public static void main(String args[]){

        int arr[] = {8,2,4,6};

        int segmentLength = 2;

        DiskSpaceAnalysis obj = new DiskSpaceAnalysis();

        System.out.println(obj.getMinSpace(arr,segmentLength));
    }


    public int getMinSpace(int arr[],int k){

        int n = arr.length;
        int res[] = new int[n-k+1];

        Deque<Integer> dq = new LinkedList<>();

        int right = 0;
        int resIndex = 0;

        while(right<n){

            int curr = arr[right];

            while(!dq.isEmpty() && right-dq.peekFirst()>=k){
                dq.removeFirst();
            }

            while(!dq.isEmpty() && arr[dq.peekLast()]>curr){
                dq.removeLast();
            }

            dq.add(right);
            if(right-k+1>=0) {
                res[resIndex++] = arr[dq.peekFirst()];
            }
            right++;
        }

        int maxValue = Integer.MIN_VALUE;
        for(int num:res){
            maxValue = Math.max(maxValue,num);
        }

        return maxValue;
    }
}
