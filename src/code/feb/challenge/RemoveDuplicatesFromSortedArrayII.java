package code.feb.challenge;

public class RemoveDuplicatesFromSortedArrayII {

    public static void main(String args[]){

        int nums[] = {1,1,1,2,2,3};

        RemoveDuplicatesFromSortedArrayII obj = new RemoveDuplicatesFromSortedArrayII();

        System.out.println(obj.removeDuplicates(nums));

    }
    public int removeDuplicates(int[] nums) {

        int wi = 0;
        int ri = 0;
        int counter = 0;

        for(;ri<nums.length-1;ri++){
            if(nums[ri]==nums[ri+1]){
                if(counter==2){
                    continue;
                }
                else{
                    nums[wi++] = nums[ri];
                    counter++;
                }
            }
            else{
                nums[wi++] = nums[ri];
                counter = 0;
            }
        }

        return wi;
    }
}
