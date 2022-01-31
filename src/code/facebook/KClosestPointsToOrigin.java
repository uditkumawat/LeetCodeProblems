package code.facebook;

import java.util.PriorityQueue;

//TC - O(Nlogk)
//SC - O(k)
public class KClosestPointsToOrigin {

    public static void main(String args[]){

        int points[][] = {{3,3},{5,-1},{-2,4}};
        int k = 1;
        KClosestPointsToOrigin obj = new KClosestPointsToOrigin();
        int res[][] = obj.kClosest(points,k);

        for(int point[]:res){
            System.out.println(point[0]+","+point[1]);
        }
    }
    public int[][] kClosest(int[][] points, int k) {

        PriorityQueue<int[]> maxHeap = new PriorityQueue<int[]>((int a[],int b[])->{
            return b[0]*b[0]+b[1]*b[1] - a[0]*a[0]+a[1]*a[1];
        });

        for(int point[]:points){
            maxHeap.add(point);
            if(maxHeap.size()>k){
                maxHeap.poll();
            }
        }

        int res[][] = new int[maxHeap.size()][];

        int index = 0;
        while(!maxHeap.isEmpty()){
            res[index] = maxHeap.poll();
            index++;
        }

        return res;
    }
}
