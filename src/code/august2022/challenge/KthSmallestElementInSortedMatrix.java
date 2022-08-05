package code.august2022.challenge;

import java.util.PriorityQueue;

//https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/submissions/
//TC - O(nlogk)
//SC - O(k)
//https://www.youtube.com/watch?v=F22d27HJsxg
public class KthSmallestElementInSortedMatrix {

    public int kthSmallest(int[][] matrix, int k) {

        if(matrix==null || matrix.length==0){
            return -1;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a, b)->{
            return b-a;
        });

        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[i].length;j++){
                pq.add(matrix[i][j]);

                if(pq.size()>k){
                    pq.poll();
                }
            }
        }

        return pq.peek();
    }
}
