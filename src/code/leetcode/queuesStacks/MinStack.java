package code.leetcode.queuesStacks;

import java.util.Stack;

public class MinStack {

    Stack<Integer> stack;
    Stack<Integer> minStack;
    public MinStack() {
        this.stack = new Stack<Integer>();
        this.minStack = new Stack<Integer>();
    }

    public void push(int val) {
        this.stack.push(val);
        if(this.minStack.isEmpty()){
            this.minStack.push(val);
        }
        else{
            int topElement = this.minStack.peek();
            if(topElement<val){
                this.minStack.push(topElement);
            }
            else{
                this.minStack.push(val);
            }
        }
    }

    public void pop() {
        this.stack.pop();
        this.minStack.pop();
    }

    public int top() {
        return this.stack.isEmpty()?-1:this.stack.peek();
    }

    public int getMin() {
        return this.minStack.isEmpty()?-1:this.minStack.peek();
    }
}
