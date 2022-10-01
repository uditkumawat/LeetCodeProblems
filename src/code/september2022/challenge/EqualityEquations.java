package code.september2022.challenge;

//https://leetcode.com/problems/satisfiability-of-equality-equations/submissions/
//https://www.youtube.com/watch?v=uvSXZWtlwTo
public class EqualityEquations {

    public boolean equationsPossible(String[] equations) {

        if(equations==null || equations.length==0){
            return true;
        }

        int parent[] = new int[26];
        int rank[] = new int[26];

        for(int i=0;i<26;i++){
            parent[i] = i;
            rank[i] = 1;
        }

        for(String eq:equations){
            if(eq.charAt(1)=='='){
                int x = eq.charAt(0)-'a';
                int y = eq.charAt(3)-'a';
                union(parent,x,y);
            }
        }

        for(String eq:equations){
            if(eq.charAt(1)=='!'){
                int x = eq.charAt(0)-'a';
                int y = eq.charAt(3)-'a';
                if(find(parent,x)==find(parent,y)){
                    return false;
                }
            }
        }

        return true;
    }

    private int find(int parent[],int x){
        if(parent[x]==x){
            return x;
        }
        parent[x] = find(parent,parent[x]);
        return parent[x];
    }

    private void union(int parent[],int x,int y){
        x = find(parent,x);
        y = find(parent,y);
        if(x!=y){
            parent[y] = x;
        }
    }
}
