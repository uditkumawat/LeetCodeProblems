package code.top100;

public class SquaresOfSortedArray {

    public static void main(String args[]){
        int nums[]={-7,-3,2,3,11};
        int output[] = sortedSquares(nums);

        for(int i:output){
            System.out.print(i+" ");
        }
    }

    public static int[] sortedSquares(int[] nums) {
        if(nums==null || nums.length==0){
            return new int[0];
        }

        int output[] = new int[nums.length];

        int p1=0;
        int p2=nums.length-1;

        int index = nums.length-1;

        while(p1<=p2){
            int first = nums[p1]*nums[p1];
            int last = nums[p2]*nums[p2];
            if(last>first){
                output[index--] = last;
                p2--;
            }
            else{
                output[index--] = first;
                p1++;
            }
        }

        return output;
    }
}
