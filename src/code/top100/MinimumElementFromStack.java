package code.top100;

import java.util.Stack;

//https://www.youtube.com/watch?v=ZvaRHYYI0-4&list=PL_z_8CaSLPWdeOezg68SKkeLN4-T_jNHd&index=11
public class MinimumElementFromStack {


    public static void main(String args[]){

        MinStack minStack = new MinStack();

        minStack.push(4);
        System.out.println(minStack.getMin());
        minStack.push(3);
        System.out.println(minStack.getMin());
        minStack.push(5);
        System.out.println(minStack.getMin());
        minStack.push(2);
        System.out.println(minStack.getMin());
        minStack.push(1);
        System.out.println(minStack.getMin());
    }

    static class MinStack {

        static Stack<Integer> stack;
        static int minElement;

        MinStack(){
            stack = new Stack<>();
        }

        public int getMin(){
            return minElement;
        }

        public void push(int element) {
            if (stack.isEmpty()) {
                stack.push(element);
                minElement = element;
            } else {
                if (minElement < element) {
                    stack.push(element);
                } else {
                    int nextMinElement = element;
                    element = 2 * element - minElement;
                    stack.push(element);
                    minElement = nextMinElement;
                }
            }
        }

        public int pop() {
            if (stack.isEmpty()) {
                return -1;
            } else {
                if (stack.peek() > minElement) {
                    return stack.pop();
                } else {
                    int temp = minElement;
                    minElement = 2 * minElement - stack.pop();
                    return temp;
                }
            }
        }
    }
}
