package code.salesforce;

//https://leetcode.com/problems/shortest-word-distance/solution/
//TC - O(N⋅M) where NN is the number of words in the input list, and MM is the total length of two input words.
public class ShortestDistance {

    public int shortestDistance(String[] words, String word1, String word2) {
        int i1 = -1, i2 = -1;
        int minDistance = words.length;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                i1 = i;
            } else if (words[i].equals(word2)) {
                i2 = i;
            }

            if (i1 != -1 && i2 != -1) {
                minDistance = Math.min(minDistance, Math.abs(i1 - i2));
            }
        }
        return minDistance;
    }
}
