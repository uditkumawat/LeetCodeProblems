package code.feb.challenge;

//https://www.youtube.com/watch?v=QRbJZOd3ZN0&t=2s

public class SingleNumberIII {

    public static void main(String args[]){

        int nums[] = {1,2,3,2,1,5};

        SingleNumberIII obj = new SingleNumberIII();

        int ans[] = obj.getSingleNumber(nums);

        System.out.print(ans[0]+" "+ans[1]);

    }

    public int[] getSingleNumber(int nums[]){

        int xor = 0;
        for(int num:nums){
            xor^=num;
        }

        int i = 0;
        int temp = xor;
        while(temp!=0){
            if((1&temp)==1){
                break;
            }
            i++;
            temp>>=1;
        }

        int numLowestBitSet = (int)Math.pow(2,i);

        int ans[] = new int[2];
        for(int num:nums){
            //column where the bit in unset
            if((numLowestBitSet & num)==0){
                ans[0]^=num;
            }
            else{
                ans[1]^=num;
            }
        }

        return ans;
    }
}
