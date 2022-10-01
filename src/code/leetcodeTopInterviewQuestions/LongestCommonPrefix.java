package code.leetcodeTopInterviewQuestions;

//https://leetcode.com/problems/longest-common-prefix/solution/
//Time complexity : O(S) , where S is the sum of all characters in all strings.
public class LongestCommonPrefix {

    public static void main(String args[]){

        String str[] = {"leety","leetcode","leetcccooddee"};

        LongestCommonPrefix obj = new LongestCommonPrefix();

        System.out.println(obj.longestCommonPrefix(str));
    }
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        String pre = strs[0];
        for (int i = 1; i < strs.length; i++) {
           // System.out.println(strs[i] + " " + pre + " " + strs[i].indexOf(pre));
            while (strs[i].indexOf(pre) != 0)
                pre = pre.substring(0, pre.length() - 1);
        }
        return pre;
    }
}
