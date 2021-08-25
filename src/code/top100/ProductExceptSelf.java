package code.top100;

public class ProductExceptSelf {

    public static void main(String args[]){

        int arr[] = {1,2,3};

        int ans[] = productExceptSelfBetter(arr);

        for(int n:ans){
            System.out.print(n+" ");
        }
    }

    //TC - O(N)
    //SC - O(N)
    public static int[] productExceptSelf(int[] nums) {

        int n = nums.length;
        int left[] = new int[n];
        int right[] = new int[n];
        int ans[] = new int[n];

        left[0]=1;
        right[n-1]=1;

        for(int i=1;i<n;i++){
            left[i] = left[i-1]*nums[i-1];
        }

        for(int i=n-2;i>=0;i--){
            right[i] = right[i+1]*nums[i+1];
        }

        for(int i=0;i<n;i++){
            ans[i] = left[i]*right[i];
        }

        return ans;

    }

    //TC - O(N)
    //SC - O(1)
    public static int[] productExceptSelfBetter(int[] nums) {

        int n = nums.length;
        int ans[] = new int[n];

        ans[0]=1;

        for(int i=1;i<n;i++){
            ans[i] = ans[i-1]*nums[i-1];
        }

        int right=1;
        for(int i=n-1;i>=0;i--){
            ans[i] = ans[i] * right;
            right = right * nums[i];
        }

        return ans;
    }
}
