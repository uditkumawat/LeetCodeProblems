package code.google;

//https://leetcode.com/problems/longest-absolute-file-path/submissions/814989016/
//TC - O(N)
public class LongestAbsoluteFilePath {

    public int lengthLongestPath(String input) {
        if (input == null || input.length() == 0) {
            return 0;
        }

        String[] ar = input.split("\n");
        int maxLength = 0;
        int[] count = new int[10000];

        for (String s : ar) {
            int tabIndex = s.lastIndexOf("\t");
            count[tabIndex + 1] = s.substring(tabIndex + 1).length();  // length of the word at current line, but exclude \t

            if (s.lastIndexOf(".") != -1) {   // If we found a file
                int length = 0;
                for (int i = 0; i <= tabIndex + 1; i++) {  // count length from root until current index in count
                    length += count[i];
                    length++;   // add 1 for forward slash
                }
                length--;   // subtract 1 for final slash

                maxLength = Math.max(length, maxLength);
            }
        }

        return maxLength;
    }
}
