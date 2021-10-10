package code.leetcode.doordash;

import java.util.HashSet;
import java.util.Set;

//https://leetcode.com/discuss/interview-question/846916/Validate-Orders-Path-(Doordash)
public class ValidateOrdersPath {

    public static void main(String args[]){

        String str[][] = {{"P1","P2","D1","D2"},
                {"P1","D1","P2","D2"},
                {"P1","D2","D1","P2"},
                {"P1","D2"},
                {"P1","P2"},
                {"P1","D1","D1"},
                {},
                {"P1","P1","D1"},
                {"P1","P1","D1","D1"},
                {"P1","D1","P1"},
                {"P1","D1","P1","D1"}};

        for(int i=0;i<str.length;i++) {
            for(int j=0;j<str[i].length;j++) {
                System.out.print(str[i][j] + " ");
            }
            System.out.println(isValidOrder(str[i]));
        }
    }

    public static boolean isValidOrder(String strs[]){

        Set<Integer> picked = new HashSet<>();
        Set<Integer> delivered = new HashSet<>();

        for(String str:strs){

            char orderType = str.charAt(0);
            int orderNumber = Integer.parseInt(str.substring(1));

            if(orderType=='P'){
                if(picked.contains(orderNumber)){
                    return false;
                }
                picked.add(orderNumber);
            }
            else if(orderType=='D'){
                if(delivered.contains(orderNumber) || !picked.contains(orderNumber)){
                    return false;
                }
                delivered.add(orderNumber);
            }
            else{
                return false;
            }
        }

        //this is important, number of picked orders should be equal to delivered
        // like test case - P1 D1 P2 P3
        return picked.size()==delivered.size();
    }
}
