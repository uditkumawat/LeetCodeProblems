package code.blind75;

import java.util.*;

public class WordLadder {

    public static void main(String args[]){

        String startWord = "hit";
        String endWord = "cog";
        List<String> words = Arrays.asList("hot","dot","dog","lot","log","cog");

        WordLadder obj = new WordLadder();
        System.out.println(obj.minSteps(startWord,endWord,words));
    }
    public int minSteps(String startWord, String endWord, List<String> words){

        Set<String> dict = new HashSet<>(words);
        if(!dict.contains(endWord)){
            return 0;
        }

        Set<String> visited = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        q.add(startWord);
        visited.add(startWord);

        int steps = 0;

        while(!q.isEmpty()){
            int size = q.size();
            steps++;
            for(int i=0;i<size;i++){
                String word = q.poll();
                if(endWord.equals(word)){
                    return steps;
                }

                char str[] = word.toCharArray();
                for(int j=0;j<str.length;j++){

                    char prev = str[j];
                    for(int k=0;k<26;k++){
                        str[j] = (char)('a'+k);
                        String newString = new String(str);

                        if(dict.contains(newString) && !visited.contains(newString)){
                            q.add(newString);
                            visited.add(newString);
                        }
                    }
                    str[j] = prev;
                }
            }

        }

        return -1;
    }
}
