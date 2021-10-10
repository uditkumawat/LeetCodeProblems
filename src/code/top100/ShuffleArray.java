package code.top100;

import java.util.Random;

public class ShuffleArray {

    public int array[];
    public int original[];
    Random rand;

    public ShuffleArray(int[] nums) {
        rand = new Random();
        array = nums;
        original = nums.clone();
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        array = original;
        original = original.clone();
        return original;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        for(int i=0;i<array.length;i++){
            swap(i,randIndex(i,array.length));
        }
        return array;
    }

    public void swap(int i,int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public int randIndex(int min,int max){
        return rand.nextInt(max-min)+min;
    }
}
