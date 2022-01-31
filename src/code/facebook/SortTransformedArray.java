package code.facebook;

public class SortTransformedArray {

    public static void main(String args[]){

        int nums[] = {-4,-2,2,4};
        int a=-1;
        int b=3;
        int c=5;

        SortTransformedArray obj = new SortTransformedArray();

        int res[] = obj.sortTransformedArray(nums,a,b,c);

        for(int num:res){
            System.out.print(num+" ");
        }

    }
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {

        int res[] = new int[nums.length];

        int left=0;
        int right=nums.length-1;
        int k=nums.length-1;

        for(int i=0;i<nums.length;i++){
            int ans1 = getRes(nums[left],a,b,c);
            int ans2 = getRes(nums[right],a,b,c);
            if(ans1>ans2){
                res[k--] = ans1;
                left++;
            }
            else{
                res[k--] = ans2;
                right--;
            }
        }

        return res;
    }

    public int getRes(int x,int a,int b,int c){
        return a*x*x+b*x+c;
    }
}
