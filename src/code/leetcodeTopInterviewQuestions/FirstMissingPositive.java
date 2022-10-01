package code.leetcodeTopInterviewQuestions;
//https://www.youtube.com/watch?v=9SnkdYXNIzM
//TC - O(N)
//SC - O(N)
public class FirstMissingPositive {

    public int firstMissingPositive(int[] nums) {

        if(nums==null || nums.length==0){
            return 1;
        }

        int lowest = 1;
        int highest = nums.length;
        boolean containsOne = false;

        for(int i=0;i<nums.length;i++){
            if(nums[i]==1){
                containsOne = true;
            }
            else if(nums[i]<lowest || nums[i]>highest){
                nums[i] = 1;
            }
        }

        if(containsOne==false){
            return 1;
        }

        for(int i=0;i<nums.length;i++){

            int index = Math.abs(nums[i])-1;
            if(nums[index]>0){
                nums[index] = -1*nums[index];
            }
        }

        for(int i=0;i<nums.length;i++){
            if(nums[i]>0){
                return i+1;
            }
        }

        return highest+1;
    }
}
