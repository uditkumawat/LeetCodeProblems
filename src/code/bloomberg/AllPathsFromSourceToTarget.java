package code.bloomberg;

import java.util.*;

//https://www.youtube.com/watch?v=CYnvDzMprdc&list=PLtQWXpf5JNGLKwqnEtL54puLD7aRTkYyD&index=1
//TC - O(n^2 * 2^n)
//SC - O(2^n) -> For every single path,there are two cases (current node will be in path and won't in path)
//https://leetcode.com/problems/all-paths-from-source-to-target/submissions/
public class AllPathsFromSourceToTarget {

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {

        List<List<Integer>> res = new ArrayList<>();

        Queue<List> q = new LinkedList<>();
        q.add(Arrays.asList(0));

        int dest = graph.length-1;


        while(!q.isEmpty()){

            List<Integer> temp = q.remove();

            int lastElement = temp.get(temp.size()-1);

            if(lastElement==dest){
                res.add(temp);
            }
            else{
                int neighbours[] = graph[lastElement];

                //TC-  O(n^2)
                for(int neighbour:neighbours){                 // going through all neighbours
                    List<Integer> newList = new ArrayList<>(temp); // copy the data to new list
                    newList.add(neighbour);
                    q.add(newList);
                }
            }
        }

        return res;
    }

}
