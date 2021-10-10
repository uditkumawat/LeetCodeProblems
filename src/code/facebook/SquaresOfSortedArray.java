package code.facebook;

public class SquaresOfSortedArray {

    public static void main(String args[]){

        SquaresOfSortedArray obj = new SquaresOfSortedArray();

        int nums[] = {-7,-3,2,3,11};

        int out[] = obj.sortedSquares(nums);

        for(int num:out){
            System.out.print(num+" ");
        }

    }

    public int[] sortedSquares(int[] nums) {
        if(nums==null || nums.length==0){
            return new int[0];
        }

        int n = nums.length;

        int output[] = new int[n];

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
