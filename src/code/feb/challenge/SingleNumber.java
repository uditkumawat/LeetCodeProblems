package code.feb.challenge;

public class SingleNumber {

    public static void main(String args[]){

        int nums[] = {4,1,2,1,2};

        SingleNumber obj = new SingleNumber();

        System.out.println(obj.singleNumber(nums));

    }
    public int singleNumber(int[] nums) {
        if(nums==null || nums.length==0){
            return 0;
        }

        int xor = 0;

        for(int num:nums){
            xor^=num;
        }

        return xor;
    }
}
