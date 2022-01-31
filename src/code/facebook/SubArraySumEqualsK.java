package code.facebook;

import java.util.HashMap;
import java.util.Map;

/**
 * The idea behind this approach is as follows: If the cumulative sum(represented by sum[i]sum[i] for sum up to i^{th}i
 * th
 *   index) up to two indices is the same, the sum of the elements lying in between those indices is zero. Extending the same thought further, if the cumulative sum up to two indices, say ii and jj is at a difference of kk i.e. if sum[i] - sum[j] = ksum[i]−sum[j]=k, the sum of elements lying between indices ii and jj is kk.
 *
 * Based on these thoughts, we make use of a hashmap mapmap which is used to store the cumulative sum up to all the indices possible along with the number of times the same sum occurs. We store the data in the form: (sum_i, no. of occurrences of sum_i)(sum
 * i
 * ​
 *  ,no.ofoccurrencesofsum
 * i
 * ​
 *  ). We traverse over the array numsnums and keep on finding the cumulative sum. Every time we encounter a new sum, we make a new entry in the hashmap corresponding to that sum. If the same sum occurs again, we increment the count corresponding to that sum in the hashmap. Further, for every sum encountered, we also determine the number of times the sum sum-ksum−k has occurred already, since it will determine the number of times a subarray with sum kk has occurred up to the current index. We increment the countcount by the same amount.
 *
 * After the complete array has been traversed, the countcount gives the required result.
 */
public class SubArraySumEqualsK {

    public static void main(String args[]){
        int nums[] = {1,1,1};
        int k = 2;
        SubArraySumEqualsK obj = new SubArraySumEqualsK();

        System.out.println(obj.subarraySum(nums,k));

    }
    public int subarraySum(int[] nums, int k) {

        if(nums==null || nums.length==0){
            return 0;
        }

        Map<Integer,Integer> map = new HashMap<>();

        int count = 0;

        int currSum = 0;
        map.put(0,1);
        for(int i=0;i<nums.length;i++){
            currSum+=nums[i];
            if(map.containsKey(currSum-k)){
                count+=map.get(currSum-k);
            }
            map.put(currSum,map.getOrDefault(currSum,0)+1);
        }

        return count;
    }
}
