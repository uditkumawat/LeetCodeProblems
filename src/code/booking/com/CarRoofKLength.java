package code.booking.com;

import java.util.Arrays;

public class CarRoofKLength {

    public static void main(String args[]){

        int arr[] = {2,10,8,7};

        int k = 3;

        CarRoofKLength obj = new CarRoofKLength();

        System.out.println(obj.getMinDist(arr,k));
    }

    public int getMinDist(int arr[],int k){

        if(arr==null || arr.length ==0){
            return 0;
        }

        Arrays.sort(arr);

        int minDist = Integer.MAX_VALUE;

        for(int i=0;i<arr.length-k+1;i++){
            int diff = arr[i+k-1]-arr[i]+1;

            minDist = Math.min(minDist,diff);
        }

        return minDist;
    }
}
