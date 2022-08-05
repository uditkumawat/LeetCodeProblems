package code.leetcode.studyplan75;

import java.util.Stack;

//https://leetcode.com/problems/asteroid-collision/submissions/
//https://www.youtube.com/watch?v=70AtvN5487Y
//TC - O(N)
//SC - O(N)
public class AsteroidCollision {

    public int[] asteroidCollision(int[] asteroids) {

        Stack<Integer> stack = new Stack<>();

        for(int i=0;i<asteroids.length;i++){

            int ast = asteroids[i];

            if(ast>0){
                stack.push(ast);
            }
            else{

                while(!stack.isEmpty() && stack.peek()>0 && stack.peek()<Math.abs(ast)){
                    stack.pop();
                }

                if(stack.isEmpty() || stack.peek()<0){
                    stack.push(ast);
                }
                else if(Math.abs(stack.peek())==Math.abs(ast)){
                    stack.pop();
                }

            }
        }

        int arr[] = new int[stack.size()];
        int index = stack.size()-1;

        while(!stack.isEmpty()){
            arr[index] = stack.pop();
            index--;
        }

        return arr;
    }
}
