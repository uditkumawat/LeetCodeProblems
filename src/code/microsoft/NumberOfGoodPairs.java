package code.microsoft;

/**
 * Given an array of integers nums, return the number of good pairs.
 *
 * A pair (i, j) is called good if nums[i] == nums[j] and i < j.
 */
//TC - O(N)
//SC - O(N)
public class NumberOfGoodPairs {

    public static void main(String args[]){

        NumberOfGoodPairs obj = new NumberOfGoodPairs();

        int nums[] = {1,2,3,1,1,3};

        System.out.println(obj.count(nums));
    }

    public int count(int nums[]){

        int count[] = new int[105];
        int res = 0;

        for(int num:nums){
            res+=count[num]++;
        }

        return res;
    }

}
