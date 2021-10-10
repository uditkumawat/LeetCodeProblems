package code.google;

public class SumOfOddLengthSubArray {

    public static void main(String args[]){

        SumOfOddLengthSubArray obj = new SumOfOddLengthSubArray();
        int arr[] = {1,4,2,5,3};
        System.out.println(obj.sumOddLengthSubarrays(arr));
    }

    public int sumOddLengthSubarrays(int[] arr) {

        int sum = 0;

        for(int k=1;k<arr.length;k=k+2){
            for(int i=0;i<arr.length-k;i++){
                for(int j=i;j<i+k;j++){
                    sum+=arr[j];
                }
            }
        }

        return sum;
    }
}
