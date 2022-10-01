package code.leetcodeTopInterviewQuestions;

import java.util.Arrays;

//https://leetcode.com/problems/boats-to-save-people/solution/
//TC-O(nlogn)
public class BoatsTOSavePeople {

    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int i = 0, j = people.length - 1;
        int ans = 0;

        while (i <= j) {
            ans++;
            if (people[i] + people[j] <= limit)
                i++;
            j--;
        }

        return ans;
    }
}
