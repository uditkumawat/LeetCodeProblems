package code.top100;

public class Duplicate {

    public int findDuplicate(int[] nums) {
        int duplicate = -1;

        for(int i=0;i<nums.length;i++){
            int index = Math.abs(nums[i]);
            if(nums[index]<0){
                duplicate = index;
                break;
            }
            nums[index] = -1*nums[index];
        }

        for(int i=0;i<nums.length;i++){
            nums[i] = Math.abs(nums[i]);
        }

        return duplicate;
    }
}
