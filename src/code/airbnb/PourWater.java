package code.airbnb;

/**
 *
 * //https://leetcode.com/problems/pour-water/
 *
 * You are given an elevation map represents as an integer array heights where heights[i] representing the height of the terrain at index i. The width at each index is 1. You are also given two integers volume and k. volume units of water will fall at index k.
 *
 * Water first drops at the index k and rests on top of the highest terrain or water at that index. Then, it flows according to the following rules:
 *
 * If the droplet would eventually fall by moving left, then move left.
 * Otherwise, if the droplet would eventually fall by moving right, then move right.
 * Otherwise, rise to its current position.
 * Here, "eventually fall" means that the droplet will eventually be at a lower level if it moves in that direction. Also, level means the height of the terrain plus any water in that column.
 *
 * We can assume there is infinitely high terrain on the two sides out of bounds of the array. Also, there could not be partial water being spread out evenly on more than one grid block, and each unit of water has to be in exactly one block.
 *
 * TC - O(N*V)
 */
public class PourWater {

    public static void main(String args[]){

        PourWater obj = new PourWater();
        int heights[] = {3,1,3};
        int volume = 5;
        int k = 1;

        int output[] = obj.pourWater(heights,volume,k);

        for(int height:output){
            System.out.print(height+" ");
        }
    }
    public int[] pourWater(int[] heights, int volume, int k) {

        int left = 0;
        int right = 0;

        while(volume>0){
            volume--;

            left = k;

            while(left>0 && heights[left]>=heights[left-1]){
                left--;
            }

            if(heights[left]<heights[k]){
                heights[left]++;
                continue;
            }

            right = k;

            while(right<heights.length-1 && heights[right+1]<=heights[right]){
                right++;
            }

            if(heights[right]<heights[k]){
                heights[right]++;
            }
            else{
                heights[k]++;
            }

        }
        return heights;
    }
}
