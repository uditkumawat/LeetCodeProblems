package code.top100;

import java.util.ArrayList;
import java.util.List;

/**
 * Time complexity: \mathcal{O}(N \times 2^N)O(N×2
 * N
 *  ) to generate all subsets and then copy them into output list.
 *
 * Space complexity: \mathcal{O}(N)O(N). We are using O(N)O(N) space to maintain curr, and are modifying curr in-place with backtracking. Note that for space complexity analysis, we do not count space that is only used for the purpose of returning output, so the output array is ignored.
 */
public class Subsets {

    static List<List<Integer>> output = new ArrayList<>();
    static int n,k;

    public static void main(String args[]){
        int nums[] = {1,2,3};
        List<List<Integer>> subsets = subsets(nums);
        for(List<Integer> list:subsets){
            System.out.println(list);
        }
    }
    public static List<List<Integer>> subsets(int[] nums) {
        n = nums.length;
        for(k=0;k<n+1;k++){
            backtrack(0,new ArrayList<Integer>(),nums);
        }

        return output;
    }

    public static void backtrack(int first,ArrayList<Integer> curr,int nums[]){
        if(curr.size()==k){
            output.add(new ArrayList<>(curr));
            return;
        }

        for(int i=first;i<n;i++){
            curr.add(nums[i]);
            backtrack(i+1,curr,nums);
            curr.remove(curr.size()-1);
        }
    }
}
