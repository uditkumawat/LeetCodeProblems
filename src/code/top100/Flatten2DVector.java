package code.top100;

import java.util.NoSuchElementException;

public class Flatten2DVector {

    private int vector[][];
    private int inner=0;
    private int outer=0;

    public static void main(String args[]){
        int vec[][] = {{1,2,3},{},{4,5}};
        Flatten2DVector obj = new Flatten2DVector(vec);
        System.out.println(obj.next());
    }
    public Flatten2DVector(int[][] vec) {
        this.vector = vec;
    }

    public int next() {
        if(!hasNext()){
            throw new NoSuchElementException();
        }

        return vector[outer][inner++];
    }

    public boolean hasNext() {
        advanceToNext();

        return outer<vector.length;
    }

    public void advanceToNext(){
        while(outer<vector.length && inner==vector[outer].length){
            inner=0;
            outer++;
        }
    }
}
