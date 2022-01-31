package code.linkedin;

/**
 * https://leetcode.com/problems/nested-list-weight-sum/
 * You are given a nested list of integers nestedList. Each element is either an integer or a list whose elements may also be integers or other lists.
 *
 * The depth of an integer is the number of lists that it is inside of. For example, the nested list [1,[2,2],[[3],2],1] has each integer's value set to its depth.
 *
 * Return the sum of each integer in nestedList multiplied by its depth.
 */

/**
 * Complexity Analysis
 *
 * Let NN be the total number of nested elements in the input list. For example, the list [ [[[[1]]]], 2 ] contains 44 nested lists and 22 nested integers (11 and 22), so N = 6N=6 for that particular case.
 *
 * Time complexity : \mathcal{O}(N)O(N).
 *
 * Recursive functions can be a bit tricky to analyze, particularly when their implementation includes a loop. A good strategy is to start by determining how many times the recursive function is called, and then how many times the loop will iterate across all calls to the recursive function.
 *
 * The recursive function, dfs(...) is called exactly once for each nested list. As NN also includes nested integers, we know that the number of recursive calls has to be less than NN.
 *
 * On each nested list, it iterates over all of the nested elements directly inside that list (in other words, not nested further). As each nested element can only be directly inside one list, we know that there must only be one loop iteration for each nested element. This is a total of NN loop iterations.
 *
 * So combined, we are performing at most 2 \cdot N2⋅N recursive calls and loop iterations. We drop the 22 as it is a constant, leaving us with time complexity \mathcal{O}(N)O(N).
 *
 * Space complexity : \mathcal{O}(N)O(N).
 *
 * In terms of space, at most O(D)O(D) recursive calls are placed on the stack, where DD is the maximum level of nesting in the input. For example, D=2D=2 for the input [[1,1],2,[1,1]], and D=3D=3 for the input [1,[4,[6]]].
 *
 * In the worst case, D = ND=N, (e.g. the list [[[[[[]]]]]]) so the worst-case space complexity is O(N)O(N).
 */
public class NestedListWeightedSum {

    /*
    public int depthSum(List<NestedInteger> nestedList) {

        if(nestedList==null || nestedList.size()==0){
            return 0;
        }

        return getSum(nestedList,1);
    }

    public int getSum(List<NestedInteger> nestedList,int depth){
        int sum = 0;

        for(NestedInteger ne:nestedList){
            if(ne.isInteger()){
                sum+=ne.getInteger()*depth;
            }
            else{
                sum+=getSum(ne.getList(),depth+1);
            }
        }

        return sum;
    } */
}
