package code.september2022.challenge;

import java.util.Arrays;

//https://leetcode.com/problems/the-number-of-weak-characters-in-the-game/submissions/
//TC - O(nlogn)
//https://leetcode.com/problems/the-number-of-weak-characters-in-the-game/discuss/1445242/Java-Solution-or-Use-only-Sorting-and-one-max-mark
public class NumberOfWeakCharacters {

    public int numberOfWeakCharacters(int[][] properties) {

        if(properties==null || properties.length==0){
            return 0;
        }

        int ans = 0;
        int maxDefence = 0;

        Arrays.sort(properties,(int properties1[], int properties2[])->{
            return properties1[0]==properties2[0]?properties1[1]-properties2[1]:
                    properties2[0]-properties1[0];
        });

        for(int property[]:properties){
            if(property[1]<maxDefence){
                ans++;
            }
            maxDefence = Math.max(maxDefence,property[1]);
        }

        return ans;
    }
}
