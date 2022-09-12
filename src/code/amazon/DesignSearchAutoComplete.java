package code.amazon;

import java.util.*;

public class DesignSearchAutoComplete {

    class TrieNode{
        Map<Character,TrieNode> map;
        Map<String,Integer> count;
        TrieNode(){
            this.map = new HashMap();
            this.count = new HashMap();
        }
    }

    class Trie{

        TrieNode root;

        Trie(){
            root = new TrieNode();
        }

        public void insert(String sentence,int times){
            TrieNode temp = root;
            for(int i=0;i<sentence.length();i++){
                char c = sentence.charAt(i);
                if(!temp.map.containsKey(c)){
                    temp.map.put(c,new TrieNode());
                }
                temp.count.put(sentence,temp.count.getOrDefault(sentence,0)+1);
                temp = temp.map.get(c);
            }
        }

        public boolean search(String sentence){
            TrieNode temp = root;
            for(int i=0;i<sentence.length();i++){
                char c = sentence.charAt(i);
                if(!temp.map.containsKey(c)){
                    return false;
                }
                temp = temp.map.get(c);
            }
            return true;
        }

        public TrieNode searchPrefix(String prefix){
            TrieNode temp = root;
            TrieNode prev = null;

            for(int i=0;i<prefix.length();i++){
                char c = prefix.charAt(i);
                if(!temp.map.containsKey(c)){
                    return null;
                }
                prev = temp;
                temp = temp.map.get(c);
            }
            return prev;
        }
    }

    class Pair {
        String s;
        int c;
        public Pair(String s, int c) {
            this.s = s; this.c = c;
        }
    }

    Trie root;
    String prefix;

    public DesignSearchAutoComplete(String[] sentences, int[] times) {
        root = new Trie();
        prefix = "";
        for(int i=0;i<sentences.length;i++){

            String sent = sentences[i];
            int count = times[i];

            root.insert(sent,count);
        }
    }

    public List<String> input(char c) {
        if(c=='#'){
            root.insert(prefix,1);
            prefix="";
            return new ArrayList<>();
        }
        else{
            prefix = prefix + c;
            TrieNode curr = root.searchPrefix(prefix);
            if(curr==null){
                return new ArrayList<String>();
            }

            PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> (a.c == b.c ? a.s.compareTo(b.s) : b.c - a.c));

            for (String s : curr.count.keySet()) {
                pq.add(new Pair(s, curr.count.get(s)));
            }

            List<String> res = new ArrayList<String>();
            for (int i = 0; i < 3 && !pq.isEmpty(); i++) {
                res.add(pq.poll().s);
            }
            return res;
        }
    }
}
