package code.leetcode.doordash;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Let NN be the total number of candidates, and KK be the size of the team.
 *
 * Time Complexity: O\big(N \cdot (\log N + \log K)\big)O(N⋅(logN+logK))
 *
 * First of all, we build a list of candidates from the inputs, which takes O(N)O(N) time.
 *
 * We then sort the candidates, which takes O(N \log N)O(NlogN) time.
 *
 * We iterate through the sorted candidates. At each iteration, we will perform at most two operations on the priority queue: one push and one pop. Each operation takes O\big(\log (K-1) \big)O(log(K−1)) time, where K-1K−1 is the capacity of the queue. To sum up, the time complexity of this iteration will be O\big(N \cdot \log (K-1)\big) = O(N \cdot \log K)O(N⋅log(K−1))=O(N⋅logK).
 *
 * Thus, the overall time complexity of the algorithm will be O\big(N \cdot (\log N + \log K)\big)O(N⋅(logN+logK)).
 *
 * Space Complexity: O(N + K)O(N+K)
 *
 * We build a list of candidates from the inputs, which takes O(N)O(N) space.
 *
 * We also use the priority queue data structure whose space capacity is O(K-1)O(K−1).
 *
 * Note that we use sorting in the algorithm, and the space complexity of the sorting algorithm depends on the implementation of each programming language. For instance, the sorted() function in Python is implemented with the Timsort algorithm whose space complexity is \mathcal{O}(N)O(N). While in Java, the Collections.sort() is implemented as a variant of the quicksort algorithm whose space complexity is \mathcal{O}(\log{N})O(logN).
 *
 * To sum up, the overall space complexity of the entire algorithm is O(N + K)O(N+K).
 */
public class MaximumPerformanceOfTeam {

    static class Engineer{
        int speed;
        int efficiency;
        Engineer(int speed,int efficiency){
            this.speed = speed;
            this.efficiency = efficiency;
        }
    }

    private static final int MOD = (int)Math.pow(10,9)+7;

    public static void main(String args[]){
        int n=6;
        int speed[]={2,10,3,1,5,8};
        int efficiency[]={5,4,3,9,7,2};
        int k=4;

        System.out.println(maxPerformance(n,speed,efficiency,k));
    }
    public static int maxPerformance(int n, int[] speed, int[] efficiency, int k) {

        List<Engineer> list = new ArrayList<>();
        for(int i=0;i<n;i++){
            list.add(new Engineer(speed[i],efficiency[i]));
        }

        Collections.sort(list,(a, b)->b.efficiency-a.efficiency);

        int sum = 0;
        int maxValue = 0;

        PriorityQueue<Engineer> pq = new PriorityQueue<Engineer>((a, b)->a.speed-b.speed);

        for(Engineer obj : list){
            sum = sum+obj.speed;
            pq.add(obj);
            if(pq.size()>k){
                Engineer temp = pq.poll();
                sum = sum-temp.speed;
            }
            maxValue = Math.max(maxValue,(sum*obj.efficiency)%MOD);
        }

        return maxValue;
    }
}
