package code.top100;

import java.util.*;

//TC - O(V+E)
//https://www.youtube.com/watch?v=0ACfAqs8mm0&list=PLEJXowNB4kPzByLnnFYNSCoqtFz0VKLk5&index=8
public class BipartitePartition {

    public static void main(String args[]){

        int arr[][] = {{1,2},{2,3},{2,4},{3,5},{4,5}};

        System.out.println(isPossible(arr));
    }

    public static boolean isPossible(int arr[][]){

        Map<Integer, List<Integer>> map  = new HashMap<>();

        int n = arr.length;
        //Unidrected graph , so mapping from both sides

        for(int i=0;i<arr.length;i++){
            int x = arr[i][0];
            int y = arr[i][1];
            if(map.containsKey(x)){
                List<Integer> list = map.get(x);
                list.add(y);
                map.put(x,list);
            }
            else{
                List<Integer> list = new ArrayList<>();
                list.add(y);
                map.put(x,list);
            }

            if(map.containsKey(y)){
                List<Integer> list = map.get(y);
                list.add(x);
                map.put(y,list);
            }
            else{
                List<Integer> list = new ArrayList<>();
                list.add(x);
                map.put(y,list);
            }
        }

        int colors[] = new int[n+1];
        Arrays.fill(colors,-1);

        for(int i=1;i<=n;i++){
            if(colors[i]==-1){
                if(!isBipartite(map,colors,i)){
                    return false;
                }
            }
        }

        return true;
    }

    public static boolean isBipartite(Map<Integer,List<Integer>> map,int colors[],int node){

        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        colors[node]=1;

        while(!q.isEmpty()){
            int curr = q.remove();
            List<Integer> neighbours = map.get(curr);

            for(int neighbour:neighbours) {
                if (colors[neighbour] == colors[curr]) {
                    return false;
                }
                if (colors[neighbour] == -1) {
                    colors[neighbour] = 1 - colors[curr];
                    q.add(neighbour);
                }
            }
        }
        return true;

    }
}
