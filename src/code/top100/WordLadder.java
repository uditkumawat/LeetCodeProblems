package code.top100;

import java.util.*;

//https://www.youtube.com/watch?v=ZVJ3asMoZ18
//TC - O(26*N*N*W)
public class WordLadder {

    public static void main(String args[]){

        System.out.println(ladderLength("hit","cog",Arrays.asList("hot","dot","dog","lot","log","cog")));

    }

    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {

        Set<String> set = new HashSet<>();

        for(String word:wordList){
            set.add(word);
        }

        if(!set.contains(endWord)){
            return 0;
        }

        Queue<String> q = new LinkedList<String>();
        q.add(beginWord);

        int depth = 0;

        while(!q.isEmpty()){

            depth++;

            int qsize = q.size();

            while(qsize-->0){

                char currWord[] = q.poll().toCharArray();

                for(int i=0;i<currWord.length;i++){

                    char temp = currWord[i];

                    for(char c='a';c<='z';c++){

                        currWord[i] = c;

                        String nextFormedWord = new String(currWord);

                        if(set.contains(nextFormedWord)){
                            if(nextFormedWord.equals(endWord)){
                                return depth+1;
                            }
                            q.add(nextFormedWord);
                            set.remove(nextFormedWord);
                        }
                    }

                    currWord[i] = temp;
                }
            }
        }

        return depth+1;
    }
}
