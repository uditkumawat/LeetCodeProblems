package code.feb.challenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://leetcode.com/problems/combination-sum-ii/
//https://leetcode.com/problems/combination-sum-ii/discuss/16878/Combination-Sum-I-II-and-III-Java-solution-(see-the-similarities-yourself)
//TC - O(2^N)

/**
 * Let NN be the size of the input array.
 *
 * Time Complexity: \mathcal{O}(2^N)O(2
 * N
 *  )
 *
 * In the worst case, our algorithm will exhaust all possible combinations from the input array, which in total amounts to 2^N2
 * N
 *   as we discussed before.
 *
 * The sorting will take \mathcal{O}(N \log N)O(NlogN).
 *
 * To sum up, the overall time complexity of the algorithm is dominated by the backtracking process, which is \mathcal{O}(2^N)O(2
 * N
 *  ).
 *
 * Space Complexity: \mathcal{O}(N)O(N)
 *
 * We use the variable comb to keep track of the current combination we build, which requires \mathcal{O}(N)O(N) space.
 *
 * In addition, we apply recursion in the algorithm, which will incur additional memory consumption in the function call stack. In the worst case, the stack will pile up to \mathcal{O}(N)O(N) space.
 *
 * To sum up, the overall space complexity of the algorithm is \mathcal{O}(N) + \mathcal{O}(N) = \mathcal{O}(N)O(N)+O(N)=O(N).
 *
 * Note: we did not take into account the space needed to hold the final results of combination in the above analysis.
 */
public class CombinationSumII {

    public static void main(String args[]){

        int candidates[] = {10,1,2,7,6,1,5};
        int target = 8;

        CombinationSumII obj = new CombinationSumII();

        List<List<Integer>> res = obj.combinationSum2(candidates,target);

        for(List<Integer> list:res){
            System.out.println(list);
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {


        List<List<Integer>> res = new ArrayList<>();

        if(target==0){
            return res;
        }

        Arrays.sort(candidates);

        combinationSumUtil(candidates,target,res,new ArrayList<>(),0);

        return res;
    }

    public void combinationSumUtil(int candidates[],int target,List<List<Integer>> res,List<Integer> currList,int startIndex){

        if(target==0){
            res.add(new ArrayList<>(currList));
            return;
        }

        if(startIndex>=candidates.length || target<0){
            return;
        }

        for(int i=startIndex;i<candidates.length;i++){
            //skipping duplicates
            if(i>startIndex && candidates[i]==candidates[i-1]){
                continue;
            }
            currList.add(candidates[i]);
            combinationSumUtil(candidates,target-candidates[i],res,currList,i+1);
            currList.remove(currList.size()-1);
        }
    }
}
