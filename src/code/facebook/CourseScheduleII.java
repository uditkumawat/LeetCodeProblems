package code.facebook;

import java.util.*;

//https://www.youtube.com/watch?v=31lxawZ3D6U
//TC - O(V+E)
//SC - O(V+E)
public class CourseScheduleII {

    public static void main(String args[]){

        int numCourses = 4;
        int preq[][] = {{1,0},{2,0},{3,1},{3,2}};

        CourseScheduleII obj = new CourseScheduleII();

        int res[] = obj.findOrder(numCourses,preq);

        for(int num:res){
            System.out.print(num+" ");
        }

    }
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        Map<Integer, List<Integer>> map = new HashMap<>();

        int indegree[] = new int[numCourses];

        for(int preq[]:prerequisites){
            //edge from dependingCourse towards the current course
            int depenedingCourse = preq[1];
            int course = preq[0];
            if(!map.containsKey(depenedingCourse)){
                map.put(depenedingCourse,new ArrayList<>());
            }
            map.get(depenedingCourse).add(course);
            indegree[course]++;
        }

        Queue<Integer> q = new LinkedList<>();

        int res[] = new int[numCourses];
        int index=0;

        for(int i=0;i<indegree.length;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }

        while(!q.isEmpty()){
            int node = q.remove();
            res[index++] = node;
            if(map.containsKey(node)){

                List<Integer> neighbours = map.get(node);

                for(int neighbour:neighbours){
                    indegree[neighbour]--;

                    if(indegree[neighbour]==0){
                        q.add(neighbour);
                    }
                }
            }
        }

        //pending courses which can't be completed
        if(index!=numCourses){
            return new int[]{};
        }
        return res;
    }
}
