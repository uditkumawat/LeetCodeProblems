package code.leetcode.doordash;

import java.util.*;

//https://www.youtube.com/watch?v=WYqsg5dziaQ

//TC - O(E)
//SC - O(V+E)
public class ReconstructItinerary {

    public static void main(String args[]){
        List<String> list1 = new ArrayList<>(Arrays.asList("JFK","SFO"));

        List<String> list2 = new ArrayList<>(Arrays.asList("JFK","ATL"));

        List<String> list3 = new ArrayList<>(Arrays.asList("SFO","ATL"));

        List<String> list4 = new ArrayList<>(Arrays.asList("ATL","JFK"));

        List<String> list5 = new ArrayList<>(Arrays.asList("ATL","SFO"));

        List<List<String>> list = new ArrayList<>();
        list.add(list1);
        list.add(list2);
        list.add(list3);
        list.add(list4);
        list.add(list5);

        List<String> finalList = findItinerary2(list);
        System.out.println(finalList);

    }


    public static List<String> findItinerary(List<List<String>> tickets) {

        Map<String, PriorityQueue<String>> map = new HashMap<>();

        for(List<String> ticket:tickets){
            String source = ticket.get(0);
            String destination = ticket.get(1);

            if(!map.containsKey(source)){
                map.put(source,new PriorityQueue<>());
            }

            map.get(source).add(destination);
        }

        List<String> list = new LinkedList<>();

        visit(map,"JFK",list);

        return list;
    }

    public static void visit(Map<String,PriorityQueue<String>> map,String place,List<String> list){
        while(map.containsKey(place) && !map.get(place).isEmpty()){
            visit(map,map.get(place).poll(),list);
        }
        list.add(0,place);
    }

    public static List<String> findItinerary2(List<List<String>> tickets) {

        List<String> result = new ArrayList<>();
        if(tickets==null || tickets.size()==0){
            return result;
        }

        Map<String,PriorityQueue<String>> adjList = new HashMap();

        for(int i=0;i<tickets.size();i++){
            String source = tickets.get(i).get(0);
            String destination = tickets.get(i).get(1);
            PriorityQueue<String> pq = adjList.getOrDefault(source,new PriorityQueue<>());
            pq.add(destination);

            adjList.put(source,pq);
        }


        dfs(adjList,"JFK",result);

        return result;
    }

    public static void dfs(Map<String,PriorityQueue<String>> adjList,String node,List<String> result){

        if(adjList.containsKey(node)){
            PriorityQueue<String> pq = adjList.get(node);

            while(!pq.isEmpty()){
                dfs(adjList,pq.poll(),result);
            }
        }

        result.add(0,node);
    }
}
