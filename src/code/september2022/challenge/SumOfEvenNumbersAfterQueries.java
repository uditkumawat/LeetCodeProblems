package code.september2022.challenge;

public class SumOfEvenNumbersAfterQueries {

    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {

        if(nums==null || nums.length==0){
            return new int[0];
        }

        int sumOdd = 0;
        int sumEven = 0;

        for(int i=0;i<nums.length;i++){
            if(nums[i]%2==0){
                sumEven+=nums[i];
            }
            else{
                sumOdd+=nums[i];
            }
        }

        int n = queries.length;
        int res[] = new int[n];

        for(int i=0;i<n;i++){

            int val = queries[i][0];
            int index = queries[i][1];

            int oldValue = nums[index];
            int newValue = oldValue+val;

            nums[index] = newValue;

            if(oldValue%2==0){
                sumEven-=oldValue;
            }
            else{
                sumOdd-=oldValue;
            }

            if(newValue%2==0){
                sumEven+=newValue;
            }
            else{
                sumOdd+=newValue;
            }

            res[i] = sumEven;
        }

        return res;
    }
}
