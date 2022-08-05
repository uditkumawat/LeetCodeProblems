package code.amazon;

//https://leetcode.com/problems/range-addition-ii/solution/
//TC - O(M*N)
//https://www.youtube.com/watch?v=68VmQaocWkQ
public class RangeAdditionII {

    public int maxCount(int m, int n, int[][] ops) {

        for(int op[]:ops){
            m = Math.min(m,op[0]);
            n = Math.min(n,op[1]);
        }

        return m*n;
    }
}
