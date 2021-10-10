package code.top100;

import java.util.Arrays;

//TC - O(n+nlogn)
public class MinimumNumberOfPlatforms {

    public static void main(String args[]){

        int arr[]={900,940,950,1100,1500};
        int dep[]={910,1200,1120,1130,1900,2000};

        System.out.println(minimumNumberOfPlatforms(arr,dep));
    }

    public static int minimumNumberOfPlatforms(int arr[],int dep[]){

        if(arr.length==0 || dep.length==0){
            return 0;
        }
        int n = arr.length;
        Arrays.sort(arr);
        Arrays.sort(dep);

        int i=1;
        int j=0;
        int platforms = 1;
        int maxPlatforms = Integer.MIN_VALUE;

        while(i<n && j<n){
            if(arr[i]<dep[j]){
                platforms++;
                maxPlatforms = Math.max(maxPlatforms,platforms);
                i++;
            }
            else{
                j++;
                platforms--;
            }
        }

        return maxPlatforms;
    }
}
