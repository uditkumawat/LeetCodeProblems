package code.march.challenge;

import javafx.util.Pair;

import java.util.PriorityQueue;

//https://leetcode.com/problems/the-k-weakest-rows-in-a-matrix/
/**
 * Time Complexity : O(m \, \log \, nk)O(mlognk).
 *
 * This approach is very similar to Approach #3. The only difference is that we're putting the "strengths" into a Priority Queue, and storing at most kk of them at a time.
 *
 * Calculating the strengths is still O(m \, \log \, n)O(mlogn).
 *
 * Inserting an item into a Priority Queue has a cost of O(\log\, x)O(logx), where xx is the maximum number of items that will be in the Priority Queue. For this algorithm, the maximum xx value is kk (not mm). Therefore, each insertion costs log(k)log(k). There are mm of these insertions, giving a total of O(m \, \log \,k)O(mlogk).
 *
 * Like before, we need to add m \, \log \, n + m \, \log \,kmlogn+mlogk, and again we can't assume which is bigger out of \log \, nlogn and \log\,klogk. Therefore, the total time complexity is m \, \log \, n + m \, \log \, k = m \cdot (\log \, n + \log \, k) = O(m \, \log nk)mlogn+mlogk=m⋅(logn+logk)=O(mlognk).
 *
 * Space Complexity : O(k)O(k).
 *
 * We are keeping at most kk pieces of "strength" data at a time. Therefore, the space complexity is O(k)O(k).
 */
public class KthWaekestRowsInMatrix {

    public static void main(String args[]){
        int mat[][] = {{1,1,0,0,0},
                {1,1,1,1,0},
                {1,0,0,0,0},
                {1,1,0,0,0},
                {1,1,1,1,1}};
        int k = 3;
        KthWaekestRowsInMatrix obj = new KthWaekestRowsInMatrix();

        int res[] = obj.kWeakestRows(mat,k);
        for(int num:res){
            System.out.print(num+" ");
        }
    }
    public int[] kWeakestRows(int[][] mat, int k) {

        int count[] = new int[mat.length];

        if(mat==null || mat.length==0 || k==0){
            return count;
        }

        for(int i=0;i<mat.length;i++){

            int index = search(mat[i],0,mat[i].length-1);
            //if only soldiers are present,
            // we made search on arr based on starting position of 0
            if(index==-1){
                index = mat[i].length;
            }
            count[i] = index;
        }

        PriorityQueue<Pair<Integer,Integer>> pq = new PriorityQueue<>((a, b)->{
            if(a.getKey()==b.getKey()){
                return b.getValue()-a.getValue();
            }
            return b.getKey()-a.getKey();
        });

        for(int i=0;i<count.length;i++){
            pq.add(new Pair(count[i],i));
            if(pq.size()>k){
                pq.poll();
            }
        }

        int res[] = new int[k];

        while(!pq.isEmpty()){
            res[--k] = pq.poll().getValue();
        }

        return res;
    }

    private int search(int arr[],int left,int right){

        if(left>right){
            return -1;
        }

        int mid = left+(right-left)/2;
        if((mid==0 && arr[mid]==0) || (mid>0 && arr[mid]==0 && arr[mid-1]==1)){
            return mid;
        }
        else if(arr[mid]==1){
            return search(arr,mid+1,right);
        }
        else{
            return search(arr,left,mid-1);
        }
    }
}
