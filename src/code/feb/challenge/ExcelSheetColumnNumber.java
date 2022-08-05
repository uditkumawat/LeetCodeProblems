package code.feb.challenge;

//https://leetcode.com/problems/excel-sheet-column-number/solution/
//TC - O(N)
//SC - O(1)
public class ExcelSheetColumnNumber {

    public static void main(String args[]){

        ExcelSheetColumnNumber obj = new ExcelSheetColumnNumber();
        System.out.println(obj.titleToNumber("A"));
        System.out.println(obj.titleToNumber("AB"));
        System.out.println(obj.titleToNumber("ZY"));
    }
    public int titleToNumber(String columnTitle) {

        int res = 0;

        for(char c : columnTitle.toCharArray()){
            res = res*26 + c-'A'+1;
        }

        return res;
    }
}
