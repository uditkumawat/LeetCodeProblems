package code.leetcode.doordash;

//1359. Count All Valid Pickup and Delivery Options
//https://leetcode.com/problems/count-all-valid-pickup-and-delivery-options/discuss/516968/JavaC%2B%2BPython-Easy-and-Concise

//https://www.youtube.com/watch?v=THVucbW1hwY

/**
 * https://leetcode.com/problems/count-all-valid-pickup-and-delivery-options/discuss/516941/Python-O(n)-with-detailed-explanations
 *
 * Consider n = 3 orders.
 *
 * Now consider one particular sequence; S = [(P1, D1), (P2, D2), (P3, D3)]
 * Now let us consider an arrangement like this, where P1 comes before P2 and P2 comes before P3, i.e., P1 ... P2 ... P3 ...
 * Now we observe that -
 *
 * D3 can only be placed in one position (1 ways), i.e., at the last after P3. So, the sequence becomes - P1 ... P2 ... P3 ... D3 ...
 * D2 can be placed at any one of three positions (3 ways), i.e., between P2 and P3, or between P3 and D3, or after D3. So, one of the sequence becomes - P1 ... P2 ... P3 ... D2 ... D3 ...
 * D1 can be placed at any one of the above five positions (5 ways).
 * So, for the above particular sequence S we have - 1 * 3 * 5 = 15 ways.
 * But the sequence can be arranged in 3! ways. So, the ans is 3! * (1 * 3 * 5).
 *
 * In general, the ans is - n! * (1 * 3 * 5 * ... * (2*n-1)).
 */

/**
 *

 Given n orders, each order consist in pickup and delivery services, so we have altogether 2n slots to fit in all the pickups and deliverys. Since delivery(i) is always after of pickup(i) for all i, we can deduce that:

 The first slot must be a pickup, and there are 2n-1 possible slots for its delivery.
 If the first delivery is at the second slot, then the third slot must be a pickup; if the first delivery is after the second slot, then the second slot must be a pickup. Either way, the second delivery can be put in any of the remaining 2n-3 empty slot.
 By induction, we can find that there are Sn = (2n-1) * (2n-3) * ... * 3 * 1 different arrangements of pickup and delivery pairs.
 And for every arrangement, there are n! permutations, so the final result is (n! * Sn) % 1000000007.
 */
//TC - O(N)
//SC - O(1)
//https://leetcode.com/problems/count-all-valid-pickup-and-delivery-options/discuss/1325792/C-solution-with-steps-to-come-up-with-the-formula
public class CoundValidOrderDelivery {

    private static long MOD = (long)(1e9)+7;

    public static void main(String args[]){

        for(int i=0;i<10;i++) {
            System.out.println(countCorrectOrdersWithoutExtraSpace(i));
        }
    }


    public static int countCorrectOrdersWithoutExtraSpace(int n){
        if(n<=0){
            return 0;
        }
        long count = 1;
        for(int i=2;i<=n;i++){
            int spotsForPickup = 2*i;
            int spotsForDelivery = 2*i-1;
            int totalCombinations = spotsForPickup*spotsForDelivery;
            /// with correct order preference like delivery should be aafter pickup only
            int totalGenuineCombinations = totalCombinations/2;

            count = (count*totalGenuineCombinations)%MOD;
        }

        return (int)count;
    }

    public static int countCorrectOrdersWithExtraSpace(int n){
        long dp[] = new long[501];
        dp[0] = 0;
        dp[1] = 1;
        for(int i=2;i<=n;i++){
            int spotsForPickup = 2*i;
            int spotsForDelivery = 2*i-1;
            int totalCombinations = spotsForPickup*spotsForDelivery;
            /// with correct order preference like delivery should be aafter pickup only
            int totalGenuineCombinations = totalCombinations/2;

            dp[i] = (dp[i-1]*totalGenuineCombinations)%MOD;
        }

        return (int)dp[n];
    }

    public static int countOrders(int n) {
        long dp[] = new long[501];
        dp[1] = 1L;
        dp[2] = 6L;
        for(int i=3;i<=n;i++){
            int spaceCount = (i-1)*2+1;
            long val = (spaceCount)*(spaceCount+1)/2;
            dp[i] = (dp[i-1]*val)%MOD;
        }
        return (int)dp[n];
    }


    public static int count(int n){
        if(n<=0){
            return 0;
        }

        int spots = 2*n;
        long res = 1;

        for(int i=n;i>0;i--){
            res = (res*(spots*(spots-1))/2)%MOD;
            spots = spots-2;
        }

        return (int)res;
    }
}
