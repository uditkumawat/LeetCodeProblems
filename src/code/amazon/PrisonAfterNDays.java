package code.amazon;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//https://leetcode.com/problems/prison-cells-after-n-days/submissions/
public class PrisonAfterNDays {

    public int[] prisonAfterNDays(int[] cells, int n) {

        if(cells==null || cells.length==0){
            return cells;
        }

        int cycle = 0;
        boolean hasCycle = false;
        Set<String> set = new HashSet();

        for(int i=0;i<n;i++){
            int temp[] = update(cells);
            String str = Arrays.toString(temp);
            if(!set.contains(str)){
                set.add(str);
                cycle++;
            }
            else{
                hasCycle = true;
                break;
            }
            cells = temp;
        }

        if(hasCycle){
            n = n % cycle;
            for(int i=0;i<n;i++){
                int temp[] = update(cells);
                cells = temp;
            }
        }

        return cells;
    }

    public int[] update(int cells[]){
        int temp[] = new int[cells.length];
        for(int i=1;i<temp.length-1;i++){
            if(cells[i-1]==cells[i+1]){
                temp[i] = 1;
            }
        }
        return temp;
    }
}
