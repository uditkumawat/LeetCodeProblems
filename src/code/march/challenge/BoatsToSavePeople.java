package code.march.challenge;

import java.util.Arrays;

/**
 * We simply maintain 2 pointers start and end. If people[start] + people[end] <= limit meaning both start and end can put in the same boat, hence we increament start and decrement end. If people[start] + people[end] > limit meaning only end can be on the boad, hence we decrement end and keep start.
 */
public class BoatsToSavePeople {

    public static void main(String args[]){

        int people[] = {3,2,2,1};
        int limit = 3;

        BoatsToSavePeople obj = new BoatsToSavePeople();

        System.out.println(obj.numRescueBoats(people,limit));

    }
    public int numRescueBoats(int[] people, int limit) {

        int ans = 0;

        Arrays.sort(people);
        int left = 0;
        int right = people.length-1;

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
