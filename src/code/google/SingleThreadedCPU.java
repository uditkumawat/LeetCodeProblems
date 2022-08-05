package code.google;

import java.util.PriorityQueue;

public class SingleThreadedCPU {

    public static void main(String args[]){

        int tasks[][] = {{7,10},{7,12},{7,5},{7,4},{7,2}};

        SingleThreadedCPU obj = new SingleThreadedCPU();

        int res[] = obj.getOrder(tasks);

        for(int index:res){
            System.out.print(index+" ");
        }
    }
    public int[] getOrder(int[][] tasks) {

        PriorityQueue<int[]> pq = new PriorityQueue<>((int e1[], int e2[])->{
            if(e1[2]==e2[2]){
                return e1[0] - e2[0];
            }
            else{
                return e1[2]-e2[2];
            }
        });


        int endTime = tasks[0][0]+tasks[0][1];

        pq.add(new int[]{0,tasks[0][0],endTime});

        int i = 1;

        int res[] = new int[tasks.length];
        int resIndex = 0;

        while(!pq.isEmpty()){

            int temp[] = pq.poll();
            endTime = temp[2];

            res[resIndex] = temp[0];
            resIndex++;

            while(i<tasks.length && endTime>=tasks[i][0]){
                pq.add(new int[]{i,tasks[i][0],tasks[i][0]+tasks[i][1]});
                i++;
            }
        }

        return res;
    }
}
