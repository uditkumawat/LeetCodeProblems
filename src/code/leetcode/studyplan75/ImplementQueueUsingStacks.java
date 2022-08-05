package code.leetcode.studyplan75;

import java.util.Stack;

public class ImplementQueueUsingStacks {

    Stack<Integer> st1;
    Stack<Integer> st2;
    public ImplementQueueUsingStacks() {
        st1 = new Stack<Integer>();
        st2 = new Stack<Integer>();
    }

    public void push(int x) {
        st1.push(x);
    }

    public int pop() {
        while(!st1.isEmpty()){
            st2.push(st1.pop());
        }
        int elem=st2.isEmpty()?-1:st2.pop();
        while(!st2.isEmpty()){
            st1.push(st2.pop());
        }
        return elem;
    }

    public int peek() {
        while(!st1.isEmpty()){
            st2.push(st1.pop());
        }
        int elem=st2.isEmpty()?-1:st2.peek();
        while(!st2.isEmpty()){
            st1.push(st2.pop());
        }
        return elem;
    }

    public boolean empty() {
        return st1.isEmpty();
    }
}
