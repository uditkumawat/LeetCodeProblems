package code.top100;

//https://www.youtube.com/watch?v=YxuK6A3SvTs&list=PLEJXowNB4kPxQIN2dCUAnQ_92HIziG4x6&index=22
public class Kadane {

    public static void main(String args[]){

        int arr[] = {-2,-3,4,-1,-2,1,5,-3};

        System.out.println(largestContiguousSubArray(arr));
    }

    public static int largestContiguousSubArray(int arr[]){

        int maxEndingHere = arr[0];
        int maxSoFar = Integer.MIN_VALUE;
        int startIndex = 0;
        int endIndex = 0;
        for(int i=1;i<arr.length;i++){

            maxEndingHere = maxEndingHere+arr[i];
            if(maxEndingHere<arr[i]){
                maxEndingHere = arr[i];
                startIndex = i;
            }
            if(maxSoFar<maxEndingHere){
                endIndex = i;
                maxSoFar = maxEndingHere;
            }
        }

        System.out.println("Start and End ->"+startIndex+" "+endIndex);

        return maxSoFar;
    }
}
