package code.amazon;

//https://leetcode.com/problems/range-addition/
//TC - O(N)
//SC - O(1)
public class RangeAddition {

    public static void main(String args[]){

        int length = 10;
        int updates[][] = {{2,4,6},{5,6,8},{1,9,-4}};

        RangeAddition obj = new RangeAddition();

        int res[] = obj.addition(length,updates);

        for(int num:res){
            System.out.print(num+" ");
        }
    }
    public int[] addition(int length,int updates[][]){

        int res[] = new int[length];

        for(int i=0;i<updates.length;i++){

            int update[] = updates[i];

            int startIndex = update[0];
            int endIndex = update[1];
            int val = update[2];

            res[startIndex]+=val;

            if(endIndex<length-1){
                res[endIndex+1] = res[endIndex+1]-val;
            }
        }

        for(int i=1;i<res.length;i++){
            res[i] = res[i-1]+res[i];
        }

        return res;
    }

}
