package code.leetcode.doordash;

import java.util.PriorityQueue;

//TC - O(Nlogk)

public class KPointsClosetToOrigin {


    public static void main(String args[]){
        int arr[][] ={{3,3},{5,-1},{-2,4}};
        int k=2;

        int points[][] = kClosest(arr,k);
        for(int point[]:points){
            System.out.println(point[0]+" "+point[1]);
        }
    }
    public static int[][] kClosest(int[][] points, int k) {

        //created max heap
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b)->{
            return b[0]*b[0]+b[1]*b[1]-a[0]*a[0]-a[1]*a[1];
        });

        for(int point[]:points){
            pq.add(point);
            if(pq.size()>k){
                pq.poll();
            }
        }

        int arr[][] = new int[k][2];

        while(k>0){
            arr[--k] = pq.poll();
        }

        return arr;
    }

}
