package code.amazon;

import java.util.PriorityQueue;

/**
 * Always pick two of the smallest sticks to connect and continue doing this until you get only one stick. Let's see why this works.
 *
 * Consider 4 sticks of the following lengths:
 *
 * sticks = [a_1, a_2, a_3, a_4]sticks=[a
 * 1
 * ​
 *  ,a
 * 2
 * ​
 *  ,a
 * 3
 * ​
 *  ,a
 * 4
 * ​
 *  ]
 *
 * Let's try to connect them left to right.
 *
 * After first merge, we will have:
 *
 * sticks = [(a_1 + a_2), a_3, a_4], cost = (a_1 + a_2)sticks=[(a
 * 1
 * ​
 *  +a
 * 2
 * ​
 *  ),a
 * 3
 * ​
 *  ,a
 * 4
 * ​
 *  ],cost=(a
 * 1
 * ​
 *  +a
 * 2
 * ​
 *  )
 *
 * After second merge, we will have:
 *
 * sticks = [(a_1 + a_2 + a_3), a_4], cost = (a_1 + a_2) + (a_1 + a_2 + a_3)sticks=[(a
 * 1
 * ​
 *  +a
 * 2
 * ​
 *  +a
 * 3
 * ​
 *  ),a
 * 4
 * ​
 *  ],cost=(a
 * 1
 * ​
 *  +a
 * 2
 * ​
 *  )+(a
 * 1
 * ​
 *  +a
 * 2
 * ​
 *  +a
 * 3
 * ​
 *  )
 *
 * And finally, last stick will look like:
 *
 * sticks = [(a_1 + a_2 + a_3 + a_4)], cost = (a_1 + a_2) + (a_1 + a_2 + a_3) +(a_1 + a_2 + a_3 + a_4)sticks=[(a
 * 1
 * ​
 *  +a
 * 2
 * ​
 *  +a
 * 3
 * ​
 *  +a
 * 4
 * ​
 *  )],cost=(a
 * 1
 * ​
 *  +a
 * 2
 * ​
 *  )+(a
 * 1
 * ​
 *  +a
 * 2
 * ​
 *  +a
 * 3
 * ​
 *  )+(a
 * 1
 * ​
 *  +a
 * 2
 * ​
 *  +a
 * 3
 * ​
 *  +a
 * 4
 * ​
 *  )
 *
 * The final cost can be re-written as: cost = (3a_1 + 3a_2 + 2a_3 + a_4)cost=(3a
 * 1
 * ​
 *  +3a
 * 2
 * ​
 *  +2a
 * 3
 * ​
 *  +a
 * 4
 * ​
 *  )
 *
 * As we can see, the sticks which are connected first are included in the final cost more than the ones that are picked later. Hence, it is optimal to pick smaller sticks first to get the smallest cost.
 *
 * Let's try to figure out which data structure will be optimal to perform following tasks:
 *
 * Get two of the smallest sticks (stick1 and stick2) from the array.
 * Add one stick (stick1 + stick2) back to the array.
 * We can use a min heap data structure (which is, generally, implemented as a PriorityQueue in most languages) which gives us O(\log{N})O(logN) complexity for both the operations.
 */
//https://leetcode.com/problems/minimum-cost-to-connect-sticks/solution/
public class MinimumCostToConnectSticks {

    public static void main(String args[]){

        int sticks[] = {1,8,3,5};

        MinimumCostToConnectSticks obj = new MinimumCostToConnectSticks();

        System.out.println(obj.connectSticks(sticks));
    }

    public int connectSticks(int[] sticks) {

        if(sticks==null || sticks.length==0){
            return 0;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b)->{
            return a-b;
        });

        for(int stick:sticks){
            pq.add(stick);
        }

        int sum = 0;

        while(!pq.isEmpty() && pq.size()>1){

            int val1 = pq.poll();
            int val2 = pq.poll();

            int currSum = val1 + val2;

            sum = sum + currSum;

            pq.add(currSum);
        }

        return sum;
    }
}
