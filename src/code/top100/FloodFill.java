package code.top100;

/**
 * Time Complexity: O(N)O(N), where NN is the number of pixels in the image. We might process every pixel.
 *
 * Space Complexity: O(N)O(N), the size of the implicit call stack when calling dfs.
 */
public class FloodFill {

    public static void main(String args[]){

        int matrix[][]={{1,1,1,1},{0,0,1,0},{1,1,1,0},{0,1,0,0}};

        int srcx = 0;
        int srcy = 0;
        int newColor = 2;
        int rows = matrix.length;
        int cols = matrix[0].length;
        int srcColor = 1;

        System.out.println("Initial Matrix");

        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[i].length;j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }

        dfs(matrix,srcx,srcy,rows,cols,srcColor,newColor);
        System.out.println("After Flood fillMatrix");

        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[i].length;j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static void dfs(int matrix[][],int srcx,int srcy,int rows,int cols,int srcColor,int newtColor) {

        if (srcx < 0 || srcx >=rows || srcy < 0 || srcy >=cols){
            return;
        }
        else if (matrix[srcx][srcy] != srcColor){
            return;
        }

        matrix[srcx][srcy] = newtColor;

        dfs(matrix,srcx-1,srcy,rows,cols,srcColor,newtColor);
        dfs(matrix,srcx+1,srcy,rows,cols,srcColor,newtColor);
        dfs(matrix,srcx,srcy-1,rows,cols,srcColor,newtColor);
        dfs(matrix,srcx,srcy+1,rows,cols,srcColor,newtColor);
    }
}
