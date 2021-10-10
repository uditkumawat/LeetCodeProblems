package code.top100;

import java.util.*;

//TC- O(n^2*2^N)
//SC - O(2^n)
//https://www.youtube.com/watch?v=CYnvDzMprdc
public class AllPathsFromSourceToTarget {

    public static void main(String args[]){

        int graph[][] = {{1,2},{3},{1,3},{}};

        List<List<Integer>> paths = getPaths(graph);

        for(List<Integer> path:paths){
            System.out.println(path);
        }
    }

    public static List<List<Integer>> getPaths(int graph[][]){

        if(graph==null || graph.length==0){
            return new ArrayList<>();
        }

        List<List<Integer>> paths = new ArrayList<>();

        Map<Integer,List<Integer>> map = new HashMap<>();

        for(int i=0;i<graph.length;i++){
            List<Integer> edges = map.getOrDefault(i,new ArrayList<>());
            for(int j=0;j<graph[i].length;j++){
                edges.add(graph[i][j]);
            }
            map.put(i,edges);
        }

        Queue<List<Integer>> q = new LinkedList<>();

        //start from source node
        q.add(Arrays.asList(0));

        int goalNode = graph.length-1;

        while(!q.isEmpty()){
            List<Integer> temp = q.poll();
            if(temp==null || temp.size()==0){
                continue;
            }

            int lastVertexInList = temp.get(temp.size()-1);

            if(lastVertexInList==goalNode){
                paths.add(new ArrayList<>(temp));
            }
            else {

                List<Integer> neighbours = map.get(lastVertexInList);

                for (int neighbour : neighbours) {
                    List<Integer> intermediateTemp = new ArrayList<>(temp);
                    intermediateTemp.add(neighbour);
                    q.add(intermediateTemp);
                }
            }
        }
        return paths;
    }
}
