package code.top100;

public class ExcelSheetNumber {

    public static void main(String args[]){

        String s = "FXSHRXW";
        System.out.println(titleToNumber(s));
    }

    public static int titleToNumber(String columnTitle) {

        int num = 0;

        int power = 0;
        for(int i=columnTitle.length()-1;i>=0;i--){
            num = num + (columnTitle.charAt(i)-'A'+1)*(int)Math.pow(26,power);
            power++;
        }

        return num;
    }
}
