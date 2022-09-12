package code.salesforce;

//https://www.geeksforgeeks.org/split-array-three-equal-sum-subarrays/
public class SplitArrayThreeEqualSum {

    public int verifyThreeEqualSumSubArrayExists(int nums[]){

        int ind1 = -1;
        int ind2 = -1;
        int sum = 0;

        for(int i=0;i<nums.length;i++){
            sum = sum + nums[i];
        }

        //not able to divide into three parts
        if(sum%3!=0){
            return 0;
        }

        int s1 = sum/3;
        int s2 = 2*s1;

        int prefixSum = 0;

        for(int i=0;i<nums.length;i++){
            prefixSum = prefixSum + nums[i];

            if(prefixSum==s1 && ind1==-1){
                ind1 = i;
            }
            else if(prefixSum==s2 && ind1!=-1){
                ind2 = i;
                break;
            }
        }

        System.out.println("Found indices "+ind1+" "+ind2);
        return 0;
    }
}
