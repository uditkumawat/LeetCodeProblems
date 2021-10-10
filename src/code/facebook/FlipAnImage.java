package code.facebook;

/**
 * Given an n x n binary matrix image, flip the image horizontally, then invert it, and return the resulting image.
 *
 * To flip an image horizontally means that each row of the image is reversed.
 *
 * For example, flipping [1,1,0] horizontally results in [0,1,1].
 * To invert an image means that each 0 is replaced by 1, and each 1 is replaced by 0.
 *
 * For example, inverting [0,1,1] results in [1,0,0].
 */
public class FlipAnImage {

    public static void main(String args[]){
        FlipAnImage obj = new FlipAnImage();
        int image[][] = {{1,1,0},{1,0,1},{0,0,0}};
        int output[][] = obj.flipAndInvertImage(image);

        for(int out[]:output){
            for(int num:out){
                System.out.print(num+" ");
            }
            System.out.println();
        }

    }

    public int[][] flipAndInvertImage(int[][] image) {

        if(image==null || image.length==0){
            return image;
        }

        for(int row=0;row<image.length;row++){
            int left = 0;
            int right = image[row].length-1;

            while(left<=right){
                int temp = image[row][left]^1;
                image[row][left] = image[row][right]^1;
                image[row][right] = temp;


                left++;
                right--;
            }
        }

        return image;
    }
}
