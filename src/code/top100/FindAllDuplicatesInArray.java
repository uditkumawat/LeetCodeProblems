package code.top100;

import java.util.ArrayList;
import java.util.List;

public class FindAllDuplicatesInArray {

    public static void main(String args[]){

        FindAllDuplicatesInArray obj = new FindAllDuplicatesInArray();
        int arr[] = {1,1,2};

        List<Integer> list = obj.findDuplicates(arr);

        for(int i:list){
            System.out.print(i+" ");
        }
    }

    public List<Integer> findDuplicates(int[] nums) {

        List<Integer> res = new ArrayList<>();
        if(nums==null || nums.length==0){
            return res;
        }

        for(int num:nums){

            int index = Math.abs(num)-1;

            if(nums[index]<0){
                res.add(index+1);
            }
            else{
                nums[index] = -1*nums[index];
            }
        }

        return res;
    }
}
