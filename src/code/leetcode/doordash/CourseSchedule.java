package code.leetcode.doordash;

import java.util.ArrayList;
import java.util.List;

//youtube tech dose
// TC - O(V+E)
 //SC - O(V+E)
public class CourseSchedule {

    public static void main(String args[]){
        int numCourses=2;
        int pre[][] = {{1,0},{0,1}};
        System.out.println(canFinish(numCourses,pre));
    }
    public static boolean canFinish(int numCourses, int[][] prerequisites) {

        if(prerequisites==null || prerequisites.length==0){
            return true;
        }

        List<List<Integer>> list = new ArrayList<>(numCourses);

        for(int i=0;i<numCourses;i++){
            list.add(new ArrayList<Integer>());
        }

        for(int pre[]:prerequisites){
            int prerequisite = pre[1];
            int course = pre[0];

            list.get(course).add(prerequisite);
        }

        /**
         0 - un processed
         1 - processing
         2- processed
         */

        int visited[] = new int[numCourses];

        for(int i=0;i<numCourses;i++){
            if(visited[i]==0 && isCyclic(list,i,visited)){
                return false;
            }
        }

        return true;
    }

    public static boolean isCyclic(List<List<Integer>> list,int node,int visited[]){

        //check whether we are visiting same node again which are under processing
        if(visited[node]==1){
            return true;
        }

        visited[node]=1;

        for(int n:list.get(node)){
            if(visited[n]!=2 && isCyclic(list,n,visited)){
                return true;
            }
        }

        visited[node]=2;

        return false;

    }
}
