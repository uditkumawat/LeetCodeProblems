package code.march.challenge;

public class SparseMatrixMultiplication {

    public static void main(String args[]){

        int a[][] = {{1,2,3},{4,5,6}};
        int b[][] = {{7,8,9},{4,5,6},{1,2,3}};

        SparseMatrixMultiplication obj = new SparseMatrixMultiplication();
        int res[][] = obj.multiply(a,b);

        for(int list[]:res){
            for(int num:list){
                System.out.print(num+" ");
            }
            System.out.println();
        }
    }

    private int[][] multiply(int a[][],int b[][]){

        int rows = a.length;
        int cols = b[0].length;
        int res[][] = new int[rows][cols];

        for(int i=0;i<a.length;i++){

        }
        return res;
    }
}
