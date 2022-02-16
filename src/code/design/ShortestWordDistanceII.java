package code.design;

import java.util.*;

//https://leetcode.com/problems/shortest-word-distance-ii/
public class ShortestWordDistanceII {

    Map<String, ArrayList<Integer>> map;
    public ShortestWordDistanceII(String[] wordsDict) {
        this.map = new HashMap<String, ArrayList<Integer>>();
        buildMapIndexes(wordsDict,map);
    }

    public static void main(String args[]){
        String wordsDict[] = {"practice", "makes", "perfect", "coding", "makes"};
        ShortestWordDistanceII obj = new ShortestWordDistanceII(wordsDict);
        System.out.println(obj.shortest("coding", "practice"));
        System.out.println(obj.shortest("makes", "coding"));

    }

    public int shortest(String word1, String word2) {
        List<Integer> indexes1 = map.get(word1);
        List<Integer> indexes2 = map.get(word2);

        int i = 0;
        int j = 0;
        int res = Integer.MAX_VALUE;

        while(i<indexes1.size() && j<indexes2.size()){
            int first = indexes1.get(i);
            int second = indexes2.get(j);
            if(first<second){
                res = Math.min(res,second-first);
                i++;
            }
            else{
                res = Math.min(res,first-second);
                j++;
            }
        }
        return res;
    }

    public void buildMapIndexes(String wordsDict[],Map<String,ArrayList<Integer>> map){
        for(int i=0;i<wordsDict.length;i++){
            String word = wordsDict[i];
            ArrayList<Integer> indexes = map.getOrDefault(word,new ArrayList<>());
            indexes.add(i);
            map.put(word,indexes);
        }
    }
}
