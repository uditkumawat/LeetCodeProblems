package code.google;

public class ReplaceDigits {

    public static void main(String args[]){

        ReplaceDigits obj = new ReplaceDigits();

        String s = "a1c1e1";

        System.out.println(obj.replaceDigits(s));
    }

    public String replaceDigits(String s) {

        if(s==null || s.length()==0){
            return s;
        }

        StringBuilder str = new StringBuilder();

        for(int i=1;i<s.length();i=i+2){
            str.append(s.charAt(i-1));
            str.append((char)(s.charAt(i-1)+s.charAt(i)-'0'));
        }

        return str.toString();
    }
}
