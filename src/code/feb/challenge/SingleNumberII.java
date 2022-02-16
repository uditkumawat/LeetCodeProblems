package code.feb.challenge;

//https://www.youtube.com/watch?v=cOFAmaMBVps
//https://leetcode.com/problems/single-number-ii/
public class SingleNumberII {

    public static void main(String args[]){

        int arr[] = {2,2,2,4,4,4,3};

        SingleNumberII obj = new SingleNumberII();

        System.out.println(obj.getSingleNumber(arr));

    }

    public int getSingleNumber(int nums[]){

        int ones = 0;
        int twos = 0;

        for(int num:nums){
            ones = ~twos & (num ^ ones);
            twos = ~ones & (num ^ twos);
        }
        return ones;
    }
}
