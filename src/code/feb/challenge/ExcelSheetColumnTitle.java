package code.feb.challenge;

public class ExcelSheetColumnTitle {


    public static void main(String args[]){

        ExcelSheetColumnTitle obj = new ExcelSheetColumnTitle();
        System.out.println(obj.convertToTitle(1));
        System.out.println(obj.convertToTitle(28));
        System.out.println(obj.convertToTitle(701));
    }
    public String convertToTitle(int columnNumber) {

        StringBuilder sb = new StringBuilder();

        while(columnNumber!=0){
            columnNumber--;
            char c = (char)('A'+columnNumber%26);
            sb.append(c);
            columnNumber/=26;
        }

        return sb.reverse().toString();
    }
}
