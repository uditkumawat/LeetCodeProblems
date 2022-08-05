package code.feb.challenge;

//https://leetcode.com/problems/majority-element/
//boore voting algo
//https://www.youtube.com/watch?v=AoX3BPWNnoE
//TC-O(N)
//SC-O(1)
public class MajorityElement {

    public static void main(String args[]){

        int nums[] = {7,7,5,7,5,1,5,7,5,5,7,7,5,5,5,5};

        MajorityElement obj = new MajorityElement();

        System.out.println(obj.majorityElement(nums));
    }

    public int majorityElement(int[] nums) {

        if(nums==null || nums.length==0){
            return 0;
        }

        int count = 0;
        int curr = 0;

        for(int i=0;i<nums.length;i++){
            if(count==0){
                curr = nums[i];
            }
            if(nums[i]==curr){
                count++;
            }
            else{
                count--;
            }
        }

        return curr;
    }
}
