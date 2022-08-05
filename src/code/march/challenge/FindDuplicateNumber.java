package code.march.challenge;

//https://leetcode.com/problems/find-the-duplicate-number/solution/
//https://www.youtube.com/watch?v=7jODYhS2ztg
public class FindDuplicateNumber {

    public static void main(String args[]){

        int nums[] = {1,3,2,4,3};

        FindDuplicateNumber obj = new FindDuplicateNumber();

        System.out.println(obj.findDuplicate(nums));

    }
    public int findDuplicate(int[] nums) {

        if(nums==null || nums.length==0){
            return 0;
        }

        int dup = -1;

        for(int i=0;i<nums.length;i++){

            int index = Math.abs(nums[i]);
            if(nums[index]<0){
                dup = index;
                break;
            }
            else{
                nums[index] = -nums[index];
            }
        }

        for(int i=0;i<nums.length;i++){
            nums[i] = Math.abs(nums[i]);
        }

        return dup;
    }

    public int findDuplicateNumber(int nums[]){

        int slow = nums[0];
        int fast = nums[0];

        do{
            slow = nums[slow];
            fast = nums[nums[fast]];
        }while(slow!=fast);

        slow = nums[0];

        while(slow!=fast){
            fast = nums[fast];
            slow = nums[slow];
        }

        return slow;
    }
}
