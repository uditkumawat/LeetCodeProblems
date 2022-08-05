package code.bloomberg;

import java.util.Deque;
import java.util.LinkedList;

//https://leetcode.com/problems/jump-game-vi/submissions/
//TC - O(N)
//SC - O(N)
public class JumpGameVI {

    public int maxResult(int[] nums, int k) {

        int n = nums.length;
        int score[] = new int[n];

        score[0] = nums[0];
        Deque<Integer> dq = new LinkedList<>();
        dq.offerLast(0);

        for(int i=1;i<n;i++){

            while(!dq.isEmpty() && dq.peekFirst()<i-k){
                dq.pollFirst();
            }

            score[i] = score[dq.peek()] + nums[i];

            while(!dq.isEmpty() && score[i]>=score[dq.peekLast()]){
                dq.pollLast();
            }

            dq.offerLast(i);
        }

        return score[n-1];
    }
}
