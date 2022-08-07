package code.leetcode.studyplan75;

import java.util.PriorityQueue;

//https://leetcode.com/problems/min-cost-to-connect-all-points/solution/
//https://www.youtube.com/watch?v=K7LqWeA9WSg&t=692s
public class MinCostToConnectAllPoints {

    public int minCostConnectPoints(int[][] points) {

        if(points==null || points.length==0){
            return 0;
        }

        int totalCost = 0;

        //min heap based on distance
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((int a[], int b[])->{
            return a[1] - b[1];
        });

        boolean visited[] = new boolean[points.length];

        //putting any random point with distance 0 to itself
        pq.add(new int[]{0,0});

        while(!pq.isEmpty()){

            int pd[] = pq.poll();

            int pointIndex = pd[0];
            int distance = pd[1];

            if(visited[pointIndex]){
                continue;
            }
            totalCost+=distance;
            visited[pointIndex] = true;

            for(int i=0;i<points.length;i++){
                if(!visited[i]){
                    pq.add(new int[]{i,getDistance(points,pointIndex,i)});
                }
            }
        }

        return totalCost;
    }

    public int getDistance(int points[][],int i,int j){
        return Math.abs(points[i][0]-points[j][0])+Math.abs(points[i][1]-points[j][1]);
    }
}
