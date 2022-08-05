package code.feb.challenge;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {

    public static void main(String args[]){

        int arr[] = {0,2,4,5,7};

        SummaryRanges obj = new SummaryRanges();

        List<String> res = obj.summaryRanges(arr);

        for(String s:res){
            System.out.println(s);
        }
    }
    public List<String> summaryRanges(int[] nums) {
        List<String> summary = new ArrayList<>();
        for (int i = 0, j = 0; j < nums.length; ++j) {
            // check if j + 1 extends the range [nums[i], nums[j]]
            if (j + 1 < nums.length && nums[j + 1] == nums[j] + 1)
                continue;
            // put the range [nums[i], nums[j]] into the list
            if (i == j)
                summary.add(nums[i] + "");
            else
                summary.add(nums[i] + "->" + nums[j]);
            i = j + 1;
        }
        return summary;
    }
}
