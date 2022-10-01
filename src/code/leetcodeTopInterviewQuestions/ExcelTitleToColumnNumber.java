package code.leetcodeTopInterviewQuestions;

//https://www.geeksforgeeks.org/find-excel-column-number-column-title/
//TC-O(N)
//https://leetcode.com/problems/excel-sheet-column-number/solution/
public class ExcelTitleToColumnNumber {

    static int titleToNumber(String s)
    {
        // This process is similar to
        // binary-to-decimal conversion
        int result = 0;
        for (int i = 0; i < s.length(); i++)
        {
            result *= 26;
            result += s.charAt(i) - 'A' + 1;
        }
        return result;
    }

    // Driver Code
    public static void main (String[] args)
    {
        System.out.print(titleToNumber("CDA"));
    }
}
