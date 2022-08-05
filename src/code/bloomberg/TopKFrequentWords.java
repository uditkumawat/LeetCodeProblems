package code.bloomberg;

import java.util.*;

//https://leetcode.com/problems/top-k-frequent-words/submissions/
//TC - O(nlogk) - insertion of n words into pq
//SC - O(N) -because of map
public class TopKFrequentWords {

    public List<String> topKFrequent(String[] words, int k) {

        Map<String,Integer> map = new HashMap();

        for(String word:words){
            map.put(word,map.getOrDefault(word,0)+1);
        }

        PriorityQueue<String> pq = new PriorityQueue<>((String s1, String s2)->{

            int freq1 = map.get(s1);
            int freq2 = map.get(s2);

            if(freq1==freq2){
                return s2.compareTo(s1);
            }
            else{
                return freq1-freq2;
            }
        });

        for(Map.Entry<String,Integer> entry:map.entrySet()){
            pq.add(entry.getKey());
            if(pq.size()>k){
                pq.poll();
            }
        }

        List<String> res = new ArrayList();

        while(!pq.isEmpty()){
            res.add(0,pq.poll());
        }

        return res;
    }
}
