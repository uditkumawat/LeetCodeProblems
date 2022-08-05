package code.booking.com;

import java.util.*;

//https://leetcode.com/problems/top-k-frequent-words/
//TC - O(nlogk)
//SC - O(N)
public class TopKFrequentWords {

    public static void main(String args[]){

        String words[] = {"the","day","is","sunny","the","the","the","sunny","is","is"};
        int k = 4;

        TopKFrequentWords obj = new TopKFrequentWords();

        List<String> res = obj.topKFrequent(words,k);

        for(String word:res){
            System.out.println(word);
        }

    }
    public List<String> topKFrequent(String[] words, int k) {

        List<String> res = new ArrayList<>();

        if(words==null || words.length==0){
            return res;
        }

        Map<String,Integer> map = new HashMap<>();

        for(String word:words){
            map.put(word,map.getOrDefault(word,0)+1);
        }

        PriorityQueue<Map.Entry<String,Integer>> pq = new PriorityQueue<>((e1, e2)->{
            if(e1.getValue()==e2.getValue()){
                return e2.getKey().compareTo(e1.getKey());
            }
            else{
                return e1.getValue()-e2.getValue();
            }
        });

        for(Map.Entry<String,Integer> entry:map.entrySet()){
            pq.add(entry);
            if(pq.size()>k){
                pq.poll();
            }
        }

        while(!pq.isEmpty()){
            res.add(0,pq.poll().getKey());
        }

        return res;
    }
}
