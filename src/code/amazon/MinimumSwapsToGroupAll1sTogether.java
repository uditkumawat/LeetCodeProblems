package code.amazon;

//https://leetcode.com/problems/minimum-swaps-to-group-all-1s-together/solution/
//TC - O(N)
//SC - O(1)
public class MinimumSwapsToGroupAll1sTogether {

    public int minSwaps(int[] data) {

        if(data==null || data.length==0){
            return 0;
        }

        int ones = 0;

        for(int num:data){
            if(num==1){
                ones++;
            }
        }

        int right = 0;
        int left = 0;
        int cntOnes = 0;
        int maxOne = 0;

        while(right<data.length){

            cntOnes+=data[right];
            right++;

            if(right-left>ones){
                cntOnes = cntOnes - data[left];
                left++;
            }

            maxOne = Math.max(cntOnes,maxOne);
        }

        return ones-maxOne;

    }
}
