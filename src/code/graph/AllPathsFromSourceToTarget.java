package code.graph;

import java.util.*;

//https://www.youtube.com/watch?v=CYnvDzMprdc
//https://www.youtube.com/watch?v=uvN4y7E3wZ8&t=1s
//https://leetcode.com/problems/all-paths-from-source-to-target/
public class AllPathsFromSourceToTarget {


    public List<List<Integer>> allPathsSourceTarget(int graph[][]){

        List<List<Integer>> ans = new ArrayList<>();

        Queue<List<Integer>> q = new LinkedList<>();

        q.add(Arrays.asList(0));

        int goalNode = graph.length-1;

        while(!q.isEmpty()){

            List<Integer> path = q.poll();
            int lastNode = path.get(path.size()-1);

            if(lastNode==goalNode){
                ans.add(new ArrayList<>(path));
            }
            else{
                for(int neighbour:graph[lastNode]){

                    List<Integer> list = new ArrayList<>(path);
                    list.add(neighbour);
                    q.add(list);
                }
            }
        }

        return ans;
    }
}
