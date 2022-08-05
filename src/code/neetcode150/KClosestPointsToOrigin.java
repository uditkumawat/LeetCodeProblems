package code.neetcode150;

import java.util.PriorityQueue;

//https://leetcode.com/problems/k-closest-points-to-origin/submissions/
//TC - O(nlogk)
//SC - O(k)
public class KClosestPointsToOrigin {

    public int[][] kClosest(int[][] points, int k) {

        if(points==null || points.length==0){
            return new int[0][0];
        }

        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((int a[], int b[])->{
            return (b[0]*b[0]+b[1]*b[1])-(a[0]*a[0]+a[1]*a[1]);
        });

        for(int point[]:points){
            pq.add(point);
            if(pq.size()>k){
                pq.poll();
            }
        }

        int ans[][] = new int[k][2];
        int index = 0;
        while(!pq.isEmpty()){
            ans[index++] = pq.poll();
        }

        return ans;
    }
}
