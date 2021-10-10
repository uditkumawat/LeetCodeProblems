package code.microsoft;

/**
 * Given the array nums, for each nums[i] find out how many numbers in the array are smaller than it. That is, for each nums[i] you have to count the number of valid j's such that j != i and nums[j] < nums[i].
 *
 * Return the answer in an array.
 */
//TC - O(N)
//SC - O(N)
public class NumbersSmallerThanCurrentNumber {

    public static void main(String args[]){
        NumbersSmallerThanCurrentNumber obj = new NumbersSmallerThanCurrentNumber();

        int nums[] = {4,5,1,3,5,4,4,1,4,5,1,4};

        int output[] = obj.getSmallerNumbersCount(nums);

        for(int num:output) {
            System.out.print(num + " ");
        }
    }

    public int[] getSmallerNumbersCount(int nums[]){

        int n = nums.length;

        int count[] = new int[502];
        int output[] = new int[n];

        for(int i=0;i<n;i++){
            count[nums[i]]++;
        }

        for(int i=1;i<502;i++){
            count[i]+=count[i-1];
        }

        for(int i=0;i<n;i++){
            int pos = nums[i];
            output[i] = count[pos-1];
        }

        return output;
    }
}
