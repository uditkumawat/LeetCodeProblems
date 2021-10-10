package code.top100;


//TC - O(n^2)
//first transpose and then revers each row
public class RotateMatrix {

    public static void main(String args[]){

        int matrix[][] = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};

        System.out.println("Before rotation \n");
        for(int arr[]:matrix) {
            for(int num:arr) {
                System.out.print(num+" ");
            }
            System.out.println();
        }
        rotate(matrix);
        System.out.println("After rotation \n");
        for(int arr[]:matrix) {
            for(int num:arr) {
                System.out.print(num+" ");
            }
            System.out.println();
        }
    }

    public static void rotate(int matrix[][]){

        //transpose
        for(int i=0;i<matrix.length;i++){
            for(int j=i;j<matrix[0].length;j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        //reverse each row
        for(int i=0;i<matrix.length;i++){
            int j = 0;
            int k = matrix[i].length - 1;
            while(j<=k){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][k];
                matrix[i][k] = temp;
                j++;
                k--;
            }
        }

    }
}
