package code.top100;

import java.util.*;

//https://www.geeksforgeeks.org/given-sorted-dictionary-find-precedence-characters/
public class AlienDictionary {

    static class Graph{
        int vertices;
        List<List<Integer>> adjList;
        Graph(int vertices){
            this.vertices = vertices;
            this.adjList = new ArrayList<>(vertices);
            for(int i=0;i<this.vertices;i++){
                this.adjList.add(new ArrayList<>());
            }
        }

        public void addEdge(int startVertex,int endVertex){

            adjList.get(startVertex).add(endVertex);
        }

        public int getNoOfVertices(){
            return vertices;
        }

        public void topologicalSortUtil(int vertice,boolean visited[],Stack<Integer> stack){

            if(visited[vertice]){
                return;
            }

            visited[vertice] = true;

            for(int neighbour:adjList.get(vertice)){
                if(!visited[neighbour]) {
                    topologicalSortUtil(neighbour, visited, stack);
                }
            }

            stack.push(vertice);
        }
        public void topologicalSort(){

            Stack<Integer> stack = new Stack();

            boolean visited[] = new boolean[getNoOfVertices()];

            Arrays.fill(visited,false);

            for(int i=0;i<getNoOfVertices();i++){
                if(!visited[i]){
                    topologicalSortUtil(i,visited,stack);
                }
            }

            while(!stack.isEmpty()){
                System.out.print((char)('a'+stack.pop())+" ");
            }
        }
    }
    public static void main(String args[]){

        String words[] = {"caa","aaa","aab"};
        int n = findUniqueCharacters(words);
        System.out.println("Number of vertices "+n);
        Graph gobj = new Graph(n);
        printOrder(words,gobj);
    }

    public static int findUniqueCharacters(String words[]){
        Set<Character> uniqueChars = new HashSet<>();
        for(String word:words){
            for(char c:word.toCharArray()){
                uniqueChars.add(c);
            }
        }
        return uniqueChars.size();
    }

    public static void printOrder(String words[],Graph graphObj){

        for(int i=0;i<words.length-1;i++){

            String fWord = words[i];
            String sWord = words[i+1];
            for(int j=0;j<Math.min(fWord.length(),sWord.length());j++){

                //all words are sorted
                if(fWord.charAt(j)!=sWord.charAt(j)){
                    int startEdge = fWord.charAt(j)-'a';
                    int endEdge = sWord.charAt(j)-'a';
                    graphObj.addEdge(startEdge,endEdge);
                    break;
                }
            }
        }

        graphObj.topologicalSort();
    }
}
