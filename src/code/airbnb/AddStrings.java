package code.airbnb;

public class AddStrings {

    public static void main(String args[]){

        String num1="456",num2="77";

        AddStrings obj = new AddStrings();

        System.out.println(obj.addStrings(num1,num2));

    }

    public String addStrings(String num1, String num2) {

        int l1 = num1.length()-1;
        int l2 = num2.length()-1;

        StringBuilder resNum = new StringBuilder();
        int sum = 0;
        int carry = 0;
        int d1 = 0;
        int d2 = 0;
        while(l1>=0 || l2>=0){

            d1 = l1>=0?num1.charAt(l1)-'0':0;
            d2 = l2>=0?num2.charAt(l2)-'0':0;

            sum = (d1+d2+carry)%10;
            carry = (d1+d2+carry)/10;

            resNum.append(sum);

            l1--;
            l2--;
        }

        return resNum.reverse().toString();
    }
}
