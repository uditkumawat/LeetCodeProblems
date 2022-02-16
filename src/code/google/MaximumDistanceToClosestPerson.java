package code.google;

import java.util.Arrays;

//https://www.youtube.com/watch?v=AyQarOkptdw
//https://leetcode.com/problems/maximize-distance-to-closest-person/
public class MaximumDistanceToClosestPerson {

    public static void main(String args[]){

        int arr[] = {1,0,0,0,1,0,1};

        MaximumDistanceToClosestPerson obj = new MaximumDistanceToClosestPerson();

        System.out.println(obj.getDistance(arr));

    }

    public int getDistance(int arr[]){

        if(arr==null || arr.length==0){
            return 0;
        }

        int len = arr.length;

        int left[] = new int[len];
        Arrays.fill(left,-1);

        int lastFilledIndex = -1;
        int i=0;

        while(i<len){
            if(arr[i]==1){
                lastFilledIndex = i;
            }
            else{
                left[i] = lastFilledIndex;
            }
            i++;
        }

        int right[] = new int[len];
        Arrays.fill(right,-1);

        i = len-1;
        while(i>=0){
            if(arr[i]==1){
                lastFilledIndex = i;
            }
            else{
                right[i] = lastFilledIndex;
            }
            i--;
        }

        int resDistance = 0;

        for(i=0;i<len;i++) {
            if (arr[i] == 0) {
                int leftDistance = i - left[i];
                int rightDistance = right[i] - i;
                int currDistance = Math.max(leftDistance, rightDistance);
                resDistance = Math.max(resDistance, currDistance);
            }
        }

        return resDistance;
    }
}
