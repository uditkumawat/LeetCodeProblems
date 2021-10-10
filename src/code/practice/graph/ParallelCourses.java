package code.practice.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//https://leetcode.com/problems/parallel-courses/

/**
 * You are given an integer n, which indicates that there are n courses labeled from 1 to n. You are also given an array relations where relations[i] = [prevCoursei, nextCoursei], representing a prerequisite relationship between course prevCoursei and course nextCoursei: course prevCoursei has to be taken before course nextCoursei.
 *
 * In one semester, you can take any number of courses as long as you have taken all the prerequisites in the previous semester for the courses you are taking.
 *
 * Return the minimum number of semesters needed to take all courses. If there is no way to take all the courses, return -1.
 */
public class ParallelCourses {

    public static void main(String args[]){

        int n = 3;
        int relations[][] = {{1,3},{2,3}};
        ParallelCourses obj = new ParallelCourses();
        System.out.println(obj.minimumSemesters(n,relations));
    }
    public int minimumSemesters(int n, int[][] relations) {

        int inDegree[] = new int[n+1];

        List<List<Integer>> adjList = new ArrayList(n+1);

        for(int i=0;i<=n;i++){
            adjList.add(new ArrayList());
        }

        for(int edge[]:relations){
            int source = edge[0];
            int destination = edge[1];
            adjList.get(source).add(destination);

            inDegree[destination]++;
        }

        Queue<Integer> q = new LinkedList<>();

        for(int i=1;i<=n;i++){
            if(inDegree[i]==0){
                q.add(i);
            }
        }

        int steps=0;
        int studiedCount = 0;

        while(!q.isEmpty()){

            steps++;

            int size = q.size();

            for(int i=0;i<size;i++){

                studiedCount++;

                Integer node = q.poll();

                for(int neighbour:adjList.get(node)){
                    inDegree[neighbour]--;

                    if(inDegree[neighbour]==0){
                        q.add(neighbour);
                    }
                }
            }

        }

        return studiedCount==n?steps:-1;


    }
}
