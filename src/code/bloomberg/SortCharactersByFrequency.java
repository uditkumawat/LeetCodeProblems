package code.bloomberg;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

//TC - O(nlong)
//SC - O(n)
public class SortCharactersByFrequency {

    public String frequencySort(String s) {

        Map<Character,Integer> freqMap = new HashMap();

        for(char c:s.toCharArray()){
            freqMap.put(c,freqMap.getOrDefault(c,0)+1);
        }

        PriorityQueue<Map.Entry<Character,Integer>> pq = new PriorityQueue<Map.Entry<Character,Integer>>((e1, e2)->{
            return e2.getValue()-e1.getValue();
        });

        for(Map.Entry<Character,Integer> entry:freqMap.entrySet()){
            pq.add(entry);
        }

        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()){
            Map.Entry<Character,Integer> entry = pq.poll();
            int freq = entry.getValue();
            while(freq!=0){
                sb.append(entry.getKey());
                freq--;
            }
        }

        return sb.toString();
    }

    /**
     *  Map<Character,Integer> counts = new HashMap();
     *         for(char c:s.toCharArray()){
     *             counts.put(c,counts.getOrDefault(c,0)+1);
     *         }
     *
     *         List<Character> characters = new ArrayList<>(counts.keySet());
     *         Collections.sort(characters,(a,b)->counts.get(b)-counts.get(a));
     *
     *         StringBuilder sb = new StringBuilder();
     *         for(char c:characters){
     *             int count = counts.get(c);
     *             while(count-->0){
     *                 sb.append(c);
     *             }
     *         }
     *         return sb.toString();
     */
}
