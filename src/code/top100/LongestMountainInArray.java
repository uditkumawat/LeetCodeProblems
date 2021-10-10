package code.top100;

public class LongestMountainInArray {


    public static void main(String args[]){
        int arr[] = {2,1,4,7,3,2,5};
        System.out.println(longestMountain(arr));
    }
    public static int longestMountain(int[] arr) {

        int up = 0;
        int down = 0;
        int i = 0;
        int n = arr.length;
        int maxLength = 0;

        while(i<n){
            up = 0;
            down = 0;

            while(i>0 && i<n && arr[i-1]<arr[i]){
                i++;
                up++;
            }

            while(i>0 && i<n && arr[i-1]>arr[i]){
                i++;
                down++;
            }

            if(up>0 && down>0){
                maxLength = Math.max(maxLength,up+down+1);
            }

            while(i>0 && i<n && arr[i-1]==arr[i]){
                i++;
            }
            i++;
        }
        return maxLength;
    }
}
