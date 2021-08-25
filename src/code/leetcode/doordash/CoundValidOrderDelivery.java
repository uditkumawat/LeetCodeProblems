package code.leetcode.doordash;

//1359. Count All Valid Pickup and Delivery Options
//https://leetcode.com/problems/count-all-valid-pickup-and-delivery-options/discuss/516968/JavaC%2B%2BPython-Easy-and-Concise

/**
 * Analysis
 *
 * Assume there were n-1 pairs Pickup and Delivery. Now we need insert the nth pair P&D.
 *
 * For there were 2*(n-1) services, so we have 2*(n-1)+1 choices for the Pickup.
 *
 * And now there were 2*n-1 services, so we hava 2*n choices for the Delivery.
 *
 * Now, the total choices is 2*n*(2*n-1).
 *
 * Because that delivery(i) is always after of pickup(i), so we need divide 2.
 *
 * And for every P&D inserting, we wil hava n*(2*n - 1) choices.
 */
public class CoundValidOrderDelivery {

    public int countOrders(int n) {
        long res = 1;
        long mod = 1000000007;
        for (int i = 1; i <= n; i++) {
            res = res * (2 * i - 1) * i % mod;
        }
        return (int)res;
    }
}
