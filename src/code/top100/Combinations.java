package code.top100;

import java.util.LinkedList;
import java.util.List;

public class Combinations {

    class Solution {

        List<List<Integer>> output;
        int n;
        int k;


        public List<List<Integer>> combine(int n, int k) {
            this.n = n;
            this.k = k;
            backtrack(1,new LinkedList<Integer>());
            return output;
        }

        public void backtrack(int first,LinkedList<Integer> curr){
            if(curr.size()==k){
                output.add(new LinkedList<>(curr));
                return;
            }

            for(int i=first;i<=n;i++){
                curr.add(i);

                backtrack(i+1,curr);

                curr.removeLast();
            }
        }
    }
}
