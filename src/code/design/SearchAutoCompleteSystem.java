package code.design;

import javafx.util.Pair;

import java.util.*;

public class SearchAutoCompleteSystem {

    public class TrieNode{
        public Map<Character,TrieNode> map;
        public boolean isWord;
        public String word;
        public PriorityQueue<Pair<String,Integer>> pq;

        TrieNode(){
            this.map = new HashMap<>();
            this.isWord = false;
            this.word = "";
            pq = new PriorityQueue<>((a,b)->{
                return a.getValue() - b.getValue();
            });
        }
    }

    public String sentences[];
    public int times[];
    public TrieNode root;
    public int k;
    public StringBuilder prefix;

    SearchAutoCompleteSystem(String sentences[],int times[],int k){
        this.sentences = sentences;
        this.times = times;
        this.root = new TrieNode();
        this.k = k;
        this.prefix = new StringBuilder();
        insertSentences(sentences,times,k);
    }

    private void insertSentences(String sentences[],int times[],int k){

        for(int i=0;i<sentences.length;i++){
            String sentence = sentences[i];
            int time = times[i];
            insertSentence(sentence,time,k);
        }
    }

    private void insertSentence(String sentence,int time,int k){

        TrieNode temp = root;
        for(char c:sentence.toCharArray()){
            if(!temp.map.containsKey(c)){
                temp.map.put(c,new TrieNode());
            }
            temp.pq.add(new Pair(sentence,time));
            while(temp.pq.size()>k){
                temp.pq.poll();
            }
            temp = temp.map.get(c);
        }
        temp.isWord = true;
        temp.word = sentence;
        temp.pq.add(new Pair(sentence,time));
    }

    public List<String> getTopKSuggestions(char c){
        prefix.append(c);
        TrieNode searchedNode = searchPrefix(prefix.toString());
        List<String> res = new ArrayList<>();
        while(searchedNode.pq.size()>0){
            res.add(searchedNode.pq.poll().getKey());
        }
        return res;
    }

    private TrieNode searchPrefix(String prefix){

        TrieNode temp = root;
        for(char c:prefix.toCharArray()){
            if(!temp.map.containsKey(c)){
                return null;
            }
            temp = temp.map.get(c);
        }
        return temp;
    }

    public static void main(String args[]){

        String sentences[] = {"i love you", "island", "iroman", "i love leetcode"};
        int times[] = {5, 3, 2, 2};

        SearchAutoCompleteSystem obj = new SearchAutoCompleteSystem(sentences,times, 3);

        List<String> res = obj.getTopKSuggestions('i');

        System.out.println("Top 3 words starting with-> i");
        for(String str:res){
            System.out.println(str+" ");
        }

        System.out.println();
        System.out.println("Top 3 words starting with -> i ");
        res = obj.getTopKSuggestions(' ');

        for(String str:res){
            System.out.println(str+" ");
        }

        System.out.println();
        System.out.println("Top 3 words starting with -> i l");
        res = obj.getTopKSuggestions('l');

        for(String str:res){
            System.out.println(str+" ");
        }

        while(obj.root.pq.size()>0){
            System.out.println(obj.root.pq.poll());
        }
    }
}
