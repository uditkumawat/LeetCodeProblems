package code.top100;

import java.util.Arrays;

//https://www.youtube.com/watch?v=h6_lIwZYHQw
public class Candy {

    public static void main(String args[]){

        int arr[] = {12,4,3,11,34,34,1,67};
        int n = arr.length;
        int left[] = new int [n];
        int right[] = new int [n];

        Arrays.fill(left,1);
        Arrays.fill(right,1);

        for(int i=1;i<n;i++){
            if(arr[i-1]<arr[i]){
                left[i] = 1+ left[i-1];
            }
        }

        for(int i=n-2;i>=0;i--){
            if(arr[i+1]<arr[i]){
                right[i] = 1+ right[i+1];
            }
        }

        int ans = 0;
        for(int i=0;i<n;i++){
            ans+=Math.max(left[i],right[i]);
        }

        System.out.println(ans);
    }

}
