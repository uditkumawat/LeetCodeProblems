package code.leetcode.studyplan75;

import java.util.Stack;

//https://leetcode.com/problems/max-stack/
//TC - O(N)
//SC - O(N)
public class MaxStack {

    Stack<Integer> stack;
    Stack<Integer> maxStack;
    public MaxStack() {
        stack = new Stack<Integer>();
        maxStack = new Stack<Integer>();
    }

    public void push(int x) {
        stack.push(x);
        if(maxStack.isEmpty() || maxStack.peek()<x){
            maxStack.push(x);
        }
        else{
            maxStack.push(maxStack.peek());
        }
    }

    public int pop() {
        maxStack.pop();
        return stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int peekMax() {
        return maxStack.peek();
    }

    public int popMax() {
        int max = maxStack.peek();
        Stack<Integer> buffer = new Stack();
        while(stack.peek()!=max){
            buffer.push(stack.pop());
        }
        stack.pop();
        while(!buffer.isEmpty()){
            stack.push(buffer.pop());
        }

        return max;
    }
}
