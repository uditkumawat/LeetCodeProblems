package code.feb.challenge;

import java.util.Stack;

public class MaxStack {

    Stack<Integer> stack;
    Stack<Integer> maxStack;

    public MaxStack() {
        stack = new Stack<>();
        maxStack = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        int maxPeek = maxStack.isEmpty()?x:maxStack.peek();
        maxStack.push(maxPeek>x ? maxPeek:x);
    }

    public int pop() {
        if(!stack.isEmpty()){
            maxStack.pop();
            return stack.pop();
        }
        else{
            return -1;
        }
    }

    public int top() {
        return stack.peek();
    }

    public int peekMax() {
        return maxStack.peek();
    }

    //when popping from maxStack, we need to remove that element from stack also
    public int popMax() {
        int max = maxStack.pop();
        Stack<Integer> temp = new Stack<>();
        while(top()!=max){
            temp.push(pop());
        }
        pop();
        while(!temp.isEmpty()){
            stack.push(temp.pop());
        }
        return max;
    }

    public static void main(String args[]){

        MaxStack obj = new MaxStack();

        obj.push(5);
        obj.push(1);
        obj.push(5);

        System.out.println(obj.top());
        System.out.println(obj.popMax());
        System.out.println(obj.top());
        System.out.println(obj.peekMax());
        System.out.println(obj.pop());
        System.out.println(obj.top());

    }
}
