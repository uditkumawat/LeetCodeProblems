package code.techdose;

import java.util.Stack;

//https://leetcode.com/problems/min-stack/
//TC - O(1)
//sc - O(N)
public class MinStack {

    Stack<Integer> stack;
    Stack<Integer> minStack;
    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public static void main(String args[]){

        MinStack obj = new MinStack();

        obj.push(-2);
        obj.push(0);
        obj.push(-3);
        System.out.println(obj.getMin());
        obj.pop();
        System.out.println(obj.top());
        System.out.println(obj.getMin());
    }

    public void push(int val) {
        stack.push(val);
        if(!minStack.isEmpty() && minStack.peek()<val){
            minStack.push(minStack.peek());
        }
        else {
            minStack.push(val);
        }
    }

    public void pop() {
        stack.pop();
        minStack.pop();
    }

    public int top() {
        minStack.pop();
        return stack.pop();
    }

    public int getMin() {
        int min = minStack.peek();
        return min;
    }
}
