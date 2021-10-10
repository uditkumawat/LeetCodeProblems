package code.microsoft;

/**
 * There is a function signFunc(x) that returns:
 *
 * 1 if x is positive.
 * -1 if x is negative.
 * 0 if x is equal to 0.
 * You are given an integer array nums. Let product be the product of all values in the array nums.
 *
 * Return signFunc(product).
 */
public class SignOfProductOfArray {

    public static void main(String args[]){

        SignOfProductOfArray obj = new SignOfProductOfArray();
        int nums[] = {-1,1,-1,1,-1};
        System.out.println(obj.arraySign(nums));

    }
    public int arraySign(int[] nums) {

        int negativeCount = 0;
        boolean hasZero = false;

        for(int num:nums){
            if(num==0){
                hasZero = true;
                break;
            }
            if(num<0){
                negativeCount++;
            }
        }

        if(hasZero){
            return 0;
        }
        else{
            if(negativeCount%2==1){
                return -1;
            }
            else{
                return 1;
            }
        }
    }
}
