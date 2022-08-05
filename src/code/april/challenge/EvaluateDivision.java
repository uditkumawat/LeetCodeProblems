package code.april.challenge;

import java.util.*;

//https://leetcode.com/problems/evaluate-division/discuss/171649/1ms-DFS-with-Explanations
//https://www.youtube.com/watch?v=gPtkIxy9bUo
//https://leetcode.com/problems/evaluate-division/
public class EvaluateDivision {

    public static void main(String args[]){

        List<String> eq1 = Arrays.asList("a","b");
        List<String> eq2 = Arrays.asList("b","c");
        List<List<String>> equations = Arrays.asList(eq1,eq2);

        double values[] = {2.0,3.0};

        List<String> eq3 = Arrays.asList("a","c");
        List<String> eq4 = Arrays.asList("b","a");
        List<String> eq5 = Arrays.asList("a","e");
        List<String> eq6 = Arrays.asList("a","a");
        List<String> eq7 = Arrays.asList("x","x");
        List<List<String>> queries = Arrays.asList(eq3,eq4,eq5,eq6,eq7);

        EvaluateDivision obj = new EvaluateDivision();

        double res[] = obj.calcEquation(equations,values,queries);

        for(double num:res){
            System.out.print(num+" ");
        }
    }
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {

        Map<String,Map<String,Double>> graph = buildGraph(equations,values,queries);

        double res[] = new double[queries.size()];

        for(int i=0;i<queries.size();i++){
            List<String> query = queries.get(i);
            Set<String> visited = new HashSet();
            double ans = dfs(query.get(0),query.get(1),graph,visited);
            res[i] = ans;
        }

        return res;
    }

    public double dfs(String start, String end, Map<String, Map<String,Double>> graph, Set<String> visited){

        if(!graph.containsKey(start)){
            return -1.0;
        }

        if(graph.get(start).containsKey(end)){
            return graph.get(start).get(end);
        }

        visited.add(start);
        for(Map.Entry<String,Double> neighbour:graph.get(start).entrySet()){
            if(!visited.contains(neighbour.getKey())){
                double ans = dfs(neighbour.getKey(),end,graph,visited);
                if(ans!=-1.0){
                    return neighbour.getValue()*ans;
                }
            }
        }

        return -1.0;
    }

    private Map<String,Map<String,Double>> buildGraph(List<List<String>> equations, double[] values, List<List<String>> queries){

        Map<String,Map<String,Double>> graph = new HashMap();

        int i = 0;

        for(List<String> list:equations){

            String start = list.get(0);
            String end = list.get(1);

            double val = values[i++];

            graph.putIfAbsent(start,new HashMap());
            graph.get(start).put(end,val);

            graph.putIfAbsent(end,new HashMap());
            graph.get(end).put(start,1/val);
        }

        return graph;
    }


}
