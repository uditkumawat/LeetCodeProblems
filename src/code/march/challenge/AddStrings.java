package code.march.challenge;

//https://leetcode.com/problems/add-strings/
//TC - O(max(m,n))
//SC - O(max(m,n)+1)
public class AddStrings {

    public static void main(String args[]){

        String s1 = "11";
        String s2 = "123";

        AddStrings obj = new AddStrings();

        System.out.println(obj.addStrings(s1,s2));
    }
    public String addStrings(String num1, String num2) {

        if(num1==null && num2==null){
            return null;
        }

        if(num1==null){
            return num2;
        }

        if(num2==null){
            return num1;
        }

        StringBuilder sb = new StringBuilder();

        int i = num1.length()-1;
        int j = num2.length()-1;

        int sum = 0;
        int carry = 0;

        while(i>=0 || j>=0){

            int a = i>=0 ? num1.charAt(i)-'0':0;
            int b = j>=0 ? num2.charAt(j)-'0':0;

            sum = a+b+carry;
            carry = sum / 10;

            sb.append(sum%10);

            i--;
            j--;

        }

        if(carry>0){
            sb.append(carry);
        }

        return sb.reverse().toString();
    }
}
