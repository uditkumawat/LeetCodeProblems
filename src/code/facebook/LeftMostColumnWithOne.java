package code.facebook;

//O(N+M)
public class LeftMostColumnWithOne {

    /*
    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        int rows = binaryMatrix.getDimensions().get(0);
        int cols = binaryMatrix.getDimensions().get(1);

        int currentRow = 0;
        int currentCol = cols-1;

        while(currentRow<rows && currentCol>=0){
            if(binaryMatrix.get(currentRow,currentCol)==1){
                currentCol--;
            }
            else{
                currentRow++;
            }
        }

        return currentCol<0?-1:currentCol;
    }

     */
}
