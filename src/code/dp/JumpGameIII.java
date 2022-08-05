package code.dp;

import java.util.LinkedList;
import java.util.Queue;

public class JumpGameIII {

    public boolean canReach(int[] arr, int start) {
        if(arr==null || arr.length==0){
            return false;
        }

        Queue<int[]> q = new LinkedList<>();
        boolean visited[] = new boolean[arr.length];

        q.add(new int[]{start,arr[start]});
        visited[start] = true;



        while(!q.isEmpty()){

            int node[] = q.poll();

            int index = node[0];
            int value = node[1];

            if(value==0){
                return true;
            }

            if(index+value>=0 && index+value<arr.length && visited[index+value]==false){
                int newIndex = index+value;
                int newValue = arr[newIndex];
                q.add(new int[]{newIndex,newValue});
                visited[newIndex]  = true;
            }


            if(index-value>=0 && index-value<arr.length && visited[index-value]==false){
                int newIndex = index-value;
                int newValue = arr[newIndex];
                q.add(new int[]{newIndex,newValue});
                visited[newIndex]  = true;
            }
        }

        return false;
    }
}
