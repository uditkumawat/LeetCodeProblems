package code.march.challenge;

//https://leetcode.com/problems/minimum-domino-rotations-for-equal-row/solution/
//TC - O(N)
//SC - O(1)
public class MinimumDominoRotationsForEqualRow {

    public int minDominoRotations(int[] tops, int[] bottoms) {

        int len = tops.length;

        int rotations = check(tops[0],tops,bottoms,len);

        if(rotations!=-1){
            return rotations;
        }

        return check(bottoms[0],tops,bottoms,len);
    }

    private int check(int x,int tops[],int bottoms[],int len){

        int swapTops = 0;
        int swapBottoms = 0;

        for(int i=0;i<len;i++){
            if(tops[i]!=x && bottoms[i]!=x){
                return -1;
            }
            else if(tops[i]==x && bottoms[i]!=x){
                swapBottoms++;
            }
            else if(tops[i]!=x && bottoms[i]==x){
                swapTops++;
            }
        }

        return Math.min(swapBottoms,swapTops);
    }
}
