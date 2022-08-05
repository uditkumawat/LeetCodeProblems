package code.arcesium;

import java.util.Arrays;

//https://leetcode.com/problems/boats-to-save-people/solution/
//TC - O(nlogn)
public class BoatsToSavePeople {

    public int numRescueBoats(int[] people, int limit) {

        Arrays.sort(people);
        int left = 0;
        int right = people.length-1;

        int ans = 0;

        while(left<=right){
            ans++;
            if(people[left]+people[right]<=limit){
                left++;
            }
            right--;
        }

        return ans;
    }
}
