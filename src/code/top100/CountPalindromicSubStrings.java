package code.top100;

//TC - O(N^2)
//Sc- O(1)

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
public class CountPalindromicSubStrings {

    public int countSubstrings(String s) {
        int ans = 0;

        for (int i = 0; i < s.length(); ++i) {
            // odd-length palindromes, single character center
            ans += countPalindromesAroundCenter(s, i, i);

            // even-length palindromes, consecutive characters center
            ans += countPalindromesAroundCenter(s, i, i + 1);
        }

        return ans;
    }

    private int countPalindromesAroundCenter(String ss, int lo, int hi) {
        int ans = 0;

        while (lo >= 0 && hi < ss.length()) {
            if (ss.charAt(lo) != ss.charAt(hi))
                break;      // the first and last characters don't match!

            // expand around the center
            lo--;
            hi++;

            ans++;
        }

        return ans;
    }
}
