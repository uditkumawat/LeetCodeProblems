package code.top100;

import java.util.PriorityQueue;

public class KthSmallestElementInMatrix {

    public static void main(String args[]){

        int matrix[][] = {{1,5,9},{10,11,13},{12,13,15}};

        System.out.println(kthSmallest(matrix,8));
    }
    static class HeapNode{
        int row;
        int col;
        int value;
        public HeapNode(int row,int col,int value){
            this.row = row;
            this.col = col;
            this.value = value;
        }

        public int getRow(){
            return row;
        }

        public int getValue(){
            return value;
        }

        public int getCol(){
            return col;
        }
    }

    public static int kthSmallest(int[][] matrix, int k) {

        if(matrix==null || matrix.length==0){
            return 0;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;

        PriorityQueue<HeapNode> pq = new PriorityQueue<>((a, b)->(a.getValue()-b.getValue()));

        for(int r=0;r<rows;r++){
            pq.add(new HeapNode(r,0,matrix[r][0]));
        }

        HeapNode node = null;
        while(k-->0){
            node = pq.poll();

            int row = node.getRow();
            int col = node.getCol();

            if(col+1<cols){
                int value = matrix[row][col+1];
                pq.add(new HeapNode(row,col+1,value));
            }
        }

        return node.getValue();

    }
}
