package code.neetcode150;

import java.util.Stack;

//https://leetcode.com/problems/min-stack/submissions/
//TC - O(N)
//SC - O(N)
public class MinStack {

    public Stack<Integer> stack;
    public Stack<Integer> minStack;
    public MinStack() {
        this.stack = new Stack<Integer>();
        this.minStack = new Stack<Integer>();
    }

    public void push(int val) {
        this.stack.push(val);
        if(!this.minStack.isEmpty()){
            int currentMin = this.minStack.peek();
            if(currentMin<val){
                this.minStack.push(currentMin);
            }
            else{
                this.minStack.push(val);
            }
        }
        else{
            this.minStack.push(val);
        }
    }

    public void pop() {
        this.stack.pop();
        this.minStack.pop();
    }

    public int top() {
        return !this.stack.isEmpty()?this.stack.peek():-1;
    }

    public int getMin() {
        return !this.minStack.isEmpty()?this.minStack.peek():-1;
    }
}
