package code.bloomberg;

import java.util.*;

//https://leetcode.com/problems/alien-dictionary/solution/
//TC - O(V+E)
//SC- O(V+E)
//https://www.youtube.com/watch?v=_u1Mn4_2hIo
public class AlienDictionary {

    public String alienOrder(String[] words) {

        if(words==null || words.length==0){
            return null;
        }

        Map<Character,Integer> indegree = new HashMap();
        Map<Character, List<Character>> graph = new HashMap();

        for(String word : words){
            for(char c : word.toCharArray()){
                indegree.put(c,0);
            }
        }

        for(int i=0;i<words.length-1;i++){

            String currWord = words[i];
            String nextWord = words[i+1];

            if(currWord.length() > nextWord.length() && currWord.startsWith(nextWord)){
                return "";
            }

            int len = Math.min(currWord.length(),nextWord.length());

            for(int j=0;j<len;j++){

                if(currWord.charAt(j)!=nextWord.charAt(j)){

                    if(!graph.containsKey(currWord.charAt(j))){
                        graph.put(currWord.charAt(j),new ArrayList());
                    }
                    graph.get(currWord.charAt(j)).add(nextWord.charAt(j));
                    indegree.put(nextWord.charAt(j),indegree.getOrDefault(nextWord.charAt(j),0)+1);
                    break;
                }
            }
        }

        Queue<Character> q = new LinkedList<Character>();
        for(Character c:indegree.keySet()){
            if(indegree.get(c)==0){
                q.add(c);
            }
        }

        StringBuilder sb = new StringBuilder();


        while(!q.isEmpty()){
            Character c = q.remove();
            sb.append(c);

            if(graph.containsKey(c)){
                for(char neighbour:graph.get(c)){
                    indegree.put(neighbour,indegree.get(neighbour)-1);
                    if(indegree.get(neighbour)==0){
                        q.add(neighbour);
                    }
                }
            }
        }


        return sb.length()<indegree.size() ? "":sb.toString();
    }
}
