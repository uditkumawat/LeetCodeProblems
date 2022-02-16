package code.feb.challenge;

import java.util.*;

public class WordLadder {

    public static void main(String args[]){

        String beginWord = "hit";
        String endWord = "cog";

        List<String> wordList = Arrays.asList("hot","dot","dog","lot","log","cog");

        WordLadder obj = new WordLadder();
        System.out.println(obj.getShortedSequence(beginWord,endWord,wordList));
    }

    public int getShortedSequence(String beginWord,String endWord,List<String> wordList){

        Set<String> set = new HashSet<>();
        for(String word:wordList){
            set.add(word);
        }

        if(!set.contains(endWord)){
            return 0;
        }

        set.add(beginWord);

        Map<String,List<String>> map = getWordMapping(set);
        Set<String> visited = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        q.add(beginWord);

        int level = 0;

        while(!q.isEmpty()){
            int size = q.size();
            level++;
            while(size-->0){
                String word = q.poll();
                //check if we got the endWord
                if(word.equals(endWord)){
                    return level;
                }

                if(visited.contains(word)){
                    continue;
                }

                List<String> mapWords = map.getOrDefault(word,new ArrayList<>());
                for (String w : mapWords) {
                    if(!visited.contains(w)) {
                        q.add(w);
                    }
                }

                visited.add(word);
            }
        }

        if(visited.contains(endWord)){
            return level;
        }
        else {
            return 0;
        }
    }

    public Map<String,List<String>> getWordMapping(Set<String> wordSet){

        Map<String,List<String>> map = new HashMap<>();
        for(String word1:wordSet){
            for(String word2:wordSet){
                if(!word1.equals(word2) && isStringDifferByOne(word1,word2)){

                    List<String> list1 = map.getOrDefault(word1,new ArrayList<>());
                    list1.add(word2);
                    map.put(word1,list1);


                    List<String> list2 = map.getOrDefault(word2,new ArrayList<>());
                    list2.add(word1);
                    map.put(word2,list2);
                }
            }
        }

        return map;
    }

    public boolean isStringDifferByOne(String a,String b){
        if(a.length()!=b.length()){
            return false;
        }
        boolean foundOneDifference = false;
        for(int i=0;i<a.length();i++){
            if(a.charAt(i)!=b.charAt(i)){
                //if already one mismatch char found
                if(foundOneDifference){
                    return false;
                }
                foundOneDifference = true;
            }
        }

        return true;
    }
}
