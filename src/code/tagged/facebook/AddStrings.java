package code.tagged.facebook;

//https://leetcode.com/problems/add-strings/solution/
//TC - O(Max(N1,N2)) -> N! and N2 are lengths of num1 and num2
//SC - O(Max(N1,N2))+1 -> 1 for carry
public class AddStrings {

    public static void main(String args[]){

        AddStrings obj = new AddStrings();

        System.out.println(obj.addStrings("11","123"));
        System.out.println(obj.addStrings("456","77"));
        System.out.println(obj.addStrings("0","0"));

    }
    public String addStrings(String num1, String num2) {

        if(num1==null && num2==null){
            return null;
        }

        if(num1==null && num2!=null){
            return num2;
        }

        if(num1!=null && num2==null){
            return num1;
        }

        StringBuilder sb = new StringBuilder();

        int i = num1.length()-1;
        int j = num2.length()-1;
        int carry = 0;
        int sum = 0;

        while(i>=0 || j>=0)
        {
            int a = i>=0?num1.charAt(i--)-'0':0;
            int b = j>=0?num2.charAt(j--)-'0':0;

            sum = a + b + carry;
            carry = sum/10;

            sb.append(sum%10);
        }

        if(carry>0){
            sb.append(carry);
        }

        return sb.reverse().toString();

    }
}
