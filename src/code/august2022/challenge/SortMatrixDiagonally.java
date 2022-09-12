package code.august2022.challenge;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

//https://leetcode.com/problems/sort-the-matrix-diagonally/
//TC - O(rows * cols * log(min(rows,cols))
//SC - O( rows * cols )
//https://www.youtube.com/watch?v=1FkUtzp4Pqs
public class SortMatrixDiagonally {

    public int[][] diagonalSort(int[][] mat) {

        Map<Integer, PriorityQueue<Integer>> map = new HashMap();

        int rows = mat.length;
        int cols = mat[0].length;

        for(int row=0;row<rows;row++){
            for(int col=0;col<cols;col++){
                int key = row-col;
                PriorityQueue<Integer> pq = map.getOrDefault(key,new PriorityQueue<Integer>());
                pq.add(mat[row][col]);

                map.put(key,pq);
            }
        }

        for(int row=0;row<rows;row++){
            for(int col=0;col<cols;col++){
                int key = row-col;
                PriorityQueue<Integer> pq = map.get(key);
                mat[row][col] = pq.poll();
            }
        }

        return mat;
    }
}
