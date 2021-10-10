package code.leetcode.doordash;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class MinimumStepByKnight {

    static class Coordinate{
        int x;
        int y;
        Coordinate(int x,int y){
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String args[]){

        int xtarget = 1;
        int ytarget = 1;

        System.out.println(minimumMoves(xtarget,ytarget));
    }

    public static int minimumMoves(int xtarget,int ytarget){
       //// If we can reach x,y in one quadrant then we can do it for all others in the same number of moves too.
        xtarget = Math.abs(xtarget);
        ytarget = Math.abs(ytarget);

        Queue<Coordinate> q = new LinkedList<>();
        q.add(new Coordinate(0,0));

        Set<String> visited = new HashSet<String>();
        visited.add("0,0");

        int moves = 0;

        int dirs[][] = {{-2,1},{-2,-1},{2,1},{2,-1},{1,2},{1,-2},{-1,2},{-1,-2}};

        while(!q.isEmpty()){
            int size = q.size();

            for(int i=0;i<size;i++) {
                Coordinate curr = q.remove();
                if (curr.x == xtarget && curr.y == ytarget){
                    return moves;
                }

                for(int j=0;j<dirs.length;j++){

                    int newx = curr.x+dirs[j][0];
                    int newy = curr.y+dirs[j][1];

                    String visitedCoordinate = newx+" "+newy;
                    /**
                     * For example, to reach (1,1) from (0, 0), the best way is to get (2, -1) or (-1, 2) first, then (1,1) (two steps). If we eliminate all coordinates with negative numbers, then we can't reach (1,1) from (0, 0) within two steps.
                     */
                    if(!visited.contains(visitedCoordinate) && newx>=-1 && newy>=-1){
                        q.add(new Coordinate(newx,newy));
                        visited.add(visitedCoordinate);
                    }
                }
            }
            moves++;
        }

        return -1;
    }
}
