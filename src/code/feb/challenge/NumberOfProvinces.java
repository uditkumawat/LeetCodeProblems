package code.feb.challenge;

//https://leetcode.com/problems/number-of-provinces/
public class NumberOfProvinces {

    class UnionFind{

        int parent[];
        int rank[];

        UnionFind(int n){

            parent = new int[n];
            rank = new int[n];

            for(int i=0;i<n;i++){
                parent[i] = i;
                rank[i] = 1;
            }
        }

        public int find(int x){
            if(parent[x]!=x){
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public boolean union(int a,int b){
            int parentA = find(a);
            int parentB = find(b);

            //if already are in same set
            if(parentA==parentB){
                return false;
            }

            if(rank[parentA]>rank[parentB]){
                parent[parentB] = parent[parentA];
            }
            else if(rank[parentA]<rank[parentB]){
                parent[parentB] = parent[parentA];
            }
            else{
                parent[parentA] = parentB;
                rank[parentB]++;
            }

            return true;
        }
    }

    public int findCircleNum(int[][] isConnected) {

        if(isConnected==null || isConnected.length==0){
            return 0;
        }

        int n = isConnected.length;
        int count = 0;

        UnionFind uf = new UnionFind(n);

        for(int i=0;i<isConnected.length;i++){
            for(int j=0;j<isConnected[i].length;j++){
                if(i!=j && isConnected[i][j]==1){
                    uf.union(i,j);
                }
            }
        }

        for(int i=0;i<n;i++){
            if(uf.parent[i]==i){
                count++;
            }
        }

        return count;
    }

    public static void main(String args[]){

        int isConnected[][] = {{1,0,0},{0,1,0},{0,0,1}};

        NumberOfProvinces obj = new NumberOfProvinces();

        System.out.println(obj.findCircleNum(isConnected));
    }
}
