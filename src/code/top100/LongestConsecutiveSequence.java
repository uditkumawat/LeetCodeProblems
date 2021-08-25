package code.top100;

import java.util.HashSet;
import java.util.Set;

/**
 * Time complexity : O(n)O(n).
 *
 * Although the time complexity appears to be quadratic due to the while loop nested within the for loop, closer inspection reveals it to be linear. Because the while loop is reached only when currentNum marks the beginning of a sequence (i.e. currentNum-1 is not present in nums), the while loop can only run for nn iterations throughout the entire runtime of the algorithm. This means that despite looking like O(n \cdot n)O(n⋅n) complexity, the nested loops actually run in O(n + n) = O(n)O(n+n)=O(n) time. All other computations occur in constant time, so the overall runtime is linear.
 *
 * Space complexity : O(n)O(n).
 *
 * In order to set up O(1)O(1) containment lookups, we allocate linear space for a hash table to store the O(n)O(n) numbers in nums. Other than that, the space complexity is identical to that of the brute force solution.
 */
public class LongestConsecutiveSequence {

    public static void main(String args[]){
        int nums[] = {100,200,1,3,2,4};

        System.out.println(longestConsecutive(nums));
    }
    public static int longestConsecutive(int[] nums) {

        Set<Integer> numsSet = new HashSet<>();
        for(int num:nums){
            numsSet.add(num);
        }

        int longestStreak = 0;

        for(int num:nums){
            if(!numsSet.contains(num-1)){
                int currentStreak = 1;
                int currentNum = num;

                while(numsSet.contains(currentNum+1)){
                    currentNum++;
                    currentStreak++;
                }

                longestStreak = Math.max(longestStreak,currentStreak);
            }
        }

        return longestStreak;
    }
}
