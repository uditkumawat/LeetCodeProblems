package code.leetcode.doordash;


//https://leetcode.com/problems/basic-calculator-ii/solution/
//TC - O(N)
//SC - O(1)
public class BasicCalculatorIIO1 {

    public static void main(String args[]){

        String str = "3+5/2";

        int curr = 0;
        int last = 0;
        char op = '+';
        int res = 0;

        for(int i=0;i<str.length();i++){

            if(isNumber(str.charAt(i))){
                int num = 0;
                while(i<str.length() && isNumber(str.charAt(i))){
                    num = num*10 + str.charAt(i)-'0';
                    i++;
                }
                curr = num;
                i--;
            }

            if(!isNumber(str.charAt(i)) && str.charAt(i)!=' ' || i==str.length()-1){

                if(op=='+'){
                    res+=last;
                    last = curr;
                }
                else if(op=='-'){
                    res+=last;
                    last = -curr;
                }
                else if(op=='*'){
                    last = last*curr;
                }
                else if(op=='/'){
                    last = last/curr;
                }
                op = str.charAt(i);
                curr = 0;
            }
        }

        res+=last;
        System.out.println(res);
    }

    public static boolean isNumber(char c){
        return c>='0' && c<='9';
    }
}
