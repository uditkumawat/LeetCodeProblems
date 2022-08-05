package code.graph;

//https://leetcode.com/problems/flood-fill/

/**
 * Time Complexity: O(N)O(N), where NN is the number of pixels in the image. We might process every pixel.
 *
 * Space Complexity: O(N)O(N), the size of the implicit call stack when calling dfs.
 */
public class FloodFill {

    public static void main(String args[]){

        int image[][] = {{1,1,1},{1,1,0},{1,0,1}};
        int sr = 1;
        int sc = 1;
        int newColor = 2;

        FloodFill obj = new FloodFill();
        System.out.println("Before flood fill");
        obj.printMatrix(image);
        image = obj.floodFill(image,sr,sc,newColor);
        System.out.println("\nAfter flood fill");
        obj.printMatrix(image);
    }

    public void printMatrix(int arr[][]){
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[i].length;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {

        int currentColor = image[sr][sc];

        dfs(image,sr,sc,currentColor,newColor);

        return image;
    }

    public void dfs(int image[][],int row,int col,int currentColor,int newColor){

        image[row][col] = newColor;

        int dirs[][] = {{1,0},{0,1},{-1,0},{0,-1}};

        for(int i=0;i<dirs.length;i++){

            int newRow = row + dirs[i][0];
            int newCol = col + dirs[i][1];

            if(isValid(image,newRow,newCol,currentColor,image.length,image[0].length)){
                dfs(image,newRow,newCol,currentColor,newColor);
            }
        }
    }

    public boolean isValid(int image[][],int row,int col,int color,int rows,int cols){
        if(row<0 || row>=rows || col<0 || col>=cols || image[row][col]!=color){
            return false;
        }
        return true;
    }
}
