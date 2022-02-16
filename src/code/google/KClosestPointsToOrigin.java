package code.google;

import java.util.PriorityQueue;

public class KClosestPointsToOrigin {

    public static void main(String args[]){

        int points[][] = {{3,3},{5,-1},{-2,4}};
        int k = 2;

        KClosestPointsToOrigin obj = new KClosestPointsToOrigin();

        int res[][] = obj.kClosest(points,k);

        for(int point[]:res){

            System.out.println(point[0]+" "+point[1]);
        }

    }
    public int[][] kClosest(int[][] points, int k) {

        if(points==null || points.length==0){
            return null;
        }

        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b)->{
            return ((b[0]*b[0]+b[1]*b[1])-(a[0]*a[0]+a[1]*a[1]));
        });

        for(int point[]:points){
            pq.add(point);
            if(pq.size()>k){
                pq.poll();
            }
        }

        int res[][] = new int[pq.size()][2];
        int i = 0;
        while(!pq.isEmpty()){
            res[i] = pq.poll();
            i++;
        }

        return res;
    }
}
