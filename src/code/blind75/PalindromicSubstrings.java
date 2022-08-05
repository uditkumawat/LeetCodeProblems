package code.blind75;

//https://leetcode.com/problems/palindromic-substrings/submissions/
//TC - O(N^2)

/**
 * Time Complexity: O(N^2)O(N
 * 2
 *  ) for input string of length NN. The total time taken in this approach is dictated by two variables:
 *
 * The number of possible palindromic centers we process.
 * How much time we spend processing each center.
 * The number of possible palindromic centers is 2N-12N−1: there are NN single character centers and N-1N−1 consecutive character pairs as centers.
 *
 * Each center can potentially expand to the length of the string, so time spent on each center is linear on average. Thus total time spent is N \cdot (2N-1) \simeq N^2N⋅(2N−1)≃N
 * 2
 *  .
 *
 * Space Complexity: O(1)O(1). We don't need to allocate any extra space since we are repeatedly iterating on the input string itself.
 */
public class PalindromicSubstrings {

    public int countSubstrings(String s) {

        int ans = 0;

        for(int i=0;i<s.length();i++){

            ans+=countPalindromeAroundCenter(s,i,i);
            ans+=countPalindromeAroundCenter(s,i,i+1);

        }

        return ans;
    }

    public int countPalindromeAroundCenter(String s,int start,int end){

        int count = 0;

        while(start>=0 && end<s.length()){

            if(s.charAt(start)!=s.charAt(end)){
                break;
            }

            start--;
            end++;
            count++;
        }

        return count;
    }
}
