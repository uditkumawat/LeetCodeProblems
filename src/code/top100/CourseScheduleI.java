package code.top100;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//TC - O(V+E)
//SC - O(V)   recursion stack


public class CourseScheduleI {

    public static void main(String args[]){

        int arr[][] = {{1,0}};
        int numCourses = 2;
        System.out.println(isPossible(arr,numCourses));
    }

    public static boolean isPossible(int arr[][],int numCourses){

        if(arr==null || arr.length==0){
            return true;
        }

        Map<Integer, List<Integer>> map = new HashMap<>();

        //directed graph
        for(int i=0;i<arr.length;i++){
            int source = arr[i][0];
            int destination = arr[i][1];

            List<Integer> list = new ArrayList<>();
            if(map.containsKey(source)){
                list = map.get(source);
            }
            list.add(destination);
            map.put(source,list);
        }

        int visited[] = new int[numCourses];
        for(int i=0;i<numCourses;i++){
            if(visited[i]==0 && hasCycle(map,visited,i)){
                return false;
            }
        }

        return true;
    }

    public static boolean hasCycle(Map<Integer,List<Integer>> map,int visited[],int currNode){

        //check whether we are visiting same node again which was in processing mode
        if(visited[currNode]==1){
            return true;
        }

        visited[currNode]=1;

        if(map.containsKey(currNode)) {
            List<Integer> neighbours = map.get(currNode);
            for(int i=0;i<neighbours.size();i++){
                if(visited[i]!=2 && hasCycle(map,visited,neighbours.get(i))){
                    return true;
                }
            }
        }

        visited[currNode]=2;

        return false;
    }
}
