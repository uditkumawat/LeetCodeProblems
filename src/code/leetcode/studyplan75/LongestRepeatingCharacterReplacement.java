package code.leetcode.studyplan75;

//https://leetcode.com/problems/longest-repeating-character-replacement/submissions/
//TC - O(N)
//https://www.youtube.com/watch?v=00FmUN1pkGE
public class LongestRepeatingCharacterReplacement {

    public int characterReplacement(String s, int k) {

        int len = s.length();
        int window_start = 0;
        int maxCount = 0;
        int count[] = new int[26];
        int maxLength = 0;

        for(int window_end=0;window_end<len;window_end++){

            count[s.charAt(window_end)-'A']++;

            int currentCount = count[s.charAt(window_end)-'A'];

            maxCount = Math.max(maxCount,currentCount);

            while(window_end-window_start-maxCount+1>k){

                count[s.charAt(window_start)-'A']--;
                window_start++;
            }

            maxLength = Math.max(maxLength,window_end-window_start+1);
        }

        return maxLength;
    }
}
