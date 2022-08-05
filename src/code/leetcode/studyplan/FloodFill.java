package code.leetcode.studyplan;

//https://leetcode.com/problems/flood-fill/solution/
//TC - O(N)
//SC - O(N)
public class FloodFill {

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {

        int currentColor = image[sr][sc];
        int rows = image.length;
        int cols = image[0].length;

        //important check to avoid stackoverflow
        if(currentColor!=newColor){
            dfs(image,sr,sc,rows,cols,newColor,currentColor);
        }
        return image;
    }

    public void dfs(int image[][],int row,int col,int rows,int cols,int newColor,int currentColor){

        if(row<0 || row>=rows || col<0 || col>=cols || image[row][col]!=currentColor){
            return;
        }


        image[row][col] = newColor;

        dfs(image,row-1,col,rows,cols,newColor,currentColor);
        dfs(image,row+1,col,rows,cols,newColor,currentColor);
        dfs(image,row,col-1,rows,cols,newColor,currentColor);
        dfs(image,row,col+1,rows,cols,newColor,currentColor);

    }
}
