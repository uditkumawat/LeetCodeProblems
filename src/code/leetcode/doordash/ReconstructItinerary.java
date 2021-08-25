package code.leetcode.doordash;

import java.util.*;

//https://www.youtube.com/watch?v=WYqsg5dziaQ

//TC - O(E)
//SC - O(V+E)
public class ReconstructItinerary {

    public static void main(String args[]){
        List<String> list1 = new ArrayList<>(Arrays.asList("MUC","LHR"));

        List<String> list2 = new ArrayList<>(Arrays.asList("JFK","MUC"));

        List<String> list3 = new ArrayList<>(Arrays.asList("SFO","SJC"));

        List<String> list4 = new ArrayList<>(Arrays.asList("LHR","SFO"));

        List<List<String>> list = new ArrayList<>();
        list.add(list1);
        list.add(list2);
        list.add(list3);
        list.add(list4);

        List<String> finalList = findItinerary(list);
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
}
