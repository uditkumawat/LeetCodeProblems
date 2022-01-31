package code.google;

public class ShortedSubArrayWithSumGreaterThanK {

    public static void main(String args[]){

        int arr[] = {1,2,3,4,5,6,7,10};

        int k = 10;

        ShortedSubArrayWithSumGreaterThanK obj = new ShortedSubArrayWithSumGreaterThanK();

        System.out.println(obj.getMinLength(arr,k));
    }

    public int getMinLength(int arr[],int k){
        int left = 0;
        int minLength = Integer.MAX_VALUE;
        int sum = 0;

        for(int right=0;right<arr.length;right++){
            sum+=arr[right];

            while(left<=right && sum>k){
                sum = sum-arr[left];
                left++;
            }

            minLength = Math.min(minLength,right-left+1);
        }

        return minLength;
    }
}
