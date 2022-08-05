package code.april.challenge;

import java.util.PriorityQueue;

//https://leetcode.com/problems/min-cost-to-connect-all-points/solution/
//TC - O(N^2logN)
//https://www.youtube.com/watch?v=K7LqWeA9WSg
public class MinCostToConnectAllPoints {

    public static void main(String args[]){

        int points[][] = {{0,0},{2,2},{3,10},{5,2},{7,0}};

        MinCostToConnectAllPoints obj = new MinCostToConnectAllPoints();

        System.out.println(obj.getMinCost(points));
    }

    public int getMinCost(int points[][]){

        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b)->{
           return a[1]-b[1];
        });

        int n = points.length;

        boolean visited[] = new boolean[n];

        pq.add(new int[]{0,0});

        int totalCost = 0;

        while(!pq.isEmpty()){

            int pointDetail[] = pq.poll();
            int point = pointDetail[0];
            int distance = pointDetail[1];

            if(visited[point]){
                continue;
            }

            totalCost+=distance;
            visited[point] = true;

            for(int i=0;i<points.length;i++){
                if(!visited[i]){
                    pq.add(new int[]{i,distance(points[point],points[i])});
                }
            }
        }

        return totalCost;
    }

    private int distance(int point1[],int point2[]){

        return Math.abs(point1[0]-point2[0]) + Math.abs(point1[1]-point2[1]);
    }
}
