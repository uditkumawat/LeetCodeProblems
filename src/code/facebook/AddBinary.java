package code.facebook;

public class AddBinary {

    public static void main(String args[]){

        String a = "11";
        String b = "1";

        AddBinary obj = new AddBinary();

        System.out.println(obj.addBinary(a,b));
    }
    public String addBinary(String a, String b) {

        String ans = "";

        int i=a.length()-1;
        int j=b.length()-1;
        int sum = 0;
        int carry = 0;

        while(i>=0 || j>=0){
            int x = (i>=0)?a.charAt(i)-'0':0;
            int y = (j>=0)?b.charAt(j)-'0':0;

            sum = x+y+carry;
            carry = sum/2;

            ans = sum%2+ans;

            i--;
            j--;
        }

        if(carry>0){
            ans = carry + ans;
        }

        return ans;
    }
}
