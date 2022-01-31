package code.google;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//TC - O(n^2)
public class ThreeSum {

    public static void main(String args[]){

        int arr[] = {-1,0,1,2,-1,-4};

        ThreeSum obj = new ThreeSum();

        List<List<Integer>> res = obj.threeSum(arr);

        for(List<Integer> list:res){
            System.out.println(list);
        }
    }
    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
        if(nums==null || nums.length<3){
            return new ArrayList<>();
        }

        Arrays.sort(nums);
        for(int i=0;i<nums.length-2;i++){

            if(i==0 || (i>0 && nums[i]!=nums[i-1])) {

                int j = i + 1;
                int k = nums.length - 1;
                int target = 0 - nums[i];

                while (j < k) {

                    int sum = nums[j] + nums[k];
                    if (sum == target) {
                        res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                        while (j < k && nums[j] == nums[j + 1]) {
                            j++;
                        }
                        while (j < k && nums[k] == nums[k - 1]) {
                            k--;
                        }
                        j++;
                        k--;
                    } else if (sum > target) {
                        k--;
                    } else {
                        j++;
                    }
                }
            }
        }

        return res;
    }
}
