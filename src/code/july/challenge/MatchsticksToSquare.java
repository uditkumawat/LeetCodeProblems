package code.july.challenge;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

//https://leetcode.com/problems/matchsticks-to-square/submissions/
//https://www.youtube.com/watch?v=w-R8qAtsP1A
public class MatchsticksToSquare {

    public List<Integer> nums;
    public int[] sums;
    public int possibleSquareSide;

    public MatchsticksToSquare() {
        this.sums = new int[4];
    }

    public boolean makesquare(int[] matchsticks) {

        if(matchsticks==null || matchsticks.length==0){
            return false;
        }

        int perimeter = 0;
        for(int num:matchsticks){
            perimeter+=num;
        }

        this.possibleSquareSide = perimeter/4;

        if(this.possibleSquareSide*4!=perimeter){
            return false;
        }

        this.nums = Arrays.stream(matchsticks).boxed().collect(Collectors.toList());
        Collections.sort(this.nums, Collections.reverseOrder());

        return this.dfs(0);
    }

    public boolean dfs(int index){

        if (index == this.nums.size()) {
            return sums[0] == sums[1] && sums[1] == sums[2] && sums[2] == sums[3];
        }

        // Get current matchstick.
        int element = this.nums.get(index);

        // Try adding it to each of the 4 sides (if possible)
        for(int i = 0; i < 4; i++) {
            if (this.sums[i] + element <= this.possibleSquareSide) {
                this.sums[i] += element;
                if (this.dfs(index + 1)) {
                    return true;
                }
                this.sums[i] -= element;
            }
        }

        return false;
    }
}
