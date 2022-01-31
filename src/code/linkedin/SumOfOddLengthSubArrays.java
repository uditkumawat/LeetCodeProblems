package code.linkedin;

public class SumOfOddLengthSubArrays {

    public static void main(String args[]){
        int arr[] = {1,4,2,5,3};
        SumOfOddLengthSubArrays obj = new SumOfOddLengthSubArrays();
        System.out.println(obj.sumOddLengthSubarrays(arr));
    }
    public int sumOddLengthSubarrays(int[] arr) {

        int sum = 0;
        for(int i=0;i<arr.length;i++){
            for(int j=i;j<arr.length;j=j+2){
                for(int k=i;k<=j;k++) {
                    System.out.print(arr[k]);
                }
                System.out.println();
            }
            System.out.println();
        }
        return sum;
    }
}
