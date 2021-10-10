package code.atlassian;

/**
 * https://leetcode.com/problems/lemonade-change/
 * At a lemonade stand, each lemonade costs $5. Customers are standing in a queue to buy from you, and order one at a time (in the order specified by bills). Each customer will only buy one lemonade and pay with either a $5, $10, or $20 bill. You must provide the correct change to each customer so that the net transaction is that the customer pays $5.
 *
 * Note that you don't have any change in hand at first.
 *
 * Given an integer array bills where bills[i] is the bill the ith customer pays, return true if you can provide every customer with correct change, or false otherwise.
 */
public class LemondeChange {

    public static void main(String args[]){

        LemondeChange obj = new LemondeChange();
        int bills[] = {10,10};

        System.out.println(obj.lemonadeChange(bills));
    }

    public boolean lemonadeChange(int[] bills) {

        if(bills==null || bills.length==0){
            return true;
        }

        int fiveCoins = 0;
        int tenCoins = 0;

        for(int amount:bills){
            if(amount==5){
                fiveCoins++;
            }
            else if(amount==10){
                if(fiveCoins>0){
                    tenCoins++;
                    fiveCoins--;
                }
                else{
                    return false;
                }
            }else if(amount==20){
                if(tenCoins>0 && fiveCoins>1){
                    tenCoins--;
                    fiveCoins--;
                }
                else if(fiveCoins>2){
                    fiveCoins-=3;
                }
                else{
                    return false;
                }
            }
        }

        return true;
    }
}
