package code.bloomberg;

import java.util.Random;

//https://www.youtube.com/watch?v=81z5a4StXHM
//TC - O(N)
public class ShuffleAnArray {

    int array[];
    int original[];
    Random rand;

    public ShuffleAnArray(int[] nums) {
        rand = new Random();
        array = nums;
        original = nums.clone();
    }

    public int[] reset() {
        array = original;
        original = original.clone();
        return original;
    }

    public int[] shuffle() {

        for(int i=0;i<array.length;i++){
            swapAt(i,randRange(i,array.length));
        }
        return array;
    }

    public int randRange(int min,int max){
        return rand.nextInt(max-min)+min;
    }

    public void swapAt(int i,int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
