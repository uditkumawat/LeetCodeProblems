package code.top100;

public class SubArrayWithGivenSum {

    public static void main(String args[]){

        int arr[] = {1,4,20,3,10,5};
        int ss = 33;
        System.out.println(isSubArrayWithSumExists(arr,ss));
    }

    public static boolean isSubArrayWithSumExists(int arr[],int ss){

        int left = 0;
        int right = 0;
        int sum = 0;

        while(right<arr.length){
            if(sum<ss){
                sum = sum+arr[right];
                right++;
            }
            else if(sum>ss){
                sum = sum-arr[left];
                left++;
            }
            else if(sum==ss){
                System.out.println("Start and end ->"+left+" "+right);
                return true;
            }
        }

        return false;
    }
}
