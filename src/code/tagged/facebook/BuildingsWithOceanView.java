package code.tagged.facebook;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/buildings-with-an-ocean-view/
//TC - O(N)
//SC - O(1)
public class BuildingsWithOceanView {

    public static void main(String args[]){

        BuildingsWithOceanView obj = new BuildingsWithOceanView();

        int res[] = obj.findBuildings(new int[]{4,2,3,1});
        obj.print(res);
        res = obj.findBuildings(new int[]{4,3,2,1});
        obj.print(res);
        res = obj.findBuildings(new int[]{1,3,2,4});
        obj.print(res);
    }

    private void print(int res[]){
        for(int num:res){
            System.out.print(num+" ");
        }
        System.out.println();
    }
    public int[] findBuildings(int[] heights) {


        if(heights==null || heights.length==0){
            return null;
        }

        List<Integer> list = new ArrayList<>();
        int maxHeight = -1;

        for(int i=heights.length-1;i>=0;i--){

            if(maxHeight<heights[i]){
                list.add(i);

                maxHeight = heights[i];
            }
        }

        int res[] = new int[list.size()];

        for(int i=0;i<list.size();i++){
            res[i] = list.get(list.size()-1-i);
        }

        return res;
    }
}
